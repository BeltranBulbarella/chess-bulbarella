package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

class VerticalMovementValidator() : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
        return movement.getFrom().getY() == movement.getTo().getY()
    }
}