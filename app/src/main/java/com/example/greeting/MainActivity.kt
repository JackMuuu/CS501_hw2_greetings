package com.example.greeting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.greeting.ui.theme.GreetingTheme
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameInput = findViewById<EditText>(R.id.nameInput)
        val greetButton = findViewById<Button>(R.id.greetButton)
        val greetingMessage = findViewById<TextView>(R.id.greetingMessage)

        greetButton.setOnClickListener {
            val name = nameInput.text.toString()
            val greeting = getGreetingMessage(name)
            greetingMessage.text = greeting
        }
    }

    private fun getGreetingMessage(name: String): String {
        val currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        val timeBasedGreeting = when (currentHour) {
            in 5..11 -> listOf(
                "Morning, $name! Time for a fresh start!",
                "Rise and shine, $name! Let's make today amazing!",
                "Good morning, $name! Ready to conquer the day?"
            ).random()

            in 12..17 -> listOf(
                "Good afternoon, $name! Keep up the awesome work!",
                "Good vibes only, $name! Let’s power through the afternoon!",
                "Hey, $name! Hope your afternoon is as bright as the sun!"
            ).random()

            in 18..23 -> listOf(
                "Good evening, $name! Time to unwind and relax!",
                "Hey there, $name! Hope you had a productive day!",
                "Evening, $name! Ready to take a hot bath?"
            ).random()

            else -> listOf(
                "It’s late, $name! Time to recharge for tomorrow!",
                "Good night, $name! Don’t let the bedbugs bite!",
                "Hey, $name! It's night owl time, but sleep is important!"
            ).random()
        }
        return timeBasedGreeting
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
    GreetingTheme {
        Greeting("Android")
    }
}