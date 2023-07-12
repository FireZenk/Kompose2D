package com.firezenk.kompose2d.shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay

@Composable
fun FPS(running: Boolean, onTick: () -> Unit) {
    LaunchedEffect(Unit) {
        while(running) {
            delay(6)
            onTick()
        }
    }
}

fun fpsHandler(dt: Float): Float = dt + 1