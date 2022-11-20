package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

class InBoundsValidator : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
       return gameState.getActualBoard().betweenLimits(movement.getFrom()) && gameState.getActualBoard().betweenLimits(movement.getTo())
    }
}