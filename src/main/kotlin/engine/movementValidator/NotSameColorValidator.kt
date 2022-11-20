package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement

class NotSameColorValidator : MovementValidator {
    override fun validate(gameState: GameState, movement: Movement): Boolean {
        val toTile = gameState.getActualBoard().getSquare(movement.getTo())
        val fromTile = gameState.getActualBoard().getSquare(movement.getFrom())
        return !toTile.hasPiece() || !toTile.getPiece().getColor().equals(fromTile.getPiece().getColor())
    }
}