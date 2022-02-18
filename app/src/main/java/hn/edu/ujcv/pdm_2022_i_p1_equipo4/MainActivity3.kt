package hn.edu.ujcv.pdm_2022_i_p1_equipo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val message = intent.getStringExtra("Extra")
        val message1 = intent.getStringExtra("Extra1")
        val message2 = intent.getStringExtra("Extra2")
        val message3 = intent.getStringExtra("Extra3")

        val textView = findViewById<TextView>(R.id.textView3).apply {
            text = message
        }

        val textView1 = findViewById<TextView>(R.id.textView4).apply {
            text = message1
        }

        val textView2 = findViewById<TextView>(R.id.textView5).apply {
            text = message2
        }

        val textView3 = findViewById<TextView>(R.id.textView6).apply {
            text = message3
        }
    }
}