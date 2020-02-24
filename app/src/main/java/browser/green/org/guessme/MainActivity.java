package browser.green.org.guessme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView_1;
    TextView textView_2;
    TextView textView_3;
    TextView tips;
    int number=(int)(Math.random()*1000);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int number=(int)(Math.random()*1000);
        editText=(EditText)findViewById(R.id.editText3);
        textView_1=(TextView)findViewById(R.id.textView);
        textView_2=(TextView)findViewById(R.id.textView2);
        textView_3=(TextView)findViewById(R.id.textView3);
        tips=(TextView)findViewById(R.id.tips);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check(view,number);
            }
        });

    }

    public void check(View view,int number){
        int temp=Integer.parseInt(editText.getText().toString());
        if(editText.getText().toString().equals(null))
            tips.setText("Please input a number!");
        else if(temp<0||temp>9999)
            tips.setText("Please input a number between 0 and 9999!");
        else if(temp<number){
            textView_1.setText("too samll!");
            textView_1.setBackgroundColor(Color.GREEN);
            textView_3.setText("");
            textView_3.setBackgroundColor(Color.WHITE);
        }
        else if(temp>number){
            textView_3.setText("too big!");
            textView_3.setBackgroundColor(Color.RED);
            textView_1.setText("");
            textView_1.setBackgroundColor(Color.WHITE);
        }
        else{
            textView_2.setText("congratulation!");
            textView_2.setBackgroundColor(Color.YELLOW);
            textView_1.setText("");
            textView_1.setBackgroundColor(Color.WHITE);
            textView_3.setText("");
            textView_3.setBackgroundColor(Color.WHITE);
        }
    }
}
