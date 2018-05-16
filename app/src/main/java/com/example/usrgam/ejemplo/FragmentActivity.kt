package com.example.usrgam.ejemplo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity() {
    lateinit var fragmentoActual: android.support.v4.app.Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        //manager
        val fragmentManager = supportFragmentManager
        //transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragmentoDos = FragmentoDos()
        fragmentoActual = fragmentoDos
        fragmentTransaction.add(R.id.rl_fragmento, fragmentoDos)

        fragmentTransaction.commit()

        boton_tab1.setOnClickListener{view: View ->
            reemplazarFragmentoActual(FragmentoUno())
        }

        boton_tab2.setOnClickListener{view: View ->
            reemplazarFragmentoActual(FragmentoDos())
        }
        boton_tab3.setOnClickListener{view: View ->
            reemplazarFragmentoActual(FragmentoTres())
        }
        boton_destruir_fragmento.setOnClickListener{view: View ->
            destruirFragmentoActual()
        }
    }
    fun reemplazarFragmentoActual(fragmento: android.support.v4.app.Fragment){
        fragmentoActual = fragmento
        val fragmentManager = supportFragmentManager
        //transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.rl_fragmento, fragmento)
        fragmentTransaction.commit()
    }

    fun destruirFragmentoActual(){
        val fragmentManager = supportFragmentManager
        //transacciones
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.remove(fragmentoActual)
        fragmentTransaction.commit()
    }
}
