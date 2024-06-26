package screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.seiko.imageloader.rememberImagePainter

data class Details(
    val id: String,
    val name: String,
    val img: String,
    val description: String

) : Screen {

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow
        Scaffold (topBar = {
            TopAppBar (modifier = Modifier.fillMaxWidth(), backgroundColor = Color.Black){
                IconButton(
                    onClick = {
                        navigator.pop()
                    }
                ){
                    Icon(Icons.AutoMirrored.Filled.ArrowBack,contentDescription = null, tint = Color.White)
                }

                Text("Sticker Detail", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }){
            Column (modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally){
                Text(name, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp,30.dp,20.dp,0.dp))
                Image(painter = rememberImagePainter(img!!),contentDescription = null, modifier = Modifier.width(100.dp).height(100.dp).padding(0.dp,0.dp,10.dp,0.dp), contentScale = ContentScale.Inside)
                Text(description, fontSize = 18.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(20.dp,30.dp,20.dp,0.dp))
            }
        }
    }
}