package nastya.shymanovich.casher.domain.di

import dagger.Component
import nastya.shymanovich.casher.domain.di.moduls.AppModule
import nastya.shymanovich.casher.domain.di.moduls.RepositoryModule
import nastya.shymanovich.casher.domain.di.moduls.viewModel.AddFragmentVMComponent
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, RepositoryModule::class])
interface AppComponent {
    fun plusAddFragmentVMComponent(): AddFragmentVMComponent.Builder
}