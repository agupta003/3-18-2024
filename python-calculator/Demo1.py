import tkinter as tk


class Calculator:
	def __init__(self, root: tk.Tk) -> None:
		self.root = root
		self.root.title("Calculator")
		self.root.resizable(False, False)

		self.display_value = tk.StringVar(value="0")
		self.first_number: int | None = None
		self.operator: str | None = None
		self.start_new_number = True

		display = tk.Entry(
			root,
			textvariable=self.display_value,
			font=("Segoe UI", 24),
			justify="right",
			state="readonly",
			width=12,
			readonlybackground="white",
		)
		display.grid(row=0, column=0, columnspan=4, padx=10, pady=10, ipady=8)

		buttons = [
			("7", 1, 0), ("8", 1, 1), ("9", 1, 2), ("/", 1, 3),
			("4", 2, 0), ("5", 2, 1), ("6", 2, 2), ("*", 2, 3),
			("1", 3, 0), ("2", 3, 1), ("3", 3, 2), ("-", 3, 3),
			("0", 4, 0), ("C", 4, 1), ("=", 4, 2), ("+", 4, 3),
		]

		for label, row, column in buttons:
			command = self.clear if label == "C" else self.calculate if label == "=" else lambda value=label: self.press(value)
			tk.Button(
				root,
				text=label,
				command=command,
				font=("Segoe UI", 16),
				width=4,
				height=2,
			).grid(row=row, column=column, padx=4, pady=4)

	def press(self, value: str) -> None:
		if value in "+-*/":
			self.first_number = int(self.display_value.get())
			self.operator = value
			self.start_new_number = True
			return

		if self.start_new_number or self.display_value.get() == "0":
			self.display_value.set(value)
			self.start_new_number = False
		else:
			self.display_value.set(self.display_value.get() + value)

	def calculate(self) -> None:
		if self.first_number is None or self.operator is None:
			return

		second_number = int(self.display_value.get())
		try:
			if self.operator == "+":
				result = self.first_number + second_number
			elif self.operator == "-":
				result = self.first_number - second_number
			elif self.operator == "*":
				result = self.first_number * second_number
			elif second_number == 0:
				raise ZeroDivisionError
			else:
				result = self.first_number // second_number
		except ZeroDivisionError:
			self.display_value.set("Cannot divide by 0")
		else:
			self.display_value.set(str(result))

		self.first_number = None
		self.operator = None
		self.start_new_number = True

	def clear(self) -> None:
		self.display_value.set("0")
		self.first_number = None
		self.operator = None
		self.start_new_number = True


if __name__ == "__main__":
	window = tk.Tk()
	Calculator(window)
	window.mainloop()
