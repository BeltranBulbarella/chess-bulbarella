package edu.austral.dissis.chess.engine.finishValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.Position
import enums.Color

class CheckMateValidator : FinishValidator {
    //check mate is a brute force where we check every possible move for every piece and see if the king is in check
    //in every move we check if there is a winner
    override fun check(gameState: GameState): CheckFinishResult {
        val colorToCheck = if(gameState.getLastColorMovement() == Color.WHITE.toString()) {
            Color.BLACK.toString()
        }else {
            Color.WHITE.toString()
        }
        val board = gameState.getActualBoardCopy()
        val pieces = board.getColorPieces(colorToCheck)
        for (piece in pieces) {
            val piecePosition = board.getPositionFromPiece(piece)
            for (i in 0 until board.getRowSize()){
                for (j in 0 until board.getColSize()){
                    val toPosition = Position(i,j)
                    if(piece.canMove(Movement(piecePosition, toPosition),gameState)){
                        return NoWinnerResult()
                    }
                }
            }
        }
        return HasWinnerResult(gameState.getLastColorMovement())
    }
}