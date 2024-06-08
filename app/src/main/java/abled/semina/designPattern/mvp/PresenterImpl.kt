package abled.semina.designPattern.mvp

import android.util.Log

class PresenterImpl(private val view: Presenter.View): Presenter {

    private val TAG = "mvp 프레젠터 구현부"
    private val model: Model
        get() = Model()


    override fun getCatUrl() {
        Log.d(TAG, "Presenter는 Model에게 데이터를 요청")
        view.setImageView(model.getCatUrl())
        Log.d(TAG, "Presenter가 모델로부터 받은 데이터를 처리해서 뷰에 전달")
    }

}