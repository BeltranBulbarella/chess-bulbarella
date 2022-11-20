package edu.austral.dissis.chess.engine

import edu.austral.dissis.chess.engine.board.Board
import edu.austral.dissis.chess.engine.board.Movement

class GameState(
    private val movements: MutableList<Movement>,
    private val initialBoard: Board,
    private val actualBoard: Board,
    private var hasFinished: Boolean,
    private var winnerColor: String,
    private var lastColorMovement: String,
) {

    fun getActualBoard(): Board = actualBoard

    fun getActualBoardCopy(): Board = actualBoard.getCopy()

    fun getInitialBoardCopy(): Board = initialBoard.getCopy()

    fun getMovements(): MutableList<Movement> = movements

    fun finishGame(color: String) {
        hasFinished = true
        winnerColor = color
    }

    fun getLastColorMovement(): String {
       return lastColorMovement
    }

    override fun toString(): String {
        return actualBoard.toString()
    }

    fun hasFinished(): Boolean = hasFinished

    fun getWinner(): String = winnerColor

    fun toggleLastColorMovement() {
        lastColorMovement = if(lastColorMovement == "BLACK") {
            "WHITE"
        } else {
            "BLACK"
        }
    }

    fun getCopy(): GameState {
        return GameState(
            movements,
            initialBoard.getCopy(),
            actualBoard.getCopy(),
            hasFinished,
            winnerColor,
            lastColorMovement
        )
    }
}