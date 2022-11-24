package edu.austral.dissis.chess.engine.factory.capablancaChess

import edu.austral.dissis.chess.engine.factory.SquaredBoardFactory
import edu.austral.dissis.chess.engine.Game
import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.OccupiedSquare
import edu.austral.dissis.chess.engine.board.Position
import edu.austral.dissis.chess.engine.finishValidator.CheckMateValidator
import edu.austral.dissis.chess.engine.finishValidator.FinishValidator
import enums.Color

class CapablancaGameFactory(
    //Factory for the creation of a capablanca game, requires a board and a piece factory
    private val squaredBoardFactory: SquaredBoardFactory,
    private val CapablancaPieceFactory: CapablancaPieceFactory
) {

    companion object Create {
        fun createFactory(): CapablancaGameFactory {
            return CapablancaGameFactory(
                SquaredBoardFactory(),
                CapablancaPieceFactory()
            )
        }
    }

    fun create(): Game {
        val finishValidators = listOf<FinishValidator>(
            CheckMateValidator()
        )
        //creates a board and asigns the pieces to it
        val board = squaredBoardFactory.create()
        for (i in 0..7) {
            board.putAt(Position(1,i), OccupiedSquare(board.getSquare(Position(1,i)).getColor(), CapablancaPieceFactory.pawn("1$i", Color.WHITE.toString(), 0)))
            board.putAt(Position(6,i), OccupiedSquare(board.getSquare(Position(6,i)).getColor(), CapablancaPieceFactory.pawn("6$i", Color.BLACK.toString(), 7)))
        }
        board.putAt(
            Position(0,0),
            OccupiedSquare(board.getSquare(Position(0,0)).getColor(),  CapablancaPieceFactory.knightRook("00", Color.WHITE.toString()))
        )
        board.putAt(
            Position(0,7),
            OccupiedSquare(board.getSquare(Position(0,7)).getColor(),  CapablancaPieceFactory.knightRook("07", Color.WHITE.toString()))
        )
        board.putAt(
            Position(0,2),
            OccupiedSquare(board.getSquare(Position(0,2)).getColor(),  CapablancaPieceFactory.knightBishop("01", Color.WHITE.toString()))
        )
        board.putAt(
            Position(0,5),
            OccupiedSquare(board.getSquare(Position(0,5)).getColor(),  CapablancaPieceFactory.knightBishop("06", Color.WHITE.toString()))
        )
        board.putAt(
            Position(0,1),
            OccupiedSquare(board.getSquare(Position(0,1)).getColor(),  CapablancaPieceFactory.knight("02", Color.WHITE.toString()))
        )
        board.putAt(
            Position(0,6),
            OccupiedSquare(board.getSquare(Position(0,6)).getColor(),  CapablancaPieceFactory.knight("05", Color.WHITE.toString()))
        )
        board.putAt(
            Position(0,3),
            OccupiedSquare(board.getSquare(Position(0,3)).getColor(),  CapablancaPieceFactory.queen("03", Color.WHITE.toString()))
        )
        board.putAt(
            Position(0,4),
            OccupiedSquare(board.getSquare(Position(0,4)).getColor(),  CapablancaPieceFactory.king("04", Color.WHITE.toString()))
        )

        board.putAt(
            Position(7,0),
            OccupiedSquare(board.getSquare(Position(7,0)).getColor(),  CapablancaPieceFactory.knightRook("70", Color.BLACK.toString()))
        )
        board.putAt(
            Position(7,7),
            OccupiedSquare(board.getSquare(Position(7,7)).getColor(),  CapablancaPieceFactory.knightRook("77", Color.BLACK.toString()))
        )
        board.putAt(
            Position(7,2),
            OccupiedSquare(board.getSquare(Position(7,2)).getColor(),  CapablancaPieceFactory.knightBishop("71", Color.BLACK.toString()))
        )
        board.putAt(
            Position(7,5),
            OccupiedSquare(board.getSquare(Position(7,5)).getColor(),  CapablancaPieceFactory.knightBishop("76", Color.BLACK.toString()))
        )
        board.putAt(
            Position(7,1),
            OccupiedSquare(board.getSquare(Position(7,1)).getColor(),  CapablancaPieceFactory.knight("72", Color.BLACK.toString()))
        )
        board.putAt(
            Position(7,6),
            OccupiedSquare(board.getSquare(Position(7,6)).getColor(),  CapablancaPieceFactory.knight("75", Color.BLACK.toString()))
        )
        board.putAt(
            Position(7,3),
            OccupiedSquare(board.getSquare(Position(7,3)).getColor(),  CapablancaPieceFactory.queen("73", Color.BLACK.toString()))
        )
        board.putAt(
            Position(7,4),
            OccupiedSquare(board.getSquare(Position(7,4)).getColor(),  CapablancaPieceFactory.king("74", Color.BLACK.toString()))
        )

        return Game(
            finishValidators,
            GameState(
                mutableListOf(),
                board,
                board.getCopy(),
                false,
                "",
                Color.BLACK.toString()
            )
        )
    }

}