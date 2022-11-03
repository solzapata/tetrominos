package ar.edu.ips.aus.seminario2.tetrominos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        Intent intent = new Intent(MainActivity.this, GameMainActivity.class);

        Button easyButton = findViewById(R.id.easy);
        easyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("level", 1);
                startActivity(intent);
            }
        });

        Button normalButton = findViewById(R.id.normal);
        normalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("level", 4);
                startActivity(intent);
            }
        });

        Button expertButton = findViewById(R.id.expert);
        expertButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("level", 6);
                startActivity(intent);
            }
        });
    }
}