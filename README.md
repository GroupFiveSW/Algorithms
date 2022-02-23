# Assignment 3: Code Coverage (DD2480)

In this assignment we were tasked to do a series of tasks related to code coverage to our selected forked repository [Algorithms](https://github.com/GroupFiveSW/Algorithms).

## Project Structure

In this repository you can find the code for Task 1. In the forked [Algorithms](https://github.com/GroupFiveSW/Algorithms)  repository you can find the accompaning issues and tasks for this assignment.

Answers to any questions can be found in our [Google Doc document](https://docs.google.com/document/d/1bt9GIrMK8Onisi5SNo1qF5o6E88D0EX2Kfyqa3HVL58/edit?usp=sharing).

## Summary

### Task 1

Here we were tasked with writing a DIY-solution to test the code-coverage of our five selected functions. We use [JavaParser](http://javaparser.org/) to inject a code-statement at every branch into the original code. Once the injection is done, we run the tests which will run our injected statements if the branch has been reached. By saving each branched reached in a HashMap, and then find the percantages of branches reached, we find the code coverage.

### Task 2

We were tasked with implementing tests to improve our code-coverage and thus we wrote 2 tests per group member in the forked [Algorithms repo](https://github.com/GroupFiveSW/Algorithms).

### Task 3

We were tasked with documenting a plan on how we would reduce the complexity of five functions, and this documented plan can be found in our [Google Doc document](https://docs.google.com/document/d/1bt9GIrMK8Onisi5SNo1qF5o6E88D0EX2Kfyqa3HVL58/edit?usp=sharing).

### Task 4

We were tasked with documenting our way-of-working according to the Essence-standard and this can be found in our [Google Doc document](https://docs.google.com/document/d/1bt9GIrMK8Onisi5SNo1qF5o6E88D0EX2Kfyqa3HVL58/edit?usp=sharing).

### Tooling

- **Programming Language:** Java was used due to all members having experience with it and its support for testing.
- **Project Updates:** GitHub built-in _Projects_ tool was used with an active Kanban-board. You can find this board connected to the forked Algorithms repo.
- **Build tools:** Maven and Gradle

---


## Group Members:
- Gabriel Acar (Gabriel-Acar)
- Elias Bonnici (elibon99)
- Gustaf Halvardsson (gustafvh)
- Alexander Krantz (Klako)
- Oscar Spolander (Carnoustie)

## Contributions
(# = IssueNumber on Github if applicable)

### Gabriel Acar
- **Task 2:** Identify 2 high-complexity methods (Together with everyone) (#2)
- Document the answers for 3.4 Complexity measurement (Togeather with Oscar) (#21)
- **Task 2:** Implement four tests for lineSegmentLineSegmentIntersection() (#32)
- Count code complexity by hand (Togeather with Oscar) (#15)
- Document coverage percent before and after written tests (Togeather with Alexander) (#28)

### Elias Bonnici
- **Task 1:** Identify and Assign a unique ID to each branch. (Together with Alexander and Gustaf) (#10)
- **Task 1:** Create data structures that hold coverage information (Together with Alexander and Gustaf) (#11)
- **Task 1:** Write information about taken branches into a file or to console (Together with Alexander and Gustaf) (#12)
- **Task 1:** Implement unit test structure for Task 1 (Together with Alexander and Gustaf) (#22)
- **Task 2:** Identify 2 high-complexity methods (Together with everyone) (#2)
- **Task 2:** Implement two tests for bfs() (#30)
- **Task 2:** Implement two tests for bellmanFord() (#31)
- Implement thorough README.md (#23)

### Gustaf Halvardsson
- **Task 1:** Identify and Assign a unique ID to each branch. (Together with Alexander and Elias) (#10)
- **Task 1:** Implement unit test structure for Task 1 (#22)
- **Task 1:** Document the answers for 3.3 Onboarding (#20)
- **Task 1:** Research framework for code coverage implementation  (Together with Alexander) (#9)
- **Task 1:** Create data structures that hold coverage information (Together with Alexander and Elias) (#11)
- **Task 1:** Write information about taken branches into a file or to console (Together with Alexander and Elias) (#12)
- **Task 1:** Implement unit test structure for Task 1 (Together with Alexander and Elias) (#22)
- **Task 2:** Identify 2 high-complexity methods (Together with everyone) (#2)
- **Task 2:** Write four tests for lcs() (#18)
- **Task 4:** Self Assesment Essence (#19)

### Alexander Krantz
- **Task 1:** Set up project for code coverage tool (Together with Elias) (#13)
- **Task 1:** Identify and Assign a unique ID to each branch. (Together with Gustaf and Elias) (#10)
- **Task 1:** Research framework for code coverage implementation  (Together with Gustaf) (#9)
- **Task 1:** Create data structures that hold coverage information (Together with Gustaf and Elias) (#11)
- **Task 1:** Write information about taken branches into a file or to console (Together with Gustaf and Elias) (#12)
- **Task 1:** Implement unit test structure for Task 1 (Together with Gustaf and Elias) (#22)
- **Task 1:** Document DIY tool
- **Task 2:** Identify 2 high-complexity methods (Together with everyone) (#2)
- **Task 2:** Test ChineseRemainderTheorem::reduce (#29)
- Document coverage percent before and after written tests (Together with Gabriel) (#28)

### Oscar Spolander

- **Task 2 Identify 2 high-complexity methods (Together with everyone) (#2)
- **Task 2 Implement four tests for lcs() (#24)
- **Task 2 Count Code Complexity by hand (Together with Gabriel) (#15)
- **Task 3 Describe Refactorization (#7)
- Document Complexity reasoning (With Gabriel)

## How to run the code
Thanks to the already existing configuration of the Algorithms-repo you can run, build and test the code in the most easy manner with your integrated IDE (like Intellij for ex.) in accordance to their onboarding.

To run it via the command-line use `gradle test` (Make sure your JDK is correctly set in accordance to the onboarding guide).

