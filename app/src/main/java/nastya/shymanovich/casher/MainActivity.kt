package nastya.shymanovich.casher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import nastya.shymanovich.casher.databinding.ActivityMainBinding
import nastya.shymanovich.casher.ui.fragments.register.FragmentRegister

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        if(savedInstanceState == null){
////            val tr = this.supportFragmentManager.beginTransaction() //заменяем активи(экран приложения) фрагментом(то, что добавили на экран)
////            tr.replace(R.id.fragmentContainerView, FragmentRegister()).commit()
//        }
    }
}
