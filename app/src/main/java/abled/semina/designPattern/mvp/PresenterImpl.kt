package abled.semina.designPattern.mvp

import abled.semina.designPattern.mvp.View
import abled.semina.designPattern.mvp.Model

class PresenterImpl(private val view: View): Presenter {

    private val model: Model
        get() = Model()


    override fun getCatUrl() {
        view.setImageView(model.getCatUrl())
    }

}