package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.EmptySquare
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.OccupiedSquare

class HasMovedValidator : MovementValidator {

    override fun validate(gameState: GameState, movement: Movement): Boolean {
        val pieceId = gameState.getActualBoard().getTile(movement.getFrom()).getPiece().getId()
        val initialBoard = gameState.getInitialBoardCopy()
        val movements = gameState.getMovements()
        for(movement in movements) {
            if(initialBoard.getTile(movement.getFrom()).getPiece().getId() == pieceId) return false
            val oldFromTile = initialBoard.getTile(movement.getFrom())
            val oldToTile = initialBoard.getTile(movement.getTo())
            initialBoard.putAt(movement.getTo(), OccupiedSquare(oldToTile.getColor(), oldFromTile.getPiece()))
            initialBoard.putAt(movement.getFrom(), EmptySquare(oldFromTile.getColor()))
        }
        return true
    }

}