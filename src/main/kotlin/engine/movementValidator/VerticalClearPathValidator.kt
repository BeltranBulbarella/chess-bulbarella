package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.Position

class VerticalClearPathValidator : MovementValidator {

    override fun validate(gameState: GameState, movement: Movement): Boolean {
        if(movement.getFrom().getX() < movement.getTo().getX()){
            var i = movement.getFrom().getX() + 1;
            while( i < movement.getTo().getX()) {
                if(gameState.getActualBoard().getTile(Position(i, movement.getFrom().getY())).hasPiece()){
                    return false
                }
                i += 1
            }
            return true
        }else {
            var i = movement.getFrom().getX() - 1;
            while( i > movement.getTo().getX()) {
                if(gameState.getActualBoard().getTile(Position(i, movement.getFrom().getY())).hasPiece()){
                    return false
                }
                i -= 1
            }
            return true
        }
    }

}