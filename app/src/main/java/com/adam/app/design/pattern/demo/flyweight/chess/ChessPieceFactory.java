/**
 * Description: This class is the chess piece factory
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.flyweight.chess;

import android.content.Context;

import com.adam.app.design.pattern.demo.R;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceFactory {
    // map of chess piece: key is the string chess color , value is the chess piece
    private static final Map<String, IChessPiece> sChessPieceMap = new HashMap<>();

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
}
