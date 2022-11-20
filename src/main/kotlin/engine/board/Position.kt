package edu.austral.dissis.chess.engine.board

class Position (private val x: Int, private val y: Int){
    fun getX(): Int = x
    fun getY(): Int = y
    fun equals(otherPosition: Position): Boolean = otherPosition.getX() == this.x && otherPosition.getY() == this.y
}