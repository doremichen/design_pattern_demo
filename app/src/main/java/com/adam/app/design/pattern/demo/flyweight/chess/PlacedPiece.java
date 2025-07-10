/**
 * Description: This class is the placed piece
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.flyweight.chess;

public class PlacedPiece {
    public IChessPiece mPiece;
    public int mX;
    public int mY;

    /**
     * constructor
     */
    public PlacedPiece(IChessPiece piece, int x, int y) {
        mPiece = piece;
        mX = x;
        mY = y;
    }
}
