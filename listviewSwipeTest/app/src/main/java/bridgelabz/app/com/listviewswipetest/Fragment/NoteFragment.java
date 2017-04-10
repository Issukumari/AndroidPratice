package bridgelabz.app.com.listviewswipetest.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bridgelabz.app.com.listviewswipetest.R;

/**
 * Created by bridgeit on 8/4/17.
 */
public class NoteFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_view, container, false);

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}