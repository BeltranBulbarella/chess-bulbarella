package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

interface MovementValidator {
    fun validate(gameState: GameState, movement: Movement): Boolean;
}