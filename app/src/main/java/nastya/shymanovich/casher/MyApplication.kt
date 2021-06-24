package nastya.shymanovich.casher

import androidx.multidex.MultiDexApplication
import nastya.shymanovich.casher.domain.di.AppComponent
import nastya.shymanovich.casher.domain.di.DaggerAppComponent
import nastya.shymanovich.casher.domain.di.moduls.AppModule
import nastya.shymanovich.casher.domain.di.moduls.RepositoryModule

class MyApplication : MultiDexApplication() {

    companion object {
        private lateinit var appComponent: AppComponent
        fun getAppComponent(): AppComponent = appComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .repositoryModule(RepositoryModule(this))
            .build()
    }

}