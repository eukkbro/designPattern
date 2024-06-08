package abled.semina.designPattern.mvc

import android.util.Log

class Model {

    private val TAG = "mvc 모델"
    private var randomCatUrl = "https://cataas.com/cat?type=square"
    fun getCatUrl(): String{
        Log.d(TAG, "Model 에서 데이터 응답")
        return randomCatUrl
    }

}