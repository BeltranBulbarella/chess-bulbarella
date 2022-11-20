package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.board.Board

interface BoardFactory {
    fun create(): Board
}