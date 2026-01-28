package chess.piecemoves;

import java.util.ArrayList;
import java.util.Collection;

import chess.ChessBoard;
import chess.ChessGame.TeamColor;
import chess.ChessMove;
import chess.ChessPiece;
import chess.ChessPosition;

public class KnightMovesCalculator implements PieceMovesCalculator {

    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {

        int currentRow = myPosition.getRow();
        int currentCol = myPosition.getColumn();

        TeamColor pieceColor = board.getPiece(myPosition).getTeamColor();

        ArrayList<ChessMove> possibleMoves = new ArrayList<ChessMove>();

        // Add all candidate moves for the knight
        ArrayList<ChessPosition> candidatePositions = new ArrayList<ChessPosition>();
        candidatePositions.add(new ChessPosition(currentRow + 2, currentCol + 1));
        candidatePositions.add(new ChessPosition(currentRow + 1, currentCol + 2));
        candidatePositions.add(new ChessPosition(currentRow - 1, currentCol + 2));
        candidatePositions.add(new ChessPosition(currentRow - 2, currentCol + 1));
        candidatePositions.add(new ChessPosition(currentRow + 2, currentCol - 1));
        candidatePositions.add(new ChessPosition(currentRow + 1, currentCol - 2));
        candidatePositions.add(new ChessPosition(currentRow - 1, currentCol - 2));
        candidatePositions.add(new ChessPosition(currentRow - 2, currentCol - 1));

        // Check all positions to see if they are valid
        for (ChessPosition candidatePosition : candidatePositions) {

            if (candidatePosition.getRow() > 8 || candidatePosition.getRow() < 1 || candidatePosition.getColumn() > 8 || candidatePosition.getColumn() < 1) {
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
