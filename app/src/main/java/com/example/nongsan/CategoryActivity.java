package com.example.nongsan;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nongsan.data.remote.entity.Category;
import com.example.nongsan.data.remote.entity.Product;
import com.example.nongsan.ui.adapter.ProductAdapter;
import com.example.nongsan.ui.constract.CategoryConstract;
import com.example.nongsan.ui.constract.CategoryPresenter;
import com.example.nongsan.utils.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CategoryActivity extends BaseActivity implements CategoryConstract.IView{
    private CategoryConstract.IPresenter mPresenter;
    private RecyclerView rcCategory;

    private ImageView ivCategoryImage;
    private TextView tvCategoryName;

    private ImageButton ibBtnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        
        initGUI();
        initData();
    }

    private void initGUI(){
        ivCategoryImage = findViewById(R.id.iv_category_image);
        tvCategoryName = findViewById(R.id.tv_category_name);
        rcCategory = findViewById(R.id.rc_category);

        ibBtnBack = findViewById(R.id.ib_btn_back);
        ibBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void initData() {
        int categoryId = getIntent().getIntExtra(Constants.CATEGORY_ID, 1);

        mPresenter = new CategoryPresenter();
        mPresenter.setView(this);
        mPresenter.getProductListByCategory(categoryId);
        mPresenter.getCategory(categoryId);
    }

    @Override
    public void setProductListToView(List<Product> productList) {
        ProductAdapter adapter = new ProductAdapter(this, productList);
        rcCategory.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        rcCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setCategoryToView(Category category) {
        Picasso.get().load(category.image).into(ivCategoryImage);
        tvCategoryName.setText(category.name);
    }
}