package abled.semina.designPattern.mvp

interface Presenter {

    fun getCatUrl()
    interface View{
        fun setImageView(url: String)

    }

}

