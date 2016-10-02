package pg.guest.findpg.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

import pg.guest.findpg.R;

/**
 * Created by ADMIN on 22-08-2016.
 */
public class GuestSignUpFormFragment extends BaseFragment implements View.OnClickListener,DatePickerDialog.OnDateSetListener{

    private Button dtDateOfBirth;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.guest_signup_form, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTheFragment();
    }

    private void setTheFragment() {
        setTitle(getResources().getString(R.string.guest_singup));
        dtDateOfBirth = (Button) getView().findViewById(R.id.lbl_date_of_birth);
        dtDateOfBirth.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        new DatePickerDialog(getActivity(), this, year, month, day).show();

    }



    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }


}
