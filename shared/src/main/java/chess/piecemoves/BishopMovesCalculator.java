package chess.piecemoves;

import java.util.Collection;
import java.util.ArrayList;

import chess.ChessBoard;
import chess.ChessGame.TeamColor;
import chess.ChessMove;
import chess.ChessPosition;
import chess.ChessPiece;

public class BishopMovesCalculator implements PieceMovesCalculator{
    
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        int currentRow = myPosition.getRow();
        int currentCol = myPosition.getColumn();

        TeamColor pieceColor = board.getPiece(myPosition).getTeamColor();

        ArrayList<ChessMove> possibleMoves = new ArrayList<ChessMove>();

        // Check up and to the right
        currentRow = myPosition.getRow() + 1;
        currentCol = myPosition.getColumn() + 1;
        while (currentRow <= 8 && currentCol <= 8) {

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
            currentCol++;

        }

        // Check up and to the left
        currentRow = myPosition.getRow() + 1;
        currentCol = myPosition.getColumn() - 1;
        while (currentRow <= 8 && currentCol >= 1) {

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
            currentCol--;
            
        }

        // Check down and to the right
        currentRow = myPosition.getRow() - 1;
        currentCol = myPosition.getColumn() + 1;
        while (currentRow >= 1 && currentCol <= 8) {

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
            currentCol++;

        }

        // Check down and to the left
        currentRow = myPosition.getRow() - 1;
        currentCol = myPosition.getColumn() - 1;
        while (currentRow >= 1 && currentCol >= 1) {

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
            currentCol--;

        }

        return possibleMoves;

    }

}
