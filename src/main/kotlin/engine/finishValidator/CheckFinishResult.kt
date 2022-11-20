package edu.austral.dissis.chess.engine.finishValidator

interface CheckFinishResult {
    fun hasWinner(): Boolean
    fun getWinnerColor(): String
}