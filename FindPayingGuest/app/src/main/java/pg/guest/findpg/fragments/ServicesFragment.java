package pg.guest.findpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import pg.guest.findpg.R;

/**
 * Created by Rojesh on 24-10-2016.
 */

public class ServicesFragment extends  BaseFragment implements View.OnClickListener {
    ImageButton mBtnRoomService,mBtnRepairService,mBtnWaterService,mBtnLaundryService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.services_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("Services");
        setTheFragment();
    }

    private void setTheFragment() {
        mBtnRoomService = (ImageButton) getActivity().findViewById(R.id.btn_roomservice);
        mBtnRoomService.setOnClickListener(this);
        mBtnLaundryService = (ImageButton) getActivity().findViewById(R.id.btn_laundry);
        mBtnLaundryService.setOnClickListener(this);
        mBtnRepairService = (ImageButton) getActivity().findViewById(R.id.btn_repair);
        mBtnRepairService.setOnClickListener(this);
        mBtnWaterService = (ImageButton) getActivity().findViewById(R.id.btn_water);
        mBtnWaterService.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_roomservice:
                gotoRoomServices();
                break;
            case R.id.btn_repair:
                gotoRepairs();
                break;
            case R.id.btn_water:
                gotoWaterService();
                break;
            case R.id.btn_laundry:
                gotoLaundry();
                break;
            default:
                break;
        }

    }

    private void gotoLaundry() {
        LaundryFragment roomServiceFragment = new LaundryFragment();
        addFragment(roomServiceFragment,true);
    }

    private void gotoWaterService() {
        WaterServiceFragment roomServiceFragment = new WaterServiceFragment();
        addFragment(roomServiceFragment,true);
    }

    private void gotoRepairs() {
        RepairServiceFragment roomServiceFragment = new RepairServiceFragment();
        addFragment(roomServiceFragment,true);
    }

    private void gotoRoomServices() {
        RoomServiceFragment roomServiceFragment = new RoomServiceFragment();
        addFragment(roomServiceFragment,true);
    }
}
