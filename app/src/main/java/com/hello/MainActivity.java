package com.hello;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private int secondCount = 1;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        mShowCount = findViewById(R.id.show_count);
    }

    public void countUp(View view) {
        EditText input_limit = findViewById(R.id.input_limit);

        if (!input_limit.getText().toString().isEmpty()) {
            int limit = Integer.parseInt(input_limit.getText().toString());

            if (mCount >= limit) {
                Toast.makeText(this, "You've reached the limit", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        int next = mCount;
        mCount = secondCount;
        secondCount = next + mCount;

        if (mShowCount != null) {
            mShowCount.setText(Integer.toString(next));

            if (next % 2 != 0) { // Check if the number is odd
                mShowCount.setTextColor(Color.parseColor("#BF00FF")); // Set text color to orange
            } else {
                mShowCount.setTextColor(Color.BLACK); // Set text color to black for even numbers
            }
        }
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void reset(View view) {
        mCount = 0;
        secondCount = 1;
        if (mShowCount != null) {
            mShowCount.setText("0");
            mShowCount.setTextColor(Color.BLACK); // Reset text color to black
        }
    }
}
