package nastya.shymanovich.casher.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import nastya.shymanovich.casher.domain.db.entity.CashEntity
import nastya.shymanovich.casher.domain.db.entity.CashOperation

interface CashRepository {
    fun insertCash(cashEntity: CashOperation): Completable
    fun observeCash(): Flowable<List<CashOperation>>
    fun deleteCash(cashEntity: CashOperation): Completable
}