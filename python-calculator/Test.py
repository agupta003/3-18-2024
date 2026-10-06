from math import sqrt, pi
import math
import random

number = 65
print(math.sqrt(number))
    
num = [10,21,31,41]
print(random.choice(num))
print(pi)

list = ["Delhi", "NewYork", "Cardiff", "Moradabad", "Bangalore", "Charlotte", "Chennai"]
print(random.choice(list))



import random

list1 = ["abhishek", "kapil","mohit","deepak"]
list2 = ["ajay","nikhil","parul","mota"]
print(random.randrange(20))
print(random.choices(list1,k=2))
print(random.shuffle(list2))

import datetime
now = datetime.datetime.now()

now.strftime('%a')
now.strftime('%A')
now.strftime('%Y')
now.strftime('%m')
date = now.strftime('%d-%m-%Y :: %H:%M:%S')
print(date)

import datetime
filecreate = now.strftime('%d-%m-%Y :: %H:%M:%S')
fileprefix = 'Test_'
filename = fileprefix + filecreate 
print(filename)


from datetime import datetime, timedelta    
#add 10 days
future_date= now + timedelta(days= 10)
print(future_date)


from datetime import datetime, timedelta
def add_days(days):
    current_date = datetime.now()
    feture_date = current_date + timedelta(days=days)
    return feture_date

print("Date after -5 days:", add_days(-5))
print("Date after 10 days:", add_days(10))
print("Date after 30 days:", add_days(30))    

# This will create the test.txt file in the specified path 
import os 

data = 'This is test file used for AI automation'
fp = open('C://Users//Owner//Documents//test.txt','w')
fp.write(data)
fp.close()

# mode = w create a new file or overwrite the existing file
#\n means new line
#\t means add a tab
import os
fp = open('C://Users//Owner//Documents//test.txt', 'w')
for i in range(1,3):
    fp = open('C://Users//Owner//Documents//test.txt', mode='a')
    brand = input("Enter the bike brand:").strip()
    price = input(f"Enter the price for {brand}: $")
    txt = brand +"|" + price + '\n'
    print(txt)
    fp.write(txt)
    fp.close()

    fp = open('C://Users//Owner//Documents//test.txt', 'r')
    contents= fp.read()
    fp.close()
    print (contents)

    # creating a csv file

fp = open('C://Users//Owner//Documents//test.csv', mode='w')
heading ='brand' + ',' + 'price' + '\n'
fp.write(heading)
print(txt)

for i in range (1, 3):
        fp = open('C://Users//Owner//Documents//test.csv', mode='a')
        brand = input("Enter the bike name :")
        price = input(f"Enter the price for {brand}: $")
        txt = brand +',' + price +'\n'
        print(txt)
        fp.write(txt)
        fp.close()


with open("C://Users//Owner//Documents//test.txt", "w") as file:
    file.write("Abhishek\n")
    file.write("Kush\n")
    file.write("John\n")
    