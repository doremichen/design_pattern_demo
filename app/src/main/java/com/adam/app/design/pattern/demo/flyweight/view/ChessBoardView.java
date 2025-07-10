/**
 * Description: This class is defined a chess board view.
 * Author: Adam Chen
 * Date: 2025/07/10
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
}
