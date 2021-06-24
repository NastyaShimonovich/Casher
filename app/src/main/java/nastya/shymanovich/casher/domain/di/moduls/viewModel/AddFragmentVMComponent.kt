package nastya.shymanovich.casher.domain.di.moduls.viewModel

import dagger.Provides
import dagger.Subcomponent
import nastya.shymanovich.casher.ui.fragments.add_information.AddInformationVMFactory

@Subcomponent
interface AddFragmentVMComponent {
    fun getAddFragmentFactory(): AddInformationVMFactory

    @Subcomponent.Builder
    interface Builder {
        fun build(): AddFragmentVMComponent
    }
}