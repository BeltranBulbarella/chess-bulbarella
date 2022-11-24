package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.movementValidator.*
import edu.austral.dissis.chess.engine.mover.CastlingMover
import edu.austral.dissis.chess.engine.mover.ClassicMover
import edu.austral.dissis.chess.engine.mover.CoronationMover
import edu.austral.dissis.chess.engine.piece.Piece
import enums.PieceName

class ClassicPieceFactory {
    fun pawn(id: String, color: String, startingSideX: Int): Piece {
        return Piece(id, PieceName.PAWN.toString(), color, listOf(
            //coronation
            CoronationMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalDistanceValidator(1),
                    EmptySquareValidator(),
                    OnlyForwardVerticalValidator(startingSideX),
                    CoronationSpecialValidator(startingSideX),
                    GeneratesCheckValidator()
                )
            ),
            //1 move foward
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalDistanceValidator(1),
                    EmptySquareValidator(),
                    OnlyForwardVerticalValidator(startingSideX),
                    GeneratesCheckValidator()
                )
            ),
            //2 moves foward only first time
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalDistanceValidator(2),
                    HasMovedValidator(),
                    EmptySquareValidator(),
                    OnlyForwardVerticalValidator(startingSideX),
                    GeneratesCheckValidator()
                )
            ),
            //capture move 1 diagonal
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalDistanceValidator(1),
                    EatsValidator(),
                    OnlyForwardVerticalValidator(startingSideX),
                    GeneratesCheckValidator()
                )
            ),
        ))
    }
    fun bishop(id: String, color: String): Piece {
        return Piece(id, PieceName.BISHOP.toString(), color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            )
        ))
    }
    fun knight(id: String, color: String): Piece {
        return Piece(id, PieceName.KNIGHT.toString(), color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    SpecialHorseMovementValidator(),
                    NotSameColorValidator(),
                    GeneratesCheckValidator()
                )
            ),
        ))
    }
    fun rook(id: String, color: String): Piece {
        return Piece(id, PieceName.ROOK.toString(), color, listOf(
            ClassicMover(
                //rook movement horizontal
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HorizontalMovementValidator(),
                    HorizontalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            //rook movement vertical
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
        ))
    }
    fun queen(id: String, color: String): Piece {
        return Piece(id, PieceName.QUEEN.toString(), color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HorizontalMovementValidator(),
                    HorizontalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
        ))
    }
    fun king(id: String, color: String): Piece {
        return Piece(id,PieceName.KING.toString(), color, listOf(
            ClassicMover(
                //knight 1 horizontal
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HorizontalMovementValidator(),
                    HorizontalDistanceValidator(1),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            //knight 1 vertical
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalDistanceValidator(1),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            //knight 1 diagonal
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalDistanceValidator(1),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            CastlingMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HasMovedValidator(),
                    HorizontalClearPathValidator(),
                    HorizontalMovementValidator(),
                    CastlingSpecialValidator(),
                )
            )
        ))
    }
    fun knightBishop(id: String, color: String): Piece {
        return Piece(id, PieceName.BISHOP.toString(), color, listOf(
            //bishop movers
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    DiagonalMovementValidator(),
                    DiagonalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            //knight movers
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    SpecialHorseMovementValidator(),
                    NotSameColorValidator(),
                    GeneratesCheckValidator()
                )
            ),
        ));
    }
    fun knightRook(id: String, color: String): Piece {
        return Piece(id, PieceName.ROOK.toString(), color, listOf(
            //rook movers
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HorizontalMovementValidator(),
                    HorizontalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    VerticalMovementValidator(),
                    VerticalClearPathValidator(),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
            //knight movers
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    SpecialHorseMovementValidator(),
                    NotSameColorValidator(),
                    GeneratesCheckValidator()
                )
            ),
        ));
    }
}