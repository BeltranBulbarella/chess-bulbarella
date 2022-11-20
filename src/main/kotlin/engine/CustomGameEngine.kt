package edu.austral.dissis.chess.engine

import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.board.Position
import edu.austral.dissis.chess.gui.*

class CustomGameEngine(
    private val game: Game
) : GameEngine{

    override fun applyMove(move: Move): MoveResult {
        return try {
            val movement = Movement(
                Position(move.from.row-1, move.from.column-1),
                Position(move.to.row-1, move.to.column-1)
            )
            game.move(movement)
            if(game.hasFinished()){
                GameOver(game.getWinner())
            } else {
                NewGameState(game.getChessPieces(),game.getNextPlayer())
            }
        }catch (e: Exception){
            InvalidMove(e.message!!)
        }
    }

    override fun init(): InitialState {
        val pieces = game.getChessPieces()
        return InitialState(BoardSize(8,8), pieces, PlayerColor.WHITE)
    }
}