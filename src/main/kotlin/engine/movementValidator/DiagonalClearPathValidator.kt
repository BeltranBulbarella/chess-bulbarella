package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.Position

class DiagonalClearPathValidator : MovementValidator {

    override fun validate(gameState: GameState, movement: Movement): Boolean {
        if(movement.getFrom().getX() > movement.getTo().getX() && movement.getFrom().getY() > movement.getTo().getY()) {
            var i = movement.getFrom().getX() - 1;
            var j = movement.getFrom().getY() - 1;
            while( i > movement.getTo().getX() && j > movement.getTo().getY()) {
                if(gameState.getActualBoard().getTile(Position(i, j)).hasPiece()){
                    return false
                }
                i -= 1
                j -= 1
            }
            return true
        } else if (movement.getFrom().getX() > movement.getTo().getX() && movement.getFrom().getY() < movement.getTo().getY()) {
            var i = movement.getFrom().getX() - 1;
            var j = movement.getFrom().getY() + 1;
            while( i > movement.getTo().getX() && j < movement.getTo().getY()) {
                if(gameState.getActualBoard().getTile(Position(i, j)).hasPiece()){
                    return false
                }
                i -= 1
                j += 1
            }
            return true
        } else if (movement.getFrom().getX() < movement.getTo().getX() && movement.getFrom().getY() > movement.getTo().getY()) {
            var i = movement.getFrom().getX() + 1;
            var j = movement.getFrom().getY() - 1;
            while( i < movement.getTo().getX() && j > movement.getTo().getY()) {
                if(gameState.getActualBoard().getTile(Position(i, j)).hasPiece()){
                    return false
                }
                i += 1
                j -= 1
            }
            return true
        } else {
            var i = movement.getFrom().getX() + 1;
            var j = movement.getFrom().getY() + 1;
            while( i < movement.getTo().getX() && j < movement.getTo().getY()) {
                if(gameState.getActualBoard().getTile(Position(i, j)).hasPiece()){
                    return false
                }
                i += 1
                j += 1
            }
            return true
        }
    }

}