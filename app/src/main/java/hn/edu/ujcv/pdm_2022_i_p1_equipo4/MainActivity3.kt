package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main3.*
import java.util.HashMap

class MainActivity3 : AppCompatActivity() {
    var valores: HashMap<Int, String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btnBuscar.setOnClickListener { inicializar() }
    }

    private fun inicializar() {
        var intent = intent
        valores = intent.getSerializableExtra("valores") as HashMap<Int, String>
        var nombreLibro = ""
        var Autor = ""
        var Fecha = ""
        var Editorial = ""


        for (valor in valores){
            val lista = valor.toString().split("|").toTypedArray()

            nombreLibro = lista[1].toString()
            Autor = lista[2].toString()
            Fecha = lista[3].toString()
            Editorial = lista[4].toString()
        }

        txvNombreL.setText(nombreLibro)
        txvA.setText(Autor)
        txvF.setText(Fecha)
        txvEdi.setText(Editorial)
    }
}