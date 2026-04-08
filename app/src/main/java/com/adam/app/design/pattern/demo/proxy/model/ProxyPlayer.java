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

package com.adam.app.design.pattern.demo.proxy.model;

public class ProxyPlayer extends IGamePlayer{
    // TAG
    private static final String TAG = "ProxyPlayer";

    private String mCachedAssetsHash;
    private long mLastPlayEpochMs;

    // real player
    private final RealPlayer mRealPlayer;

    public ProxyPlayer(String name) {
        super(name);
        mRealPlayer = new RealPlayer(name);
    }

    @Override
    public void play(LogSink sink) {
        long now = System.currentTimeMillis();

        sink.add(TAG + ": start play");

        // time boundary
        // Not allow to play again during the 1.5 sec.
        long intervalMs = 1500L;
        if ((now - mLastPlayEpochMs) < intervalMs) {
            sink.add(TAG + ": rate-limited (wait " + (intervalMs - (now - mLastPlayEpochMs)) + "ms)");
            return;
        }
        // update last play time
        mLastPlayEpochMs = now;

        // check permission
        sink.add(TAG + ": checking permission...");
        String token = AuthService.obtainToken(sink);
        if (token == null) {
            sink.add(TAG + ": permission denied.");
            return;
        }

        sink.add(TAG + ": : auth ok: " + token.substring(0, Math.min(6, token.length())) + "...");

        // check assets
        if (mCachedAssetsHash == null) {
            sink.add(TAG + ": loading assets...");
            mCachedAssetsHash = AssetLoader.loadHeavyAssets(sink);
            sink.add(TAG + ": done: " + mCachedAssetsHash);
        } else {
            sink.add(TAG + ": cache hit → reuse assets: " + mCachedAssetsHash);
        }

        // real play
        sink.add(TAG + ": start real play...");
        mRealPlayer.play(sink);

        sink.add(TAG + ": analytics tracked.");
    }
}
