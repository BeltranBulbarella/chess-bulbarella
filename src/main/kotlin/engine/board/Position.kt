package edu.austral.dissis.chess.engine.board

class Position (private val x: Int, private val y: Int){
    //Every position has an x and a y coordinate
    //In a regular board ot would be number and letter
    fun getX(): Int = x
    fun getY(): Int = y
    //This method is used to compare positions
    //It is used to validate not same square movement
    fun equals(otherPosition: Position): Boolean = otherPosition.getX() == this.x && otherPosition.getY() == this.y
}