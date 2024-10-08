package com.m3.m3hw2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m3.m3hw2.databinding.FragmentDetailBinding;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            String song = getArguments().getString("song");
            switch (song){
                case "ChopSuey":
                    binding.trackInfo.setText("Artist: System of a Down\nAlbum: Toxicity" );
                    break;
                case "BfgDivision":
                    binding.trackInfo.setText("Artist: Mick Gordon\nAlbum: Doom (Original Game Soundtrack)" );
                    break;
                case "Order":
                    binding.trackInfo.setText("Artist: Heaven Pierce Her\nAlbum: ULTRAKILL: CHAOS/ORDER" );
                    break;
                case "Persona3":
                    binding.trackInfo.setText("Artist: アトラスサウンドチーム (ATLUS Sound Team)\nAlbum: Persona 3 Reload (Original Soundtrack)" );
                    break;
            }
        } else {
            binding.trackInfo.setText("Error");
        }

    }
}