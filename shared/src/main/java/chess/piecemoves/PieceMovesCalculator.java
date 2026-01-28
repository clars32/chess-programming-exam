package chess.piecemoves;

import java.util.Collection;

import chess.ChessBoard;
import chess.ChessMove;
import chess.ChessPosition;

public interface PieceMovesCalculator {
    
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition);

}
