package edu.austral.dissis.chess.engine.factory.capablancaChess

import edu.austral.dissis.chess.engine.board.EmptySquare
import edu.austral.dissis.chess.engine.board.SquaredBoard
import edu.austral.dissis.chess.engine.board.Square
import edu.austral.dissis.chess.engine.factory.BoardFactory
import enums.Color

class CustomBoardFactory(private val size: Int ) : BoardFactory {
    override fun create(): SquaredBoard {
        val board = Array(size) { arrayOfNulls<Square>(8) }
        for (i in 0..size) {
            for(j in 0..size) {
                if ((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    board[i][j] = EmptySquare(Color.BLACK.toString())
                } else {
                    board[i][j] = EmptySquare(Color.WHITE.toString())
                }
            }
        }
        return SquaredBoard(board as Array<Array<Square>>)
    }
}