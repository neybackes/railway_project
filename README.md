# Railway

Simple Java study project modeling a railway system.

## Structure
### OOP. Class. Object. Encapsulation:
- Create a new Java project.
- Create 10 Java classes for the topic.
- Create `Main` with simple business logic.
- Each class has at least 1 property.
- At least 5 private properties in total.
- Private properties have getters and setters.
- Each class has at least one custom constructor.
- `main()` instantiates objects of the implemented classes.


### OOP. Inheritance. Polymorphism
- Refactor your projects with 5 Abstract classes(make hierarchy).
- add toString() at least 5 classes(that for example you're already using for printing info)
  - All classes, including one abstract class, implement the toString() method.
- equals() and hashCode() - 3 times randomly for practice or for classes that you are using as well
- Use polymorphism at least 1 time in your project
  * Override
    - The abstract class Wagon defines the method showInfo().
    - The subclasses PassengerWagon and CargoWagon override this method.
    - The toString() method is also overridden across multiple classes.
  * Overloading
    - Method overloading in the Wagon class by implementing setCapacity() with different parameter types (int and double).

Code layout:
- `Main.java`: entry point.
- `cargo/`, `passenger/`, `station/`, `system/`, `train/`: domain classes.

## Branch conventions
- `main`: stable code.
- `develop`: integration branch.
- `feature/<short-name>`: new features.
- `refact/<short-name>`: refactoring

## Notes
No external dependencies.
