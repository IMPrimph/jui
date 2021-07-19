package com.example.noob.ui.home;

import android.nfc.Tag;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.noob.HomeToCards;
import com.example.noob.MainActivity;
import com.example.noob.R;
import com.example.noob.databinding.FragmentHomeBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    Chip chip;
    MaterialButton btn_add_tag, btn_get_selected;
    ChipGroup chipGroup;
    TextInputEditText textInputEditText;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        root = binding.getRoot();
//        chip = (Chip) root.findViewById(R.id.chip_example);
        btn_add_tag = (MaterialButton)root.findViewById(R.id.btn_add_tag);
//        btn_get_selected = (MaterialButton)root.findViewById(R.id.btn_show_selected);
        chipGroup = (ChipGroup) root.findViewById(R.id.chip_group);
        textInputEditText = (TextInputEditText) root.findViewById(R.id.inputField);

        btn_add_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] tags = textInputEditText.getText().toString().split(" ");
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                for(String text: tags){
                    Chip chip = (Chip)inflater.inflate(R.layout.chip_item, null, false);
                    chip.setText(text);
                    chip.setOnCloseIconClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view){
                            chipGroup.removeView(view);
                        }
                    });

                    // add to group
                    chipGroup.addView(chip);
                }
            }
        });

//        btn_get_selected.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                StringBuilder result = new StringBuilder("");
//                for(int i = 0; i < chipGroup.getChildCount(); i++){
//                    Chip chip = (Chip)chipGroup.getChildAt(i);
//                    if(chip.isChecked())
//                        if(i < chipGroup.getChildCount() - 1)
//                            result.append(chip.getText()).append(",");
//                        else
//                            result.append(chip.getText());
//                }
//                Toast.makeText(getActivity(), "" + result.toString(), Toast.LENGTH_SHORT);
//            }
//        });

//        chip.setOnCheckedChangeListener((CompoundButton, b) -> {
//            Toast.makeText(getActivity(), "Checked change to", Toast.LENGTH_SHORT).show();
//        });
//
//        chip.setOnCloseIconClickListener(new View.OnClickListener(){
//                @Override
//                public void onClick(View view){
//                    Toast.makeText(getActivity(), "Close icon clicked", Toast.LENGTH_SHORT).show();
//                }
//            });

        return root;
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


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}