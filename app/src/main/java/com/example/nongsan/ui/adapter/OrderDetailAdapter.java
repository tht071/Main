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
import com.example.nongsan.data.dao.DatabaseDao;
import com.example.nongsan.data.dao.model.OrderDetail;
import com.example.nongsan.ui.constract.OrderFragmentConstract;
import com.example.nongsan.utils.Constants;
import com.example.nongsan.utils.StringHelper;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.ViewHolder> {
    private List<OrderDetail> productList;
    private Context mContext;
    private OrderFragmentConstract.IPresenter mPresenter;

    public OrderDetailAdapter(Context context, List<OrderDetail> productList, OrderFragmentConstract.IPresenter presenter){
        mContext = context;
        this.productList = productList;
        mPresenter = presenter;
    }

    @NonNull
    @Override
    public OrderDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_order_detail, parent, false);

        return new ViewHolder(view);
    }

    @NonNull

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderDetail product = productList.get(position);
        Picasso.get().load(product.image).into(holder.imgOrderDetail);
        holder.tvOrderDetailName.setText(product.name);
        holder.tvPrice.setText(StringHelper.currencyFormat(product.price));
        holder.tvQuantity.setText(String.valueOf(product.quantity));

        holder.ivBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.delete(product.id);
            }
        });

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
        public ImageView imgOrderDetail;
        private TextView tvOrderDetailName;
        private TextView tvPrice;
        private TextView tvQuantity;
        private ImageView ivBtnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgOrderDetail = itemView.findViewById(R.id.imgProduct);
            tvOrderDetailName = itemView.findViewById(R.id.tv_product_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            ivBtnDelete = itemView.findViewById(R.id.iv_btn_delete);
        }
    }
}
