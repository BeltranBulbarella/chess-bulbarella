package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.board.EmptySquare
import edu.austral.dissis.chess.engine.board.SquaredBoard
import edu.austral.dissis.chess.engine.board.Tile

class SquaredBoardFactory : BoardFactory {
    override fun create(): SquaredBoard {
        val board = Array(8) { arrayOfNulls<Tile>(8) }
        for (i in 0..7) {
            for(j in 0..7) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    board[i][j] = EmptySquare("BLACK")
                } else {
                    board[i][j] = EmptySquare("WHITE")
                }
            }
        }
        return SquaredBoard(board as Array<Array<Tile>>)
    }
}