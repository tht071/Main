package com.example.nongsan.ui.constract;

import com.example.nongsan.data.dao.DatabaseDao;
import com.example.nongsan.data.dao.model.OrderDetail;

import java.util.List;

public class OrderFragmentPresenter implements OrderFragmentConstract.IPresenter {
    private OrderFragmentConstract.IView mView;
    @Override
    public void setView(OrderFragmentConstract.IView view) {
        mView = view;
    }

    @Override
    public void getOrderDetailList() {
        List<OrderDetail> orderDetailList = DatabaseDao.getInstance().getOrderDetailDao().all();
        mView.setOrderDetailListToView(orderDetailList);
    }
    @Override
    public void delete(int orderDetailId) {
        DatabaseDao.getInstance().getOrderDetailDao().delete(orderDetailId);
        mView.setDeleteSuccess();
    }

    @Override
    public void deleteAll() {
        DatabaseDao.getInstance().getOrderDetailDao().deleteAll();
        mView.setDeleteSuccess();
    }
}
