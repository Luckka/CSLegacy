package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import api.Server
import cafe.adriel.voyager.core.screen.Screen
import list_item.StickerItem
import model.Sticker

data class Home(val id: String): Screen {

    @Composable
    override fun Content() {

       val server = Server()

        var stickerList by remember {mutableStateOf(mutableListOf<Sticker>())}

        LaunchedEffect(Unit){
            server.getStickers().collect{ stickerListServer ->
                    stickerList = stickerListServer
            }
        }

        Column(modifier = Modifier.fillMaxSize().background(Color.Gray)){
            LazyColumn {
                itemsIndexed(stickerList){_,sticker ->

                    StickerItem(sticker = sticker)


                }

            }
        }
    }
}