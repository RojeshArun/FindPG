package com.example.gaddams.listteam;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Gaddam's on 8/22/2016.
 */
public class SignUp extends Activity implements View.OnClickListener {

    Button saveGuestData,uploadProof;
    Spinner guestProof;
    EditText age,email,phoneNumber,name;
    String[] proofType={"PanCard","adhar","DL","others"};
    ImageView profilePic;
    RadioButton male,female;
    CheckBox veg,nonVeg,eggy;
    View focusView=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_guest);
        //giving  references to all Views of the layout
        loadreferences();
        //loading values before selection
        loadValues();
        //validating the Values enter from keyboard
        validateInputValues();
        //Click Events
        clicks();

    }

    private void clicks() {
        uploadProof.setOnClickListener(this);
        saveGuestData.setOnClickListener(this);
    }

    private void validateInputValues() {

        /*if(!(email.getText().toString().contains("@"))) {
            Toast.makeText(getApplicationContext(), "enter valid email id", Toast.LENGTH_SHORT).show();
        }*/


    }

    private void loadValues() {

        age.setClickable(true);
        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*AlertDialog.Builder ageDialog= new AlertDialog.Builder(SignUp.this);
                ageDialog.setTitle("Choose your Age");
                String[] dummyAges={"18","19","20","21","22","23","24","25","26","27","28","29","30","31","32",};
                final ArrayAdapter<String> ageAdapter=new ArrayAdapter<String>(SignUp.this,android.R.layout.select_dialog_singlechoice,dummyAges);
                ageDialog.setAdapter(ageAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String ageValue=ageAdapter.getItem(which);
                        age.setText(ageValue);
                    }
                });
                AlertDialog dialog=ageDialog.create();
                dialog.show();*/
Calendar calendar=Calendar.getInstance();
                int mYear,mMonth,mDay;
                mYear=calendar.get(Calendar.YEAR);
                mMonth=calendar.get(Calendar.MONTH);
                mDay=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(SignUp.this,datePickerListener ,mYear,mMonth,mDay);
datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
         
            }
        });
 DatePickerDialog.OnDateSetListener datePickerListener=new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        age.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+year);
                    }
                };
        ArrayAdapter proofAdapter=new ArrayAdapter(this,android.R.layout.simple_spinner_item,proofType);
        proofAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        guestProof.setAdapter(proofAdapter);

    }

    private void loadreferences() {
        profilePic= (ImageView) findViewById(R.id.guestProfilePic);
        age= (EditText) findViewById(R.id.age);
        email= (EditText) findViewById(R.id.guestEmailId);
        phoneNumber= (EditText) findViewById(R.id.guestNumber);
        guestProof= (Spinner) findViewById(R.id.guestProof);
        male= (RadioButton) findViewById(R.id.genderMale);
        female= (RadioButton) findViewById(R.id.genderFemale);
        name= (EditText) findViewById(R.id.guestName);
        uploadProof= (Button) findViewById(R.id.uplaodProof);
        veg= (CheckBox) findViewById(R.id.veggy);
        nonVeg= (CheckBox) findViewById(R.id.nonVeggy);
        eggy= (CheckBox) findViewById(R.id.eggy);
        saveGuestData= (Button) findViewById(R.id.saveGuestData);

    }


    @Override
    public void onClick(View v) {
        //whether proof is selected
        boolean validateSelectedProof=validateSelectedProof();

        //check all editfield enter or not
        boolean editFieldsok=validate(new EditText[]{name,phoneNumber,email});

        switch (v.getId()){
            case R.id.uplaodProof:
               // boolean validateSelectedProof=validateSelectedProof();

                if (!validateSelectedProof){
                    Toast.makeText(getApplicationContext(),"select any proof Type",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(),"upload sucess",Toast.LENGTH_SHORT).show();
                break;
            case R.id.saveGuestData:


                if ((male.isChecked()||female.isChecked())&&age.length()>0&&editFieldsok&&validateSelectedProof)
                    Toast.makeText(getApplicationContext(),"saved",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"fill all fields",Toast.LENGTH_SHORT).show();

        }

    }

    private boolean validateSelectedProof() {
        String selectedProof= (String) guestProof.getSelectedItem();
        if (selectedProof.isEmpty()){
            return false;
        }
        else
            return true;

    }

    private boolean validate(EditText[] editTexts) {
        for (int i=0;i<editTexts.length;i++){
            EditText currentValue=editTexts[i];
            if (currentValue.getText().toString().length()<=0)
                return  false;
        }
        return true;
    }
}
