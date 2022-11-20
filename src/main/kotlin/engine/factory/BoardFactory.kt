package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.board.Board

interface BoardFactory {
    //Interface for the creation of a board
    fun create(): Board
}