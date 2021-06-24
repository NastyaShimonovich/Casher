package nastya.shymanovich.casher.ui.fragments.diagram

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nastya.shymanovich.casher.R
import nastya.shymanovich.casher.databinding.FragmentDiagramBinding
import nastya.shymanovich.casher.databinding.FragmentOperationsBinding

class DiagramFragment : Fragment(R.layout.fragment_diagram) { //lateinit var - поздняя инизиализации, мы потом заполним
    private lateinit var binding: FragmentDiagramBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDiagramBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.diagramTv.setOnClickListener {
            Log.d("myTag", "Hello world")
        }
    }
}