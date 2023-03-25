package com.example.mypet.data.model

enum class Type {
    CAT,
    DOG,
    BIRD,
    MOUSE,
    HAMSTER,
    SNAKE
}

enum class Male {
    MALE,
    FEMALE,
    UNKNOWN
}

data class Pet(
    val name: String,
    val age: Int,
    val type: Type,
    val sex: Male,
    var imageResource: Int?
)