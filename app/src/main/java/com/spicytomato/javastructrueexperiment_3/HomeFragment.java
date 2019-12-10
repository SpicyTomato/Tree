package com.spicytomato.javastructrueexperiment_3;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.spicytomato.javastructrueexperiment_3.databinding.FragmentHomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);
        final MyViewModel myViewModel;
        myViewModel = ViewModelProviders.of(requireActivity()).get(MyViewModel.class);

        final FragmentHomeBinding binding;
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(requireActivity());

        binding.buttonCommit.setEnabled(false);


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.editText.getText().toString().trim().isEmpty()){
                    binding.buttonCommit.setEnabled(false);
                }else {
                    binding.buttonCommit.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        binding.editText.addTextChangedListener(textWatcher);

        binding.buttonCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputMethodManager inputMethodManager = (InputMethodManager) requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(),0);
                final NavController controller = Navigation.findNavController(v);
                AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                builder.setTitle(R.string.alertdialog_title);
                builder.setPositiveButton(R.string.alertdialog_positive, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int length = binding.editText.getText().length();
                        String[] strings = new String[length];
                        for (int i = 0 ; i < length ; i++){
                            strings[i] = binding.editText.getText().charAt(i) + "";
                        }
                        myViewModel.getBinaryTree().root = myViewModel.getBinaryTree().creat(strings);
                        controller.navigate(R.id.action_homeFragment_to_selectFragment);
                    }
                });
                builder.setNegativeButton(R.string.alertdialog_negative, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        return binding.getRoot();
    }
}
