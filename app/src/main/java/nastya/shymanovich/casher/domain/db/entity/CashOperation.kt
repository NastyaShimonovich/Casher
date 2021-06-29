package nastya.shymanovich.casher.domain.db.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cashOperation")
data class CashOperation(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "dateNumber")
    val dateNumber: Int,
    @ColumnInfo(name = "dayOfWeek")
    val dayOfWeek: String,
    @ColumnInfo(name = "month")
    val month: String,
    @ColumnInfo(name = "listCashEntity")
    val list: CashEntity
)