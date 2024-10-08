package com.example.contadordevidas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.contadordevidas.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Integer lifep1 = 20;
    private Integer poisonp1 = 0;
    private Integer lifep2 = 20;
    private Integer poisonp2 = 0;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        if (savedInstanceState != null) {
            lifep1 = savedInstanceState.getInt("lifep1", lifep1);
            poisonp1 = savedInstanceState.getInt("poisonp1", poisonp1);
            lifep2 = savedInstanceState.getInt("lifep2", lifep2);
            poisonp2 = savedInstanceState.getInt("poisonp2", poisonp2);
        } else {
            reset();
        }
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            lifep1 = savedInstanceState.getInt("lifep1");
            poisonp1 = savedInstanceState.getInt("poisonp1");
        }

        binding.btnPM.setOnClickListener(v -> {
            poisonp1++;
            refresh();
        });
        binding.btnPm.setOnClickListener(v -> {
            poisonp1--;
            refresh();
        });
        binding.btnPM2.setOnClickListener(v -> {
            poisonp2++;
            refresh();
        });
        binding.btnPm2.setOnClickListener(v -> {
            poisonp2--;
            refresh();
        });

        binding.imgBtnLM.setOnClickListener(v -> {
            lifep1++;
            refresh();
        });
        binding.imgBtnLm.setOnClickListener(v -> {
            lifep1--;
            refresh();
        });
        binding.imgBtnLM2.setOnClickListener(v -> {
            lifep2++;
            refresh();
        });
        binding.imgBtnLm2.setOnClickListener(v -> {
            lifep2--;
            refresh();
        });
        binding.imgBtnAUp.setOnClickListener(v -> {
            lifep1++;
            lifep2--;
            refresh();
        });
        binding.imgBtnADown.setOnClickListener(v -> {
            lifep2++;
            lifep1--;
            refresh();
        });
    }
    private void refresh() {
        binding.txt1.setText(lifep1 + "/" + poisonp1);
        binding.txt2.setText(lifep2 + "/" + poisonp2);
    }

    private void reset() {
        poisonp1 = 0;
        poisonp2 = 0;
        lifep1 = 20;
        lifep2 = 20;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("lifep1", lifep1);
        outState.putInt("poisonp1", poisonp1);
        outState.putInt("lifep2", lifep2);
        outState.putInt("poisonp2", poisonp2);
    }


}