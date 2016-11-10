package pg.guest.findpg.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pg.guest.findpg.R;

/**
 * Created by Rojesh on 17-10-2016.
 */

public class FoodFragment extends BaseFragment implements View.OnClickListener {

    private Button mBtnRequestPlate,mBtnConfirm,mBtnFoodMenu,mBtnFoodFeedback;
    private ImageView mBtnNextDayMenu,mBtnPreviousMenu;
    private TextView mLblTitle;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.food_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("Food");
        setFragment();
    }

    private void setFragment() {
        mBtnRequestPlate = (Button) getView().findViewById(R.id.btn_request_plate);
        mBtnConfirm = (Button) getView().findViewById(R.id.btn_food_confirm);
        mBtnFoodFeedback = (Button) getView().findViewById(R.id.btn_food_feeback);
        mBtnFoodMenu= (Button) getView().findViewById(R.id.btn_food_menu);
        mBtnPreviousMenu = (ImageView) getView().findViewById(R.id.btn_previous_menu);
        mBtnNextDayMenu= (ImageView) getView().findViewById(R.id.btn_next_menu);
        mLblTitle = (TextView) getView().findViewById(R.id.lbl_title);

        mBtnRequestPlate.setOnClickListener(this);
        mBtnFoodMenu.setOnClickListener(this);
        mBtnConfirm.setOnClickListener(this);
        mBtnFoodFeedback.setOnClickListener(this);
        mBtnNextDayMenu.setOnClickListener(this);
        mBtnPreviousMenu.setOnClickListener(this);

        mBtnPreviousMenu.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_request_plate:
                handleRequestPlate();
                break;
            case R.id.btn_food_menu:
                displayTodaysMenu();
                break;
            case R.id.btn_next_menu:
                changeNextDayMenu();
                break;
            case R.id.btn_previous_menu:
                changeToPreviousMenu();
                break;
            case R.id.btn_food_feeback:
                gotoFeedBackForm();
                break;
            default:
                break;
        }
    }

    private void gotoFeedBackForm() {
        FeedbackFragment mFeedbackFragment = new FeedbackFragment();
        addFragment(mFeedbackFragment,true);
    }

    private void changeToPreviousMenu() {
        mBtnPreviousMenu.setVisibility(View.INVISIBLE);
        mLblTitle.setText("Today's Menu");
    }

    private void changeNextDayMenu() {
        mBtnPreviousMenu.setVisibility(View.VISIBLE);
        mLblTitle.setText("Tomorrows's Menu");

    }

    private void displayTodaysMenu() {
        AlertDialog.Builder mTodayMenuDialog = new AlertDialog.Builder(getActivity());
        mTodayMenuDialog.setView(R.layout.todays_menu);
        Dialog mDialog = mTodayMenuDialog.create();
        mDialog.show();

    }

    private void handleRequestPlate() {
        showProgressBar();
        Handler handlerTimer = new Handler();
        handlerTimer.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideProgressBar();
                Toast.makeText(getActivity(),"Your plate request has be placed succesfully",Toast.LENGTH_LONG).show();
            }
        }, 2000);


    }
}
