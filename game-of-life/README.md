# Game-of-Life

Conway's Game of Life Solution In Java

According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970." https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

Given a board with rowLength by colLength cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

# System Requirements
Gradle, Java and Git 

# Build instructions
1. Git clone repository
2. cd into project directory game-of-life and run ./gradlew clean build shadowJar (This should create build directory with jar file in build/libs folder.

# Execution instructions
1. java -jar build/libs/game-of-life-1.0-SNAPSHOT-all.jar 
2. You should see following interactive session saying 
Choose from following seed board types :
BLOCK,BEEHIVE,LOAF,BOAT,TUB,BLINKER,TOAD,BEACON,PULSAR,GLIDER,LWSS, RANDOM 
<Input any of the patterns><PRESS ENTER>
Enter number of iterations
<Enter number of stages of Lifecycle you would like to see><PRESS ENTER>

The various stages of patterns will get printed in the console.


