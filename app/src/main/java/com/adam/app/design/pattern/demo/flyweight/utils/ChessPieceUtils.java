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

package com.adam.app.design.pattern.demo.flyweight.utils;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.flyweight.chess.BlackPiece;
import com.adam.app.design.pattern.demo.flyweight.chess.IChessPiece;
import com.adam.app.design.pattern.demo.flyweight.chess.WhitePiece;

import java.util.HashMap;
import java.util.Map;

public final class ChessPieceUtils {
    // map of chess piece: key is the string chess color , value is the chess piece
    private static final Map<String, IChessPiece> sChessPieceMap = new HashMap<>();

    private ChessPieceUtils() {
        throw new UnsupportedOperationException("This is Chess picker Utils");
    }


    /**
     * get chess piece
     *
     * @param context
     * @param color   String
     * @return IChessPiece
     */
    public static IChessPiece getChessPiece(Context context, String color) {
        // if the chess piece is not in the map, add it
        if (!sChessPieceMap.containsKey(color)) {
            if (color.equals(context.getString(R.string.demo_flyweight_color_black))) {
                final BlackPiece black = new BlackPiece();
                sChessPieceMap.put(color, black);
                return black;
            } else if (color.equals(context.getString(R.string.demo_flyweight_color_white))) {
                final WhitePiece white = new WhitePiece();
                sChessPieceMap.put(color, white);
                return white;
            }
        }

        return sChessPieceMap.get(color);
    }

    /**
     * get instance count
     * @return the number of instance
     */
    public static String getInstanceCount() {
        return String.valueOf(sChessPieceMap.size());
    }

}
