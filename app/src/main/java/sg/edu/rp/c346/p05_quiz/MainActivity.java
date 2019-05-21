package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    CheckBox cbOneWay;
    CheckBox cbRoundTrip;
    TextView tvValue;
    Button btnMinus;
    Button btnAdd;
    Button btnSubmit;

    Integer num = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cbOneWay = findViewById(R.id.one);
        cbRoundTrip = findViewById(R.id.round);
        tvValue = findViewById(R.id.value);
        btnMinus = findViewById(R.id.minus);
        btnAdd = findViewById(R.id.add);
        btnSubmit = findViewById(R.id.submit);

        tvValue.setText(num.toString());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num + 1;
                tvValue.setText(num.toString());
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = num - 1;
                tvValue.setText(num.toString());
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, FlightDetails.class);

                if (cbOneWay.isChecked()) {

                    if(num > 0) {

                        intent.putExtra("pax", num);
                        intent.putExtra("one", "One-Way");

                    }

                    else {
                        Toast.makeText(MainActivity.this, "Please Enter Pax", Toast.LENGTH_LONG);
                    }

                }

                else if (cbRoundTrip.isChecked()){

                    if (num > 0) {
                        intent.putExtra("pax", num);
                        intent.putExtra("round", "Round_Trip");
                    }

                    else {
                        Toast.makeText(MainActivity.this, "Please Enter Pax", Toast.LENGTH_LONG);
                    }

                }

                else{

                    Toast.makeText(MainActivity.this, "Please Enter All Fields", Toast.LENGTH_LONG);

                }

                startActivity(intent);

            }
        });


    }
}
