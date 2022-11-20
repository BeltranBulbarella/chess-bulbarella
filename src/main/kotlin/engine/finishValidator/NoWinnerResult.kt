package edu.austral.dissis.chess.engine.finishValidator

class NoWinnerResult : CheckFinishResult{

    override fun hasWinner(): Boolean = false

    override fun getWinnerColor(): String = throw Exception()

}