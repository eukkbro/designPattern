package abled.semina.designPattern.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import abled.semina.designPattern.R
import abled.semina.designPattern.databinding.FragmentCommonBinding
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class commonFragment : Fragment() {

    private val TAG = "일반 프래그먼트"

    //랜덤 고양이 사진 url
    private var randomCatUrl = "https://cataas.com/cat?type=square"

    //데이터바인딩 늦은 초기화
    lateinit var binding: FragmentCommonBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

       /**데이터 바인딩**/
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mvc, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**리스너 설정**/
        setListener()
    }

    private fun setListener(){

        /**버튼 클릭 리스너**/
        binding.button.setOnClickListener{
            Log.d(TAG, "View & Controller : 다른 사진 보기 버튼 클릭")

            /**이미지뷰 설정 메서드**/
            setImageView(randomCatUrl)
        }
    }

    private fun setImageView(url: String){

        /**글라이드**/
        Glide.with(this)
            .load(url) //what
            .placeholder(R.drawable.loading) // 로딩하는 동안 불러올 이미지
            .skipMemoryCache(true) // 캐시 제거
            .diskCacheStrategy(DiskCacheStrategy.NONE) // 캐시 제거
            .into(binding.imageView) // where

    }
}