# Assignment 4: Issue resolution (refactoring) (DD2480)

In this assignment we were tasked to do a series of tasks related to issue resolution to our selected forked repository [Algorithms](https://github.com/GroupFiveSW/Algorithms).

## Project Structure

In this repository you can find the code for Task 1. In the forked [Algorithms](https://github.com/GroupFiveSW/Algorithms) repository you can find the accompaning issues and tasks for this assignment under the Assignment4 board.

Answers to any questions can be found in our [Google Doc document](https://docs.google.com/document/d/1fuZfs5OmAHSEE7-_Y_GGQDoY2GnvouBpUqnO2LI3ao8/edit?usp=sharing).

## Summary

We chose to solve an [issue in the Algorithms repo](https://github.com/williamfiset/Algorithms/issues/131) that included implementing a Rope as a new datastructure in the repo. More information about what a Rope is can be found [here](https://en.wikipedia.org/wiki/Rope_(data_structure)). We implemented it in the [datastructures directory](https://github.com/GroupFiveSW/Algorithms/tree/ropeImplementation/src/main/java/com/williamfiset/algorithms/datastructures/rope) and included four different classes Rope, Leaf, Node and RopePair. We also wrote approximately 34 tests to test both the Leafs, Nodes but also the full Rope structure itself.

### Tooling

- **Programming Language:** Java was used due to all members having experience with it and its support for testing.
- **Project Updates:** GitHub built-in _Projects_ tool was used with an active Kanban-board. You can find this board connected to the forked Algorithms repo under Assignment 4.
- **Build tools:** Maven and Gradle

---


## Group Members:
- Gabriel Acar (Gabriel-Acar)
- Elias Bonnici (elibon99)
- Gustaf Halvardsson (gustafvh)
- Alexander Krantz (Klako)
- Oscar Spolander (Carnoustie)

## Contributions

Due to the requirement of more detailed reporting of work done, all the contributions with time-intervals included, can be found in our [Excel document](https://docs.google.com/spreadsheets/d/1qbVwAm9-8dX8jTVcjB-bbnJhG5tiwD7IolXG_EMDoPo/edit?usp=sharing)


## How to run the code
Thanks to the already existing configuration of the Algorithms-repo you can run, build and test the code in the most easy manner with your integrated IDE (like Intellij for ex.) in accordance to their onboarding.

To run it via the command-line use `gradle test` (Make sure your JDK is correctly set in accordance to the onboarding guide).

