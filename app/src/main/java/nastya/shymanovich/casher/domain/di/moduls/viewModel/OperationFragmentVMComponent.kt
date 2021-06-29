package nastya.shymanovich.casher.domain.di.moduls.viewModel

import dagger.Subcomponent
import nastya.shymanovich.casher.ui.fragments.operations.OperationVMFactory

@Subcomponent
interface OperationFragmentVMComponent {
    fun getOperationFragmentFactory(): OperationVMFactory

    @Subcomponent.Builder
    interface Builder {
        fun build(): OperationFragmentVMComponent
    }
}