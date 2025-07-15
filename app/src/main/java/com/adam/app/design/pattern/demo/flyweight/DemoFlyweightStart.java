/**
 * Description: This class is the start activity of Flyweight demo
 * Author: Adam Chen
 * Date: 2025/07/10
 */
package com.adam.app.design.pattern.demo.flyweight;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoFlyweightStartBinding;
import com.adam.app.design.pattern.demo.flyweight.chess.ChessPieceFactory;
import com.adam.app.design.pattern.demo.flyweight.chess.IChessPiece;
import com.adam.app.design.pattern.demo.flyweight.chess.PlacedPiece;
import com.adam.app.design.pattern.demo.flyweight.view.ChessBoardView;

import java.util.Random;

public class DemoFlyweightStart extends AppCompatActivity {

    // view binding
    private ActivityDemoFlyweightStartBinding mBinding;
    private Random  mRandom = new Random();
    // chess board view
    private ChessBoardView mChessBoardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // view binding
        mBinding = ActivityDemoFlyweightStartBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mChessBoardView = mBinding.chessBoard;

        // set place piece button click listener
        mBinding.btnPlacePiece.setOnClickListener(v -> {
            // get color from spinner
            String color = mBinding.spinnerColor.getSelectedItem().toString();
            // get chess by chess piece factory
            IChessPiece chess = ChessPieceFactory.getChessPiece(this , color);
            // set x and y of chess
            int x = 50 + mRandom.nextInt(500);
            int y = 200 + mRandom.nextInt(800);
            // place chess
            mChessBoardView.addPlacedPiece(new PlacedPiece(chess, x, y));
        });

        // set back button click listener
        mBinding.btnBack.setOnClickListener(v -> {
            Util.backToMainActivity(this);
        });


    }
}