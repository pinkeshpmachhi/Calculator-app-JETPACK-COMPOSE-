package com.p2m.calculatorjetpackcompose

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.notkamui.keval.Keval

class MyViewModel :ViewModel() {

    var input :String by mutableStateOf("")
    var result :String by mutableStateOf("")

    fun onInputChange(newValue :String) {
        if (newValue == ""){
            input=""
            result=""
        }else{
            input += newValue
        }

    }



    fun getResultt()  {
        try {

            val zz = Keval.eval(input.trim())
            Log.d("CCCC", "getResultt: Result is :: $zz")
            val kk :String= (Keval.eval(input)).toString()
            result = kk
        }catch (e :Exception) {
            result = "Mathematical Error"
            input = ""
        }
    }

}