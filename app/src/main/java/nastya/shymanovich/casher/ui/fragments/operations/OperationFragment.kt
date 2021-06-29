package nastya.shymanovich.casher.ui.fragments.operations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import nastya.shymanovich.casher.MyApplication
import nastya.shymanovich.casher.R
import nastya.shymanovich.casher.databinding.FragmentOperationsBinding

class OperationFragment : Fragment(R.layout.fragment_operations) {
    private lateinit var binding: FragmentOperationsBinding
    private lateinit var viewModel: OperationVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOperationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()
    }

    private fun initViewModel() {
        val factory = MyApplication
            .getAppComponent()
            .plusOperationFragmentVMComponent()
            .build()
            .getOperationFragmentFactory()

        viewModel = ViewModelProvider(this, factory)
            .get(OperationVM::class.java)
    }

    private fun initView() {
        binding.fab.setOnClickListener {
            openFragment()
        }
    }

    private fun openFragment() {
        requireActivity().findNavController(R.id.fragmentContainerView).navigate(R.id.addFragment)
    }
}