package com.example.nongsan.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nongsan.CheckOutActivity;
import com.example.nongsan.R;
import com.example.nongsan.data.dao.model.OrderDetail;
import com.example.nongsan.ui.adapter.OrderDetailAdapter;
import com.example.nongsan.ui.constract.OrderFragmentConstract;
import com.example.nongsan.ui.constract.OrderFragmentPresenter;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class OrderFragment extends Fragment implements OrderFragmentConstract.IView {
    private OrderFragmentConstract.IPresenter mPresenter;
    private RecyclerView rcOrderDetail;
    private ImageView ivBtnDeleteAll;
    private Button button;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootVIew = inflater.inflate(R.layout.fragment_order, container, false);

        initGUI(rootVIew);
        initData();

        return rootVIew;
    }

    private void initGUI(View rootVIew){
        rcOrderDetail = rootVIew.findViewById(R.id.rc_order_detail);
        ivBtnDeleteAll = rootVIew.findViewById(R.id.iv_btn_delete_all);
        ivBtnDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.deleteAll();
            }
        });

    }

    private void initData(){
        mPresenter = new OrderFragmentPresenter();
        mPresenter.setView(this);
        mPresenter.getOrderDetailList();
    }

    @Override
    public void setOrderDetailListToView(List<OrderDetail> orderDetailList) {
        OrderDetailAdapter adapter = new OrderDetailAdapter(getContext(), orderDetailList, mPresenter);
        rcOrderDetail.setAdapter(adapter);
        rcOrderDetail.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void setDeleteSuccess() {
        new SweetAlertDialog(getContext())
                .setTitleText("Xoá thành công!")
                .show();
        initData();
    }
}
