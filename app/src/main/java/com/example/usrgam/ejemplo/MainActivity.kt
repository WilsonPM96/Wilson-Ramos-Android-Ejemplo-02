package com.example.usrgam.ejemplo

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA
        )
        Log.i("tag", "Crear permiso ${permission}")
        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i("tag", "Entrando a pedir permiso")
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA, Manifest.permission.SEND_SMS), RESULTADO_PERMISO_CAMARA)
        } else {
            Log.i("tag", "Ya tiene este permiso")
        }


        button_navegar_activida_dos
                .setOnClickListener { view: View ->
                    irAActividadDos()
                }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun irAActividadDos() {
        val intent = Intent(this, ActividadDos::class.java)
        intent.putExtra("nombre", "Wilson")
        startActivity(intent)
    }
    companion object {
        val RESULTADO_PERMISO_CAMARA = 1
    }
}













