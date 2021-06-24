package nastya.shymanovich.casher.ui.fragments.add_information

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.skydoves.powerspinner.IconSpinnerAdapter
import com.skydoves.powerspinner.IconSpinnerItem
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import io.reactivex.rxjava3.disposables.CompositeDisposable
import nastya.shymanovich.casher.MyApplication
import nastya.shymanovich.casher.R
import nastya.shymanovich.casher.databinding.FragmentAddBinding
import nastya.shymanovich.casher.domain.utils.Category
import nastya.shymanovich.casher.domain.utils.Date
import java.util.*

class AddInformationFragment : Fragment(R.layout.fragment_add) {

    private val compositeDisposable = CompositeDisposable()

    private lateinit var binding: FragmentAddBinding
    private lateinit var viewModel: AddInformationVM
    private val datePickerCallback = object : DatePickerDialog.OnDateSetListener {
        override fun onDateSet(
            view: DatePickerDialog?,
            year: Int,
            monthOfYear: Int,
            dayOfMonth: Int
        ) {
            val date = Date(year, monthOfYear + 1, dayOfMonth)
            binding.dateET.text = date.toString()
            viewModel.setDate(date)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initObservers()
        initView()
    }

    private fun initViewModel() {
        val factory = MyApplication
            .getAppComponent()
            .plusAddFragmentVMComponent()
            .build()
            .getAddFragmentFactory()

        viewModel = ViewModelProvider(this, factory)
            .get(AddInformationVM::class.java)
    }

    private fun initObservers() {
        compositeDisposable.add(
            viewModel.observeSaveData.subscribe { status ->
                when (status) {
                    Status.Success -> {
                        Toast.makeText(requireContext(), "Save success", Toast.LENGTH_SHORT).show()
                    }
                    Status.Error -> {
                        Toast.makeText(requireContext(), "Save error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        )
    }

    private fun initView() {
        initSpinner()
        binding.addButton.setOnClickListener {
            viewModel.saveData()
        }
        binding.dateET.setOnClickListener {
            pickDate()
        }

        binding.enterAmount.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) { //
                viewModel.setAmount(p0.toString().toFloat())
            }
        })

        binding.selectCategory.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                viewModel.setCategory(p0.toString())
            }
        })

        binding.comment.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                viewModel.setComment(p0.toString())
            }
        })
    }

    private fun initSpinner() {
        val iconSpinnerItem = arrayListOf<IconSpinnerItem>()
        for (element in Category.getList()) {
            iconSpinnerItem.add(
                IconSpinnerItem(text = element.name)
            )
        }
        val adapter = IconSpinnerAdapter(binding.selectCategory)
        adapter.setItems(iconSpinnerItem)
        binding.selectCategory.apply {
            setSpinnerAdapter(IconSpinnerAdapter(this))
            setItems(iconSpinnerItem)
            getSpinnerRecyclerView().layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun pickDate() {
        val now = Calendar.getInstance()
        val dpt = DatePickerDialog.newInstance(
            datePickerCallback,
            now.get(Calendar.YEAR),
            now.get(Calendar.MONTH),
            now.get(Calendar.DAY_OF_MONTH)
        )

        dpt.version = DatePickerDialog.Version.VERSION_2


        dpt.show(parentFragmentManager, "Date")
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}