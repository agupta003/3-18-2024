def calculate_marks(
	student_name: str,
	english_marks: float,
	maths_marks: float,
	history_marks: float,
	science_marks: float,
	computer_marks: float,
) -> tuple[str, float, float]:
	"""Calculate total and average marks for one student."""
	marks = (
		english_marks,
		maths_marks,
		history_marks,
		science_marks,
		computer_marks,
	)
	total_marks = sum(marks)
	average_marks = total_marks / len(marks)
	return student_name, total_marks, average_marks


def assign_grade(average_marks: float) -> str:
	"""Return a letter grade based on the average marks."""
	if average_marks >= 90:
		return "A"
	if average_marks >= 75:
		return "B"
	if average_marks >= 60:
		return "C"
	if average_marks >= 40:
		return "D"
	return "F"


def read_mark(subject_name: str) -> float:
	"""Read one valid subject mark from the user."""
	while True:
		try:
			mark = float(input(f"Enter marks for {subject_name}: "))
			if 0 <= mark <= 100:
				return mark
			print("Marks must be between 0 and 100.")
		except ValueError:
			print("Please enter a valid number.")


def main() -> None:
	student_name = input("Enter student name: ").strip()
	subjects = ("English", "Maths", "History", "Science", "Computer")
	marks = [read_mark(subject) for subject in subjects]
	student_name, total, average = calculate_marks(student_name, *marks)
	grade = assign_grade(average)
	print(f"Student: {student_name}")
	print(f"Total marks: {total:g}")
	print(f"Average marks: {average:g}")
	print(f"Grade: {grade}")


if __name__ == "__main__":
	main()
