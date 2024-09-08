package com.furkancolak.ilhamver

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkancolak.ilhamver.ui.theme.IlhamVerTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IlhamVerTheme {
                MainScreen()
            }
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    // Bir top app bar durumu oluşturuluyor
    val topAppBarState = rememberTopAppBarState()

    // Scaffold bileşeni
    Scaffold(
        topBar = {
            // topAppBarState kullanarak TopAppBar tanımı yapılabilir
            TopAppBar(title = { Text(text = "İlham Ver")}
            , colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = colorResource(id = R.color.anaRenk),
                    // yukarısı arka plan rengi
                titleContentColor = colorResource(id = R.color.white)
                // yazı rengi
            ))
        },
        // İçerik kısmı
        content = {
            // İçerik buraya gelecek
            Column(modifier = Modifier.fillMaxSize(1f)
                , verticalArrangement = Arrangement.SpaceEvenly// dikeyde
                , horizontalAlignment = Alignment.CenterHorizontally)// yatayda
            {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                androidx.compose.foundation.Image(painter = painterResource(R.drawable.stevejobs),
                    contentDescription ="" )
                Text(text = "Steve Jobs",
                    color = Color.Red
                    ,fontWeight = FontWeight.Bold
                , fontSize = 22.sp)
                Text(
                    text = "Dünyayı değiştirecek insanlar, onu değiştirebileceklerini düşünecek kadar çılgın olanlardır.",
                    modifier = Modifier.padding(all =20.dp)
                        //.border(BorderStroke(3.dp, color = Color.Blue))
                        ,textAlign = TextAlign.Center
                )
                Button(
                    colors =ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.padding(end = 15.dp),
                    onClick = {
                        Log.e("Button","İlham Verildi")
                    }) {
                    Text(text = "İlham Ver")
                }
            }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    IlhamVerTheme {
        MainScreen()
    }
}