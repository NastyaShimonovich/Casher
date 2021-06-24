package nastya.shymanovich.casher.domain.repository

import io.reactivex.rxjava3.core.BackpressureStrategy
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.schedulers.Schedulers
import nastya.shymanovich.casher.domain.db.dao.CashDao
import nastya.shymanovich.casher.domain.db.entity.CashEntity

class CashRepositoryImp (private val cashDao: CashDao) : CashRepository {
    override fun insertCash(cashEntity: CashEntity): Completable {
        return cashDao.insertCash(cashEntity)
            .subscribeOn(Schedulers.io())
    }

    override fun observeCash(): Flowable<List<CashEntity>> {
        return cashDao
            .getCash()
            .toFlowable(BackpressureStrategy.BUFFER)
            .subscribeOn(Schedulers.io())
    }

    override fun deleteCash(cashEntity: CashEntity): Completable {
        return cashDao
            .deleteCash(cashEntity)
            .subscribeOn(Schedulers.io())
    }
}