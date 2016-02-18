package com.rv.funfacts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    // Declare our view variable
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    private String mFact = mFactBook.getFact(0);
    private int mColor = mColorWheel.getColor(8);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR,mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mFactTextView.setText(mFact);
        mColor = savedInstanceState.getInt(KEY_COLOR);
        mRelativeLayout.setBackgroundColor(mColor);
        mShowFactButton.setTextColor(mColor);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);


        //Assign the Views from the layout file to the corresponding variables.

        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mFact = mFactBook.getFact();
                mColor = mColorWheel.getColor();


                //Update the screen with our dynamic fact
                mFactTextView.setText(mFact);
                mRelativeLayout.setBackgroundColor(mColor);
                mShowFactButton.setTextColor(mColor);


            }
        };

        mShowFactButton.setOnClickListener(listener);


        //Toast.makeText(FunFactsActivity.this, "Yay! Our activity was created!", Toast.LENGTH_SHORT).show();
    }
}
