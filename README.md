# Petri Net Java Implementation

This project is a Java-based implementation of a Petri Net, a mathematical modeling language used for the description and analysis of distributed systems. The main components include `Place`, `Transition`, and `Arc` classes, along with specialized arcs for various behaviors.

## Class Diagram Modifications

The Petri Net class diagram was refined from version 1.0 to version 2.0 to correct some logical and naming errors in the initial version, as well as to simplify and enhance certain functionalities. The class diagrams for this project are displayed in the files `./Diagramme_de_classe_v1.0.png` and `./Diagramme_de_classe_v2.0.png`. The content of version 2.0 reflects the design applied in the final implementation of the program. Below are the key modifications made in version 2.0:

1. **Method Renaming in Interface and Implementation**:
   - In the `PetriNet` interface, the `step` method was renamed to `fire`, and a new `fireAll` method was added. This change unifies the naming logic for execution commands across the program and better reflects their role in the Petri Net simulation, where `fire` executes a single transition step, and `fireAll` executes all transitions. This change was also applied to the `PetriNetImpl` class.

2. **Method Removal in Transition Class**:
   - In the `Transition` class, several unnecessary getter and setter methods were removed: `getArcIn()` and `getArcOut()` (used to retrieve input and output arcs) and `setArcIn()` and `setArcOut()` (used to set input and output arcs). This optimization simplifies the `Transition` class and improves the program’s overall conciseness.

3. **Method Modification in VideursArc Class**:
   - In the `VideursArc` class, the constructor `VideursArc(int, Place)` was removed to better align with the logic of `VideursArc`. The `VideursArc` is activated when there are tokens in the source `Place`, and upon activation, it clears all tokens. Therefore, the concept of `weight` is unnecessary, and retaining only the `VideursArc(Place)` constructor is logical.
   - Additionally, the `deleteTokens()` method was renamed to `executeTransition()` to maintain consistency in naming conventions.

4. **Method Modification in ZeroArc Class**:
   - In the `ZeroArc` class, the constructor `ZeroArc(int, Place)` was removed to better align with the logic of `ZeroArc`. The `ZeroArc` is activated when there are no tokens in the source `Place`, so the concept of `weight` is unnecessary. Therefore, retaining only the `ZeroArc(Place)` constructor is logical.

5. **Method Renaming in ArcIn Class**:
   - The `stepAble` method in `ArcIn` was renamed to `fireAble` to align with the naming convention used in the `PetriNet` interface (`fire` method). This change makes the code more consistent and readable.

These modifications provide a clearer and more consistent structure while adding essential functionality for managing transitions and arcs in the Petri Net. The updated design in version 2.0 reflects these improvements, enhancing the usability and maintainability of the Petri Net implementation.



## Project Structure

The project follows a Maven directory structure with `main` and `test` directories for source and test code, respectively.

```plaintext
PetriNet2/
├── src
│   ├── main/java/petriNet/app
│   │   ├── Arc.java               # Base class for arcs in the Petri Net
│   │   ├── ArcIn.java             # Input arc that removes tokens from a Place
│   │   ├── ArcOut.java            # Output arc that adds tokens to a Place
│   │   ├── PetriNet.java          # Interface defining basic operations of a Petri Net
│   │   ├── PetriNetImpl.java      # Implementation of the Petri Net
│   │   ├── Place.java             # Represents a place holding tokens
│   │   ├── Transition.java        # Manages transitions in the Petri Net
│   │   ├── VideursArc.java        # Special arc that removes all tokens from a Place
│   │   └── ZeroArc.java           # Special arc that only allows transition if no tokens in Place
│   └── test/java/petriNet/test
│       ├── ArcInTest.java         # Unit tests for ArcIn class
│       ├── ArcOutTest.java        # Unit tests for ArcOut class
│       ├── ArcTest.java           # Unit tests for Arc class
│       ├── PlaceTest.java         # Unit tests for Place class
│       ├── TransitionTest.java    # Unit tests for Transition class
│       ├── VideursArcTest.java    # Unit tests for VideursArc class
│       └── ZeroArcTest.java       # Unit tests for ZeroArc class
├── pom.xml                        # Maven configuration file
└── README.md                      # Project documentation
```

## Usage

To use this Petri Net implementation:

1. **Create Places**: Initialize `Place` objects with the required token count.
2. **Create Arcs**: Instantiate `ArcIn` and `ArcOut` objects to connect `Places` with `Transitions`.
3. **Create Transitions**: Define `Transition` objects with input and output arcs.
4. **Build the Petri Net**: Use `PetriNetImpl` to manage the network of places, transitions, and arcs.
5. **Execute Steps**: Call the `step` method on `PetriNetImpl` to simulate steps in the Petri Net.

### Example

```java
// Initialize places
Place place1 = new Place(5);
Place place2 = new Place(0);

// Initialize arcs
ArcIn arcIn = new ArcIn(3, place1);
ArcOut arcOut = new ArcOut(3, place2);

// Initialize transition
Transition transition = new Transition(List.of(arcIn), List.of(arcOut));

// Initialize Petri Net and add components
PetriNetImpl petriNet = new PetriNetImpl();
petriNet.addPlace(place1);
petriNet.addPlace(place2);
petriNet.addArc(arcIn);
petriNet.addArc(arcOut);
petriNet.addTransition(transition);

// Execute a step
petriNet.fireAll();
```

## Test:

### Object:

Use JUnit to test all methods in all classes to ensure the accuracy of the code.

### Instructions:

Click the green arrow on the left to test the function. If the Test Result is green at the end, the function has been successfully tested.

![截屏2024-11-08 23.30.08](https://p.ipic.vip/67qroi.png)

## Class Descriptions

### Arc
The base class for arcs in the Petri Net, connecting a `Place` to a `Transition` with a specified weight.

### ArcIn
An input arc that removes tokens from a `Place` when the connected transition fires. It checks if the `Place` has enough tokens for the transition.

### ArcOut
An output arc that adds tokens to a `Place` when the connected transition fires.

### Place
Represents a location in the Petri Net where tokens are stored. Tokens represent the state or resources in the net.

### Transition
Manages input and output arcs and checks if a transition can fire based on the tokens in the input places.

### VideursArc
A specialized input arc that clears all tokens from its connected `Place` when the transition fires.

### ZeroArc
A specialized input arc that only allows the transition if the `Place` has zero tokens.

## Requirements

- Java Development Kit (JDK) 8 or later
- Maven (for building and testing)
- Java IDE (e.g.,IntelliJ IDEA,  Eclipse)

## Authors

- [JIAO Yongshun](https://github.com/Jiaobanzhang)
- [ZHU Xinlei](https://github.com/GatsbyBytheSea)

## License

This project is licensed under the MIT License - see the [LICENSE](./LICENSE) file for details.