package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.EmptySquare
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.OccupiedSquare
import edu.austral.dissis.chess.engine.board.Position
import kotlin.math.abs

class CastlingSpecialValidator : MovementValidator {

    override fun validate(gameState: GameState, movement: Movement): Boolean {

        val pieceId = if(movement.getFrom().getY() <  movement.getTo().getY()) {
            gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), 7)).getPiece().getId()
        }else {
            gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), 0)).getPiece().getId()
        }

        //checks free space besides rook
        if(movement.getFrom().getY() <  movement.getTo().getY() && gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), 6)).hasPiece()) {
            return false
        }else if (movement.getFrom().getY() >  movement.getTo().getY() && gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), 1)).hasPiece()){
            return false
        }

        //checks that king is moving 2 to the left or rithg
        if(abs( movement.getFrom().getY()-movement.getTo().getY()) != 2) {
            return false
        }

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