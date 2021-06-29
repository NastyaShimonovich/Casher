package nastya.shymanovich.casher.domain.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import nastya.shymanovich.casher.domain.db.entity.CashEntity
import nastya.shymanovich.casher.domain.db.entity.CashOperation

@Dao
interface CashDao {

    @Insert
    fun insertCash(cashEntity: CashOperation): Completable

    @Query("SELECT*FROM cashOperation")
    fun getCash(): Observable<List<CashOperation>>

    @Delete
    fun deleteCash(cashEntity: CashOperation): Completable

}