package model

import kotlinx.serialization.Serializable

@Serializable
data class Sticker(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val tournament_event: String? = null,
    val tournament_team: String? = null,
    val image: String? = null,
    val rarity: Rarity? = null,
    val crates: List<Crate>? = null,
    val type: String? = null,
    val market_hash_name: String? = null,
    val effect: String? = null,
    val tournament_player: String? = null,
    val special_notes: List<SpecialNote>? = null
)


@Serializable
data class Rarity(
    val id: String,
    val name: String,
    val color: String
)
@Serializable
data class Crate(
    val id: String,
    val name: String,
    val image: String
)

@Serializable
data class SpecialNote(
    val source: String,
    val text: String
)
