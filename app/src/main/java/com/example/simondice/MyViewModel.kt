package com.example.simondice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MyViewModel() : ViewModel() {

    // para que sea mas facil la etiqueta del log
    private val TAG_LOG: String = "mensaje ViewModel"

    // este va a ser nuestro array para la secuencia random
    val numbers = mutableListOf<Int>()
    // definimos la ronda actual para observar
    val ronda = MutableLiveData<MutableList<Int>>()
    val msjBoton = MutableLiveData<String>()

    // inicializamos variables cuando instanciamos
    init {
        ronda.value = numbers
        msjBoton.value ="Start"
    }

    /**
     * añadimos entero random a ronda
     */
    fun sumarRonda() {
        // añadimos entero random a la ronda

        numbers.add(Random.nextInt(0,4))
        ronda.postValue(numbers)
        Log.d(TAG_LOG, "Array:" + numbers.toString())
    }

    /**
     * cambiamos mensaje con coroutinas
     */
    fun salidaLog() {
        CoroutineScope(Dispatchers.Main).launch {
            suspendFun("Start")
            // esperamos dos segundos y cambiamos el mensaje
            delay(2000)
            suspendFun("Stop")
        }
    }

    /**
     * funcion auxiliar que es llamada desde la coroutina
     */
    private fun suspendFun(msg: String) {
        msjBoton.value = msg
        Log.d(TAG_LOG, msg)
    }
}