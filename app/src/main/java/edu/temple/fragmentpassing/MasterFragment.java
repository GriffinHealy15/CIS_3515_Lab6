package edu.temple.fragmentpassing;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.content.Context;
import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 */
public class MasterFragment extends Fragment {

    ListView listView;

    Context parent;

    public MasterFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.parent = context;


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final String[] theColors = {"Blue", "Yellow", "Red", "Magenta", "Green", "White", "Black"};
        View v = inflater.inflate(R.layout.fragment_master, container, false);
        listView = v.findViewById(R.id.listView);
        Color_Adapter colorAdapter = new Color_Adapter(parent, getResources().getStringArray(R.array.Colors));
        listView.setAdapter(colorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
                //String planetName = (String) parentView.getItemAtPosition(position);
                String colorName = (String) theColors[position];
               // String planetName = (String) "YO";
                Log.i("Color passed",colorName);
                ((GetColorInterface) parent).colorSelected(colorName);
            }
        });

        return v;
    }


    interface GetColorInterface{
        void colorSelected(String colorName);
    }

}
