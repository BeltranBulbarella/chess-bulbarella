package edu.austral.dissis.chess.engine.piece

import edu.austral.dissis.chess.engine.GameState
import edu.austral.dissis.chess.engine.board.Movement
import edu.austral.dissis.chess.engine.mover.Mover

class Piece (
    private val id: String,
    private val name: String,
    private val color: String,
    private val movers: List<Mover>,
) {

    //to move a piece we have to check if the movement is valid and then move it
    fun move(movement: Movement, gameState: GameState) {
        for(mover in movers) {
            if(mover.validMovement(movement, gameState)) {
                mover.move(movement, gameState)
                return
            }
        }
        throw Exception("Invalid move")
    }

    //can move to a square if there is a valid movement
    fun canMove(movement: Movement, gameState: GameState): Boolean {
        for(mover in movers) {
            if(mover.validMovement(movement, gameState)) {
                return true
            }
        }
        return false
    }

    fun getId(): String = id

    fun getColor(): String = color

    fun getName(): String = name

    override fun toString(): String = "${color[0]}/$name/$id"


}