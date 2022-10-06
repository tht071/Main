package com.example.nongsan.ui.constract;


import com.example.nongsan.data.remote.entity.Category;
import com.example.nongsan.data.remote.entity.Product;
import com.example.nongsan.data.remote.RetrofitContrller;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryPresenter implements CategoryConstract.IPresenter{
    private CategoryConstract.IView mView;
    @Override
    public void setView(CategoryConstract.IView view) {
        mView = view;
    }

    @Override
    public void getProductListByCategory(int categoryId) {
        Call<List<Product>> call = RetrofitContrller.service().productListByCategory(categoryId);
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                mView.setProductListToView(response.body());
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }

    @Override
    public void getCategory(int categoryId) {
        Call<Category> call = RetrofitContrller.service().category(categoryId);
        call.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                mView.setCategoryToView(response.body());
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {

            }
        });
    }
}
