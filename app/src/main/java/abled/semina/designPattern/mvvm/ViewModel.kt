package abled.semina.designPattern.mvvm

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel(){

    private val TAG = "mvvm 뷰모델"

    private var model = Model()

    private val _randomCatUrl = MutableLiveData<String>()
    val randomCatUrl: LiveData<String>
        get() = _randomCatUrl


    fun setOnButtonClick(){
        Log.d(TAG, "viewModel : model에게 url 요청")
        _randomCatUrl.value = model.getCatUrl()
    }

}