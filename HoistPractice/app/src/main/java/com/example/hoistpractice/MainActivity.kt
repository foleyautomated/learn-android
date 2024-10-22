package com.example.hoistpractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hoistpractice.ui.theme.HoistPracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HoistPracticeTheme {
                MainScaffold()
            }
        }
    }
}

@Composable
fun MainScaffold() {
    var count = remember {
        mutableStateOf(0)
    }
    var incrementCount = {
        count.value += 1;
    }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier.padding(50.dp)
        ) {
            CounterButton(incrementCount)
            CountDisplay(count.value)
        }
    }
}



@Composable
fun CounterButton( increment: ()->Unit) {
    Button(
        modifier = Modifier.background(Color.Red),
        onClick = increment
    ){
        Text("Increment!")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HoistPracticeTheme {
        MainScaffold()
    }
}

@Composable
fun CountDisplay(count: Int=0) {
    Text("#$count")
}
