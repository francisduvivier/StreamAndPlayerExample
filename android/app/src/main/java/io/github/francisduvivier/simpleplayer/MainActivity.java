package io.github.francisduvivier.simpleplayer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static io.github.francisduvivier.simpleplayer.PlayerActivity.SOURCE_EXTRA_ID;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final VideoSourceData[] sources = new VideoSourceData[]{
            new VideoSourceData("Stream 1", "https://storage.googleapis.com/wvmedia/clear/h264/tears/tears.mpd"),
            new VideoSourceData("Stream 2", "https://storage.googleapis.com/exoplayer-test-media-1/60fps/bbb-clear-1080/manifest.mpd")
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ListView listView = findViewById(R.id.sources_list_view);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.list_item, sources));
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            playSource(sources[i]);
        });
    }

    private void playSource(@NonNull VideoSourceData source) {
        Intent playerLaunchIntent = new Intent(this, PlayerActivity.class);
        playerLaunchIntent.putExtra(SOURCE_EXTRA_ID, source.url);
        startActivity(playerLaunchIntent);
    }
}
