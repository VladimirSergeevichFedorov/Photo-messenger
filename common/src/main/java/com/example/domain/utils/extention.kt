package com.example.domain.utils

import java.math.BigInteger
import java.security.MessageDigest

fun String.getSHA512(): String {
    val md: MessageDigest = MessageDigest.getInstance("SHA-512")
    val messageDigest = md.digest(this.toByteArray(Charsets.UTF_16LE))
    val no = BigInteger(1, messageDigest)
    var hashtext: String = no.toString(16)
    while (hashtext.length < 128) {
        hashtext = "0$hashtext"
    }
    return hashtext
}
