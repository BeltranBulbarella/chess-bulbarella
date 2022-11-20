package edu.austral.dissis.chess.engine.finishValidator

import edu.austral.dissis.chess.engine.GameState

interface FinishValidator {
   fun check(gameState: GameState): CheckFinishResult;
}