package edu.austral.dissis.chess.engine.board

import edu.austral.dissis.chess.engine.piece.Piece


interface Square {
    fun hasPiece(): Boolean
    fun getPiece(): Piece
    fun getColor(): String
    override fun toString(): String
}