package abled.semina.designPattern

import abled.semina.designPattern.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private val TAG= "메인 액티비티"

    private lateinit var binding: ActivityMainBinding

    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setVariable()
        setListener()
    }


    private fun setVariable(){

        // 네비게이션을 담는 호스트
        navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        // 네비게이션 컨트롤러
        navController = navHostFragment.navController

        // 바텀 네비게이션 뷰와 네비게이션을 묶는다.
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)

        // 바인딩 라이프사이클 오너 초기화
        binding.lifecycleOwner = this

    }



    private fun setListener(){

        // 프래그먼트 백스택 관찰을 위한 리스너
        navHostFragment.childFragmentManager.addOnBackStackChangedListener {
            Log.d(TAG, "setView: 백스택 : " + navHostFragment.childFragmentManager.backStackEntryCount.toString())
        }
    }
}