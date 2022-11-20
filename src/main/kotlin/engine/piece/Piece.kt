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

    fun move(movement: Movement, gameState: GameState) {
        for(mover in movers) {
            if(mover.validMovement(movement, gameState)) {
                mover.move(movement, gameState)
                return
            }
        }
        throw Exception("Invalid move")
    }

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