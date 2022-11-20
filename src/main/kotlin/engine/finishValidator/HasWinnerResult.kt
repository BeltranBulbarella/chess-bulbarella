package edu.austral.dissis.chess.engine.finishValidator

class HasWinnerResult(
    private val winnerColor: String
) : CheckFinishResult{

    override fun hasWinner(): Boolean = true

    override fun getWinnerColor(): String = winnerColor

}