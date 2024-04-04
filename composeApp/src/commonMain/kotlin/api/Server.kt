package api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.cache.HttpCache
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import model.Sticker

class Server {

    suspend fun getStickers(): Flow<MutableList<Sticker>>{
        val client  = HttpClient{
            install(ContentNegotiation){
                json()
            }

            install(HttpCache)
        }
        val stickers = client
            .get("https://bymykel.github.io/CSGO-API/api/en/stickers.json")
            .body<MutableList<Sticker>>()

        return MutableStateFlow(stickers)
    }
}