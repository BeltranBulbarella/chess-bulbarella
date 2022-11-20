package edu.austral.dissis.chess.engine.mover

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.movementValidator.MovementValidator

interface Mover{
    val validators: List<MovementValidator>
    fun move(movement: Movement, gameState: GameState)
    fun validMovement(movement: Movement, gameState: GameState): Boolean
}