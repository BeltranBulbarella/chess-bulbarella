package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

class EmptySquareValidator : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
        return !gameState.getActualBoard().getTile(movement.getTo()).hasPiece()
    }
}