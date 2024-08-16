package ru.android.handsapp.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import ru.android.handsapp.R

abstract class BaseCell(
    val title: String,
    val subTitle: String,
    @DrawableRes val image: Int
) {
    open val typeCell: TypeCell = TypeCell.Dead
    abstract val brush: Brush
}

class CellNewLife(
    title: String = "Жизнь",
    subTitle: String = "Ку-ку!",
    image: Int = R.drawable.cell_new_life
) : BaseCell(title, subTitle, image) {
    override val typeCell: TypeCell = TypeCell.NewLife
    override val brush: Brush
        get() = Brush.verticalGradient(
            colors = listOf(
                Color(0xFFAD00FF),
                Color(0xFFFFB0E9)
            )
        )
}

class CellLive(
    title: String = "Живая",
    subTitle: String = "и шевелится!",
    image: Int = R.drawable.cell_live
) : BaseCell(title, subTitle, image) {
    override val typeCell: TypeCell = TypeCell.Live
    override val brush: Brush
        get() = Brush.verticalGradient(
            colors = listOf(
                Color(0xFFFFB800),
                Color(0xFFFFF7B0)
            )
        )
}

class CellDead(
    title: String = "Мертвая",
    subTitle: String = "или прикидывается",
    image: Int = R.drawable.cell_dead
) : BaseCell(title, subTitle, image) {
    override val typeCell: TypeCell = TypeCell.Dead
    override val brush: Brush
        get() = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF0D658A),
                Color(0xFFB0FFB4)
            )
        )
}

enum class TypeCell {
    Live, Dead, NewLife
}