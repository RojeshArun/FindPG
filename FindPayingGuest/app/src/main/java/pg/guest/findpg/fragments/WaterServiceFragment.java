package pg.guest.findpg.fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pg.guest.findpg.R;
import pg.guest.findpg.Utils.StaticUtils;

import static android.app.Activity.RESULT_OK;

/**
 * Created by Rojesh on 24-10-2016.
 */

public class WaterServiceFragment extends BaseFragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    private Spinner mSprnFeedBackType;

    private Button mBtnSubmit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.water_service_frag, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("Water Request");
        setTheFragment();
    }

    private void setTheFragment() {
        mSprnFeedBackType = (Spinner) getView().findViewById(R.id.spr_water_containertype);
        mSprnFeedBackType.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select water container type");
        categories.add("Water can (25 ltr");
        categories.add("1 ltr bottle");
        categories.add("2 ltr bottle");
        categories.add("5 ltr bottle");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, categories);
        // attaching data adapter to spinner
        mSprnFeedBackType.setAdapter(dataAdapter);

        mBtnSubmit = (Button) getView().findViewById(R.id.btn_submit);
        mBtnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                //todo
                StaticUtils.ShowToast(getActivity(),"Request placed successfully.");
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
