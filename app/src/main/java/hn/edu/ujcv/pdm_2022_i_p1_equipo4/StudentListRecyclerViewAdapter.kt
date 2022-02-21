package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_view_holder.view.*
import java.util.*

class StudentListRecyclerViewAdapter(val studentList : List<Alumno>) : RecyclerView.Adapter<StudentListRecyclerViewAdapter.StudentHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
        val view = LayoutInflater.from(parent.context)
        return StudentHolder(view.inflate(R.layout.layout_view_holder,parent,false))
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
        holder.renderizar(studentList[position])
    }

    override fun getItemCount(): Int = studentList.size


    class StudentHolder(val view: View):RecyclerView.ViewHolder(view){

        var alumnoHolder : Alumno = Alumno()
        fun renderizar(alumno: Alumno){
            view.studentNameVH.text = alumno.Nombre
            view.numCuentaVH.text = alumno.NumeroCuenta
            alumnoHolder = alumno
        }

        init {
            view.vhLayout.setOnClickListener{
                val alertDialogBuilder = AlertDialog.Builder(view.context)
                alertDialogBuilder.setTitle("Datos de Estudiante")
                alertDialogBuilder.setMessage("Nombre: ${alumnoHolder.Nombre}\n" +
                        "Cuenta: ${alumnoHolder.NumeroCuenta}\n" +
                        "Carrera: ${alumnoHolder.Carrera}\n" +
                        "Fecha Ingreso:${alumnoHolder.FechaIngreso}\n" +
                        "Correo:${alumnoHolder.Correo}")
                alertDialogBuilder.show()
            }
        }
    }
}