package com.firezenk.kompose2d

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.firezenk.kompose2d.shared.fpsHandler

data class State(
    // Mandatory properties
    val width: Float = 0F,
    val height: Float = 0F,
    val dt: Float = 0F,
    val isPlaying: Boolean = true,
    val isOver: Boolean = false,
    // Sample properties
    val x: Float = 0F,
    val y: Float = 0F,
    val size: Float = 0F,
    val speed: Float = 1F,
    val direction: Pair<Direction, Direction> = Direction.RIGHT to Direction.DOWN
)
enum class Direction { UP, DOWN, LEFT, RIGHT }

class MainViewModel : GameVM() {

    internal var state by mutableStateOf(State())
        private set

    override fun isCanvasReady(): Boolean = state.width != 0F && state.height != 0F

    override fun isGameOver(): Boolean = state.isOver

    override fun isPlaying(): Boolean = state.isPlaying

    override fun onCanvas(width: Float, height: Float) {
        if (isCanvasReady()) return
        state = state.copy(width = width, height = height)
        // TODO: Initialize game state
        state = state.copy(x = width / 2, y = height / 2, size = width / 5)
    }

    override fun onUpdate() {
        if (isGameOver()) return
        fpsHandler(state.dt).run {
            state = state.copy(dt = this)
        }
        // TODO: Update game state
        bounceAnimation()
    }

    override fun onClean() {
        state = state.copy(isPlaying = false, isOver = true)
        // TODO: Clean game state
    }

    // Sample animation
    private fun bounceAnimation() {
        val (dirX, dirY) = state.direction
        val (dx, dy) = when {
            state.x + state.size >= state.width -> Direction.LEFT to dirY
            state.x - state.size <= 0 -> Direction.RIGHT to dirY
            state.y + state.size >= state.height -> dirX to Direction.UP
            state.y - state.size <= 0 -> dirX to Direction.DOWN
            else -> state.direction
        }
        when(dx) {
            Direction.LEFT -> state = state.copy(x = state.x - state.speed)
            Direction.RIGHT -> state = state.copy(x = state.x + state.speed)
            else -> Unit
        }
        when(dy) {
            Direction.UP -> state = state.copy(y = state.y - state.speed)
            Direction.DOWN -> state = state.copy(y = state.y + state.speed)
            else -> Unit
        }
        state = state.copy(direction = dx to dy)
    }
}