package nastya.shymanovich.casher.ui.fragments.operations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class OperationVMFactory @Inject constructor(private val provide: Provider<OperationVM>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return (provide.get()) as T
    }
}