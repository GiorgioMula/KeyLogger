package com.example.keylogger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import static android.view.KeyEvent.*;
//import static android.view.KeyEvent.KEYCODE_DPAD_CENTER;
//import static android.view.KeyEvent.KEYCODE_DPAD_DOWN;
//import static android.view.KeyEvent.KEYCODE_DPAD_LEFT;
//import static android.view.KeyEvent.KEYCODE_DPAD_RIGHT;
//import static android.view.KeyEvent.KEYCODE_DPAD_UP;
//import static android.view.KeyEvent.KEYCODE_ENTER;
//import static android.view.KeyEvent.KEYCODE_ESCAPE;

public class MainActivity extends Activity {
    private TextView mKeyReceivedTextView;
//    private AsyncTask mKeyTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main_activity);
        mKeyReceivedTextView = findViewById(R.id.textView);

    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        //return super.dispatchKeyEvent(event);
        printKey(event);
        return true;
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

//        if (mKeyTask != null) {
//            mKeyTask.cancel(true);
//        }
//        mKeyTask = new AsyncTask() {
//            @Override
//            protected Object doInBackground(Object[] objects) {
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException ex){
//
//                }
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Object o) {
//                mKeyReceivedTextView.setText("Wait for key event ...");
//            }
//        };
//        mKeyTask.execute();
        return super.onKeyDown(keyCode, event);
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
            case KEYCODE_ESCAPE:
                codeName = "KEYCODE_ESCAPE";
                break;
            case KEYCODE_BACK:
                codeName = "KEYCODE_BACk";
                break;
            case KEYCODE_ENTER:
                codeName = "KEYCODE_BACk";
                break;

            default:
                codeName = String.format("KEYCODE: %d", keycode);
                break;
        }

        mKeyReceivedTextView.setText(codeName);
    }
}
