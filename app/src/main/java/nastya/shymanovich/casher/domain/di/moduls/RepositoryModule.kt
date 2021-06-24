package nastya.shymanovich.casher.domain.di.moduls

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import nastya.shymanovich.casher.domain.db.AppDatabase
import nastya.shymanovich.casher.domain.db.dao.CashDao
import nastya.shymanovich.casher.domain.repository.CashRepository
import nastya.shymanovich.casher.domain.repository.CashRepositoryImp
import javax.inject.Singleton

@Module
class RepositoryModule (private val context: Context) {

    private var database: AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "database").build()

    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase = database

    @Provides
    @Singleton
    fun provideCashDao(appDatabase: AppDatabase): CashDao = appDatabase.cashDao()

    @Provides
    @Singleton
    fun provideCashRepository(cashDao: CashDao): CashRepository = CashRepositoryImp(cashDao)
}