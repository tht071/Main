package com.example.nongsan.ui.constract;

import com.example.nongsan.data.dao.DatabaseDao;
import com.example.nongsan.data.dao.OrderDetailDao;
import com.example.nongsan.data.dao.model.OrderDetail;
import com.example.nongsan.data.remote.entity.Product;
import com.example.nongsan.data.remote.RetrofitContrller;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductDetailPresenter implements ProductDetailConstract.IPresenter{
    private ProductDetailConstract.IView mView;
    @Override
    public void setView(ProductDetailConstract.IView view) {
        mView = view;
    }

    @Override
    public void getProduct(int productId) {
        Call<Product> call = RetrofitContrller.service().product(productId);
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                mView.setProductToView(response.body());
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {

            }
        });
    }

    @Override
    public void order(Product product, int quantity) {
        OrderDetailDao orderDetailDao = DatabaseDao.getInstance().getOrderDetailDao();
        List<OrderDetail> orderDetailList = orderDetailDao.all();
        OrderDetail orderDetail = orderDetailDao.findByProductId(product.id);
        if(orderDetail == null){
            orderDetailDao.insert(new OrderDetail(
                    0,
                    product.name,
                    quantity,
                    product.price,
                    product.image,
                    product.id
            ));
        }else{
            orderDetail.quantity += quantity;
            orderDetailDao.update(orderDetail);
        }
        mView.setOrderSuccess();
    }
}
