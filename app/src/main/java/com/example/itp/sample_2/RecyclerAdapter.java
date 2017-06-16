package com.example.itp.sample_2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by ITP on 6/16/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {


    private ArrayList<Movie> moviesList;
    Context con;
    RecyclerView rc;


    public RecyclerAdapter(Context con, ArrayList<Movie> moviesList, RecyclerView rc) {
        this.moviesList = moviesList;
        this.con = con;
        this.rc = rc;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_items, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RecyclerAdapter.ViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.name.setText(movie.getName());

        Float rating = Float.valueOf(movie.getRating());
        holder.rating.setRating(rating);
        //  holder.rating.setEnabled(false);

      /*  holder.rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/

        holder.rating.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    // TODO perform your action here
                    String[] data1 = {"DATA 1", "DATA 2", "DATA 3", "DATA 4", "DATA 5"};

                    LayoutInflater layoutInflater = (LayoutInflater) con.getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popupView = layoutInflater.inflate(R.layout.listview_layout, null);
                    final PopupWindow popupWindow = new PopupWindow(popupView,
                            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

                    ListView listView = (ListView) popupView.findViewById(R.id.listview1);
                    listView.setAdapter(new ArrayAdapter<String>(con, android.R.layout.simple_list_item_1, data1));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        public void onItemClick(AdapterView<?> arg0, View arg1,
                                                int arg2, long arg3) {
                            // TODO Auto-generated method stub
                            System.out.println("Item Clicked");
                            popupWindow.dismiss();
                        }
                    });

                    popupWindow.showAsDropDown(holder.rating, 0, 0);

                }
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        RatingBar rating;

        public ViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.textView);
            rating = (RatingBar) view.findViewById(R.id.ratingBar);
        }
    }
}
