package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

class EatsValidator() : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
        val toTile = gameState.getActualBoard().getTile(movement.getTo())
        val fromTile = gameState.getActualBoard().getTile(movement.getFrom())
        return toTile.hasPiece() && (toTile.getPiece().getColor() != fromTile.getPiece().getColor())
    }
}