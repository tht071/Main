package com.example.nongsan.ui.constract;

import com.example.nongsan.data.remote.entity.Product;

public interface ProductDetailConstract {
    interface IView{
        void setProductToView(Product product);
        void setOrderSuccess();
    }

    interface IPresenter{
        void setView(ProductDetailConstract.IView view);
        void getProduct(int productId);
        void order(Product product, int quantity);
    }
}
