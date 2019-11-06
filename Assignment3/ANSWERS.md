# Answers File Assignment 3

## PART 1

Observer
1) Using an Exception to escape the recurring funtion that keeps the game running is a rather unelegant solution. At the time of implementation we did not have a better alternative. Being introduced to the new design patterns we thought this situation is a good place to implement an observer, because we could delegate the responsibility of keeping track of the checkmate state (updating the observer) to the place where the error has previously been thrown. Before calling startGame() again, the observer can be asked if the game continues.

2)
3)

2nd pattern
1)
2)
3)


## PART 2

the corresponding sequence diagrams of the methods mentioned below are in the "DiagramPictures" folder in Assignment3

considered methods:
- removePiece
![removePieceDiagram](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/removePiece().png)

- removePieceAt
- addPiece
- addPromotedPiece (only considering Queen promotion for clarity reasons)
- removeSuicideMoves
- computeLegalMoves
- makeMove (computeLegalMoves removed for clarity)
- startGame


## PART 3

3) Implement a Scoreboard using the Observer pattern
for notation rules, consider the README.md file of this project


