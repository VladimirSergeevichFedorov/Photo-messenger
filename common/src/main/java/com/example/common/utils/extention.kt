package com.example.common.utils

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
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

fun Long?.orZero(): Long = this ?: 0

fun Modifier.glow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    radius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp
) = this.drawBehind {
//    val transparentColor = android.graphics.Color.toArgb(color.copy(alpha = 0.0f).value.toLong())
//    val shadowColor = android.graphics.Color.toArgb(color.copy(alpha = alpha).value.toLong())
    val transparentColor = Color.Transparent.toArgb()
    val shadowColor = color.copy(alpha).toArgb()
    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparentColor
        frameworkPaint.setShadowLayer(
            radius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            borderRadius.toPx(),
            borderRadius.toPx(),
            paint
        )
    }
}