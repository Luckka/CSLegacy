package list_item

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
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
    val tournament_player = sticker.tournament_player ?: ""
    val navigator = LocalNavigator.currentOrThrow

    Column (modifier = Modifier.fillMaxWidth().background(Color.Gray).padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally){

        Column(modifier = Modifier.fillMaxWidth().background(Color(0xff33322e)).padding(10.dp).clip(shape = RoundedCornerShape(40.dp)).clip(
            RoundedCornerShape(40.dp)
        ),horizontalAlignment = Alignment.CenterHorizontally){

            Spacer(modifier = Modifier.height(20.dp))

              Card( shape = RoundedCornerShape(15.dp), elevation = 10.dp, backgroundColor = Color(0xffFFCA28),) {
                  Box(modifier = Modifier.height(200.dp)){
                      Image(painter = rememberImagePainter(img!!),contentDescription = null, modifier = Modifier.width(200.dp).height(200.dp).padding(0.dp,0.dp,10.dp,0.dp), contentScale = ContentScale.Fit)
                  }
              }

//
//
//            Text(name!!, fontSize = 14.sp, color = Color.White)


        }

        Column (modifier = Modifier.fillMaxWidth().background(Color(0xff33322e)).padding(10.dp), horizontalAlignment = Alignment.CenterHorizontally){
            Text(

                name!!,
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                modifier = Modifier.padding(110.dp,5.dp),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

//            Button(
//                onClick = {
//                    navigator.push(Details(
//                        id = "StickerDetails",
//                        name,
//                        img!!,
//                        tournament_player
//                    ))
//                },
//                modifier = Modifier.fillMaxWidth().height(50.dp).padding(20.dp,5.dp),
//                colors = ButtonDefaults.outlinedButtonColors(
//                    backgroundColor = Color.Black,
//                    contentColor = Color.White
//                ),
//                border = BorderStroke(
//                    2.dp,
//                    Color.Black
//                )
//            ){
//                Text("Details")
//            }


        }
    }
}