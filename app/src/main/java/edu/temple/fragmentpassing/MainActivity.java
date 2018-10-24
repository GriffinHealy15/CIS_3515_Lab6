package edu.temple.fragmentpassing;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.content.Context;


/* Griffin Healy | October 23, 2018 LAST UPDATE */

public class MainActivity extends AppCompatActivity implements MasterFragment.GetColorInterface {

    DetailFragment df;
    FragmentManager fm;
    boolean singlePane;
    View rootView;
    private TextView canvas_fragment_view;
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] theColors = {"Blue", "Yellow", "Red", "Magenta", "Green", "White", "Black"};


        singlePane = findViewById(R.id.container_2) == null;
        df = new DetailFragment();


        fm = getSupportFragmentManager();

        fm.beginTransaction()
                .replace(R.id.container_1, new MasterFragment())
                .commit();

        if (!singlePane) {
            fm.beginTransaction()
                    .replace(R.id.container_2, df)
                    .commit();
        }

    }

    @Override
    public void colorSelected(String colorName) {


        if (singlePane) {

              Context context = getApplicationContext();
              int duration = Toast.LENGTH_SHORT;
              Toast toast = Toast.makeText(context,String.valueOf(colorName) , duration);
               toast.show();


            DetailFragment newFragment = DetailFragment.newInstance(colorName);
            fm.beginTransaction()
                    .replace(R.id.container_1, newFragment)
                    .addToBackStack(null)
                    .commit();
        } else {

            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context,String.valueOf(colorName) , duration);
            toast.show();
            df.changeColor(colorName);
        }
   }
}
