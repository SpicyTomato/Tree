package com.spicytomato.javastructrueexperiment_3;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.spicytomato.javastructrueexperiment_3.databinding.FragmentSelectBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectFragment extends Fragment {
    private final String FLAG_FILE = "flag_file";
    private final String FLAG = "flag";


    public SelectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_select, container, false);
        final MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(requireActivity()).get(MyViewModel.class);

        FragmentSelectBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_select,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(FLAG_FILE, Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();



        binding.buttonPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setFlag(1);
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_selectFragment_to_resultFragment);
            }
        });

        binding.buttonIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setFlag(2);
//                editor.clear();
//                editor.putInt(FLAG,2);
//                editor.apply();
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_selectFragment_to_resultFragment);
            }
        });

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setFlag(3);
//                editor.putInt(FLAG,3);
//                editor.apply();
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_selectFragment_to_resultFragment);
            }
        });

        binding.buttonPreTraverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setFlag(4);
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_selectFragment_to_resultFragment);
            }
        });

        binding.buttonInTraverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.setFlag(5);
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_selectFragment_to_resultFragment);
            }
        });

        binding.imageViewHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_selectFragment_to_homeFragment);
            }
        });



        return binding.getRoot();
    }

}
