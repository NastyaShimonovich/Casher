package nastya.shymanovich.casher.domain.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import nastya.shymanovich.casher.domain.db.entity.CashEntity

@Dao
interface CashDao {

    @Insert
    fun insertCash(cashEntity: CashEntity): Completable

    @Query("SELECT*FROM cashTable")
    fun getCash(): Observable<List<CashEntity>>

    @Delete
    fun deleteCash(cashEntity: CashEntity): Completable

}