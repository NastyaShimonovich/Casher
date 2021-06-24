package nastya.shymanovich.casher.ui.fragments.add_information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class AddInformationVMFactory @Inject constructor(private val provider: Provider<AddInformationVM>) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return (provider.get()) as T
    }
}