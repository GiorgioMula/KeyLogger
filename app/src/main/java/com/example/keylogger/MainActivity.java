package com.example.keylogger;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

import static android.view.KeyEvent.*;

public class MainActivity extends Activity {
    private TextView mKeyReceivedTextView;
    private TextView mKeyReceivedTextViewModifier;
    private TextView mKeyReceivedTextViewEvent;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);
        mKeyReceivedTextView = findViewById(R.id.textView);
        mKeyReceivedTextViewModifier = findViewById(R.id.textViewModifier);
        mKeyReceivedTextViewEvent = findViewById(R.id.textViewEvent);
        timer = new CountDownTimer(2000, 2000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                mKeyReceivedTextView.setText(R.string.text_description);
                mKeyReceivedTextViewModifier.setText("");
                mKeyReceivedTextViewEvent.setText("");
            }
        };
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        printKey(event);
        timer.start();
        return true;
    }

    private void printKey(KeyEvent event) {
        int keycode = event.getKeyCode();

        String codeName;
        switch (keycode){
            case KEYCODE_DPAD_CENTER:
                codeName = "KEYCODE_DPAD_CENTER";
                break;
            case KEYCODE_DPAD_DOWN:
                codeName = "KEYCODE_DPAD_DOWN";
                break;
            case KEYCODE_DPAD_LEFT:
                codeName = "KEYCODE_DPAD_LEFT";
                break;
            case KEYCODE_DPAD_RIGHT:
                codeName = "KEYCODE_DPAD_RIGHT";
                break;
            case KEYCODE_DPAD_UP:
                codeName = "KEYCODE_DPAD_UP";
                break;
            case 111:   // KEYCODE_ESCAPE
                codeName = "KEYCODE_ESCAPE";
                break;
            case KEYCODE_BACK:
                codeName = "KEYCODE_BACk";
                break;
            case KEYCODE_ENTER:
                codeName = "KEYCODE_BACk";
                break;

            default:
                codeName = String.format(Locale.ENGLISH, "KEYCODE: %d", keycode);
                break;
        }

        String modifier = event.isLongPress()? "LONG PRESS": "";
        String action = event.getAction() == ACTION_UP? "UP": "DOWN";

        mKeyReceivedTextView.setText(codeName);
        mKeyReceivedTextViewModifier.setText(modifier);
        mKeyReceivedTextViewEvent.setText(action);

    }

    public void onExitButtonClick(View view) {
        finish();
    }
}
