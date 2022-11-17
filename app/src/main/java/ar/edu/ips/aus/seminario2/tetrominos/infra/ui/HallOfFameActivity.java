package ar.edu.ips.aus.seminario2.tetrominos.infra.ui;

import static java.security.AccessController.getContext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import ar.edu.ips.aus.seminario2.tetrominos.R;
import ar.edu.ips.aus.seminario2.tetrominos.adapter.ScoreViewModel;
import ar.edu.ips.aus.seminario2.tetrominos.app.Game;
import ar.edu.ips.aus.seminario2.tetrominos.infra.ScoreAdapter;

public class HallOfFameActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hall_of_fame);

        Game game = (Game) getApplication();
        Intent intent = getIntent();
        int level_msg = intent.getIntExtra("level", 1);

        RecyclerView highestScoresListView = findViewById(R.id.highest_scores);
        highestScoresListView.setLayoutManager(new LinearLayoutManager(this));

        ScoreViewModel model = new ViewModelProvider(this).get(ScoreViewModel.class);
        ScoreAdapter scoreAdapter = new ScoreAdapter(this, model);
        highestScoresListView.setAdapter(scoreAdapter);

        Button exitButton = findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Button resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                Intent newStartIntent = new Intent(HallOfFameActivity.this, GameMainActivity.class);
                startActivity(newStartIntent);
            }
        });
    }
}