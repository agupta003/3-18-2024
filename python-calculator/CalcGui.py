from math import dist

from numpy import append


print(324+343)
print("10 + 5")

item_price = 1500
tax = 0.07
total_value = item_price * tax
name = "John"
sirname = "Doe"
SirName = "Smith"
print ( name + " " + sirname+ " Total amt due is: " + str(round(total_value, 2))) # 
print (f"{name} {sirname} Total amt due is: {total_value:.2f}") # f is used to format the string and display the total amount due with two decimal places.
# in this ststment total_value:.2f ":." is used to format the total_value variable to display two decimal places. 
# The ".2f" specifies that the value should be formatted as a floating-point number with two digits after the decimal point. 
# This ensures that the total amount due is displayed in a standard currency format, making it easier to read and understand.

name1 = "Alice"
name2 = "Bob"
print("{} and {} are friends.".format(name1, name2))
print(f"{name1} and {name2} are friends.") # f is used to format the string and display the names of two friends.
print (name1 != name2)
a = 3
b = 4
print ("which one is greater :" , a >= b)
print ("which one is greater :" + str(a >= b))

is_raining = True
is_raining = not is_raining # not will reverse the value of is_raining, so if it is True, it will become False, and vice versa.
print("Is it raining? " ,is_raining)

if (is_raining): 
    print("Take an umbrella.")
else :
    print("No need for an umbrella.")

    a = 10
    b = 5

    if a>b:
        print(f"{a} is greater than {b}.")
    elif a<b:
        print(f"{a} is less than {b}.")
    else:
        print(f"{a} is equal to {b}.")  

# Use while and for loop

    counter = 1
    while(counter <= 5):
        print("Counter is less than or equal to 5.")
        counter += 1
    else:
        print("Counter is greater than 5.") 

    for counter in range(1,9):  
        print("Counter is less than or equal to 8.", counter)
    else:                                                   # else is not mandatory and will be executed when the loop is completed.
        print("Counter is greater than 8.")


"""  while True:
        user_input = input("Enter a number (or 'q' to quit): ")
        if user_input.lower() == 'q':
            break
        try:
            number = float(user_input)
            print(f"You entered: {number}")
        except ValueError:
            print("Please enter a valid number.")
"""
            # Basic Data types - int, float, str, bool, list, tuple, set, dict

            # Sequence data types - list, tuple, dict and set are all sequence data types in Python. 
            # They can be used to store multiple values in a single variable.

            # List is a datatype which stores heterogeneous data types in a single variable. It is mutable and can be changed after creation. It is defined using square brackets [].
my_list = [1, 2, 3, "four", "five", 6.0, True]
print(my_list)
        #
            # Concatination
            # repetion
            # indexing

my_list = [1, 2, 3, "four", "five", 6.0, True]
print("My List : ",my_list)
emp2 = ['233', 'abhi', 232.23, 45,'M']            
print("emp2 : ", emp2)

emp4 = emp2 * 2
print("emp4 : ", emp4)
emp3 = emp2 + my_list
print ("emp3 :",emp3)
print(f"Employee id: {emp3[0]} and name is {emp3[1]} and salary is {emp3[2]}")

# List Functions
my_list.append(7)
print("My List after append : ",my_list)
my_list.extend([8, 9, 10])
print("My List after extend : ",my_list)
my_list.insert(0, 0)
print("My List after insert : ",my_list)
my_list.remove(7)
print("My List after remove : ",my_list)
my_list.pop()
print("My List after pop : ",my_list)
my_list.clear()
print("My List after clear : ",my_list)


for i in range(emp3.__len__()):
    print(f"emp3[{i}] = {emp3[i]}")

emp5 = emp3[ :5]
emp5 = emp3[2:5] #slicing
emp5 = emp3[ :: -1] #reverse
print("emp5 : ", emp5)

#Dictionary
#{} ==> Key : value pairs, unordered, mutable, indexed by keys
my_dict = {"name": "John", "age": 30, "city": "New York", "my_list": [1, 2, 3, "four", "five", 6.0, True]}
print("My Dictionary : ",my_dict)

my_dict2 = {"employees": [{"id": 123, "name": "Alice", "salary": 50000.0, "is_manager": False},
                          {"id": 456, "name": "Bob", "salary": 60000.0, "is_manager": True},
                          {"id": 789, "name": "Charlie", "salary": 55000.0, "is_manager": False}
                          ]}
my_dict2["employees"].append({"id": 101, "name": "Tom", "salary": 70000.0, "is_manager": True})
print("My Dictionary : ",my_dict2)

#Tuples is used to store those values which are not going to change. 
# because of this, tuples are faster than lists.
# It is immutable and defined using parentheses ().

temp = (1, 2, 3, "four", "five", 6.0, True)
print("My Tuple : ",temp)

print(type(temp))
print(temp[1 : 4])
print(temp[ :: -1]) #reverse
# print(temp[0] = 10)    # will give error because tuple is immutable

print(temp.index("four"))
print(temp.count(1))    

# set is a collection of unique elements. It is unordered and mutable. It is defined using curly braces {}.
set1 = {1, 2, 3, 4, 5,5, 6, 7, 8, 9, 10}
set2 = {5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}
print("My Set : ",set1)
#union of two sets
set3 = set1.union(set2)
print("Union of set1 and set2 : ",set3)
#intersection of two sets       
set4 = set1.intersection(set2)
print("Intersection of set1 and set2 : ",set4)
#difference of two sets
set5 = set1.difference(set2)
print("Difference of set1 and set2 : ",set5)

# Functions
# Input Function - 
# Type of errors and error handling
# Files (read, write and append)

name = input("Enter your name: ")
try:
    income = float(input("Enter your income: "))
except ValueError as e:
    print("Not a valid income. - ", e)
def personInfo(name, income):
    return f"Name: {name}, Income: {income}"

print(personInfo(name, income))

def greet():            # ":" starts the function body
        print("Hello, World!")

greet()


car = input("Enter your car name: ")
bike = input("Enter your bike name: ")
cycle = input("Enter the cycle name: ")

def test(car, bike, cycle):
    for vehical in [car, bike, cycle]:
        print(f"your vehical: {vehical}")
test(car, bike, cycle)

brand = input("Enter your brand name: ")
price = float(input("Enter your price: "))

def productInfo(brand, price):
    dist = {"key": brand, "value": price}
    for product in [dist]:
        print(dist["key"], dist["value"])

productInfo(brand, price)

