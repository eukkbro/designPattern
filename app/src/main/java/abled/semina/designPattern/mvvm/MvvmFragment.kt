package abled.semina.designPattern.mvvm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import abled.semina.designPattern.R
import abled.semina.designPattern.databinding.FragmentMvvmBinding
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class MvvmFragment : Fragment() {

    private val TAG = "mvvm 프래그먼트"

    private lateinit var binding: FragmentMvvmBinding
    private var viewModel:ViewModel = ViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        /**데이터 바인딩**/
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mvvm, container, false)

        /**초기화 설정**/
        setInitialize()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**옵저버 셋팅**/
        setObserve()
    }


    private fun setInitialize(){

        /**라이프사이클오너를 프래그먼트로 설정**/
        binding.lifecycleOwner = this
        /**xml에 사용할 뷰모델 설정**/
        binding.viewModel = viewModel

    }

    private fun setObserve(){

        /**뷰모델의 randomCatUrl을 관찰**/
        viewModel.randomCatUrl.observe(viewLifecycleOwner){
            Log.d(TAG, "뷰모델의 url 데이터 관찰")

            /**관찰한 값을 글라이드를 통해 이미지 뷰에 띄우는 메서드**/
            setImageView(it)
            Log.d(TAG, "관찰해서 view를 변경")
        }
    }


    private fun setImageView(url: String){

        Log.d(TAG, "View : 관찰한 url 값을 Glide를 통해 이미지뷰에 띄우기")

        /**글라이드**/
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.loading)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)


    }

}