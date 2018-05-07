package com.example.usrgam.ejemplo

/**
 * Created by USRGAM on 07/05/2018.
 */
class Factory {
    companion object {
        var usuarios: ArrayList<Usuario> = ArrayList()
        init {
            usuarios.add(Usuario("Wilson", "Ramos", "Rojo"))
            usuarios.add(Usuario("Dennisao", "Veintimilla", "Azul"))
            usuarios.add(Usuario("Gabriel", "Bravo", "Amarillo"))
        }

    }
}