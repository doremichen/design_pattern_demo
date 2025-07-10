/**
 * Description: This class is the white chess piece
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.flyweight.chess;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class WhitePiece implements IChessPiece {
    @Override
    public void draw(Canvas canvas, int x, int y) {
        // paint
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        // draw circle
        canvas.drawCircle(x, y, 30, paint);
    }
}
