package io.github.francisduvivier.simpleplayer;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.util.MimeTypes;


public class PlayerActivity extends Activity {
    public static final String SOURCE_EXTRA_ID = "sourceUrl";
    private SimpleExoPlayer player;
    private static final String TAG = PlayerActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StyledPlayerView playerView = new StyledPlayerView(this);
        this.setContentView(playerView);
        createPlayer(getIntent().getStringExtra(SOURCE_EXTRA_ID));
        playerView.setPlayer(player);
    }

    private void createPlayer(String sourceUri) {
        if (BuildConfig.DEBUG) {
            android.util.Log.d(TAG, "creating player with source uri [" + sourceUri + "]");
        }
        SimpleExoPlayer.Builder playerBuilder = new SimpleExoPlayer.Builder(this);
        player = playerBuilder.build();
        MediaItem mediaItem = MediaItem.fromUri(sourceUri);
        player.setMediaItem(mediaItem);
        player.prepare();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null) {
            player.pause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.stop();
            player = null;
        }
    }

}
