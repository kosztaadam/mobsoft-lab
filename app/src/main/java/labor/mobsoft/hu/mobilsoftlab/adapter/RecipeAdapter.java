package labor.mobsoft.hu.mobilsoftlab.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import labor.mobsoft.hu.mobilsoftlab.R;
import labor.mobsoft.hu.mobilsoftlab.model.Recipe;
import labor.mobsoft.hu.mobilsoftlab.ui.details.RecipeDetailsActivity;

/**
 * Created by Koszta Ádám on 2017. 05. 03..
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    private Context context;

    private List<Recipe> recipeList;

    public RecipeAdapter(Context context, List<Recipe> recipeList) {
        this.context = context;
        this.recipeList = recipeList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.one_recipe_row, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Recipe recipe = recipeList.get(position);

        holder.tvId.setText(Long.toString(recipe.getId()));
        holder.tvName.setText(recipe.getTitle());
        holder.tvType.setText(recipe.getDescription());
        holder.tvCount.setText(Integer.toString(recipe.getDifficulty()));
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public TextView tvId;
        public TextView tvName;
        public TextView tvType;
        public TextView tvCount;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            tvId = (TextView) itemView.findViewById(R.id.cardrecipe_tvId);
            tvName = (TextView) itemView.findViewById(R.id.cardrecipe_tvName);
            tvType = (TextView) itemView.findViewById(R.id.cardrecipe_tvType);
            tvCount = (TextView) itemView.findViewById(R.id.cardrecipe_tvCount);
            ImageButton contextMenu = (ImageButton) itemView.findViewById(R.id.cardrecipe_favouriteButton);
            contextMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO
                }
            });
        }

        //Navigáció kezelése
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), RecipeDetailsActivity.class);
            intent.putExtra("id", tvId.getText());
            v.getContext().startActivity(intent);
        }
    }
}
