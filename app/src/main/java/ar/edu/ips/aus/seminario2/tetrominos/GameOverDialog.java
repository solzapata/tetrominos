package ar.edu.ips.aus.seminario2.tetrominos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class GameOverDialog extends DialogFragment {
    private final Activity callingActivity;
    private String data;

    public GameOverDialog(Activity activity, String mensaje) {
        this.callingActivity = activity;
        this.data = mensaje;
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
                })
                .setMessage(data);

        return builder.create();
    }
}
