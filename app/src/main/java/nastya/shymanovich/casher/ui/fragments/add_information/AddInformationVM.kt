package nastya.shymanovich.casher.ui.fragments.add_information

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import nastya.shymanovich.casher.domain.db.entity.CashEntity
import nastya.shymanovich.casher.domain.db.entity.CashOperation
import nastya.shymanovich.casher.domain.repository.CashRepository
import nastya.shymanovich.casher.domain.utils.Date
import javax.inject.Inject

class AddInformationVM @Inject constructor(
    private val cashRepository: CashRepository
) : ViewModel() {

    private var date: Date = Date()
    private var comment: String = ""
    private var amount: Float = 0f
    private var category: String = ""
    private var income: Boolean = true
    private val saveDataSubject = BehaviorSubject.create<Status>()
    val observeSaveData: Observable<Status> =
        saveDataSubject
            .observeOn(AndroidSchedulers.mainThread())
    private val disposable: CompositeDisposable = CompositeDisposable()

    fun setDate(date: Date) {
        this.date = date
    }

    fun saveData() {
        insertData()
    }

    fun setComment(comment: String){
        this.comment = comment
    }

    fun setAmount(amount: Float){
        this.amount = amount
    }

    fun setCategory(category: String){
        this.category = category
    }

    fun setIncome(income: Boolean){
        this.income = income
    }

    private fun insertData() {
        disposable.add(
            cashRepository
                .insertCash(getCash())
                .subscribe({
                    saveDataSubject.onNext(Status.Success)
                }, {
                    saveDataSubject.onNext(Status.Error)
                })
        )
    }

    private fun getCash(): CashOperation {
        return CashOperation(
            dateNumber = date.dayOfMonth,
            dayOfWeek = date.dayOfMonth.toString(),
            month = date.monthOfYear.toString(),
            list = CashEntity(
                category = category,
                currency = amount.toString(),
                comment = comment,
                date = date.toString(),
                income = income,
                timestamp = getTimeStamp()
            )
        )
    }

    private fun getTimeStamp(): Long {
        return System.currentTimeMillis()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}

sealed class Status {
    object Success: Status()
    object Error: Status()
}