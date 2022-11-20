package edu.austral.dissis.chess.engine.factory

import edu.austral.dissis.chess.engine.movementValidator.*
import edu.austral.dissis.chess.engine.mover.CastlingMover
import edu.austral.dissis.chess.engine.mover.ClassicMover
import edu.austral.dissis.chess.engine.mover.CoronationMover
import edu.austral.dissis.chess.engine.piece.Piece

class ClassicPieceFactory {
    fun pawn(id: String, color: String, startingSideX: Int): Piece {
        return Piece(id, "PAWN", color, listOf(
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
        return Piece(id, "BISHOP", color, listOf(
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
        return Piece(id, "KNIGHT", color, listOf(
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
        return Piece(id, "ROOK", color, listOf(
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
        ))
    }
    fun queen(id: String, color: String): Piece {
        return Piece(id, "QUEEN", color, listOf(
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
        return Piece(id,"KING", color, listOf(
            ClassicMover(
                listOf(
                    NotSameTileValidator(),
                    InBoundsValidator(),
                    HorizontalMovementValidator(),
                    HorizontalDistanceValidator(1),
                    GeneratesCheckValidator(),
                    NotSameColorValidator()
                )
            ),
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
        return Piece(id, "BISHOP", color, listOf(
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
        return Piece(id, "ROOK", color, listOf(
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