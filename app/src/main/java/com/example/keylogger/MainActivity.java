package com.example.keylogger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

import static android.view.KeyEvent.*;

public class MainActivity extends Activity {
    private TextView mKeyReceivedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);
        mKeyReceivedTextView = findViewById(R.id.textView);

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        printKey(event);
        // Exit from application
        if ((event.getKeyCode() == KEYCODE_BACK) && event.isLongPress()) {
            return super.dispatchKeyEvent(event);
        }
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
        if (event.isLongPress()) {
            codeName += " - LONG PRESS";
        }

        mKeyReceivedTextView.setText(codeName);
    }

    public void onExitButtonClick(View view) {
        finish();
    }
}
