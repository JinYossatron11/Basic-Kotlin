package com.example.add.begibkotlin

fun main(args: Array<String>) {
    val language = if (args.size == 0) "FN" else args[0]
    println(when (language) {
        "EN" -> "What's up"
        "FN" -> "Hello"
        else -> "Sorry, I can't greet you in $language yet"
    })
}