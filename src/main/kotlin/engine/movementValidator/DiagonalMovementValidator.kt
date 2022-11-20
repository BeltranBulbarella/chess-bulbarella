package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement
import kotlin.math.abs

class DiagonalMovementValidator : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
        return abs(movement.getFrom().getX() - movement.getTo().getX()) == abs(movement.getFrom().getY() - movement.getTo().getY())
    }
}