package com.p2m.calculatorjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.p2m.calculatorjetpackcompose.ui.theme.CalculatorJetpackComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorJetpackComposeTheme {
                val modifier = Modifier
                val myViewModel = MyViewModel()
                MainScreen(modifier = modifier, myViewModel)
            }
        }



    }

    @Composable
    fun MainScreen(modifier: Modifier, myViewModel: MyViewModel){

        Surface(modifier = modifier
            .fillMaxSize()
            .background(Color.White)) {
            Column(modifier = modifier.fillMaxSize()) {
                DisplayColumn(modifier = modifier, myViewModel)
                ButtonColumn(modifier = modifier, myViewModel)
            }
        }

    }

    @Composable
    fun DisplayColumn (modifier: Modifier, myViewModel: MyViewModel){
        Column(
            modifier =
            modifier
                .height(300.dp)
                .background(Color.White)
                .fillMaxWidth()
        ) {
            Row(
                modifier =
                modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = myViewModel.input,
                    modifier.padding(end = 25.dp,top = 50.dp),
                    fontSize = 40.sp,
                    color = Color.Green,
                    fontWeight = FontWeight.Bold
                )
            }

            InputRow(modifier = modifier, myViewModel)

        }
    }

    @Composable
    fun InputRow(modifier: Modifier, myViewModel: MyViewModel) {

        Row(
            modifier =
            modifier.
            fillMaxSize(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.End
        ) {
            Text(

                text = myViewModel.result,
                modifier.padding(end = 25.dp,bottom = 80.dp),
                fontSize = 25.sp,
                color = Color.Green
            )
        }
    }

    @Composable
    fun ButtonColumn(modifier: Modifier, myViewModel: MyViewModel) {
        Column(
            modifier =
            modifier
                .fillMaxSize()
                .background(Color.Transparent)
        ) {
            Row(modifier= modifier
                .fillMaxSize()
                .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            )
            {

                ButtonMethod(name = "C", modifier = modifier, Color.Red, myViewModel)
                ButtonMethod(name = "(", modifier = modifier, Color.Green, myViewModel)
                ButtonMethod(name = ")", modifier = modifier, Color.Green, myViewModel)
                ButtonMethod(name = "/", modifier = modifier, Color.Green, myViewModel)

            }


            Row(modifier= modifier
                .fillMaxSize()
                .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            )
            {

                ButtonMethod(name = "7", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "8", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "9", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "*", modifier = modifier, Color.Green, myViewModel)

            }


            Row(modifier= modifier
                .fillMaxSize()
                .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            )
            {

                ButtonMethod(name = "4", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "5", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "6", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "-", modifier = modifier, Color.Green, myViewModel)

            }


            Row(modifier= modifier
                .fillMaxSize()
                .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            )
            {

                ButtonMethod(name = "1", modifier = modifier, Color.Black,myViewModel)
                ButtonMethod(name = "2", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "3", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "+", modifier = modifier, Color.Green,myViewModel)

            }

            Row(
                modifier = modifier
                    .fillMaxSize()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ButtonMethod(name = "0", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = ".", modifier = modifier, Color.Black,myViewModel)
                ButtonMethod(name = "%", modifier = modifier, Color.Black, myViewModel)
                ButtonMethod(name = "=", modifier = modifier, Color.White, myViewModel)

            }
        }
    }

    @Composable
    fun ButtonMethod(name:String, modifier: Modifier, COLOR: Color, inputLive: MyViewModel){

        if (name == "="){
            Button(
                onClick = {inputLive.getResultt()},
                modifier.size(80.dp,80.dp),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(Color.Green),
                elevation = ButtonDefaults.elevation(0.dp)
            ) {
                Text(text = name,textAlign = TextAlign.Center,fontWeight = FontWeight.Bold,fontSize = 50.sp)
            }
        }else if(name=="C"){


            OutlinedButton(
                onClick = { inputLive.onInputChange("") },
                shape = CircleShape,
                modifier = modifier
                    .size(70.dp, 70.dp)

            ) {
                Text(text = name,textAlign = TextAlign.Center, color = COLOR,fontSize = 30.sp)
            }
        }
        else{
            OutlinedButton(
                onClick = { inputLive.onInputChange(name) },
                shape = CircleShape,
                modifier = modifier
                    .size(70.dp, 70.dp)

            ) {
                Text(text = name,textAlign = TextAlign.Center, color = COLOR,fontSize = 30.sp)
            }
        }



    }

}

































