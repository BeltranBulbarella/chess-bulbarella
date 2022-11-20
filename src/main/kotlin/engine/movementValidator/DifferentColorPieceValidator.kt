package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

class DifferentColorPieceValidator : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
        if(!gameState.getActualBoard().getTile(movement.getTo()).hasPiece()) return true
        return gameState.getActualBoard().getTile(movement.getFrom()).getPiece().getColor() != gameState.getActualBoard().getTile(movement.getTo()).getPiece().getColor()
    }
}