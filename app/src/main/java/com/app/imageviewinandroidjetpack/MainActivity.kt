package com.app.imageviewinandroidjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.app.imageviewinandroidjetpack.ui.theme.ImageViewInAndroidJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageViewInAndroidJetpackTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    Greeting("Android")
                 //   ImageViewCompose()

                    //Load Image with Internet
                    LoadImageWithInternet()

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ImageViewInAndroidJetpackTheme {
        Greeting("Android")
       // ImageViewCompose()
        LoadImageWithInternet()
    }
}

//lets make a new function
@Composable
fun ImageViewCompose(){
    Image(
        painter = painterResource(id = R.drawable.girl)
        , contentDescription ="Girl Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    )
}

@Composable
fun LoadImageWithInternet(){
    //1 first add coil library in gradle
    // add internet permission  android manifest
    val imageUrl= "https://www.industrialempathy.com/img/remote/ZiClJf-1920w.jpg"
    Image(painter = rememberImagePainter(data = imageUrl), contentDescription ="Image from Internet" )
}