package ar.edu.ips.aus.seminario2.tetrominos.infra.ui;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import ar.edu.ips.aus.seminario2.tetrominos.R;
import ar.edu.ips.aus.seminario2.tetrominos.adapter.HighScoreHelper;

public class GameOverDialog extends DialogFragment {

    private final Activity callingActivity;
    private final HighScoreHelper helper;

    public GameOverDialog(Activity activity, HighScoreHelper helper) {
        this.callingActivity = activity;
        this.helper = helper;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = null;

        SharedPreferences pref = callingActivity.getPreferences(MODE_PRIVATE);

        if (helper.newHighScore) {
            view = inflater.inflate(R.layout.dialog_high_score, null);
            builder.setView(view);

            String username = pref.getString("username", "");

            EditText vista = view.findViewById(R.id.player_name);
            vista.setText(username);
        }

        final View parentView = view;
        builder.setMessage(helper.message)
                .setPositiveButton(R.string.continue_game, (dialog, which) -> {
                    if (helper.newHighScore) {
                        // TODO TP2 recuperar el nombre ingresado e insertarlo en la BBDD
                        EditText inputText = parentView.findViewById(R.id.player_name);
                        String username = inputText.getText().toString();

                        helper.repo.setPlayerScore(username, helper.playerScore);

                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("username", username);
                        editor.apply();
                    }
                    callingActivity.finish();
                    Intent newStartIntent = new Intent(getContext(), HallOfFameActivity.class);
                    startActivity(newStartIntent);
                });
        return builder.create();
    }
}
