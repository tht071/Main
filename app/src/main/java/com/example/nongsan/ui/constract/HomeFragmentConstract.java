package com.example.nongsan.ui.constract;

import com.example.nongsan.data.remote.entity.Category;
import com.example.nongsan.data.remote.entity.Product;

import java.util.List;

public interface HomeFragmentConstract {
    interface IView{
        void setCategoryListToView(List<Category> categoryList);
        void showCategory(Category category);
        void setHotProductsToView(List<Product> productList);
        void setProductListSearchToView(List<Product> productList);
    }

    interface IPresenter{
        void setView(IView view);
        void getCategoryList();
        void getHotProducts();
        void search(String key);
    }
}
