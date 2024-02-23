# Introduction

The following diagram represents a map of a maze. The circles are rooms and the lines are corridors connecting the rooms. Note that each room has at most four corridors in the map.

Each room in the maze will correspond to an object in your code whilst each corridor (line) corresponds to a bidirectional link that points from one room (object) to another (object). Start the user in node A. The user’s goal is to finish in node L. The program should output possible moves in a north, south, east or west direction. Sample execution might return the following output, where user keyboard presses are emboldened:

    You are in room A of a maze of twisty little passages, all alike.
    You can go (E)ast, (S)outh, or (Q)uit.
    E 

    You are in room B of a maze of twisty little passages, all alike.
    You can go (W)est, (S)outh, or (Q)uit.
    S 

    You are in room F of a maze of twisty little passages, all alike.
    You can go (N)orth, (E)ast, or (Q)uit.
    E

Some things to think about:

- The maze could be constructed using either a 1-dimensional 2-dimensional array which is then populated by objects. If so, the maze is a grid (a popular kind of graph structure used in gaming to represent geospatial coordinates). However movement of the user between the rooms can be quite difficult to code and be inefficient both in terms of coding and resources – there would be ‘non-room’ cells in the grid for example. For more credit, a much better approach is to not use any kind of array at all and instead have each object directly linked to its neighbouring rooms via appropriate attributes. If you adopt this approach the maze is a graph of linked nodes (rooms) and the corridors are edges.

- Different maze configurations could be implemented to represent ‘easy’ and ‘hard’ levels of difficulty either by details hard-coded into the program, or using maze maps stored in separate text file(s), or by random construction at runtime (very difficult).

# Assessment

The maze exercise will be assessed according to;

a) Program functionality - how well the program works from a user’s point of view.

b) Program design - the extent to which the program source code follows good programming practice, especially layout and object-oriented style.

c) Written documentation on program design

d) Written documentation on program evaluation

# Requirements

Write a console-based Java program that implements the maze using objects with these requirements:

* Instead of using one class from which all rooms are instantiated, you can demonstrate inheritance using a base class where subclasses are different types of node (e.g. exit room treasure room, etc.).

* Do not use any kind of array and instead each object is directly linked to its neighboring room. Therefore the maze is a graph of linked nodes (rooms) and the doors are edges.

* Different maze configurations could be implement to represent ‘easy’ and ‘hard’ levels of difficulty by using maps are stored in separate text files.