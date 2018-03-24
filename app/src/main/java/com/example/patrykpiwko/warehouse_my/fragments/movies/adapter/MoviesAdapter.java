package com.example.patrykpiwko.warehouse_my.fragments.movies.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.models.Movie;
import com.squareup.picasso.Picasso;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MoviesAdapter  extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {
    private List<Movie> moviesList;

    public MoviesAdapter(List<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }


















    //operation at parameters from Movie class
    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.picture)
        ImageView picture;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.year)
        TextView year;

        @BindView(R.id.grade)
        TextView grade;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }



        //operation at parameters from Movie class
        public void bind(Movie movie){
            if(movie == null){
                return;
            }
            grade.setVisibility(View.GONE);
            title.setText(movie.getTitle());
            year.setText(String.valueOf(movie.getYear()));

            StringBuilder stringGrade = new StringBuilder();
            grade.setVisibility(View.VISIBLE);
            double myGrade = movie.getGrade() / 10;
            stringGrade.append(myGrade);
            stringGrade.append(" / 10");
            grade.setText(stringGrade);

            Picasso.get()
                    .load(movie.getPictureURL())
                    .placeholder(R.color.blue_grey_100)
                    .error(R.drawable.common_google_signin_btn_text_dark_focused)
                    .into(picture);
        }


    }
}
