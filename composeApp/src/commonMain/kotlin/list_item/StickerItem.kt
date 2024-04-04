package list_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.seiko.imageloader.rememberImagePainter
import model.Sticker
import screens.Details

@Composable
fun StickerItem(
    sticker: Sticker
) {

    val img = sticker.image
    val name = sticker.name
    val description = sticker.description
    val navigator = LocalNavigator.currentOrThrow

    Column (modifier = Modifier.fillMaxWidth().background(Color.Gray).padding(10.dp)){

        Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start){

            Image(painter = rememberImagePainter(img!!),contentDescription = null, modifier = Modifier.width(100.dp).height(100.dp).padding(0.dp,0.dp,10.dp,0.dp), contentScale = ContentScale.Inside)

            Text(name!!, fontSize = 14.sp)


        }

        Column (modifier = Modifier.fillMaxWidth().background(Color.White).padding(10.dp)){
            Text(
                description!!,
                fontSize = 16.sp,
                modifier = Modifier.padding(110.dp,5.dp),
                color = Color.Black
            )

            Button(
                onClick = {
                    navigator.push(Details(
                        id = "StickerDetails",
                        name!!,
                        img!!,
                        description!!
                    ))
                },
                modifier = Modifier.fillMaxWidth().height(50.dp).padding(20.dp,5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Yellow,
                    contentColor = Color.Black
                ),
                border = BorderStroke(
                    2.dp,
                    Color.Magenta
                )
            ){
                Text("Details")
            }


        }
    }
}