@file:OptIn(ExperimentalTextApi::class)

package com.firezenk.kompose2d

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.unit.sp

class MainActivity : Game<MainViewModel>() {

    override fun vm(): MainViewModel = MainViewModel()

    override fun DrawScope.draw(vm: MainViewModel) {
        // TODO: Draw game state (the following is just a sample)
        drawRect(Color(0xFF2BA6DF), Offset(0F, 0F), size)
        drawLine(Color(0xFF98C6E9), start = Offset(vm.state.x, 0F), end = Offset(vm.state.x, size.height), strokeWidth = 2F)
        drawLine(Color(0xFF98C6E9), start = Offset(0F, vm.state.y), end = Offset(size.width, vm.state.y), strokeWidth = 2F)
        drawCircle(Color.Red, vm.state.size, Offset(vm.state.x, vm.state.y))
        drawText(textMeasurer = textMeasurer, text = "Kömpose2D",
            topLeft = Offset(vm.state.x - vm.state.size / 2 - 18.sp.toPx(), vm.state.y - vm.state.size / 2 + 25.sp.toPx()),
            style = TextStyle(fontSize = 22.sp, brush = SolidColor(Color.White)))
    }
}