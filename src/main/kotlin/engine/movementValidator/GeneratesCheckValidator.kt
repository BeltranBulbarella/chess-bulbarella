package edu.austral.dissis.chess.engine.movementValidator

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.EmptySquare
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.OccupiedSquare

class GeneratesCheckValidator : MovementValidator {

    override fun validate(gameState: GameState, movement: Movement): Boolean {

        val gameStateCopy = gameState.getCopy()
        val board = gameStateCopy.getActualBoard()

        val oldFromTile = board.getTile(movement.getFrom())
        val oldToTile = board.getTile(movement.getTo())

        val playerColor = board.getTile(movement.getFrom()).getPiece().getColor()

        //if not it throws error when it looks for the king
        if(oldToTile.hasPiece() && oldToTile.getPiece().getColor() == playerColor && oldToTile.getPiece().getName() == "KING"){
            return false
        }

        board.putAt(movement.getTo(), OccupiedSquare(oldToTile.getColor(), oldFromTile.getPiece()))
        board.putAt(movement.getFrom(), EmptySquare(oldFromTile.getColor()))

        val playerPieces = board.getColorPieces(playerColor)

        val playerKing = playerPieces.find { piece -> piece.getName() == "KING" } ?: throw Error("king not found")

        val oppositePieces = if(playerColor == "WHITE") {
            board.getColorPieces("BLACK")
        } else {
            board.getColorPieces("WHITE")
        }

        val playerKingPosition = board.getPositionFromPiece(playerKing)

        for (piece in oppositePieces){
            val toKingMovement = Movement(board.getPositionFromPiece(piece), playerKingPosition)
            if(piece.canMove(toKingMovement, gameStateCopy)){
                return false
            }
        }
        return true
    }

}