package com.example.user.roomlivedataviewmodel.listItems;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.user.roomlivedataviewmodel.BorrowModel;
import com.example.user.roomlivedataviewmodel.R;
import com.example.user.roomlivedataviewmodel.addItem.AddActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
