# Herb & Grocery Shopping App
SSAD course team project 

| Team member | % of work | telegram |  
|-----------|:-----------:|-----------:|  
| Ilya Pechersky | 25% | @Happy_endon |  
| Timur Kharin | 25% | @tim404 |
| Renat Khairullin| 25% | @renatkh |  
| Grisha Rybolovel | 25% | @Grisha_Rybolovlev|  

# Implemented pattern
### **Factory Method** - is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

We dicided to use factory method to be able to initialize both types of shops(Food and Health).
**What is why** we have **Factory method** and **FoodMethod + HealthMood** classes which extend from FactoryMethod.

# Project structure

- [`.idea`](.idea) - xml files for project
- [`out`](out)/[`production`](production)/[`TeamProjectSSAD`](TeamProjectSSAD) - classes of app
- [`src`](src) - java files for app
- [`README.md`](README.md) - text file for structuring information for a project
- [`database.txt`](database.txt) - database of users/shops with their logins and passwords

# Build and launch

### Example (Windows)

#### Building a project

Clone the project to your device via [Git for Windows](https://gitforwindows.org/) (or write this link):

```shell
git clone https://github.com/IlyaPechersky/TeamProjectSSAD.git
```
### Launch java project

Run this java file:
- [`src`](src)/[`Application.java`](Application.java)

![UML DIAGRAM](https://github.com/IlyaPechersky/TeamProjectSSAD/blob/main/.idea/photo_2022-04-27%2022.27.10.jpeg)

