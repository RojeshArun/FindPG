package pg.guest.findpg.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import pg.guest.findpg.R;
import pg.guest.findpg.fragments.PgFragment.OnListFragmentInteractionListener;
import pg.guest.findpg.activities.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MypgRecyclerViewAdapter extends RecyclerView.Adapter<MypgRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MypgRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mPgNameTxtView.setText(mValues.get(position).pgName);
        holder.mPgTypeTxtView.setText(mValues.get(position).pgType);
        holder.mPgBedStatusTxtView.setText(mValues.get(position).pgBedStatus);
        holder.mRoomSharingTxtView.setText(mValues.get(position).roomSharing);
        if (mValues.get(position).gender)
            holder.mGenderImgView.setImageDrawable(holder.mView.getContext().getResources().getDrawable(R.drawable.gender_male_48));
        else
            holder.mGenderImgView.setImageDrawable(holder.mView.getContext().getResources().getDrawable(R.drawable.gender_female_48));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final Button mView;
        public final TextView mPgNameTxtView, mPgTypeTxtView, mPgBedStatusTxtView, mRoomSharingTxtView;
        public DummyItem mItem;
        public ImageView mGenderImgView;

        public ViewHolder(View view) {
            super(view);
            mView = (Button) view.findViewById(R.id.btn_book);
            mPgNameTxtView = (TextView) view.findViewById(R.id.lbl_pgname);
            mPgTypeTxtView = (TextView) view.findViewById(R.id.lbl_pgtype);
            mPgBedStatusTxtView = (TextView) view.findViewById(R.id.lbl_beds_status);
            mRoomSharingTxtView = (TextView) view.findViewById(R.id.lbl_sharing_type);
            mGenderImgView = (ImageView) view.findViewById(R.id.img_gender);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mPgNameTxtView.getText() + "'";
        }
    }
}
