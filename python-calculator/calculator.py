"""A simple calculator GUI built with Python's standard tkinter library."""

import ast
import operator
import tkinter as tk
from tkinter import ttk


class SafeExpressionEvaluator(ast.NodeVisitor):
    """Evaluate only the arithmetic syntax supported by the calculator."""

    binary_operations = {
        ast.Add: operator.add,
        ast.Sub: operator.sub,
        ast.Mult: operator.mul,
        ast.Div: operator.truediv,
    }

    unary_operations = {
        ast.UAdd: operator.pos,
        ast.USub: operator.neg,
    }

    def visit_Expression(self, node: ast.Expression) -> float:
        return self.visit(node.body)

    def visit_BinOp(self, node: ast.BinOp) -> float:
        operation = self.binary_operations.get(type(node.op))
        if operation is None:
            raise ValueError("Unsupported operator")
        left = self.visit(node.left)
        right = self.visit(node.right)
        if isinstance(node.op, ast.Div) and right == 0:
            raise ZeroDivisionError
        return operation(left, right)

    def visit_UnaryOp(self, node: ast.UnaryOp) -> float:
        operation = self.unary_operations.get(type(node.op))
        if operation is None:
            raise ValueError("Unsupported operator")
        return operation(self.visit(node.operand))

    def visit_Constant(self, node: ast.Constant) -> float:
        if isinstance(node.value, (int, float)) and not isinstance(node.value, bool):
            return float(node.value)
        raise ValueError("Invalid number")

    def generic_visit(self, node: ast.AST) -> float:
        raise ValueError("Invalid expression")


def evaluate_expression(expression: str) -> float:
    """Safely evaluate a calculator expression without using eval()."""
    if not expression.strip():
        raise ValueError("Enter an expression")
    tree = ast.parse(expression, mode="eval")
    return SafeExpressionEvaluator().visit(tree)


def format_result(value: float) -> str:
    """Display whole numbers without a trailing decimal point."""
    if value.is_integer():
        return str(int(value))
    return f"{value:.12g}"


class CalculatorApp:
    def __init__(self, root: tk.Tk) -> None:
        self.root = root
        self.root.title("Calculator")
        self.root.resizable(False, False)
        self.expression = tk.StringVar()
        self.result = tk.StringVar(value="0")
        self.just_calculated = False
        self.status = tk.StringVar()

        self._build_display()
        self._build_buttons()

    def _build_display(self) -> None:
        display_frame = ttk.Frame(self.root, padding=12)
        display_frame.grid(row=0, column=0, sticky="ew")

        ttk.Label(
            display_frame,
            textvariable=self.expression,
            anchor="e",
            font=("Segoe UI", 12),
        ).grid(row=0, column=0, sticky="ew")
        ttk.Label(
            display_frame,
            textvariable=self.result,
            anchor="e",
            font=("Segoe UI", 24, "bold"),
        ).grid(row=1, column=0, sticky="ew")
        ttk.Label(
            display_frame,
            textvariable=self.status,
            foreground="firebrick",
            anchor="e",
        ).grid(row=2, column=0, sticky="ew")
        display_frame.columnconfigure(0, weight=1)

    def _build_buttons(self) -> None:
        buttons_frame = ttk.Frame(self.root, padding=(12, 0, 12, 12))
        buttons_frame.grid(row=1, column=0)

        buttons = [
            ("C", 0, 0), ("⌫", 0, 1), ("%", 0, 2), ("/", 0, 3),
            ("7", 1, 0), ("8", 1, 1), ("9", 1, 2), ("*", 1, 3),
            ("4", 2, 0), ("5", 2, 1), ("6", 2, 2), ("-", 2, 3),
            ("1", 3, 0), ("2", 3, 1), ("3", 3, 2), ("+", 3, 3),
            ("0", 4, 0), (".", 4, 1), ("=", 4, 2, 2),
        ]

        for button in buttons:
            label, row, column, *column_span = button
            ttk.Button(
                buttons_frame,
                text=label,
                command=lambda value=label: self._handle_button(value),
                width=6,
            ).grid(
                row=row,
                column=column,
                columnspan=column_span[0] if column_span else 1,
                padx=3,
                pady=3,
                ipady=8,
            )

    def _handle_button(self, value: str) -> None:
        self.status.set("")
        if value == "C":
            self.clear()
        elif value == "⌫":
            self.backspace()
        elif value == "%":
            self.percent()
        elif value == "=":
            self.calculate()
        elif value in "+-*/":
            self.add_operator(value)
        else:
            self.add_number(value)

    def add_number(self, value: str) -> None:
        if self.just_calculated:
            self.expression.set("")
            self.just_calculated = False
        current = self.expression.get()
        if value == ".":
            current_number = current.replace("+", " ").replace("-", " ").replace("*", " ").replace("/", " ").split()[-1] if current else ""
            if "." in current_number:
                return
            if not current_number:
                value = "0."
        self.expression.set(current + value)
        self.result.set(self.expression.get())

    def add_operator(self, value: str) -> None:
        if self.just_calculated:
            self.expression.set(self.result.get())
            self.just_calculated = False
        current = self.expression.get().rstrip("+-*/")
        if not current:
            return
        self.expression.set(current + value)

    def percent(self) -> None:
        current = self.expression.get()
        if not current:
            return
        index = len(current)
        while index > 0 and (current[index - 1].isdigit() or current[index - 1] == "."):
            index -= 1
        number = current[index:]
        if not number:
            return
        self.expression.set(current[:index] + f"({number}/100)")
        self.result.set(self.expression.get())

    def backspace(self) -> None:
        self.expression.set(self.expression.get()[:-1])
        self.result.set(self.expression.get() or "0")

    def clear(self) -> None:
        self.expression.set("")
        self.result.set("0")
        self.status.set("")
        self.just_calculated = False

    def calculate(self) -> None:
        expression = self.expression.get().rstrip("+-*/")
        try:
            value = evaluate_expression(expression)
        except ZeroDivisionError:
            self.status.set("Cannot divide by zero")
            return
        except (SyntaxError, ValueError):
            self.status.set("Invalid expression")
            return
        self.expression.set(expression)
        self.result.set(format_result(value))
        self.just_calculated = True


def main() -> None:
    root = tk.Tk()
    CalculatorApp(root)
    root.mainloop()


if __name__ == "__main__":
    main()
