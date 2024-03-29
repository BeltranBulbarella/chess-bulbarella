package edu.austral.dissis.chess.engine.mover

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.EmptySquare
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.OccupiedSquare
import edu.austral.dissis.chess.engine.movementValidator.MovementValidator

class ClassicMover(
    override val validators: List<MovementValidator>,
) : Mover {

    override fun move(movement: Movement, gameState: GameState) {
        //valida movimiento y lo aplica
        val oldFromTile = gameState.getActualBoard().getSquare(movement.getFrom())
        val oldToTile = gameState.getActualBoard().getSquare(movement.getTo())
        gameState.getActualBoard().putAt(movement.getTo(), OccupiedSquare(oldToTile.getColor(), oldFromTile.getPiece()))
        gameState.getActualBoard().putAt(movement.getFrom(), EmptySquare(oldFromTile.getColor()))
        gameState.getMovements().add(movement)
    }

    override fun validMovement(movement: Movement, gameState: GameState): Boolean {
        return validators.all {it.validate(gameState, movement)}
    }

}