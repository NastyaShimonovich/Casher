package nastya.shymanovich.casher.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import nastya.shymanovich.casher.domain.db.entity.CashEntity

interface CashRepository {
    fun insertCash(cashEntity: CashEntity): Completable
    fun observeCash(): Flowable<List<CashEntity>>
    fun deleteCash(cashEntity: CashEntity): Completable
}