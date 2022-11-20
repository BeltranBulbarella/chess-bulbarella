package edu.austral.dissis.chess.engine.mover

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.EmptySquare
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.OccupiedSquare
import edu.austral.dissis.chess.engine.board.Position
import edu.austral.dissis.chess.engine.movementValidator.MovementValidator

class CastlingMover(
    override val validators: List<MovementValidator>,
) : Mover {

    override fun move(movement: Movement, gameState: GameState) {
        val oldFromTile = gameState.getActualBoard().getTile(movement.getFrom())
        val oldToTile = gameState.getActualBoard().getTile(movement.getTo())
        gameState.getActualBoard().putAt(movement.getTo(), OccupiedSquare(oldToTile.getColor(), oldFromTile.getPiece()))
        gameState.getActualBoard().putAt(movement.getFrom(), EmptySquare(oldFromTile.getColor()))

        //add king movement
        gameState.getMovements().add(movement)

        if(movement.getFrom().getY() < movement.getTo().getY()) {

            val oldFromTileRook = gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), movement.getFrom().getY()+3))
            val oldToTileRook = gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), movement.getTo().getY()-1))

            gameState.getActualBoard().putAt(Position(movement.getFrom().getX(), movement.getTo().getY()-1), OccupiedSquare(oldToTileRook.getColor(), oldFromTileRook.getPiece()))
            gameState.getActualBoard().putAt(Position(movement.getFrom().getX(), movement.getFrom().getY()+3), EmptySquare(oldFromTileRook.getColor()))

            //add rook movement
            gameState.getMovements().add(Movement(Position(movement.getFrom().getX(), movement.getFrom().getY()+3),Position(movement.getFrom().getX(), movement.getTo().getY()-1) ))
        }else {

            val oldFromTileRook = gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), movement.getFrom().getY()-4))
            val oldToTileRook = gameState.getActualBoard().getTile(Position(movement.getFrom().getX(), movement.getTo().getY()+1))

            gameState.getActualBoard().putAt(Position(movement.getTo().getX(), movement.getTo().getY()+1), OccupiedSquare(oldToTileRook.getColor(), oldFromTileRook.getPiece()))
            gameState.getActualBoard().putAt(Position(movement.getFrom().getX(), movement.getFrom().getY()-4), EmptySquare(oldFromTileRook.getColor()))

            //add rook movement
            gameState.getMovements().add(Movement(Position(movement.getFrom().getX(), movement.getFrom().getY()-4),Position(movement.getFrom().getX(), movement.getTo().getY()+1)))
        }
    }

    override fun validMovement(movement: Movement, gameState: GameState): Boolean {
        return validators.all {it.validate(gameState, movement)}
    }

}