package fundoohr.com.fragmentactivity;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import layout.Fragment1;

public class MainActivity extends FragmentActivity {
    private Fragment1 frag;
    //private static final String TAG = "MainActivity";
    TextView TextViewname;
    EditText EditTextname;
    Button Buttonsave;
     Button Openfragment;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  frag = new Fragment1();
        Buttonsave = (Button) findViewById(R.id.buttonsave);
        EditTextname = (EditText) findViewById(R.id.nameedit);
        TextViewname = (TextView) findViewById(R.id.nametext);
         Openfragment=(Button) findViewById(R.id.Openfragment);

        Buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditTextname.setText(EditTextname.getText());//just
                TextViewname.setText(EditTextname.getText());



            }
        });
        Openfragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FrameLayout frame=new FrameLayout(this);
                ;
                    if (savedInstanceState == null) {
                        frag=new Fragment1();
                      android.app.FragmentTransaction ft=getFragmentManager().beginTransaction();
                        ft.add(R.id.fragment,fragment1.class).commit();

                    }
              //  setContentView(frame);
                   // getFragmentManager().beginTransaction().add(R.id.fragment, Fragment1.class).commit();;

            }

        });
    }

}


