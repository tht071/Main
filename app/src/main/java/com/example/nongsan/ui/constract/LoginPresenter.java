package com.example.nongsan.ui.constract;

import android.content.Context;
import android.util.Log;

import com.example.nongsan.data.remote.RetrofitContrller;
import com.example.nongsan.data.remote.entity.LoginResponse;
import com.example.nongsan.utils.Auth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginConstract.IPresenter{
    private Context mContext;
    private LoginConstract.IView mView;

    public LoginPresenter(Context context){
        mContext = context;
    }
    @Override
    public void setView(LoginConstract.IView view) {
        mView = view;
    }

    @Override
    public void login(String phone, String password) {
        RetrofitContrller.service().login(phone, password).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Auth.getInstance(mContext).setAuthentication(response.body().result);
                if(response.body().result){
                    mView.loginSuccess();
                }else{
                    mView.loginFailed();
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Log.e("Đăng nhập thất bại", t.toString());
            }
        });
    }
}