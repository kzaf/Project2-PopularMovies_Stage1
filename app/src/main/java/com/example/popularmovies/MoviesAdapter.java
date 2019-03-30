package com.example.popularmovies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    final private ListItemClickListener mOnClickListener;
    private int mNumberItems;

    public MoviesAdapter(int numberOfMovies, ListItemClickListener listener) {
        mNumberItems = numberOfMovies;
        mOnClickListener = listener;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_list_item, viewGroup, false);

        return new MoviesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder moviesViewHolder, int position) {
        moviesViewHolder.bind(moviesViewHolder);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public interface ListItemClickListener{
        void onListItemClick(int item);
    }

    class MoviesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView mMoviePoster;

        private MoviesViewHolder(View itemView) {
            super(itemView);

            mMoviePoster = (ImageView) itemView.findViewById(R.id.iv_movie);
            itemView.setOnClickListener(this);
        }

        void bind(MoviesViewHolder moviesViewHolder) {
            Picasso.get()
                    .load("") // TODO: implement with the poster URL
                    .placeholder(R.drawable.movie_poster_placeholder_image)
                    .error(R.drawable.not_found_poster_image)
                    .into(moviesViewHolder.mMoviePoster);
        }

        @Override
        public void onClick(View v) {
            // TODO: implement onClick
        }
    }
}