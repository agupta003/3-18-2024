"""Scientific calculator GUI built with Python's standard tkinter library."""

import ast
import math
import operator
import tkinter as tk
from tkinter import ttk


def _to_display(value: float) -> str:
	if value.is_integer():
		return str(int(value))
	return f"{value:.12g}"


class SafeEvaluator(ast.NodeVisitor):
	"""Evaluate only approved mathematical expressions."""

	binary_operations = {
		ast.Add: operator.add,
		ast.Sub: operator.sub,
		ast.Mult: operator.mul,
		ast.Div: operator.truediv,
		ast.Mod: operator.mod,
		ast.Pow: operator.pow,
		ast.FloorDiv: operator.floordiv,
	}
	unary_operations = {ast.UAdd: operator.pos, ast.USub: operator.neg}
	constants = {"pi": math.pi, "e": math.e, "tau": math.tau}
	functions = {
		"sin": lambda value: math.sin(math.radians(value)),
		"cos": lambda value: math.cos(math.radians(value)),
		"tan": lambda value: math.tan(math.radians(value)),
		"asin": lambda value: math.degrees(math.asin(value)),
		"acos": lambda value: math.degrees(math.acos(value)),
		"atan": lambda value: math.degrees(math.atan(value)),
		"sqrt": math.sqrt,
		"log": math.log10,
		"ln": math.log,
		"abs": abs,
		"factorial": lambda value: math.factorial(int(value)) if value >= 0 and value.is_integer() else (_ for _ in ()).throw(ValueError("factorial needs a non-negative integer")),
	}

	def visit_Expression(self, node: ast.Expression) -> float:
		return self.visit(node.body)

	def visit_Constant(self, node: ast.Constant) -> float:
		if isinstance(node.value, (int, float)) and not isinstance(node.value, bool):
			return float(node.value)
		raise ValueError("Invalid number")

	def visit_Name(self, node: ast.Name) -> float:
		if node.id in self.constants:
			return self.constants[node.id]
		raise ValueError("Unknown name")

	def visit_BinOp(self, node: ast.BinOp) -> float:
		operation = self.binary_operations.get(type(node.op))
		if operation is None:
			raise ValueError("Unsupported operator")
		left = self.visit(node.left)
		right = self.visit(node.right)
		return operation(left, right)

	def visit_UnaryOp(self, node: ast.UnaryOp) -> float:
		operation = self.unary_operations.get(type(node.op))
		if operation is None:
			raise ValueError("Unsupported operator")
		return operation(self.visit(node.operand))

	def visit_Call(self, node: ast.Call) -> float:
		if not isinstance(node.func, ast.Name) or node.func.id not in self.functions or node.keywords:
			raise ValueError("Unsupported function")
		if len(node.args) != 1:
			raise ValueError("Function needs one value")
		return float(self.functions[node.func.id](self.visit(node.args[0])))

	def generic_visit(self, node: ast.AST) -> float:
		raise ValueError("Invalid expression")


def evaluate(expression: str) -> float:
	if not expression.strip():
		raise ValueError("Enter an expression")
	return SafeEvaluator().visit(ast.parse(expression, mode="eval"))


class ScientificCalculatorApp:
	def __init__(self, root: tk.Tk) -> None:
		self.root = root
		self.root.title("Scientific Calculator")
		self.root.resizable(False, False)
		self.expression = tk.StringVar()
		self.result = tk.StringVar(value="0")
		self.status = tk.StringVar()
		self.just_calculated = False
		self._build_display()
		self._build_buttons()

	def _build_display(self) -> None:
		frame = ttk.Frame(self.root, padding=12)
		frame.grid(row=0, column=0, sticky="ew")
		ttk.Label(frame, textvariable=self.expression, anchor="e", font=("Segoe UI", 12)).grid(row=0, column=0, sticky="ew")
		ttk.Label(frame, textvariable=self.result, anchor="e", font=("Segoe UI", 25, "bold")).grid(row=1, column=0, sticky="ew")
		ttk.Label(frame, textvariable=self.status, foreground="firebrick", anchor="e").grid(row=2, column=0, sticky="ew")
		frame.columnconfigure(0, weight=1)

	def _build_buttons(self) -> None:
		frame = ttk.Frame(self.root, padding=(12, 0, 12, 12))
		frame.grid(row=1, column=0)
		rows = [
			["sin(", "-sin(", "cos(", "-cos("],
			["tan(", "-tan(", "sqrt(", "abs("],
			["asin(", "acos(", "atan(", "log("],
			["ln(", "pi", "e", "factorial("],
			["(", ")", "^", "%"],
			["7", "8", "9", "/"],
			["4", "5", "6", "*"],
			["1", "2", "3", "-"],
			["0", ".", "+", "="],
			["C", "⌫", "abs(", "//"],
		]
		for row, labels in enumerate(rows):
			for column, label in enumerate(labels):
				ttk.Button(frame, text=label, width=8, command=lambda value=label: self.press(value)).grid(
					row=row, column=column, padx=2, pady=2, ipady=5
				)

	def press(self, value: str) -> None:
		self.status.set("")
		if value == "C":
			self.clear()
		elif value == "⌫":
			self.backspace()
		elif value == "=":
			self.calculate()
		elif value == "%":
			self.expression.set(self.expression.get() + "/100")
			self.result.set(self.expression.get())
		else:
			if self.just_calculated and (value[0].isdigit() or value in ".(" or value.endswith("(")):
				self.expression.set("")
			self.just_calculated = False
			self.expression.set(self.expression.get() + value.replace("^", "**"))
			self.result.set(self.expression.get())

	def clear(self) -> None:
		self.expression.set("")
		self.result.set("0")
		self.status.set("")
		self.just_calculated = False

	def backspace(self) -> None:
		expression = self.expression.get()
		for token in ("factorial(", "asin(", "acos(", "atan(", "sqrt(", "-sin(", "-cos(", "-tan(", "sin(", "cos(", "tan(", "abs(", "log(", "ln("):
			if expression.endswith(token):
				expression = expression[:-len(token)]
				break
		else:
			expression = expression[:-1]
		self.expression.set(expression)
		self.result.set(expression or "0")

	def calculate(self) -> None:
		try:
			value = evaluate(self.expression.get())
			if not math.isfinite(value):
				raise ValueError("Result is not finite")
		except ZeroDivisionError:
			self.status.set("Cannot divide by zero")
			return
		except (SyntaxError, ValueError, OverflowError):
			self.status.set("Invalid expression")
			return
		self.result.set(_to_display(value))
		self.just_calculated = True


def main() -> None:
	root = tk.Tk()
	ScientificCalculatorApp(root)
	root.mainloop()


if __name__ == "__main__":
	main()
