package pg.guest.findpg.fragments;

import android.support.v4.app.Fragment;

import pg.guest.findpg.activities.ContainerActivity;

/**
 * Created by ADMIN on 17-08-2016.
 */
public class BaseFragment extends Fragment {

   public void addFragment(boolean saveFragment){
       //
       ((ContainerActivity) getActivity()).addFragment(saveFragment);
   }
}
