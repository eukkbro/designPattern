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

           Log.d(TAG, "사용자의 입력이 View를 통해 Controller로 들어옴")

           Log.d(TAG, "컨트롤러는 사용자의 입력을 확인하고 모델에 업데이트를 요청")
           var url = model.getCatUrl()

           Log.d(TAG, "Model 에서 받은 데이터로 View 업데이트를 요청한다.")
           /**글라이드를 통해 이미지뷰에 이미지 띄우는 메서드**/
           setImageView(url)

       }

    }

    private fun setImageView(url: String){

        Log.d(TAG, "View는 UI를 업데이트 한다.")

        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.loading)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)


    }
}