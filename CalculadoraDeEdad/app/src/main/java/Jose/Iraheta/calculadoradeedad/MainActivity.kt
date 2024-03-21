package Jose.Iraheta.calculadoradeedad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtnum1 = findViewById<EditText>(R.id.txtfechaActual)
        val txtnum2 = findViewById<EditText>(R.id.txtFechaNacimiento)
        val btnRestar =findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)


          val objCalcular = CalculadoraEdad()


        btnRestar.setOnClickListener {
          val resul= objCalcular.resta(txtnum1.text.toString().toInt(),txtnum2.text.toString().toInt())

           txtResultado.text = "El resultado es: $resul  años"
        }

    }
}