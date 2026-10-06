

import json


person = [
{"name": "Abhishek",
"work": "Software Engineer",
"Age": 50,
"Address": "Bangalore"
},
{"name": "Shweta",
"work": "Software Engineer",
"Age": 46,
"Address": "Charlotte"
}   ]

print(person[0]["name"])
print(person[0]["Address"])
print(person[0]["Age"])

print(person[1]["name"])
print(person[1]["Address"])
print(person[1]["Age"])

Person2 = [
{"name": "Kush",
"age" : 17,
"School" :"Cuthbertson High School",
"address" : { "street" : "123 Main St", 
             "city" : "Charlotte", 
             "state" : "NC" },
"Parents" : [person[0], person[1]]
}
]
person2human = json.dumps(person)
print(person2human)

human2person = json.loads(person2human)
print(human2person)

car = {
    "brand": "BMW",
    "model": "iX",
    "year": 2023,
    "features": ["Electric", "AWD", "CarPlay"]
}

print(car["brand"])
print(car["model"])
print(car["year"])
print(car["features"])  
car = json.dumps(car)
print("Car details:", car)