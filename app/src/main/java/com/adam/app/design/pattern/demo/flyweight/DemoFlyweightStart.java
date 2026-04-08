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

package com.adam.app.design.pattern.demo.flyweight;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.adam.app.design.pattern.demo.R;
import com.adam.app.design.pattern.demo.Util;
import com.adam.app.design.pattern.demo.databinding.ActivityDemoFlyweightStartBinding;
import com.adam.app.design.pattern.demo.flyweight.utils.ChessPieceUtils;
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

        // build adapter
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.piece_colors, android.R.layout.simple_dropdown_item_1line);
        // set adapter to auto complete text view
        mBinding.autoCompleteColor.setAdapter(adapter);
        // set the first item selected
        mBinding.autoCompleteColor.setText(adapter.getItem(0), false);


        mChessBoardView = mBinding.chessBoard;

        // set place piece button click listener
        mBinding.btnPlacePiece.setOnClickListener(this::placePiece);

        // initial information
        mBinding.txtTotalCount.setText(getString(R.string.demo_flyweight_total_pieces_count, "0"));
        mBinding.txtInstanceCount.setText(getString(R.string.demo_flyweight_unique_objects_count, "0"));


        // set back button click listener
        mBinding.btnBack.setOnClickListener(v -> {
            Util.backToMainActivity(this);
        });


    }

    private void placePiece(View v) {
        // get color from spinner
        String color = mBinding.autoCompleteColor.getText().toString();
        // get chess by chess piece factory
        IChessPiece chess = ChessPieceUtils.getChessPiece(this , color);

        // get boundary of chess board view
        int boardWidth = mChessBoardView.getWidth();
        int boardHeight = mChessBoardView.getHeight();

        // define safe boundary
        int radius = 50;
        int padding = 10;
        int margin = radius + padding;

        // set x and y of chess
        int x = margin + mRandom.nextInt(Math.max(1, boardWidth - 2 * margin));
        int y = margin + mRandom.nextInt(Math.max(1, boardHeight - 2 * margin));
        // place chess
        mChessBoardView.addPlacedPiece(new PlacedPiece(chess, x, y));
        // update information
        mBinding.txtTotalCount.setText(getString(R.string.demo_flyweight_total_pieces_count, mChessBoardView.getPiecesCount()));
        mBinding.txtInstanceCount.setText(getString(R.string.demo_flyweight_unique_objects_count, ChessPieceUtils.getInstanceCount()));

        String logEntry = String.format("[%s] At (%d, %d) -> Object ID: %h\n",
                color, x, y, System.identityHashCode(chess));
        mBinding.txtFlyweightLog.append(logEntry);

        // scroll to button
        mBinding.logScroll.post(() -> mBinding.logScroll.fullScroll(View.FOCUS_DOWN));

    }
}