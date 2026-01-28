package chess.piecemoves;

import java.util.Collection;
import java.util.ArrayList;

import chess.ChessBoard;
import chess.ChessGame.TeamColor;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

public class KingMovesCalculator implements PieceMovesCalculator {
    
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        int currentRow = myPosition.getRow();
        int currentCol = myPosition.getColumn();

        TeamColor pieceColor = board.getPiece(myPosition).getTeamColor();

        ArrayList<ChessMove> possibleMoves = new ArrayList<ChessMove>();

        // Add all candidate moves for the king
        ArrayList<ChessPosition> candidatePositions = new ArrayList<ChessPosition>();
        candidatePositions.add(new ChessPosition(currentRow + 1, currentCol));
        candidatePositions.add(new ChessPosition(currentRow + 1, currentCol + 1));
        candidatePositions.add(new ChessPosition(currentRow, currentCol + 1));
        candidatePositions.add(new ChessPosition(currentRow - 1, currentCol + 1));
        candidatePositions.add(new ChessPosition(currentRow - 1, currentCol));
        candidatePositions.add(new ChessPosition(currentRow - 1, currentCol - 1));
        candidatePositions.add(new ChessPosition(currentRow, currentCol - 1));
        candidatePositions.add(new ChessPosition(currentRow + 1, currentCol - 1));

        // Check all positions to see if they are valid
        for (ChessPosition candidatePosition : candidatePositions) {

            if (candidatePosition.getRow() >= 8 || candidatePosition.getRow() <= 0 || candidatePosition.getColumn() >= 8 || candidatePosition.getColumn() <= 0) {
                continue;
            }

            ChessPiece pieceAtNext = board.getPiece(candidatePosition);
            if (pieceAtNext == null || pieceAtNext.getTeamColor() != pieceColor) {
                possibleMoves.add(new ChessMove(myPosition, candidatePosition, null));
            }
            
        }

        return possibleMoves;

    }

}
