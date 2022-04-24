package com.example.ezinvoicebusiness.ui.my_clients;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ezinvoicebusiness.databinding.FragmentMyCustomersBinding;

public class MyClientsFragment extends Fragment {

    private MyClientsModel homeViewModel;
    private FragmentMyCustomersBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(MyClientsModel.class);

        binding = FragmentMyCustomersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.title;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}