package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import android.view.View
import com.google.android.material.snackbar.Snackbar
import java.util.*

object SingletonEstudiantes {

    var listaAlumnos : ArrayList<Alumno> = ArrayList()
    var listaBusqueda : ArrayList<Alumno> = ArrayList()

    fun buscarNumCuenta(view : View, numCuenta : String){
        var listaBusqueda : ArrayList<Alumno> = ArrayList()
        for (item : Alumno in listaAlumnos){
            if (item.NumeroCuenta.equals(numCuenta)){
                listaBusqueda.add(item)
            }
        }

        if (!listaBusqueda.isEmpty()){
            this.listaBusqueda = listaBusqueda
        }else{
            Snackbar.make(view,"No se encontro un alumno con ese numero de cuenta." , Snackbar.LENGTH_LONG).show()
        }

    }

}