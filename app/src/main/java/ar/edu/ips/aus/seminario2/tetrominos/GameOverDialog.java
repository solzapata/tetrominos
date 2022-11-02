package ar.edu.ips.aus.seminario2.tetrominos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class GameOverDialog extends DialogFragment {
    private final Activity callingActivity;

    public GameOverDialog(Activity activity) {
        this.callingActivity = activity;
    }

    @NonNull
    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.game_over_message)
                .setPositiveButton(R.string.restart_game, (dialog, which) -> {
                    Intent intent = callingActivity.getIntent();
                    callingActivity.finish();
                    startActivity(intent);
                })
                .setNegativeButton(R.string.exit_game, (dialog, which) -> {
                    callingActivity.finish();
                });
        return builder.create();
    }
}
