package nastya.shymanovich.casher.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import nastya.shymanovich.casher.domain.db.dao.CashDao
import nastya.shymanovich.casher.domain.db.entity.CashEntity
import nastya.shymanovich.casher.domain.db.entity.CashOperation

@Database(entities = [CashOperation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cashDao(): CashDao
}