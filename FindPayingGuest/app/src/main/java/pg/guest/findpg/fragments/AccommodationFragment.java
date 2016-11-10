package pg.guest.findpg.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.squareup.timessquare.CalendarCellDecorator;
import com.squareup.timessquare.CalendarPickerView;
import com.squareup.timessquare.DefaultDayViewAdapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import pg.guest.findpg.R;

/**
 * Created by Rojesh on 18-10-2016.
 */

public class AccommodationFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnCaledar,mBtnFarewell;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.accomodation_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("Accommodation");
        setTheFragment();
    }

    private void setTheFragment() {
        mBtnCaledar = (Button) getActivity().findViewById(R.id.btn_calender);
        mBtnCaledar.setOnClickListener(this);

        mBtnFarewell = (Button) getActivity().findViewById(R.id.btn_farewell);
        mBtnFarewell.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_calender:
                showCaledarPopUP();
                break;
            case R.id.btn_farewell:
                showFareWellPopUp();
                break;
            default:
                break;
        }

    }

    private void showFareWellPopUp() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
        mBuilder.setTitle("Farewell");
        mBuilder.setMessage("Are you sure want to vacate PG? Note: 1 Month is the notice period");
        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getActivity(),"Your requset has been placed",Toast.LENGTH_LONG).show();
            }
        });
        mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
           dialogInterface.dismiss();
            }
        });
        Dialog mDialog = mBuilder.create();
        mDialog.show();

    }

    private void showCaledarPopUP() {

        Button mBtnDone;

        final Dialog mDialog = new Dialog(getActivity());
        mDialog.setContentView(R.layout.caldenar);
        mBtnDone = (Button) mDialog.findViewById(R.id.btn_done);

        Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.YEAR, 1);

        CalendarPickerView calendar = (CalendarPickerView) mDialog.findViewById(R.id.calendar_view);
        Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .withSelectedDate(today);

        calendar.setCustomDayView(new DefaultDayViewAdapter());
        Calendar calToday = Calendar.getInstance();
        ArrayList<Date> dates = new ArrayList<Date>();
        for (int i = 0; i < 25; i++) {
            calToday.add(Calendar.DAY_OF_MONTH, 1);
            dates.add(calToday.getTime());
        }
        calendar.setDecorators(Collections.<CalendarCellDecorator>emptyList());
        calendar.init(new Date(), nextYear.getTime()) //
                .inMode(CalendarPickerView.SelectionMode.MULTIPLE) //
                .withSelectedDates(dates);

        mDialog.show();

        mBtnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
    }


}
