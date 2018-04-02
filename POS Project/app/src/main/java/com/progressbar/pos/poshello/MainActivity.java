package com.progressbar.pos.poshello;

import android.app.Dialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    private Button button;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonShowCustomDialog);
        // add button listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // custom dialog
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.custom);
                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
                mp = MediaPlayer.create(getApplicationContext(), R.raw.sound);

                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        mp.stop();
                        Toast.makeText(getApplicationContext(), "Dismissed..!!", Toast.LENGTH_SHORT).show();
                    }
                });
                mp.start();
                dialog.show();
            }
        });
    }
}
