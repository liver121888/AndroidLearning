package com.example.androidlearning

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelActivityViewModel : ViewModel() {

    private lateinit var timer: CountDownTimer
    var timerValue =  MutableLiveData<Long>()

    private var _finished = MutableLiveData<Boolean>()
    fun finished(): LiveData<Boolean>{
        return  _finished
    }

    private val _seconds = MutableLiveData<Int>()
    fun seconds(): LiveData<Int>{
        return  _seconds
    }

    fun startTimer(){

        timer = object : CountDownTimer(timerValue.value!!.toLong(), 1000){

            override fun onFinish() {
                _finished.value = true;
            }

            override fun onTick(p0: Long) {
                val timeLeft = p0/1000
                _seconds.value = timeLeft.toInt()

            }

        }.start()
    }

    fun stopTimer(){
        timer.cancel();
    }

    var number = 0

    fun addNumber(){
        number++
    }

    // https://youtu.be/orH4K6qBzvE
    // https://developer.android.com/topic/libraries/architecture/viewmodel
    // Goes into background but before being killed by Android OS.
    // Thus a ViewModel should not contain any reference to Activity, Contexts, Fragments.
    // Also, should not contain UI control reference such as Views
    // Exception: Application Context is allowed, because it tied to Application Lifecycle.
    // In this case extends AndroidViewModel instead
    // Also, used to separate date from UI implementation
    override fun onCleared() {
        super.onCleared()
    }

}