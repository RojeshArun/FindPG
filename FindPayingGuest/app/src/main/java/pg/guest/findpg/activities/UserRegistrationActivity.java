package pg.guest.findpg.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;

import pg.guest.findpg.R;

/**
 * Created by Rojesh on 24-09-2016.
 */

public class UserRegistrationActivity extends Activity implements View.OnClickListener{

    private EditText mEdtName;
    private RadioButton mRbMale,mRbFemaler;
    private Button mBtnDOB;
    private int mYear, mMonth, mDay;
    private Calendar calendar;
    static final int DATE_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_regis_form);
        setTheActivity();
    }

    private void setTheActivity() {
        mEdtName = (EditText) findViewById(R.id.edt_name);
        mRbFemaler = (RadioButton) findViewById(R.id.rd_male);
        mRbMale = (RadioButton) findViewById(R.id.rd_female);
        mBtnDOB = (Button) findViewById(R.id.lbl_date_of_birth);
        mBtnDOB.setOnClickListener(this);

        // Set Date Formate
        mBtnDOB.setText("DD / MM / YYYY");
        calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);

        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(mYear, mMonth+1, mDay);
    }

    private void showDate(int year, int month, int day) {
        mBtnDOB.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }


    @Override
        public void onClick(View view) {
        switch (view.getId()){
            case R.id.lbl_date_of_birth:
                showDialog(DATE_DIALOG_ID);
                break;
        }
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int day, int month, int year) {
            datePicker.setMaxDate(Calendar.getInstance().getTimeInMillis());
            showDate(year,month+1,day);
        }
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, myDateListener,
                        mYear, mMonth,mDay);
        }
        return null;
    }

}
