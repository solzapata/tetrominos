package ar.edu.ips.aus.seminario2.tetrominos.infra.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ar.edu.ips.aus.seminario2.tetrominos.R;

public class StartupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup_activity);

        Intent intent = new Intent(StartupActivity.this, GameMainActivity.class);

        Button easyButton = findViewById(R.id.easyButton);
        easyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("level", 1);
                startActivity(intent);
            }
        });

        Button normalButton = findViewById(R.id.normalButton);
        normalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("level", 4);
                startActivity(intent);
            }
        });

        Button expertButton = findViewById(R.id.expertButton);
        expertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("level", 6);
                startActivity(intent);
            }
        });
    }
}