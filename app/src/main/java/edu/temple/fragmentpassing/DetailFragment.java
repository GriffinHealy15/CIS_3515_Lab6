package edu.temple.fragmentpassing;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Color;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    ImageView imageView;
    String colorName = "";
    View rootView;
    TextView canvas_fragment_view;
    Bundle bundle;


    public static final String COLOR_KEY = "color_name";

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance (String planetName) {
        DetailFragment df = new DetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString(COLOR_KEY, planetName);

        df.setArguments(bundle);

        return df;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
           colorName = getArguments().getString(COLOR_KEY);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_detail, container, false);
       // imageView = v.findViewById(R.id.imageView);
        canvas_fragment_view = v.findViewById(R.id.canvasFragLayout);
        change(colorName);

        return v;
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {

    }
   public void changeColor(String colorName) {
        change(colorName);
    }

   private void change (String colorName) {
       Log.i("The color to change to",colorName);
      //  switch (planetName) {
          // case "HI": Picasso.get().load(R.drawable.earth).into(imageView); break;
           if (colorName == "Blue") {
               canvas_fragment_view.setBackgroundColor(Color.parseColor(colorName));
           }
       if (colorName == "Yellow") {
           canvas_fragment_view.setBackgroundColor(Color.parseColor(colorName));
       }
       if (colorName == "Yellow") {
           canvas_fragment_view.setBackgroundColor(Color.parseColor(colorName));
       }
       if (colorName== "Red") {
           canvas_fragment_view.setBackgroundColor(Color.parseColor(colorName));
       }
       if (colorName == "Magenta") {
           canvas_fragment_view.setBackgroundColor(Color.parseColor(colorName));
       }
       if (colorName == "Green") {
           canvas_fragment_view.setBackgroundColor(Color.parseColor(colorName));
       }
       if (colorName == "White") {
           canvas_fragment_view.setBackgroundColor(Color.parseColor(colorName));
       }
       if (colorName == "Black") {
           canvas_fragment_view.setBackgroundColor(Color.parseColor(colorName));
       }
           /* case "Yellow": canvas_fragment_view.setBackgroundColor(Color.parseColor("Yellow"));
            case "Red": canvas_fragment_view.setBackgroundColor(Color.parseColor("Red"));
            case "Magenta": canvas_fragment_view.setBackgroundColor(Color.parseColor("Magenta"));
            case "Green": canvas_fragment_view.setBackgroundColor(Color.parseColor("Green"));
            case "White": canvas_fragment_view.setBackgroundColor(Color.parseColor("White"));
            case "Black": canvas_fragment_view.setBackgroundColor(Color.parseColor("Black")); */
//}
    }

}
