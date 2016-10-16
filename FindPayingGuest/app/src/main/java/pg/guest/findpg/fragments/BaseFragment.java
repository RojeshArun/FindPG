package pg.guest.findpg.fragments;

import android.support.v4.app.Fragment;

import pg.guest.findpg.activities.ContainerActivity;

/**
 * Created by ADMIN on 17-08-2016.
 */
public class BaseFragment extends Fragment {
    private ContainerActivity containerActivity;

    /**
     * Add a new Fragment
     */
    public void addFragment(boolean saveFragment) {
        if (getActivity() != null)
            ((ContainerActivity) getActivity()).addFragment(saveFragment);
    }

    /**
     * Set Title
     */
    public void setTitle(String title) {
        if (getActivity() != null)
            ((ContainerActivity) getActivity()).setFragmentTitle(title);

    }

    /**
     * Show progress bar
     */
    public void showProgressBar() {
        if (getActivity() != null)
            ((ContainerActivity) getActivity()).showProgressBar();
    }

    /**
     * Hide progress bar
     */
    public  void hideProgressBar(){
        if(getActivity() != null)
            ((ContainerActivity) getActivity()).hideProgressBar();
    }

}
