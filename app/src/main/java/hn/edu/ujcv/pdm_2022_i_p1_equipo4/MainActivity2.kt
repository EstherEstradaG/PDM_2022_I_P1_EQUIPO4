package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.txtFecha2
import kotlinx.android.synthetic.main.activity_prestamos.*
import java.lang.StringBuilder
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.HashMap

class MainActivity2 : AppCompatActivity() {

    var dr: String = ""
    var numero = 0
    var valores: HashMap<Int,String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        inicializar()

        btnGuardar.setOnClickListener { guardar() }
        btnEnviar.setOnClickListener { enviar() }

    }

    private fun enviar() {

        val intent = Intent(this,MainActivity3::class.java)
        intent.putExtra("valores", valores)
        startActivity(intent)
    }



    private fun guardar() {
        val dato = StringBuilder()
        numero = 0
        val pattern = "^([A-Z][a-záéíóú]* )(([A-Z][a-záéíóú]* [A-Z][a-záéíóú]*)|([A-Z][a-záéíóú]*)|([A-Z][a-záéíóú]* [A-Z][a-záéíóú]* [A-Z][a-záéíóú]*))\$"

        if (txtIdLibro.text.isEmpty()||txtNombreLibro.text.isEmpty()||txtAutor.text.isEmpty()||txtFecha2.text.isEmpty()||txtEditorial.text.isEmpty()){
            Toast.makeText(this, "Campos vacíos!!!", Toast.LENGTH_SHORT).show()
        }else if(!(Pattern.matches(pattern,txtAutor.text.toString()))){
            Toast.makeText(this, "Nombre inválido", Toast.LENGTH_SHORT).show()

        }else {
            dato.append(txtIdLibro.text.toString().trim()).append("|")
            dato.append(txtNombreLibro.text.toString().trim()).append("|")
            dato.append(txtAutor.text.toString().trim()).append("|")
            dato.append(txtFecha2.text.toString().trim()).append("|")
            dato.append(txtEditorial.text.toString().trim()).append("|")
            valores.put(numero, dato.toString())
            btnEnviar.isEnabled = true
            Toast.makeText(this, "Se guardó correctamente", Toast.LENGTH_SHORT).show()
            limpiarLibro()
        }

    }

    private fun limpiarLibro() {
        txtIdLibro.setText("")
        txtNombreLibro.setText("")
        txtAutor.setText("")
        txtFecha2.setText("")
        txtEditorial.setText("")
    }

    private fun inicializar() {

        btnEnviar.isEnabled= false
    }

    fun openDateTimePicker(view: android.view.View) {

        var c: Calendar = Calendar.getInstance()

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { datePicker, yy, mm, dd ->

            dr = "$dd/${mm+1}/$yy"
            txtFecha2.setText(dr)
        }, c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()


    }
}

