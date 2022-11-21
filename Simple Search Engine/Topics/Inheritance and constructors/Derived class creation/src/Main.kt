open class Employee(val name: String, val age: Int, var yearsOfWork: Int = 0)

class Programmer(name: String, age: Int, yearsOfWork: Int = 0) : Employee(name, age, yearsOfWork)
