package sg.edu.rp.c346.id21013643.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvNum;
    TextView tvPax;

    EditText etName;
    EditText etNum;
    EditText etPax;

    DatePicker dp;
    TimePicker tp;

    RadioGroup rg;
    RadioButton smoker;
    RadioButton nonsmoker;

    Button btnSubmit;
    Button btnReset;

    EditText etDisplay;
    TextView tvNameDisp ;
    TextView tvNumDisp;
    TextView tvPaxDisp;
    TextView tvDP;
    TextView tvTP;
    TextView tvArea;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.textViewName);
        tvNum = findViewById(R.id.textViewNumber);
        tvPax = findViewById(R.id.textViewPax);

        etName = findViewById(R.id.editTextName);
        etNum = findViewById(R.id.editTextPhone);
        etPax = findViewById(R.id.editTextPax);


        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        rg = findViewById(R.id.radioGroupsmokes);
        smoker = findViewById(R.id.radioButtonSmoker);
        nonsmoker = findViewById(R.id.radioButtonNonSmoker);

        btnSubmit = findViewById(R.id.buttonSubmit);
        btnReset = findViewById(R.id.buttonReset);

        etDisplay = findViewById(R.id.editTextDisplay);
        tvNameDisp = findViewById(R.id.textViewDisplayName);
        tvNumDisp = findViewById(R.id.textViewNumberA);
        tvPaxDisp = findViewById(R.id.textViewPaxA);
        tvArea= findViewById(R.id.textViewArea);
        tvDP = findViewById(R.id.textViewDP);
        tvTP = findViewById(R.id.textViewTP);





        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                etDisplay.setText("RECEIPT : ");

                String name = etName.getText().toString();
                String nameA = "User's Name: " + name ;

                tvNameDisp.setText(nameA);

                String number = etNum.getText().toString();
                String numberA = "User's Contact Number: " + number;
                tvNumDisp.setText(numberA);

                String paxA = "User's pax: " + etPax.getText().toString();
                tvPaxDisp.setText(paxA);


                int checkedRadioId = rg.getCheckedRadioButtonId();
                if ( checkedRadioId == R.id.radioButtonSmoker) {

                    tvArea.setText("User's Area of Choice: Smoking Area");
                } else {

                    tvArea.setText("User's Area of Choice: Non-Smoking Area");
                }

                String hour = tp.getCurrentHour().toString();
                String min = tp.getCurrentMinute().toString();
                String result1 = "Time chose is:  " + hour + ":" + min;

                tvDP.setText(result1);

                String day = String.valueOf(dp.getDayOfMonth());
                String month = String.valueOf(dp.getMonth());
                String year = String.valueOf(dp.getYear());
                String result2 = "Date chosen is: " + day + "/" + month + "/" + year;

                tvTP.setText(result2);



            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);

                dp.updateDate(2020, 5 , 01);
                etName.setText("");
                etNum.setText("");
                etPax.setText("");

                tvNameDisp.setText(" ");
                tvNumDisp.setText(" ");
                tvPaxDisp.setText(" ");
                tvArea.setText(" ");
                tvDP.setText(" ");
                tvTP.setText(" ");






            }
    });
    }

}