package pg.guest.findpg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pg.guest.findpg.R;

/**
 * Created by ADMIN on 19-08-2016.
 */
public class HomeFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.accomodation_layout,container,false);
        return inflater.inflate(R.layout.home_makemystay,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setTitle("Paying Guest");
        setTheFragment();
    }

    private void setTheFragment() {

    }
}
