package com.example.cs4261firstprogrammingassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.cs4261firstprogrammingassignment.ui.theme.CS4261FirstProgrammingAssignmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find views by ID
        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        // Set button click listener
        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            if (name.isNotEmpty()) {
                textViewResult.text = "Hello, $name!"
            } else {
                textViewResult.text = "Please enter your name."
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
            text = "Hello $name!",
            modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CS4261FirstProgrammingAssignmentTheme {
        Greeting("Android")
    }
}
