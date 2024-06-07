package abled.semina.designPattern.mvvm

import android.util.Log

class Model {

    private val TAG = "mvvm 모델"
    private var randomCatUrl = "https://cataas.com/cat?type=square"
    fun getCatUrl(): String{
        Log.d(TAG, "모델 : ${randomCatUrl}을 반환")
        return randomCatUrl
    }

}