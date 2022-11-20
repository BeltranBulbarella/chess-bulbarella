package edu.austral.dissis.chess.engine.board

import edu.austral.dissis.chess.engine.piece.Piece

//A squared board consists of an array of squares
class SquaredBoard(private val board: Array<Array<Square>>) : Board {

    //Returns the square at the given position
    override fun getSquare(position: Position): Square = board[position.getX()][position.getY()]

    //Sets the square at the given position
    override fun putAt(position: Position, square: Square): Square {
        val oldTile = board[position.getX()][position.getY()]
        board[position.getX()][position.getY()] = square
        return oldTile
    }

    //Returns true if the position is between the limits of the board
    override fun betweenLimits(position: Position): Boolean {
        return position.getX() >= 0 && position.getY() >= 0 && position.getX() <= board.size && position.getY() <= board[0].size
    }


    //Returns a copy of the board
    override fun getCopy(): Board {
        val newBoard = Array(8) { arrayOfNulls<Square>(8) }
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                val tile = board[i][j]
                if (tile.hasPiece()) {
                    newBoard[i][j] = OccupiedSquare(
                        tile.getColor(),
                        tile.getPiece()
                    )
                } else {
                    newBoard[i][j] = EmptySquare(tile.getColor())
                }
            }
        }
        return SquaredBoard(
            newBoard as Array<Array<Square>>
        )
    }

    //Returns a list of all the pieces in the board
    override fun getPieces(): List<Piece> {
        val pieces = mutableListOf<Piece>()
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j].hasPiece()) {
                    pieces.add(board[i][j].getPiece())
                }
            }
        }
        return pieces
    }

    //Returns a list of all the pieces of the given color in the board
    override fun getColorPieces(color: String): List<Piece> {
        val pieces = mutableListOf<Piece>()
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j].hasPiece() && board[i][j].getPiece().getColor() == color) {
                    pieces.add(board[i][j].getPiece())
                }
            }
        }
        return pieces
    }

    override fun toString(): String {
        var string = ""
        for (i in 7 downTo 0) {
            for (j in 0..7) {
                string += board[i][j].toString()
            }
            string += "\n"
        }
        return string
    }

    //Returns the position of a given piece
    override fun getPositionFromPiece(piece: Piece): Position {
        for (i in 0 until board.size) {
            for (j in 0 until board[i].size) {
                if (board[i][j].hasPiece() && board[i][j].getPiece().getId() == piece.getId()) {
                    return Position(i, j)
                }
            }
        }
        throw Exception("Not found")
    }

    override fun getRowSize(): Int {
        return board.size
    }

    override fun getColSize(): Int {
        return board[0].size
    }

}

