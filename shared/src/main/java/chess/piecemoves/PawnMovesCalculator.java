package chess.piecemoves;

import java.util.ArrayList;
import java.util.Collection;

import chess.ChessBoard;
import chess.ChessGame.TeamColor;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPiece.PieceType;
import chess.ChessPosition;

public class PawnMovesCalculator implements PieceMovesCalculator {
    
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        int currentRow = myPosition.getRow();
        int currentCol = myPosition.getColumn();

        TeamColor pieceColor = board.getPiece(myPosition).getTeamColor();

        int moveDirection = pieceColor == TeamColor.WHITE ? 1 : -1;

        ArrayList<ChessMove> possibleMoves = new ArrayList<ChessMove>();

        // Check to see if the pawn can move forward normally
        int newRow = currentRow + (moveDirection * 1);
        ChessPosition candidatePosition = new ChessPosition(newRow, currentCol);
        ChessPiece pieceAtNext = board.getPiece(candidatePosition);
        if (pieceAtNext == null) {
            if (pieceColor == TeamColor.WHITE && newRow == 8 || pieceColor == TeamColor.BLACK && newRow == 1) { // Promotion
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.BISHOP));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.KNIGHT));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.QUEEN));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.ROOK));
            } else {
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, null));
            }
        }

        // Check to see if the pawn can capture diagonally
        if (currentCol <= 7) { // Ensure that we're not moving off the edge of the board
            candidatePosition = new ChessPosition(currentRow + (moveDirection * 1), currentCol + 1);
            pieceAtNext = board.getPiece(candidatePosition);
            if (pieceAtNext != null && pieceAtNext.getTeamColor() != pieceColor) {
                if (pieceColor == TeamColor.WHITE && newRow == 8 || pieceColor == TeamColor.BLACK && newRow == 1) { // Promotion
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.BISHOP));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.KNIGHT));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.QUEEN));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.ROOK));
                } else {
                    possibleMoves.add(new ChessMove(myPosition, candidatePosition, null));
                }
            }
        }
        if (currentCol >= 2) {
            candidatePosition = new ChessPosition(currentRow + (moveDirection * 1), currentCol - 1);
            pieceAtNext = board.getPiece(candidatePosition);
            if (pieceAtNext != null && pieceAtNext.getTeamColor() != pieceColor) {
                if (pieceColor == TeamColor.WHITE && newRow == 8 || pieceColor == TeamColor.BLACK && newRow == 1) { // Promotion
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.BISHOP));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.KNIGHT));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.QUEEN));
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, PieceType.ROOK));
                } else {
                    possibleMoves.add(new ChessMove(myPosition, candidatePosition, null));
                }
            }
        }

        // Check to see if the pawn can move two squares off its starting row
        if ((pieceColor == TeamColor.WHITE && currentRow == 2) || (pieceColor == TeamColor.BLACK && currentRow == 7)) {
            ChessPosition interveningPosition = new ChessPosition(currentRow + (moveDirection * 1), currentCol);
            candidatePosition = new ChessPosition(currentRow + (moveDirection * 2), currentCol);
            ChessPiece interveningPiece = board.getPiece(interveningPosition);
            pieceAtNext = board.getPiece(candidatePosition);
            if (interveningPiece == null && pieceAtNext == null) {
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, null));
            }
        }

        return possibleMoves;

    }

}
