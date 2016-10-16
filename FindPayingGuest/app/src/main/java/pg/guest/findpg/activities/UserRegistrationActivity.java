package pg.guest.findpg.activities;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;

import pg.guest.findpg.R;
import pg.guest.findpg.Utils.StaticUtils;

/**
 * Created by Rojesh on 24-09-2016.
 */

public class UserRegistrationActivity extends Activity implements View.OnClickListener{

    private EditText mEdtName,mEdtPhoneNum,mEdtEmergencyContact,mEdtOccupation,mEdtEmailAddress;
    private RadioButton mRbMale,mRbFemaler;
    private Button mBtnDOB,mBtnSignUP;
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
        mEdtPhoneNum = (EditText) findViewById(R.id.edt_phone_number);
        mEdtEmergencyContact = (EditText) findViewById(R.id.edt_emergency_contact);
        mEdtEmailAddress = (EditText) findViewById(R.id.edt_email_address);
        mEdtOccupation = (EditText) findViewById(R.id.edt_occupation);
        mRbFemaler = (RadioButton) findViewById(R.id.rd_male);
        mRbMale = (RadioButton) findViewById(R.id.rd_female);
        mBtnDOB = (Button) findViewById(R.id.lbl_date_of_birth);
        mBtnDOB.setOnClickListener(this);
        mBtnSignUP  = (Button) findViewById(R.id.sign_in_button);
        mBtnSignUP.setOnClickListener(this);

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
            case R.id.sign_in_button:
                performValidation();

                break;
            default:
                break;
        }
    }

    private void performValidation() {
        if(TextUtils.isEmpty(mEdtName.getText().toString())){
            mEdtName.setError("Please enter you name");
            mEdtName.requestFocus();
        }else if(TextUtils.isEmpty(mEdtPhoneNum.getText().toString())){
            mEdtPhoneNum.setError("Please enter your phone number");
            mEdtPhoneNum.requestFocus();
        }else if(TextUtils.isEmpty(mEdtEmergencyContact.getText().toString())){
            mEdtEmergencyContact.setError("Please enter your ");
            mEdtEmergencyContact.requestFocus();
        }else if (TextUtils.isEmpty(mEdtEmailAddress.getText().toString())){
            mEdtEmailAddress.setError("Enter email address");
            mEdtEmailAddress.requestFocus();
        }else if(StaticUtils.isValidEmail(mEdtEmailAddress.getText().toString().trim())){
            mEdtEmailAddress.setError("Enter enter valid email");
            mEdtEmailAddress.requestFocus();
        }else{
            gotoMainScreen();
        }

    }

    private void gotoMainScreen() {
        Intent mMainScreenIntent = new Intent(this,ContainerActivity.class);
        startActivity(mMainScreenIntent);
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
