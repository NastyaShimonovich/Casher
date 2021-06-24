package nastya.shymanovich.casher.domain.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "cashTable")
data class CashEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0,
    @ColumnInfo(name = "sum")
    val sum: Float,
    @ColumnInfo(name = "category")
    val category: String,
    @ColumnInfo(name = "currency")
    val currency: String,
    @ColumnInfo(name = "comment")
    val comment: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "income")
    val income: Boolean,
    @ColumnInfo(name = "timestamp")
    val timestamp: Long
)