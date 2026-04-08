/*
 * Copyright (c) 2026 Adam Chen
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.adam.app.design.pattern.demo.flyweight.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.flyweight.chess.PlacedPiece;

import java.util.ArrayList;
import java.util.List;

public class ChessBoardView extends View {
    // list of place piece
    private final List<PlacedPiece> mPlacedPieces = new ArrayList<>();

    public ChessBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * add placed piece to list
     */
    public void addPlacedPiece(PlacedPiece placedPiece) {
        mPlacedPieces.add(placedPiece);
        // invalidate the view
        invalidate();
    }

    /**
     * clear all placed piece
     */
    public void clearPlacedPiece() {
        mPlacedPieces.clear();
        // invalidate the view
        invalidate();
    }

    /**
     * onDraw
     */
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        dumpPlacedPiece();

        // draw placed piece
        for (PlacedPiece placedPiece : mPlacedPieces) {
            placedPiece.mPiece.draw(canvas, placedPiece.mX, placedPiece.mY);
        }
    }

    /**
     * dump placed piece
     */
    public void dumpPlacedPiece() {
        for (PlacedPiece placedPiece : mPlacedPieces) {
            Util.logDebug("Dump placed piece:" + placedPiece.mPiece);
            Util.logDebug("Dump placed piece x:" + placedPiece.mX);
            Util.logDebug("Dump placed piece y:" + placedPiece.mY);
        }
    }

    public String getPiecesCount() {
        return String.valueOf(mPlacedPieces.size());
    }
}
