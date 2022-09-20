package com.example.rolldice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rolldice.ui.theme.RollDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                color = Color.Black
            ) {
                RollDiceTheme{
                    DiceRollerApp()
                }
            }

        }
    }
}

@Composable
@Preview
fun DiceRollerApp() {
    DiceRollerWithButtonAndImage( modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}


@Composable
fun DiceRollerWithButtonAndImage( modifier: Modifier = Modifier) {
    var dicenumber by remember { mutableStateOf(0)}
    val imageResource = when(dicenumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        6 -> R.drawable.dice_6
        else -> R.drawable.ic_launcher_foreground
    }
    Column(modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally) {
        
        Text(text = "Roll Your 🎲!",
                fontSize = 36.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.White,
            modifier = Modifier
                .padding(top = 24.dp)

        )
        Surface(modifier = Modifier
            .padding(top = 106.dp),
            color = MaterialTheme.colors.background
        ){
            Image(painter = painterResource(imageResource), contentDescription = dicenumber.toString())
        }
        Spacer(modifier = Modifier.height(106.dp))
        Button(onClick = { dicenumber = (1..6).random()}
        ) {
            Text(text = stringResource(id = R.string.roll_button_text))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Made with JetPack Compose ❤",
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)

        )


    }

}
