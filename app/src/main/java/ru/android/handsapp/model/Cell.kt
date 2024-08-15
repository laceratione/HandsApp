package ru.android.handsapp.model

abstract class BaseCell(
    val title: String,
    val subTitle: String,
) {
    open val typeCell: TypeCell = TypeCell.Dead
}

class CellNewLife(
    title: String = "Жизнь",
    subTitle: String = "Ку-ку!",
) : BaseCell(title, subTitle) {
    override val typeCell: TypeCell = TypeCell.NewLife
}

class CellLive(
    title: String = "Живая",
    subTitle: String = "и шевелится!"
) : BaseCell(title, subTitle) {
    override val typeCell: TypeCell = TypeCell.Live
}

class CellDead(
    title: String = "Мертвая",
    subTitle: String = "или прикидывается"
) : BaseCell(title, subTitle) {
    override val typeCell: TypeCell = TypeCell.Dead
}

enum class TypeCell {
    Live, Dead, NewLife
}