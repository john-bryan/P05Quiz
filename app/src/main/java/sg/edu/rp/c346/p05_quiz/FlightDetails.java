package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FlightDetails extends AppCompatActivity {

    TextView tvPax;
    TextView tvCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);

        Intent intentReceived = getIntent();
        String trip = intentReceived.getStringExtra("one");
        tvPax.setText("You have purchased a " + trip);
        Integer pax = intentReceived.getIntExtra("pax", 0);
        tvCost.setText("Your air ticket costs: $" + 100 * pax);


    }
}
