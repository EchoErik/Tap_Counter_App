package com.example.tapcounterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.tapcounterapp.ui.theme.TapCounterAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TapCounterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,


                ) {
                    CounterView()
                }
            }
        }
    }
}



@Preview
@Composable
fun CounterView() {

    var count by remember { mutableStateOf(0) }

    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = {

                count++

                      },

            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom, margin = 16.dp) // Position at the bottom
                    start.linkTo(parent.start) // Center horizontally
                    end.linkTo(parent.end) // Center horizontally
                }
//                .size(width = 200.dp, height = 80.dp) // Adjust the size here


        ) {
            Text("ADD 1", fontSize = 32.sp)
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text(
            "$count",

            Modifier.constrainAs(text) {
                bottom.linkTo(button.top, margin = 16.dp)
                start.linkTo(parent.start) // Center horizontally
                end.linkTo(parent.end) // Center horizontally
            }

        )
    }
}

