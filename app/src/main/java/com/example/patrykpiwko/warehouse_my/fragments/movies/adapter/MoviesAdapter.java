package com.example.patrykpiwko.warehouse_my.fragments.movies.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.patrykpiwko.warehouse_my.R;
import com.example.patrykpiwko.warehouse_my.activities.MainActivityInterface;
import com.example.patrykpiwko.warehouse_my.models.Movie;
import com.squareup.picasso.Picasso;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MoviesAdapter  extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    public interface MoviesAdapterInterface {
        public void onItemClick(Movie movie);
        public void onItemRemoveClick(Movie movie, int position);
    }

    private boolean isInEditMode;
    private MoviesAdapterInterface moviesAdapterInterface;
    private List<Movie> moviesList;
    public String TAG = "You clicked";

    //region adapter methods
    public MoviesAdapter(List<Movie> moviesList, MoviesAdapterInterface moviesAdapterInterface) {
        this.moviesList = moviesList;
        this.moviesAdapterInterface = moviesAdapterInterface;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.bind(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
    //endregion



    public boolean isInEditMode() {
        return isInEditMode;
    }

    public void setInEditMode(boolean inEditMode) {
        isInEditMode = inEditMode;
        notifyDataSetChanged();
    }



    public void addMovie(Movie movie){
        int pos = getPosForMovie(movie);
        moviesList.add(pos, movie);
        notifyItemInserted(pos);
    }

    private int getPosForMovie(Movie movie){
        int pos = 0;
        for (Movie item : moviesList){
            if(item.getYear() >= movie.getYear()){
                return pos;
            }
            pos++;
        }
        return pos;
    }

    public void removeMovie(int moviePosition){
        moviesList.remove(moviePosition);
        notifyItemRemoved(moviePosition);
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

        @BindView(R.id.removeButton)
        ImageView removeButton;



        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }



        //operation at parameters from Movie class
        public void bind(Movie movie){

            if(movie == null){
                return;
            }

            removeButton.setVisibility(isInEditMode ? View.VISIBLE : View.INVISIBLE);

            title.setText(movie.getTitle());
            year.setText(String.valueOf(movie.getYear()));

            year.setVisibility(movie.getYear() != 0 ? View.VISIBLE : View.INVISIBLE);
            grade.setVisibility(movie.getGrade() > 0 ? View.VISIBLE : View.INVISIBLE);


            StringBuilder stringGrade = new StringBuilder();
            double myGrade = movie.getGrade() / 10  ;
            stringGrade.append(myGrade);
            stringGrade.append(" / 10");
            grade.setText(stringGrade);

            Picasso.get()
                    .load(movie.getPictureURL())
                    .placeholder(R.color.blue_grey_100)
                    .error(R.drawable.common_google_signin_btn_text_dark_focused)
                    .into(picture);
        }

        @OnClick({R.id.picture, R.id.content})
        public void clickToPicture(){
            if(moviesAdapterInterface != null){
                moviesAdapterInterface.onItemClick(moviesList.get(getAdapterPosition()));
            }
        }

        @OnClick(R.id.removeButton)
        public void removeButton(){
            if(moviesAdapterInterface != null){
                moviesAdapterInterface.onItemRemoveClick(moviesList.get(getAdapterPosition()), getAdapterPosition());
            }
        }




    }
}
