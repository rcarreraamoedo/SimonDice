package com.example.simondice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel() : ViewModel() {
    //ronda actual del juego
    // definimos la ronda actual
    val ronda = MutableLiveData<Int>()

    // inicializamos variables cuando instanciamos
    init {
        ronda.value = 1
    }

    fun sumarRonda() {
        // añadimos uno a la ronda
        // tenemos que chequear si es null
        // lo podemos hacer con un 'if'
        ronda.value = ronda.value?.plus(1)
    }
}