package nastya.shymanovich.casher.ui.fragments.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import nastya.shymanovich.casher.R
import nastya.shymanovich.casher.databinding.FragmentMainBinding
import nastya.shymanovich.casher.ui.fragments.diagram.DiagramFragment
import nastya.shymanovich.casher.ui.fragments.main.utils.ViewPagerAdapter
import nastya.shymanovich.casher.ui.fragments.operations.OperationFragment


class MainFragment : Fragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.operations -> {
                binding.viewPager.currentItem = 0
                return@OnNavigationItemSelectedListener true
            }
            R.id.diagram -> {
                binding.viewPager.currentItem = 1
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        initViewPager()
        initBottomNavigation()
    }

    private fun initViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(this, listOf(
            OperationFragment(),
            DiagramFragment()
        ))

        binding.viewPager.orientation = (ViewPager2.ORIENTATION_HORIZONTAL)

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.bottomNavigationView.selectedItemId = when (position) {
                    0 -> R.id.operations
                    1 -> R.id.diagram
                    else -> R.id.operations
                }
            }
        })
    }

    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}