package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TextView tvInfo;
    EditText etInput;
    Button bControl;

    int guess;
    boolean gameFinished;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guess = (int)(Math.random() * 100);
        gameFinished = false;

        tvInfo = (TextView)findViewById(R.id.info_text);
        etInput = (EditText)findViewById(R.id.input_number);
        bControl = (Button)findViewById(R.id.button_OK);

        bControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //FIXME
                if (!gameFinished) {
                    String value = etInput.getText().toString();

                    if (!value.equals("")) {
                        int inp = Integer.parseInt(value);

                        if (inp < 0 || inp > 100)
                            tvInfo.setText(getResources().getString(R.string.error));
                        else {
                            if (inp > guess)
                                tvInfo.setText(getResources().getString(R.string.ahead));
                            else if (inp < guess)
                                tvInfo.setText(getResources().getString(R.string.behind));
                            else {
                                tvInfo.setText(getResources().getString(R.string.hit));
                                bControl.setText(getResources().getString(R.string.play_more));
                                gameFinished = true;
                            }
                        }
                    }
                    else {
                        tvInfo.setText(getResources().getString(R.string.error));
                    }
                } else {
                    guess = (int)(Math.random() * 100);
                    bControl.setText(getResources().getString(R.string.input_value));
                    tvInfo.setText(getResources().getString(R.string.try_to_guess));
                    gameFinished = false;
                }

                etInput.setText("");
            }
        });
    }
}