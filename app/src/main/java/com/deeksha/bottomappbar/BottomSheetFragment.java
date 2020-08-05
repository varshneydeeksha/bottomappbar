package com.deeksha.bottomappbar;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.navigation.NavigationView;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    ImageView close;

    public static BottomSheetFragment newInstance() {

        Bundle args = new Bundle();

        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment();
        bottomSheetFragment.setArguments(args);
        return bottomSheetFragment;
    }

    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback = new
            BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View view, int i) {
                    if (i == BottomSheetBehavior.STATE_HIDDEN) {
                        dismiss();
                    }
                }

                @Override
                public void onSlide(@NonNull View view, float v) {
                    if (v > 0.5) {

                    }

                }
            };

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        View view = View.inflate(getContext(), R.layout.bottom_navigation_bar, null);
        dialog.setContentView(view);

        NavigationView navigationView = view.findViewById(R.id.NavigationView);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {

                    case R.id.item1:
                        Toast.makeText(getContext(), "Home is Clicked", Toast.LENGTH_LONG)
                                .show();
                        break;

                    case R.id.item2:
                        Toast.makeText(getContext(), "Contact is Clicked", Toast.LENGTH_LONG)
                                .show();
                        break;
                    case R.id.item3:
                        Toast.makeText(getContext(), "Attachment is Clicked", Toast.LENGTH_LONG)
                                .show();
                        break;

                    case R.id.item4:
                        Toast.makeText(getContext(), "Assessment is Clicked", Toast.LENGTH_LONG)
                                .show();
                        break;

                    case R.id.item5:
                        Toast.makeText(getContext(), "Archive is Clicked", Toast.LENGTH_LONG)
                                .show();
                        break;
                }
                return false;
            }
        });
        close = view.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        CoordinatorLayout.LayoutParams layoutParams=
                (CoordinatorLayout.LayoutParams)((View)view.getParent()).getLayoutParams();

        CoordinatorLayout.Behavior behavior=layoutParams.getBehavior();

        if(behavior instanceof BottomSheetBehavior){

            ((BottomSheetBehavior)behavior).setBottomSheetCallback(bottomSheetCallback);
        }
    }
}
