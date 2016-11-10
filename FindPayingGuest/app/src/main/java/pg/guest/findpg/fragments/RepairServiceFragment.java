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

import static android.app.Activity.RESULT_OK;

/**
 * Created by Rojesh on 24-10-2016.
 */

public class RepairServiceFragment extends BaseFragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private ImageView mImgCaptureFeedback;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Spinner mSprnFeedBackType;

    private Button mBtnSubmit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.room_service_frag, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("Repair Service");
        setTheFragment();
    }

    private void setTheFragment() {

        mImgCaptureFeedback = (ImageView) getView().findViewById(R.id.img_feedback);
        mImgCaptureFeedback.setOnClickListener(this);

        mSprnFeedBackType = (Spinner) getView().findViewById(R.id.spr_feedback_type);
        mSprnFeedBackType.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Select reason type:");
        categories.add("Looking dirty");
        categories.add("Odd smell");
        categories.add("Bugs problem");
        categories.add("Gyser problem");
        categories.add("Wi-Fi issues");
        categories.add("Furniture issues");
        categories.add("Fan / AC problem");
        categories.add("General maintenance");

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
                break;
            case R.id.img_feedback:
                openCamera();
                break;
            default:
                break;
        }
    }

    private void openCamera() {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            mImgCaptureFeedback.setImageBitmap(bitmap);
        }
    }
}
