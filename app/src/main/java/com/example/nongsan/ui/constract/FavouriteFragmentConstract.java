package com.example.nongsan.ui.constract;

import com.example.nongsan.data.dao.model.Favourite;

import java.util.List;

public interface FavouriteFragmentConstract {
    interface IView{
        void setFavouriteListToView(List<Favourite> favouriteList);
    }

    interface IPresenter{
        void setView(IView view);
        void getFavouriteList();
    }
}
