package abled.semina.designPattern.mvc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import abled.semina.designPattern.R
import abled.semina.designPattern.databinding.FragmentMvcBinding
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MvcFragment : Fragment() {

    private val TAG = "mvc 프래그먼트"

    private lateinit var binding: FragmentMvcBinding
    private var model: Model = Model()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mvc, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }

    private fun setListener(){

       binding.button.setOnClickListener{
           Log.d(TAG, "View & Controller : 다른 사진 보기 버튼 클릭")
           setImageView()
       }

    }

    private fun setImageView(){

        Glide.with(this)
            .load(model.getCatUrl())
            .placeholder(R.drawable.loading)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)

        Log.d(TAG, "view & controller 모델에서 받아온 고양이사진url을 glide로 이미지 뷰에 띄우기")

    }
}