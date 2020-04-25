# Game of Life

## Introduction
Implementation of Conway’s The Game of Life (a cellular automaton devised by the British
mathematician John Horton Conway in 1970). 

## Game of Life Rules
The universe of the Game of Life is a two-dimensional grid of square cells, each of which is in one of two
possible states, alive or dead. Every cell interacts with its eight neighbors, which are the cells that are
horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:
 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by overcrowding.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The initial pattern constitutes the seed of the system. The first generation is created by applying the
above rules simultaneously to every cell in the seed—births and deaths occur simultaneously, and the
discrete moment at which this happens is called a tick. The rules continue to be applied repeatedly to
create further generations.

## Implementation details
* The grid must be 50 cells width and 50 cells height
* Frequency of game loop is 30 Hz (30 ticks per second)
* All public methods and classes must be well documented (commented)
* There are three different initial patterns that are used as first a generation of cells (see Initial
Patterns section)
* Pressing Enter on the keyboard restart the simulation and starts it from another pattern (next
from the list)

## Initial patterns
1. Random Pattern
* Every cell is random. There are 50% of alive and 50% of dead cell.
2. The Queen Bee Shuttle Pattern
3. Tumbler Pattern