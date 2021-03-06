# Answers File Assignment 3

## PART 1

**Observer**
1) Using an Exception to escape the recurring funtion that keeps the game running is a rather unelegant solution. At the time of implementation we did not have a better alternative. Being introduced to the new design patterns we thought this situation is a good place to implement an observer, because we could delegate the responsibility of keeping track of the checkmate state (updating the observer) to the place where the error has previously been thrown. Before calling startGame() again, the observer can be asked if the game continues.

2) Class Diagram

![classDiagram](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/ClassDiagramCheckMateObserver.png)

3) Sequence Diagram

![sequenceDiagram](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/CheckmateObserverSequenceDiagram.png)


**Singelton**
1) Our class CheckMate has the sole purpose to know if the game may continue. Other actors might still want to observe that as well, thus the Observer Pattern, but the CheckMate class has no additional functionality. That is why we decided to implement it as a singleton. This way we can ensure that the Game knows exactly that the Observer it asked is indeed the one that is responsible. The game does this by only asking the unique CheckMate instance if it should continue.

2) Class Diagram

![classDiagram](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/SingeltonClassDiagram.png)

3) Sequence Diagram

![sequenceDiagram](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/SingeltonSequenceDiagram.png)


## PART 2

for collaborative workflow reasons all graphs represent the state of the project at the beginning of assignment 3

the corresponding sequence diagrams of the methods mentioned below are in the "DiagramPictures" folder in Assignment3

considered methods:
- removePiece

![removePieceDiagram](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/removePiece().png)

- removePieceAt

![removePieceAt](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/removePieceAt().png)

- addPiece

![addPiece](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/addPiece().png)

- addPromotedPiece (only considering Queen promotion for clarity reasons)

![addPromotedPiece](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/addPromotedPiece().png)

- removeSuicideMoves

![removeSuicideMoves](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/removeSuicideMoves().png)

- computeLegalMoves

![comouteLegalMoves](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/computeLegalMoves().png)

- makeMove (computeLegalMoves removed for clarity)

![makeMove](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/makeMove().png)

- startGame

![startGame](https://github.com/florinulrich/BINF4241-group23/blob/master/Assignment3/DiagramPictures/startGame().png)


## PART 3

option #3 Implement a Scoreboard using the Observer pattern

for notation rules, consider the README.md file of this project


