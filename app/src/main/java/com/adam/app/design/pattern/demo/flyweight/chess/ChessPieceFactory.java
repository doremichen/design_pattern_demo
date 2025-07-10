/**
 * Description: This class is the chess piece factory
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.flyweight.chess;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceFactory {
    // map of chess piece: key is the string chess color , value is the chess piece
    private static final Map<String, IChessPiece> sChessPieceMap = new HashMap<>();
    /**
     * reference: string.xml
     * <string-array name="piece_colors">
     *         <item>Black</item>
     *         <item>White</item>
     *  </string-array>
     */
    public static final String BLACK = "Black";
    public static final String WHITE = "White";


    /**
     * get chess piece
     * @param color String
     * @return IChessPiece
     */
    public static IChessPiece getChessPiece(String color) {
        // if the chess piece is not in the map, add it
        if (!sChessPieceMap.containsKey(color)) {
            if (color.equals(BLACK)) {
                final BlackPiece black = new BlackPiece();
                sChessPieceMap.put(color, black);
                return black;
            } else if (color.equals(WHITE)) {
                final WhitePiece white = new WhitePiece();
                sChessPieceMap.put(color, white);
                return white;
            }
        }

        return sChessPieceMap.get(color);
    }
}
