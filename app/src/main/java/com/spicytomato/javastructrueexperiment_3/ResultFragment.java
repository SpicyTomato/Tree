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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spicytomato.javastructrueexperiment_3.databinding.FragmentResultBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultFragment extends Fragment {
    private final static String FLAG_FILE = "flag_file";
    private final static String FLAG = "flag";
    private final static String TAG = "nisile!!!!!!!!!";


    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_result, container, false);

        MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(requireActivity()).get(MyViewModel.class);

        FragmentResultBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_result,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

//        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(FLAG_FILE, Context.MODE_PRIVATE);
//        int flag = sharedPreferences.getInt(FLAG,0);

        int flag = myViewModel.getFlag();

        StringBuilder string = new StringBuilder();

        switch (flag){
            case 0:
                myViewModel.getBinaryTree().string.delete(0,myViewModel.getBinaryTree().string.length());
                break;
            case 1:
                myViewModel.getBinaryTree().string.delete(0,myViewModel.getBinaryTree().string.length());
                myViewModel.getBinaryTree().preorder();
                string = myViewModel.getBinaryTree().string;
                Log.d(TAG, "onCreateView1: " + string);
                break;
            case 2:
                myViewModel.getBinaryTree().string.delete(0,myViewModel.getBinaryTree().string.length());
                myViewModel.getBinaryTree().inorder();
                string = myViewModel.getBinaryTree().string;
                Log.d(TAG, "onCreateView2: " + string);
                break;
            case 3:
                myViewModel.getBinaryTree().string.delete(0,myViewModel.getBinaryTree().string.length());
                myViewModel.getBinaryTree().postorder();
                string = myViewModel.getBinaryTree().string;
                Log.d(TAG, "onCreateView3: " + string);
                break;
            case 4:
                myViewModel.getBinaryTree().string.delete(0,myViewModel.getBinaryTree().string.length());
                myViewModel.getBinaryTree().preorderTraverse();
                string = myViewModel.getBinaryTree().string;
                break;
            case 5:
                myViewModel.getBinaryTree().string.delete(0,myViewModel.getBinaryTree().string.length());
                myViewModel.getBinaryTree().inorderTraverse();
                string = myViewModel.getBinaryTree().string;
                Log.d(TAG, "onCreateView: " + string);
                break;

        }


        binding.textViewResult.setText(string);
        Log.d(TAG, "onCreateView4: "  + binding.textViewResult.getText().toString());

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_resultFragment_to_selectFragment);
            }
        });



        return binding.getRoot();
    }




}
