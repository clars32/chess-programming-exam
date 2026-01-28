package chess.piecemoves;

import java.util.ArrayList;
import java.util.Collection;

import chess.ChessBoard;
import chess.ChessGame.TeamColor;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

public class RookMovesCalculator implements PieceMovesCalculator {
    
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        int currentRow = myPosition.getRow();
        int currentCol = myPosition.getColumn();

        TeamColor pieceColor = board.getPiece(myPosition).getTeamColor();

        ArrayList<ChessMove> possibleMoves = new ArrayList<ChessMove>();

        // Horizontal moves

        // Check up
        currentRow = myPosition.getRow();
        currentCol = myPosition.getColumn() + 1;
        while (currentCol <= 8) {

            ChessPosition nextPosition = new ChessPosition(currentRow, currentCol);
            ChessPiece pieceAtNext = board.getPiece(nextPosition);

            if (pieceAtNext == null) {
                possibleMoves.add(new ChessMove(myPosition, nextPosition, null));
            } else if (pieceAtNext.getTeamColor() != pieceColor) {
                possibleMoves.add(new ChessMove(myPosition, nextPosition, null));
                break;
            } else {
                break;
            }

            currentCol++;

        }

        // Check down
        currentRow = myPosition.getRow();
        currentCol = myPosition.getColumn() - 1;
        while (currentCol >= 1) {

            ChessPosition nextPosition = new ChessPosition(currentRow, currentCol);
            ChessPiece pieceAtNext = board.getPiece(nextPosition);

            if (pieceAtNext == null) {
                possibleMoves.add(new ChessMove(myPosition, nextPosition, null));
            } else if (pieceAtNext.getTeamColor() != pieceColor) {
                possibleMoves.add(new ChessMove(myPosition, nextPosition, null));
                break;
            } else {
                break;
            }

            currentCol--;

        }

        // Check to the left
        currentRow = myPosition.getRow() - 1;
        currentCol = myPosition.getColumn();
        while (currentRow >= 1) {

            ChessPosition nextPosition = new ChessPosition(currentRow, currentCol);
            ChessPiece pieceAtNext = board.getPiece(nextPosition);


            if (pieceAtNext == null) {
                possibleMoves.add(new ChessMove(myPosition, nextPosition, null));
            } else if (pieceAtNext.getTeamColor() != pieceColor) {
                possibleMoves.add(new ChessMove(myPosition, nextPosition, null));
                break;
            } else {
                break;
            }

            currentRow--;
            
        }

        // Check to the right
        currentRow = myPosition.getRow() + 1;
        currentCol = myPosition.getColumn();
        while (currentRow <= 8) {

            ChessPosition nextPosition = new ChessPosition(currentRow, currentCol);
            ChessPiece pieceAtNext = board.getPiece(nextPosition);


            if (pieceAtNext == null) {
                possibleMoves.add(new ChessMove(myPosition, nextPosition, null));
            } else if (pieceAtNext.getTeamColor() != pieceColor) {
                possibleMoves.add(new ChessMove(myPosition, nextPosition, null));
                break;
            } else {
                break;
            }

            currentRow++;
            
        }

        return possibleMoves;

    }

}
