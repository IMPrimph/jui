package com.example.noob.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.noob.R;
import com.example.noob.databinding.FragmentDashboardBinding;
import com.google.android.material.textfield.TextInputEditText;

public class DashboardFragment extends Fragment {
    private static final String TAG = DashboardFragment.class.getSimpleName();
    private DashboardViewModel dashboardViewModel;
    private FragmentDashboardBinding binding;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textDashboard;
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void sendData(View view){
        System.out.println("We were here");
        textInputEditText = (TextInputEditText) root.findViewById(R.id.inputField);


        String[] tags = textInputEditText.getText().toString().split(" ");
        for(String i:tags)
            System.out.println(i);
        // HomeToCards myListener = (HomeToCards) getActivity();
        // myListener.passingData(firstNum, secondNum);
    }
}