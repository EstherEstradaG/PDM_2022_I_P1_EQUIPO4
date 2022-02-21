package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import android.content.Context
import android.content.Intent
import android.graphics.Color.parseColor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnL =findViewById<Button>(R.id.btnL)

        btn_AgregarPrestamo.setOnClickListener {
            val intent:Intent = Intent(this, Prestamos::class.java)
            startActivity(intent)
        }

        btnL.setOnClickListener {
            val intent:Intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }


        btn_Alumno.setOnClickListener {
            val intent:Intent = Intent(this, AlumnoActivity::class.java)
            startActivity(intent)
        }


    }





}