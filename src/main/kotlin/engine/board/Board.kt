package edu.austral.dissis.chess.engine.board

import edu.austral.dissis.chess.engine.piece.Piece


interface Board {
    // Returns the tile at the given position
    fun getSquare(position: Position): Square
    // Puts a square at the given position
    fun putAt(position: Position, square: Square): Square
    // Returns true if the given position is within the board limits
    fun betweenLimits(position: Position): Boolean
    // Returns a copy of the board
    fun getCopy(): Board
    // Returns a list of all the pieces in the board
    fun getPieces(): List<Piece>
    // Returns a list of all the pieces of the given color in the board
    fun getColorPieces(color: String): List<Piece>
    override fun toString(): String
    // Returns the position of the given piece
    fun getPositionFromPiece(piece: Piece): Position
    // Returns the number of rows in the board
    fun getRowSize(): Int
    // Returns the number of columns in the board
    fun getColSize(): Int
}