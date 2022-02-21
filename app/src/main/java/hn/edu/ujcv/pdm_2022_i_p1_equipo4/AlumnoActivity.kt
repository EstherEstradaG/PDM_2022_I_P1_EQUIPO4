package hn.edu.ujcv.pdm_2022_i_p1_equipo4


import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.content_alumno.*

class AlumnoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alumno)
       // setSupportActionBar(findViewById(R.id.toolbar))
        btn_MostrarAlumnos.isEnabled = false
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {

            else -> super.onOptionsItemSelected(item)
        }
    }

    @SuppressLint("ResourceAsColor")
    fun cuentaOnClick(view : View){
        var cuenta : EditText = findViewById(R.id.editTextNumber)
        cuenta.setTextColor(R.color.grey_text)
    }

    @SuppressLint("ResourceAsColor")
    fun nombreOnClick(view : View){
        var nombre : EditText = findViewById(R.id.textNombre)
        nombre.setTextColor(R.color.grey_text)
    }

    @SuppressLint("ResourceAsColor")
    fun carreraOnClick(view : View){
        var carrera : EditText = findViewById(R.id.textCarrera)
        carrera.setTextColor(R.color.grey_text)
    }

    @SuppressLint("ResourceAsColor")
    fun fechaIngresoOnClick(view : View){
        var fecha : EditText = findViewById(R.id.textDate)
        fecha.setTextColor(R.color.grey_text)
    }

    @SuppressLint("ResourceAsColor")
    fun correoOnClick(view : View){
        var correo : EditText = findViewById(R.id.textCorreo)
        correo.setTextColor(R.color.grey_text)
    }

    fun MostrarAlumnos(view : View){
        val intent = Intent(this,StudentListActivity::class.java)
        startActivity(intent)
    }

    fun guardarAlumno(view: View){
        var cuenta : EditText = findViewById(R.id.editTextNumber)
        var nombre : EditText = findViewById(R.id.textNombre)
        var carrera : EditText = findViewById(R.id.textCarrera)
        var fecha : EditText = findViewById(R.id.textDate)
        var correo : EditText = findViewById(R.id.textCorreo)
        try{
            var alumnoNuevo = Alumno(cuenta.text.toString(),nombre.text.toString(),carrera.text.toString(),fecha.text.toString(),correo.text.toString())
            alumnoNuevo.guardarAlumno()
            Snackbar.make(view,"Alumno almacenado con cuenta: " + cuenta.text.toString(),Snackbar.LENGTH_SHORT).show()
            btn_MostrarAlumnos.isEnabled = true
            reset()
        }catch(ex : IllegalArgumentException){

            when(Integer.parseInt(ex.message)){
                1 -> {Snackbar.make(view, "Numero de cuenta inválido.",Snackbar.LENGTH_SHORT).show()
                    cuenta.setTextColor(Color.RED)}
                2 -> {Snackbar.make(view, "Nombre inválido.",Snackbar.LENGTH_SHORT).show()
                    nombre.setTextColor(Color.RED)}
                3 -> {Snackbar.make(view, "Carrera inválida.",Snackbar.LENGTH_SHORT).show()
                    carrera.setTextColor(Color.RED)}
                4 -> {Snackbar.make(view, "Fecha de ingreso inválida",Snackbar.LENGTH_SHORT).show()
                    fecha.setTextColor(Color.RED)}
                5 -> {Snackbar.make(view, "Correo inválido.",Snackbar.LENGTH_SHORT).show()
                    correo.setTextColor(Color.RED)}
            }
        }
    }

    fun listaEstudiantesIntent(view: View){
        val intent = Intent(this,StudentListActivity::class.java)
        startActivity(intent)
    }

    fun reset(){
        findViewById<TextView>(R.id.editTextNumber).text = ""
        findViewById<TextView>(R.id.textNombre).text = ""
        findViewById<TextView>(R.id.textCarrera).text = ""
        findViewById<TextView>(R.id.textDate).text = ""
        findViewById<TextView>(R.id.textCorreo).text = ""
    }



}