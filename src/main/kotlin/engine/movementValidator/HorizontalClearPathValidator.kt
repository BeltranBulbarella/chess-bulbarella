package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.Position

class HorizontalClearPathValidator : MovementValidator {

    override fun validate(gameState: GameState, movement: Movement): Boolean {
        if(movement.getFrom().getY() < movement.getTo().getY()){
            var i = movement.getFrom().getY() + 1;
            while( i < movement.getTo().getY()) {
                if(gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), i)).hasPiece()){
                    return false
                }
                i += 1
            }
            return true
        }else {
            var i = movement.getFrom().getY() - 1;
            while( i > movement.getTo().getY()) {
                if(gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), i)).hasPiece()){
                    return false
                }
                i -= 1
            }
            return true
        }
    }

}