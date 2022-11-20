package edu.austral.dissis.chess.engine.board

class Movement (private val from: Position, private val to: Position){
    fun getFrom(): Position = from
    fun getTo(): Position = to
}