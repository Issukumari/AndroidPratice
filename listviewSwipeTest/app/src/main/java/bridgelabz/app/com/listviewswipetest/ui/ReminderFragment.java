package bridgelabz.app.com.listviewswipetest.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import bridgelabz.app.com.listviewswipetest.R;

/**
 * Created by bridgeit on 9/4/17.
 */
public class ReminderFragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reminder,container,false);
    }

}
