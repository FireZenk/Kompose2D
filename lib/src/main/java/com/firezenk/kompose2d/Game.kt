@file:OptIn(ExperimentalTextApi::class)

package com.firezenk.kompose2d

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextMeasurer
import androidx.compose.ui.text.rememberTextMeasurer
import com.firezenk.kompose2d.shared.Clean
import com.firezenk.kompose2d.shared.FPS

abstract class Game<V : GameVM> : ComponentActivity() {

    private val vm by lazy { vm() }

    lateinit var textMeasurer: TextMeasurer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            textMeasurer = rememberTextMeasurer()

            FPS(vm.isPlaying()) { vm.onUpdate() }
            Loop(vm)
            Clean { vm.onClean() }
        }
    }

    abstract fun vm(): V

    @Composable
    private fun Loop(vm: V)  = Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        vm.onCanvas(size.width, size.height)
        draw(vm)
    }

    open fun DrawScope.draw(vm: V) {}
}