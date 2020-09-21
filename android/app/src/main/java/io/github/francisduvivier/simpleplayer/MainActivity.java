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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ListView listView = findViewById(R.id.sources_list_view);
        listView.setAdapter(new ArrayAdapter<>(this, R.layout.list_item, VideoSources.sources));
        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            playSource(VideoSources.sources[i]);
        });
    }

    private void playSource(@NonNull VideoSourceData source) {
        Intent playerLaunchIntent = new Intent(this, PlayerActivity.class);
        playerLaunchIntent.putExtra(SOURCE_EXTRA_ID, source.url);
        startActivity(playerLaunchIntent);
    }
}
