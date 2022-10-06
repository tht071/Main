package com.example.nongsan.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nongsan.ProductDetailActivity;
import com.example.nongsan.R;
import com.example.nongsan.data.dao.model.Favourite;
import com.example.nongsan.utils.Constants;
import com.example.nongsan.utils.StringHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavouriteAdapter extends RecyclerView.Adapter<FavouriteAdapter.ViewHolder> {
    private List<Favourite> productList;
    private Context mContext;

    public FavouriteAdapter(Context context, List<Favourite> productList){
        mContext = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public FavouriteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favouries, parent, false);

        return new ViewHolder(view);
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Favourite product = productList.get(position);
        Picasso.get().load(product.image).into(holder.imgFavourite);
        holder.tvFavouriteName.setText(product.name);
        holder.tvPrice.setText(StringHelper.currencyFormat(product.price));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ProductDetailActivity.class);
                intent.putExtra(Constants.PRODUCT_ID, product.id);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgFavourite;
        private TextView tvFavouriteName;
        private TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFavourite = itemView.findViewById(R.id.img_favouries);
            tvFavouriteName = itemView.findViewById(R.id.tv_product_name_favouries);
            tvPrice = itemView.findViewById(R.id.tv_price_favouries);
        }
    }
}
