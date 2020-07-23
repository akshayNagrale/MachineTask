package com.example.machinetask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Dialog dialog;
    ArrayList<AssinmentObject> mlist = new ArrayList<>();
    Button add;
    Button ok;
    Button cancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        add = findViewById(R.id.btn_add);
        cancle = findViewById(R.id.btn_cancle);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    private void openDialog() {
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCanceledOnTouchOutside(false);//for avoid any cancle
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = dialog.getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(lp);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();

        final EditText name = dialog.findViewById(R.id.name_dia);
        final EditText age = dialog.findViewById(R.id.age_dia);
        final EditText rollNo = dialog.findViewById(R.id.rollNo_dia);

        AssinmentObject object = new AssinmentObject();
        name.setText(object.getName());
        age.setText(object.getAge());
        rollNo.setText(object.getRollNo());
        ok = dialog.findViewById(R.id.btn_okay);
        cancle = dialog.findViewById(R.id.btn_cancle);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AssinmentObject object = new AssinmentObject();
                object.setName(name.getText().toString());
                object.setAge(age.getText().toString());
                object.setRollNo(rollNo.getText().toString());
                mlist.add(object);
                setAdapter();

                dialog.dismiss();
            }
        });

    }

    private void setAdapter() {

//        if (mlist != null && mlist.size() > 0) {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        AssignmentAdapter adapter = new AssignmentAdapter( mlist,MainActivity.this);
        recyclerView.setAdapter(adapter);
//        }
    }


}
