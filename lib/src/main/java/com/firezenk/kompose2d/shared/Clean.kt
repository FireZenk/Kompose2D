package com.firezenk.kompose2d.shared

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

@Composable
fun Clean(onDeInit: () -> Unit) = DisposableEffect(Unit) {
    onDispose {
        onDeInit()
    }
}