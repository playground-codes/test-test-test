# Testing playground
Explore best practices and techniques for unit testing.  

Build status: [![Build Status](https://travis-ci.org/playground-codes/test-test-test.svg?branch=master)](https://travis-ci.org/playground-codes/test-test-test)  
Code coverage: [![codecov](https://codecov.io/gh/playground-codes/test-test-test/branch/master/graph/badge.svg)](https://codecov.io/gh/playground-codes/test-test-test)  

## Frameworks:
* JUnit4
* Mockito

## Libraries
Other awesome tools to make Java Unit testing easier:
* [JUnitParams](https://github.com/Pragmatists/JUnitParams): Provide easier and readable parametrised tests (required Junit >= 4.12).

## TDD - Test-Driven Development
* **Mantras**: GREEN - RED - REFACTOR.
* **Rule**: *Never write code unless you have a failing test.*
* **Benefits**:
    * All codes are unit tested
    * The code is written to satisfy the tests - there is no "future-use" codes (YANGI)
    * Writing the smallest amount of codes to make the test past results in simple solutions (KISS)
    * Refactoring phase keeps codes clean and readable (DRY)  
    * Easy to keep track of your development flow (Pick up new test and start the rhythm Red - Green - Refactor)
* **When should we avoid TDD?**  
Do not apply TDD blindly. *TDD requires a good understanding of the technology used, and the knowledge of the problem domain*. 
If we lack these, for example when we try to test out some new idea or framework, it is better to start with code-first approach.

## Test Doubles  
Test doubles are testing objects which are used to replace the real collaborators of a class. It includes the four following types.

* Dummy (dummy object): Needs to exist, no real collaboration needed

* Mock (mock object): If you need a dummy instance of a complex class 
which would use external resources like network connections, files, or databases. It helps to isolate the class under test from the rest of the system. 

* Stub (test stub): A "fancy" mock providing some more specific, prepared or pre-recorded, replayed results to certain requests under test. 

* Spy (test spy): A hybrid between real object and stub. It has original behaviors for trivial methods and fake behavior for complex methods.

* Fake (fake object): Works almost as good as real collaborator but it is somehow simpler and/or weaker(So it can be used in test only, not production).
 For example, we use an in-memory database as a fake object instead of a real-serving database. It is usually used in **integration tests** rather than unit tests.  
    
    
Note:

* Write an interaction test only if some features of SUT(system under test) cannot be tested using state testing.
Because interaction depends on production code, if implementation changes, our tests need to be updated too.
  

## References
1. "Pratical Unit Testing with JUnit and Mockito" book by Tomek Kaczanowsk
2. [StackOverflow question about differences between Mock, Stub, and Spy](https://stackoverflow.com/questions/24413184/can-someone-explain-the-difference-between-mock-stub-and-spy-in-spock-framewor)
