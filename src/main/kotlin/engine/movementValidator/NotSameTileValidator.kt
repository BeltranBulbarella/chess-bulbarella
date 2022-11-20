package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

class NotSameTileValidator : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
       return !movement.getFrom().equals(movement.getTo())
    }
}