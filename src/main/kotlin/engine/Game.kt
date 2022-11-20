package edu.austral.dissis.chess.engine

import edu.austral.dissis.chess.engine.board.Board
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.finishValidator.FinishValidator
import edu.austral.dissis.chess.gui.ChessPiece
import edu.austral.dissis.chess.gui.PlayerColor
import enums.Color
import edu.austral.dissis.chess.gui.Position as Pos

class Game (
    private val finishValidators: List<FinishValidator>,
    private val gameState: GameState,
){

    fun getActualBoard(): Board {
        return gameState.getActualBoard();
    }

    fun move(movement: Movement): GameState  {
        if(!gameState.getActualBoard().getSquare(movement.getFrom()).hasPiece()) throw Exception("Theres no piece")
        if(gameState.getActualBoard().getSquare(movement.getFrom()).getPiece().getColor() != getNextPlayerColor()) throw Exception("Not your turn")

        val pieceToMove = gameState.getActualBoard().getSquare(movement.getFrom()).getPiece()
        pieceToMove.move(movement, gameState)
        gameState.toggleLastColorMovement()
        checkWinner()
        return gameState
    }

    private fun checkWinner() {
        for (validator in finishValidators) {
            val checkFinishResult = validator.check(gameState)
            if (checkFinishResult.hasWinner()) {
                gameState.finishGame(checkFinishResult.getWinnerColor())
            }
        }
    }

    private fun getNextPlayerColor(): String {
        return if(gameState.getLastColorMovement() == Color.BLACK.toString()) {
            Color.WHITE.toString()
        } else {
            Color.BLACK.toString()
        }
    }

    fun getNextPlayer(): PlayerColor {
        val color = getNextPlayerColor()
        return if(color == Color.BLACK.toString()) {
            PlayerColor.BLACK
        }else {
            PlayerColor.WHITE
        }
    }

    fun getChessPieces(): List<ChessPiece> {
        val pieces = gameState.getActualBoard().getPieces()
        return pieces.map {piece ->
            ChessPiece(
                piece.getId(), if(piece.getColor() == Color.BLACK.toString()){ PlayerColor.BLACK} else { PlayerColor.WHITE},
                Pos(gameState.getActualBoard().getPositionFromPiece(piece).getX()+1, gameState.getActualBoard().getPositionFromPiece(piece).getY()+1), piece.getName().lowercase()
            )
        }
    }

    fun hasFinished(): Boolean {
        return gameState.hasFinished()
    }

    fun getWinner(): PlayerColor {
        val color = gameState.getWinner()
        return if(color == Color.BLACK.toString()) {
            PlayerColor.BLACK
        }else {
            PlayerColor.WHITE
        }
    }

    override fun toString(): String = gameState.toString()

}