package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

class CoronationSpecialValidator(private val startingSideX: Int) : MovementValidator {

    override fun validate(gameState: GameState, movement: Movement): Boolean {
        return if(startingSideX == 0) {
            movement.getTo().getX() == 7
        }else {
            movement.getTo().getX() == 0
        }
    }

}