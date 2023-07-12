package com.firezenk.kompose2d

import androidx.lifecycle.ViewModel

abstract class GameVM : ViewModel() {

    /**
     * @return true if canvas is ready to draw
     */
    abstract fun isCanvasReady(): Boolean

    /**
     * @return true if game is over
     */
    abstract fun isGameOver(): Boolean

    /**
     * @return true if game is playing
     */
    abstract fun isPlaying(): Boolean

    /**
     * Called when canvas is ready to draw
     * @param width of the canvas
     * @param height of the canvas
     */
    abstract fun onCanvas(width: Float, height: Float)

    /**
     * Called every game tick
     */
    abstract fun onUpdate()

    /**
     * Called when game is over
     */
    abstract fun onClean()

    override fun onCleared() {
        onClean()
        super.onCleared()
    }
}