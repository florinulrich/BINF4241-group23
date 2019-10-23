package Classes;

import Classes.Pieces.*;
import Enumerations.CastleType;
import Enumerations.Occupant;
import Enumerations.PieceColor;
import Enumerations.PieceType;
import Exceptions.CheckmateException;
import Interfaces.IPiece;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    private ArrayList<IPiece> pieces =  new ArrayList<>();

    private ArrayList<Move> legalMovesBlack = new ArrayList<>();
    private ArrayList<Move> legalMovesWhite = new ArrayList<>();

    private int scoreWhite = 0;
    private int scoreBlack = 0;

    private boolean WhiteCanCastleShort = true;
    private boolean WhiteCanCastleLong = true;

    private boolean BlackCanCastleShort = true;
    private boolean BlackCanCastleLong = true;

    private ArrayList<Move> history = new ArrayList<>();

    private void computeLegalMoves() {

        legalMovesWhite = new ArrayList<>();
        legalMovesBlack = new ArrayList<>();

        for (IPiece piece: pieces) {

            ArrayList<Move> PieceMoves = piece.getPieceMoves();

            for (Move move: PieceMoves) {
                if (piece.getColor() == PieceColor.BLACK) {
                    legalMovesBlack.add(move);
                } else {
                    legalMovesWhite.add(move);
                }
            }
        }

        removeSuicideMoves(PieceColor.WHITE, legalMovesWhite);
        removeSuicideMoves(PieceColor.BLACK, legalMovesBlack);

        checkAmbiguity(legalMovesWhite);
        checkAmbiguity(legalMovesBlack);

        findCheckOrCheckmateMoves(legalMovesWhite, PieceColor.BLACK);
        findCheckOrCheckmateMoves(legalMovesBlack, PieceColor.WHITE);

        correctForCheckAndCheckmate(legalMovesWhite);
        correctForCheckAndCheckmate(legalMovesBlack);

    }

    private void correctForCheckAndCheckmate(ArrayList<Move> moves) {

        for (Move move: moves) {

            move.correctIdentifierForCheck();
            move.correctIdentifierForCheckmate();
        }
    }

    private void findCheckOrCheckmateMoves(ArrayList<Move> moves, PieceColor opponentColor) {

        Coordinate opponentKingCoordinate = null;

        for(IPiece piece: pieces) {
            if (piece.getType() == PieceType.KING && piece.getColor() == opponentColor) {
                opponentKingCoordinate = new Coordinate(piece.getCoordinates().getKey(), piece.getCoordinates().getValue());
            }
        }
        assert opponentKingCoordinate != null;
        for (Move move: moves) {
            //1. Make Move
            move.make();
            //2. See if piece can go to King Coordinate in next move
            ArrayList<Move> piecesNextMoves = new ArrayList<>(move.getPerformingPiecesMoves());
            if (kingIsChecked(opponentColor, piecesNextMoves)) {

                //3. Set move variable accordingly
                move.setLeadsToCheck(true);
            }
            //4. calculate opponent moves
            ArrayList<Move> opponentMoves = new ArrayList<>();
            for (IPiece piece: pieces) {
                if (piece.getColor().equals(opponentColor)) {
                    opponentMoves.addAll(piece.getPieceMoves());
                }
            }
            removeSuicideMoves(opponentColor, opponentMoves);

            //5. if opponent moves empty --> Checkmate
            if (opponentMoves.isEmpty()) {
                move.setLeadsToCheckmate(true);
            }

            //6. revert move!!!
            move.revert();
        }
    }

    private void checkAmbiguity(ArrayList<Move> moves) {

        for (Move moveToCompare: moves) {

            for (Move move: moves) {

                if (move != moveToCompare) {
                    if (move.getAlgebraicIdentifier().equals(moveToCompare.getAlgebraicIdentifier())) {
                        move.correctAmbiguousIdentifier();
                        moveToCompare.correctAmbiguousIdentifier();
                    }
                }
            }
        }
    }

    //Needs to check if move is possible in the move array of the respective player
    private void makeMove(String algebraicMove, PieceColor playerColor) throws CheckmateException {

        computeLegalMoves();

        ArrayList<Move> moveArray;

        if (playerColor == PieceColor.WHITE) {
            moveArray = legalMovesWhite;
        } else {
            moveArray = legalMovesBlack;
        }


        Move chosenMove = null;
        for (Move move: moveArray) {
            if (move.getAlgebraicIdentifier().equals(algebraicMove)) { chosenMove = move; }
        }

        if (chosenMove == null) {
            System.out.println("Chosen move: " + algebraicMove);
            System.out.println("This is not a legal move, try another one!");
            System.out.println("Available Moves:");

            for (Move move: moveArray) {
                System.out.print(move.getAlgebraicIdentifier() + " ");
            }
            System.out.println();
            System.out.print("Choose again >> ");

            String newMove = getMoveInput();
            makeMove(newMove, playerColor);

            System.out.println();

        } else {

            this.removePieceAt(chosenMove.getEndCoordinate());

            if (chosenMove.getEnPassantBeatenPiece() != null)
            this.removePieceAt(chosenMove.getEnPassantBeatenPiece());

            //Check if Pawn needs to be promoted
            chosenMove.checkForPromotion();

            //Check if Castle will still be possible
            if (chosenMove.performingPieceType() == PieceType.KING) {
                if (chosenMove.performingPlayer() == PieceColor.BLACK) {
                    BlackCanCastleLong = false;
                    BlackCanCastleShort = false;
                } else {
                    WhiteCanCastleLong = false;
                    WhiteCanCastleShort = false;
                }
            }

            //Tower 1
            if (chosenMove.performingPieceType() == PieceType.TOWER) {
                if (chosenMove.performingPlayer() == PieceColor.BLACK) {
                    if (chosenMove.getStartCoordinate().getX() == 0) {
                        BlackCanCastleLong = false;
                    } else {
                        BlackCanCastleShort = false;
                    }
                } else {
                    if (chosenMove.getStartCoordinate().getX() == 0) {
                        WhiteCanCastleLong = false;
                    } else {
                        WhiteCanCastleShort = false;
                    }
                }
            }


            //Tower 2


            chosenMove.make();

            history.add(chosenMove);
        }
        computeLegalMoves();

        //After move is performed, is the opponent checkmated?

        // If there are no moves available it is checkmate
        // Player is now checkmated, if he has no moves available -> Stalemate == Checkmate

        ArrayList<Move> opponentMoves;
        if (playerColor == PieceColor.BLACK) {
            opponentMoves = legalMovesWhite;
        } else {
            opponentMoves = legalMovesBlack;
        }

        if (opponentMoves.isEmpty()) {
            System.out.println("Checkmate! Player " + playerColor + " wins!");
            throw new CheckmateException();
        }
    }

    private String getMoveInput(){

        Scanner playerInput = new Scanner(System.in);

        return playerInput.next();
    }

    public Occupant getOccupantOfSquare(int xCoordinate, int yCoordinate) {
        for (IPiece piece: pieces) {
            if (piece.getCoordinates().equals(new Pair<>(xCoordinate, yCoordinate))) {
                switch (piece.getColor()) {
                    case BLACK: return Occupant.BLACK;
                    case WHITE: return Occupant.WHITE;
                }
            }
        }
        return Occupant.EMPTY;
    }

    public void addPromotedPieceAt(int x, int y, PieceType type, PieceColor color) {

        IPiece promoted;

        switch (type){
            case KNIGHT:
                promoted = new Knight(this, x, y, color);
                break;
            case BISHOP:
                promoted = new Bishop(this, x, y, color);
                break;
            case TOWER:
                promoted = new Tower(this, x, y, color);
                break;
            default:
                promoted = new Queen(this, x, y, color);
                break;

        }
        this.pieces.add(promoted);
    }

    private void removePieceAt(Coordinate coordinate) {

        IPiece pieceToRemove = null;

        for (IPiece piece: this.pieces) {
            Coordinate pieceCoordinate = new Coordinate(piece.getCoordinates().getKey(), piece.getCoordinates().getValue());

            if (pieceCoordinate.equals(coordinate)) {
                pieceToRemove = piece;
            }
        }

        if (pieceToRemove != null) {
            removePiece(pieceToRemove);

            if (pieceToRemove.getColor() == PieceColor.WHITE) {
                scoreBlack += 1;
            } else {
                scoreWhite += 1;
            }
        }
    }


    public void removePiece(IPiece piece) {
        this.pieces.remove(piece);
    }

    void addPiece(IPiece piece) {
        this.pieces.add(piece);
    }

    void startGame() {

        printBoard();

        PieceColor colorNext = PieceColor.WHITE;
        ArrayList<Move> movesNextOpponent = new ArrayList<>();

        if (history.size() > 0) {
            if (history.get(history.size() - 1).performingPlayer() == PieceColor.BLACK) {
                movesNextOpponent = legalMovesBlack;
            } else {
                colorNext = PieceColor.BLACK;
                movesNextOpponent = legalMovesWhite;
            }
        }


        //See if opponent is now in check
        if (kingIsChecked(colorNext, movesNextOpponent)) {
            System.out.println("Check!");
        }


        System.out.print(colorNext + " Player move >> ");

        String nextMove = getMoveInput();
        try {
            makeMove(nextMove, colorNext);
            startGame();
        } catch (CheckmateException e) {
            printBoard();
        }


    }

    private void printBoard() {
        System.out.println();

        ArrayList<ArrayList<PrintSquares>> printSquares = new ArrayList<>();

        for(int i = 0; i < 8; i++) {
            printSquares.add(new ArrayList<>());
        }
        for (ArrayList<PrintSquares> list: printSquares) {
            for(int i = 0; i < 8; i++) {
                list.add(new PrintSquares());
            }
        }

        for (IPiece piece: this.pieces) {
            //getCoordinates
            Pair<Integer, Integer> coordinates = piece.getCoordinates();
            Integer x = coordinates.getKey();
            Integer y = coordinates.getValue();

            printSquares.get(y).get(x).setOccupant(piece.getType(), piece.getColor());
        }

        for (int i = 7; i >= 0; i--) {

            StringBuilder line = new StringBuilder("(" + (i + 1) + ")" + "\t");

            for (PrintSquares square: printSquares.get(i)) {
                line.append(square.getOutputString());
            }

            System.out.print(line);

            if (i==7){
                System.out.println("\t\t WHITE Player score: " + scoreWhite);
            } else if (i==6){
                System.out.println("\t\t BLACK Player score: " + scoreBlack);
            } else{
                System.out.print("\n");
            }
        }

        System.out.println("\t(a )(b )(c )(d )(e )(f )(g )(h )\n");
    }

    private void removeSuicideMoves(PieceColor playerColor, ArrayList<Move> playerMoves) {

        PieceColor opponentColor = PieceColor.WHITE;
        if (playerColor == opponentColor) {
            opponentColor = PieceColor.BLACK;
        }

        ArrayList<Move> movesToRemove = new ArrayList<>();

        for (Move move: playerMoves) {

            boolean illegal = false;
            IPiece beatenEnemy = getPieceAt(move.getEndCoordinate());
            if (beatenEnemy != null) {
                removePiece(beatenEnemy);
            }

            move.make();



            ArrayList<Move> opponentMoves = new ArrayList<>();
            for (IPiece piece: pieces) {
                if (piece.getColor().equals(opponentColor)) {
                    opponentMoves.addAll(piece.getPieceMoves());
                }
            }

            //Check if Move beats Piece and its moves therefore don't count
            ArrayList<Move> movesOfBeatenEnemy = new ArrayList<>();
            for (Move opponentMove: opponentMoves){

                //Check if Piece is Protected --> If protected, cant be beaten by King
                if (move.getEndCoordinate().equals(opponentMove.getStartCoordinate())) {
                    movesOfBeatenEnemy.add(opponentMove);
                }
            }

            opponentMoves.removeAll(movesOfBeatenEnemy);

            if (kingIsChecked(playerColor, opponentMoves)) {
                illegal = true;
            }

            move.revert();
            if (beatenEnemy != null) {
                addPiece(beatenEnemy);
            }

            if (illegal) {
                movesToRemove.add(move);
            }


        }

        playerMoves.removeAll(movesToRemove);

        //1. Make Move
        //2. Check for check
        //3. Save result
        //4. Revert Move
        //5. If necessary remove move from list

    }

    public IPiece getPieceAt(Coordinate coordinate) {
        for (IPiece piece: pieces) {
            Coordinate pieceCoordinate = new Coordinate(piece.getCoordinates().getKey(), piece.getCoordinates().getValue());
            if (pieceCoordinate.equals(coordinate)) {
                return piece;
            }
        }
        return null;
    }

    private boolean kingIsChecked(PieceColor color, ArrayList<Move> opponentsMoves) {

        Coordinate kingCoordinate = null;

        for (IPiece piece: pieces) {
            if (piece.getType() == PieceType.KING && piece.getColor() == color) {
                Pair<Integer, Integer> coordinatePair = piece.getCoordinates();
                kingCoordinate = new Coordinate(coordinatePair.getKey(), coordinatePair.getValue());
            }
        }


        for (Move move: opponentsMoves) {
            assert kingCoordinate != null;
            if (move.getEndCoordinate().equals(kingCoordinate)) {
                return true;
            }
        }

        return false;
    }

    public boolean enPassantAt(int x, int y) {
        Coordinate testedCoordinate = new Coordinate(x, y);
        for (IPiece piece: pieces) {
            if (piece.getType() == PieceType.PAWN) {
                Pawn pawn = (Pawn) piece;
                Coordinate pawnCoordinate = new Coordinate(pawn.getCoordinates().getKey(), pawn.getCoordinates().getValue());
                Coordinate pawnStartCoordinate;
                if (pawn.getColor() == PieceColor.BLACK) {
                    pawnStartCoordinate = new Coordinate(pawnCoordinate.getX(), 6);
                } else {
                    pawnStartCoordinate = new Coordinate(pawnCoordinate.getX(), 1);
                }

                if (history.size() > 0) {

                    Move lastMove = history.get(history.size() - 1);
                    if (lastMove.getEndCoordinate().equals(pawnCoordinate)
                            && lastMove.getEndCoordinate().equals(testedCoordinate)
                            && lastMove.getStartCoordinate().equals(pawnStartCoordinate))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean kingOrTowerNotMoved(PieceColor color, CastleType type) {
        if (color == PieceColor.BLACK) {
            if (type == CastleType.LONG) {
                return BlackCanCastleLong;
            } else {
                return BlackCanCastleShort;
            }
        } else {
            if (type == CastleType.LONG) {
                return WhiteCanCastleLong;
            } else {
                return WhiteCanCastleShort;
            }
        }
    }

    public boolean kingCanCastle(PieceColor color, CastleType type) {

        ArrayList<Move> opponentMoves = legalMovesBlack;
        if (color == PieceColor.BLACK) {
            opponentMoves = legalMovesWhite;
        }


        if (kingIsChecked(color, opponentMoves)) {
            return false;
        }


        if (kingOrTowerNotMoved(color, type)) {

            if (color == PieceColor.WHITE) {

                if (type == CastleType.LONG) {

                    if (getOccupantOfSquare(1, 0) == Occupant.EMPTY
                            && getOccupantOfSquare(2, 0) == Occupant.EMPTY
                            && getOccupantOfSquare(3, 0) == Occupant.EMPTY) {

                        //Check if opponent blocks Castle
                        for (Move move: opponentMoves) {
                            if ((move.getEndCoordinate().getX() == 2 && move.getEndCoordinate().getY() == 0)
                                    || (move.getEndCoordinate().getX() == 3 && move.getEndCoordinate().getY() == 0)) {
                                return false;
                            }
                            return true;
                        }

                    } else {
                        return false;
                    }

                } else {

                    if (getOccupantOfSquare(5, 0) == Occupant.EMPTY
                            && getOccupantOfSquare(6, 0) == Occupant.EMPTY) {


                        //Check if opponent blocks Castle
                        for (Move move: opponentMoves) {
                            if ((move.getEndCoordinate().getX() == 5 && move.getEndCoordinate().getY() == 0)
                                    || (move.getEndCoordinate().getX() == 6 && move.getEndCoordinate().getY() == 0)) {
                                return false;
                            }
                        }
                        return true;

                    } else {
                        return false;
                    }
                }

            } else {

                if (type == CastleType.LONG) {

                    if (getOccupantOfSquare(1, 7) == Occupant.EMPTY
                            && getOccupantOfSquare(2, 7) == Occupant.EMPTY
                            && getOccupantOfSquare(3, 7) == Occupant.EMPTY) {

                        //Check if opponent blocks Castle
                        for (Move move: opponentMoves) {
                            if ((move.getEndCoordinate().getX() == 2 && move.getEndCoordinate().getY() == 7)
                                    || (move.getEndCoordinate().getX() == 3 && move.getEndCoordinate().getY() == 7)) {
                                return false;
                            }
                        }
                        return true;

                    } else {
                        return false;
                    }

                } else {

                    if (getOccupantOfSquare(5, 7) == Occupant.EMPTY
                            && getOccupantOfSquare(6, 7) == Occupant.EMPTY) {

                        //Check if opponent blocks Castle
                        for (Move move: opponentMoves) {
                            if ((move.getEndCoordinate().getX() == 5 && move.getEndCoordinate().getY() == 7)
                                    || (move.getEndCoordinate().getX() == 6 && move.getEndCoordinate().getY() == 7)) {
                                return false;
                            }
                        }
                        return true;

                    } else {
                        return false;
                    }
                }
            }

        }
        return false;
    }
}
