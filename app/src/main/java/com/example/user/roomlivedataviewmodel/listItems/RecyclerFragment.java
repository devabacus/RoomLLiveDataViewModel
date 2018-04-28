package com.example.user.roomlivedataviewmodel.listItems;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.roomlivedataviewmodel.BorrowModel;
import com.example.user.roomlivedataviewmodel.R;
import com.example.user.roomlivedataviewmodel.addItem.AddActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment implements View.OnLongClickListener {

    private BorrowedListViewModel viewModel;
    private RecyclerViewAdapter recyclerViewAdapter;


    public RecyclerFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(BorrowedListViewModel.class);
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_recycler, container, false);


        FloatingActionButton fabFrag = view.findViewById(R.id.fab_frag);
        fabFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), AddActivity.class));
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewFrag);
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<BorrowModel>(), this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerViewAdapter);

        viewModel.getItemAndPersonList().observe(getActivity(), new Observer<List<BorrowModel>>() {
            @Override
            public void onChanged(@Nullable List<BorrowModel> borrowModels) {
                recyclerViewAdapter.addItems(borrowModels);
            }
        });

        return view;
    }

    @Override
    public boolean onLongClick(View v) {
        BorrowModel borrowModel = (BorrowModel) v.getTag();
        viewModel.deleteItem(borrowModel);
        return true;
    }
}
