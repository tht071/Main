package com.example.nongsan.ui.constract;

public interface LoginConstract {
    interface IView{
        void loginSuccess();
        void loginFailed();
    }

    interface IPresenter{
        void setView(IView view);
        void login(String phone, String password);
    }
}
