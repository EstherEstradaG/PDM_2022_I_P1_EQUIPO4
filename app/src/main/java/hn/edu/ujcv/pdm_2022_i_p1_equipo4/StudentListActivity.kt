package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_student_list.*
import kotlinx.android.synthetic.main.activity_student_list.view.*
import kotlinx.android.synthetic.main.layout_view_holder.view.*
import java.util.*

class StudentListActivity () : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)
        cargarRCV(SingletonEstudiantes.listaAlumnos)

    }

    fun busqueda(view : View){
        var cuenta : EditText = findViewById(R.id.cuentaBusqueda)
        if(cuenta.text.toString() == ""){
            cargarRCV(SingletonEstudiantes.listaAlumnos)
        }else{
            SingletonEstudiantes.buscarNumCuenta(view,cuenta.text.toString())
            cargarRCV(SingletonEstudiantes.listaBusqueda)
        }
    }

    fun cargarRCV(list : ArrayList<Alumno>){
        rcvStudents.layoutManager = LinearLayoutManager(this)
        val adapter = StudentListRecyclerViewAdapter(list)
        rcvStudents.adapter = adapter
    }


}