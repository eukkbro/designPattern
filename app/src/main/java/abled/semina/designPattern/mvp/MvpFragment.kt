package abled.semina.designPattern.mvp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import abled.semina.designPattern.R
import abled.semina.designPattern.databinding.FragmentMvpBinding
import abled.semina.designPattern.mvc.Model
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


class MvpFragment : Fragment(), Presenter.View{

    private val TAG = "mvp 프래그먼트"
    private lateinit var binding: FragmentMvpBinding
    private lateinit var presenterImpl: PresenterImpl
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mvp, container, false)

        setInitialize()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setListener()
    }


    private fun setInitialize(){

        presenterImpl = PresenterImpl(this)

    }
    private fun setListener(){
        binding.button.setOnClickListener {
            Log.d(TAG, "View에서 받은 사용자의 입력을 받는다.")
            Log.d(TAG, "View에서 Presenter에게 데이터를 요청")
            presenterImpl.getCatUrl()
        }
    }

    override fun setImageView(url: String) {

        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.loading)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .into(binding.imageView)

    }

}