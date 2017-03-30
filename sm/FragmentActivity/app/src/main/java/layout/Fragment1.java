package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import fundoohr.com.fragmentactivity.R;


public class Fragment1 extends Fragment {
    TextView TextViewname;
    EditText EditTextname;
    Button Buttonsave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
        /*Buttonsave=(Button) findViewById(R.id.buttonsave);
        EditTextname=(EditText) findViewById(R.id.nameedit);
        TextViewname=(TextView) findViewById(R.id.nametext);*/

        /*buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextname.setText("O android");//just
                textViewname.setText(editTextname.getText());
                Intent intent =new Intent(MainActivity.this,SumOfTWoNo.class);
                startActivity(intent);
            }
        });*/
        //  buttonsave.setOnClickListener(this);

      /*  FragmentManager  fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().remove();
*//*
        Buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditTextname.setText(EditTextname.getText());//just
                TextViewname.setText(EditTextname.getText());


            }});*/
    }


}