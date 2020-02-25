package browser.green.org.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView display;
    TextView tips;
    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final int number = (int) (Math.random() * 1000);
        number = 234; //testing

        editText = findViewById(R.id.et_input);
        display = findViewById(R.id.tv_display);

        tips = findViewById(R.id.tips);

    }


    // Handle the button click
    public void btnCheck(View view) {

        //todo: limit the number of input -what is len valid for int in Java?
        //todo: what if the input is null?
        String input = editText.getText().toString();
        if (input.isEmpty()) {
            Toast.makeText(this, "Invalid input", Toast.LENGTH_LONG).show();
        } else {
            // inputs are valid int
            int value = Integer.parseInt(input);

            if (value < 0 || value > 1000) // requirement was [1, 1000]
                tips.setText("Please input a number between [1, 1000]!");
            else if (value < number) {
                display.setText("too small!");
            } else if (value > number) {
                display.setText("Too big");
            } else {
                Toast.makeText(this, "Got it!", Toast.LENGTH_LONG).show();
                Log.e("TAG", "Got it");
                display.setText("Congratulations!");
                display.setBackgroundColor(Color.GREEN);
                display.setTextColor(Color.WHITE);

            }
        }
    }


}
