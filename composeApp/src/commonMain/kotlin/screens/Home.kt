package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cafe.adriel.voyager.core.screen.Screen
import list_item.StickerItem
import model.Sticker

data class Home(val id: String): Screen {

    @Composable
    override fun Content() {

        val stickerList: MutableList<Sticker> = mutableListOf(
            Sticker(
                name = "Sticker1",
                image = "Image1",
                description = "desc1",
                tournamentEvent = "Major1",
                tournamentTeam = "NIP",
                id = "1ID"
            ),
            Sticker(
                name = "Sticker1",
                image = "Image1",
                description = "desc2",
                tournamentEvent = "Major1",
                tournamentTeam = "NIP",
                id = "1ID"
            ),
            Sticker(
                name = "Sticker1",
                image = "Image1",
                description = "desc3",
                tournamentEvent = "Major1",
                tournamentTeam = "NIP",
                id = "1ID"
            ),
        )


        Column(modifier = Modifier.fillMaxSize().background(Color.Gray)){
            LazyColumn {
                itemsIndexed(stickerList){_,sticker ->

                    StickerItem(sticker = sticker)


                }

            }
        }
    }
}