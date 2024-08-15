package ru.android.handsapp.presentation.main

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.android.handsapp.model.BaseCell
import ru.android.handsapp.model.CellDead
import ru.android.handsapp.model.CellLive
import ru.android.handsapp.model.CellNewLife
import ru.android.handsapp.model.TypeCell
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class CelliesViewModel @Inject constructor() : ViewModel() {
    private val _cellies = mutableStateListOf<BaseCell>()
    val cellies: List<BaseCell> = _cellies

    fun create() {
        viewModelScope.launch {
            randomCell()
            if (isLifeUpdate(typeCell = TypeCell.Live)) {
                _cellies.add(CellNewLife())
            } else if (isLifeUpdate(typeCell = TypeCell.Dead)) {
                val last = _cellies.findLast { it.typeCell == TypeCell.NewLife }
                last?.let { _cellies.remove(it) }
            }
        }
    }

    private fun randomCell() {
        val type = if (Random.nextBoolean()) 0 else 1
        when (type) {
            0 -> _cellies.add(CellDead())
            1 -> _cellies.add(CellLive())
        }
    }

    private fun isLifeUpdate(typeCell: TypeCell): Boolean {
        var check = false
        if (_cellies.size >= 3) {
            val iStart = _cellies.size - 3
            for (i in iStart.._cellies.size - 1) {
                check =
                    if (_cellies.get(i).typeCell == typeCell) true
                    else {
                        return false
                    }
            }
        }
        return check
    }
}
