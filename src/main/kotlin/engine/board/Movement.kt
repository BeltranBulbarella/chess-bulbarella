package edu.austral.dissis.chess.engine.board

class Movement (private val from: Position, private val to: Position){
    //Every movement consist of a from and a to position
    //The from helps to validate movements
    fun getFrom(): Position = from
    fun getTo(): Position = to
}