package com.example.spotify_group4.View.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.spotify_group4.Listener.ReplaceFragmentListener;
import com.example.spotify_group4.Presenter.AuthPresenter;
import com.example.spotify_group4.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    FragmentLoginBinding layoutBinding;
    ReplaceFragmentListener replaceFragmentListener;
    AuthPresenter authPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layoutBinding = FragmentLoginBinding.inflate(getLayoutInflater(), null, false);
        return layoutBinding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        authPresenter = new AuthPresenter(context);
        replaceFragmentListener = (ReplaceFragmentListener) context;
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setEvent();
        super.onViewCreated(view, savedInstanceState);
    }

    void setEvent() {
        layoutBinding.btnPhoneAth.setOnClickListener(v ->
                replaceFragmentListener.replaceFragment(new PhoneNumberAthFragment()));
        layoutBinding.btnLoginAccount1.setOnClickListener(v ->
                replaceFragmentListener.replaceFragment(new LoginEmailFragment())
        );
        layoutBinding.btnLoginGoogle.setOnClickListener(v -> SignInGoogle());
        layoutBinding.btnRegisterAccount.setOnClickListener(v -> replaceFragmentListener.replaceFragment(new FragmentRegisterAccount()));
    }

    private void SignInGoogle() {
        // Gọi thẳng phương thức chuyển sang màn hình chính mà không cần kiểm tra thông tin từ Google
        authPresenter.goHomeActivity();

        // Kết thúc màn hình đăng nhập
        if (getActivity() != null) {
            getActivity().finish();
        }
    }
}
