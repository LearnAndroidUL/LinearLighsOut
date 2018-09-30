package io.ruszkipista.linearlightsout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LightsOutGame mGame;
    int numButtons = 10;
    TextView mGameStateTextView;
    Button[] mButtons = new Button[numButtons];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGame = new LightsOutGame(numButtons);
        mGameStateTextView = findViewById(R.id.game_state_text_view);
        mButtons[0] = findViewById(R.id.button0);
        mButtons[1] = findViewById(R.id.button1);
        mButtons[2] = findViewById(R.id.button2);
        mButtons[3] = findViewById(R.id.button3);
        mButtons[4] = findViewById(R.id.button4);
        mButtons[5] = findViewById(R.id.button5);
        mButtons[6] = findViewById(R.id.button6);
        mButtons[7] = findViewById(R.id.button7);
        mButtons[8] = findViewById(R.id.button8);
        mButtons[9] = findViewById(R.id.button9);
        updateView();
    }

    private void updateView() {
        mGameStateTextView.setText(getString(R.string.n_presses,mGame.getNumPresses()));
        Toast.makeText(this, "State: " + mGame.getValueAtIndex(0), Toast.LENGTH_SHORT).show();
        for (int i=0;i<mButtons.length;i++){
            mButtons[i].setText(Integer.toString(mGame.getValueAtIndex(i)));
        }
    }

    public void pressedBoardButton(View view) {
        int buttonIndex = Integer.parseInt(view.getTag().toString());
        mGame.pressedButtonAtIndex(buttonIndex);
        updateView();
    }

    public void pressedNewGame(View view) {
        mGame = new LightsOutGame(numButtons);
        updateView();
    }
}