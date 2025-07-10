/**
 * Description: This interface is the chess piece interface
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.flyweight.chess;

import android.graphics.Canvas;

public interface IChessPiece {

    /**
     * draw chess piece
     * @param canvas Canvas
     * @param x int
     * @param y int
     */
    void draw(Canvas canvas, int x, int y);
}
