package com.example.usrgam.ejemplo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_ciclo_vida.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class CicloVidaActivity : AppCompatActivity() {
    var contador = 0
    var usuario: UsuarioParcelable? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciclo_vida)
        Log.i("ciclo-vida", "Ejecuto: Oncreate")
        usuario = intent.getParcelableExtra("usuario-intent")
        val contadorGuardado: Int? = savedInstanceState?.get("contador") as Int?

        val usuarioGuardado: UsuarioParcelable? = savedInstanceState?.get("usuario") as UsuarioParcelable?

        Log.i("ciclo-vida", "El contador es: $contadorGuardado")

        if (contadorGuardado == null && usuarioGuardado == null) {
            textView_contador.text = usuario?.edad.toString()
        } else {
            textView_contador.text = usuarioGuardado?.edad.toString()
            usuario = usuarioGuardado
        }


        boton_contador
                .setOnClickListener { view ->
                    usuario?.aumentarunAnio(1)
                    textView_contador.text = usuario?.edad.toString()
                }

    }

    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "Ejecuto: OnStart")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.i("ciclo-vida", "Ejecuto: On RestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable("usuario", usuario)
        outState?.putInt("contador",contador)

        Log.i("ciclo-vida", "Ejecuto: On SaveInstanceState")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida", "Ejecuto: OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida", "Ejecuto: On Pause")
    }



    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida", "Ejecuto: On Stop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida", "Ejecuto: OnDestroy")
    }

    override fun finish() {
        super.finish()
        Log.i("ciclo-vida", "Ejecuto: Finish")
    }

}
