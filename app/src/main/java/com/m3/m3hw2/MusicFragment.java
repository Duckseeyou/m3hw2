package com.m3.m3hw2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.m3.m3hw2.databinding.FragmentMusicBinding;

import java.util.concurrent.atomic.AtomicInteger;


public class MusicFragment extends Fragment {
    private FragmentMusicBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMusicBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] songs = {"ChopSuey", "BfgDivision", "Order", "Persona3"};
        AtomicInteger currentSong = new AtomicInteger();
        binding.coverImg.setImageResource(R.drawable.chop_suey);
        binding.forwardBtn.setOnClickListener(v -> {


            if (currentSong.get() < songs.length - 1){
                currentSong.getAndIncrement();
                switch (songs[currentSong.get()]){
                    case "BfgDivision":
                        binding.coverImg.setImageResource(R.drawable.bfg_division);
                        break;
                    case "ChopSuey":
                        binding.coverImg.setImageResource(R.drawable.chop_suey);
                        break;
                    case "Order":
                        binding.coverImg.setImageResource(R.drawable.order);
                        break;
                    case "Persona3":
                        binding.coverImg.setImageResource(R.drawable.persona3);
                        break;
                }

            } else {
                currentSong.set(0);
                switch (songs[currentSong.get()]){
                    case "BfgDivision":
                        binding.coverImg.setImageResource(R.drawable.bfg_division);
                        break;
                    case "ChopSuey":
                        binding.coverImg.setImageResource(R.drawable.chop_suey);
                        break;
                    case "Order":
                        binding.coverImg.setImageResource(R.drawable.order);
                        break;
                    case "Persona3":
                        binding.coverImg.setImageResource(R.drawable.persona3);
                        break;
                }
            }

        });

        binding.backwardBtn.setOnClickListener(v -> {


            if (currentSong.get() > 0){
                currentSong.getAndDecrement();
                switch (songs[currentSong.intValue()]){
                    case "ChopSuey":
                        binding.coverImg.setImageResource(R.drawable.chop_suey);
                        break;
                    case "BfgDivision":
                        binding.coverImg.setImageResource(R.drawable.bfg_division);
                        break;
                    case "Order":
                        binding.coverImg.setImageResource(R.drawable.order);
                        break;
                    case "Persona3":
                        binding.coverImg.setImageResource(R.drawable.persona3);
                        break;
                }
            } else {
                Toast.makeText(requireContext(), "At the beginning of list", Toast.LENGTH_SHORT).show();
            }

        });

        binding.coverImg.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("song", songs[currentSong.get()]);
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setArguments(bundle);
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view_main, detailFragment).addToBackStack(null).commit();

        });
    }
}