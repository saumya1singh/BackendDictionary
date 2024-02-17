package com.example.mydictionaryapp

    data class MyDataClass(
        val word: String,
        val phonetics: List<Phonetic>,
        val meanings: List<Meaning>
    )

    data class Meaning(
        val partOfSpeech: String,
        val definitions: List<Definition>,
        val synonyms: List<String>,
        val antonyms: List<String>,
    )

    data class Definition(
        val definition: String,
        val synonyms: List<Any?>,
        val antonyms: List<Any?>,
        val example: String?,
    )

    data class Phonetic(
        val audio: String,
        val text: String?,
    )
