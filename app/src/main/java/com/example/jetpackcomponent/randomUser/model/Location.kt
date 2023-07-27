package com.example.jetpackcomponent.randomUser.model

data class Location(
    val city: String,
    val coordinates: Coordinates,
    val country: String,
    val postcode: Long,
    val state: String,
    val street: Street,
    val timezone: Timezone
)