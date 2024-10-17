package com.example.estados

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var tag = "MainActivity"
    private var contador = 1
    // var texto: TextView? = null
    lateinit var texto: TextView
    // var boton: Button? = null
    lateinit var boton: Button

    //Cuando se crea la activity 1º Paso.
    // onde se suelen hacer las acciones de iniciar los componentes, cargar layout, configurar componentes, etc..
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(tag, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById<View>(R.id.texto) as TextView
        boton = findViewById<View>(R.id.button) as Button
        boton.setOnClickListener(this)
        texto.text = contador.toString()
    }

    override fun onClick(view: View) {
        contador = contador * 2
        texto.text = contador.toString()
    }

/*
        @Override protected void onSaveInstanceState(Bundle estado){
            super.onSaveInstanceState(estado);
            estado.putInt("posicion", contador);
        }

        @Override protected void onRestoreInstanceState(Bundle estado){
            super.onRestoreInstanceState(estado);
            contador = estado.getInt("posicion");
            texto.setText(String.valueOf(contador));
        }
    */

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("posicion", contador)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        contador = savedInstanceState.getInt("posicion")
        texto.text = contador.toString()
    }
    //Cuando volvemos a tener la pantalla en foco después de pasar de estado onStop()
    override fun onStart() {
        Log.d(tag, "onStart")
        super.onStart()
    }

    //La activity se sigue viendo en pantalla pero hay algo que la esta bloqueando.
    override fun onResume() {
        Log.d(tag, "onResume")
        super.onResume()
        Toast.makeText(this, "Mensaje al usuario", Toast.LENGTH_LONG).show()
    }

    //Lo contrario de onResume(), cuando vuelve a estar preparada.
    override fun onPause() {
        Log.d(tag, "onPause")
        super.onPause()
    }

    //cuando la aplicación va a segundo plano, cuando le damos al botón de home, si nos movemos a otra aplicación, etc.. estado dormido
    override fun onStop() {
        Log.d(tag, "onStop")
        super.onStop()
    }

    //Cuando la activity se destruye y entes de destruir la aplicación(tanto por el sistema para dejar memoria o recursos
    //libre, como cierre de la aplicación o activity)
    override fun onDestroy() {
        Log.d(tag, "onDestroy")
        super.onDestroy()
    }
}