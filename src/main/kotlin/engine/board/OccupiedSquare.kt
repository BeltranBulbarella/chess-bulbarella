package edu.austral.dissis.chess.engine.board

import edu.austral.dissis.chess.engine.piece.Piece

class OccupiedSquare(private val color: String, private val piece: Piece) : Square {
    //An occupied square has only 1 piece
    override fun hasPiece(): Boolean = true
    override fun getPiece(): Piece = piece
    override fun toString(): String = " [${piece.toString()} ${color[0]}] "
    override fun getColor() = color
}
