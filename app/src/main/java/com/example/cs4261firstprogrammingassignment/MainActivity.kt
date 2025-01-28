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
import com.google.firebase.database.FirebaseDatabase

class MainActivity : ComponentActivity() {
    private val database = FirebaseDatabase.getInstance()
    private val dbRef = database.getReference("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonSubmit = findViewById<Button>(R.id.buttonSubmit)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonSubmit.setOnClickListener {
            val name = editTextName.text.toString()
            if (name.isNotEmpty()) {
                // Push data to Firebase
                val userId = dbRef.push().key
                userId?.let {
                    dbRef.child(it).setValue(name)
                    textViewResult.text = "Hello, $name! Your data has been saved."
                }
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
