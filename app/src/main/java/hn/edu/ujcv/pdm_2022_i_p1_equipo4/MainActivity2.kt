package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button = findViewById<Button>(R.id.btnG)
        button.setOnClickListener {
            callActivity()
        }

    }
    fun callActivity(){
        val editText = findViewById<EditText>(R.id.nameL)
        val editText1 = findViewById<EditText>(R.id.autor)
        val editText2 = findViewById<EditText>(R.id.fecha1)
        val editText3 = findViewById<EditText>(R.id.editorial)
        val message = editText.text.toString()
        val message1 = editText1.text.toString()
        val message2 = editText2.text.toString().toInt()
        val message3 = editText3.text.toString()

        val intent = Intent (this,MainActivity3::class.java ).also {
            it.putExtra("Extra", message)
            it.putExtra("Extra1", message1)
            it.putExtra("Extra2", message2)
            it.putExtra("Extra3", message3)
            startActivity(it)
        }
    }


}