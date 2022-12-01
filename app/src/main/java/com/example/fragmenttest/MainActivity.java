package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);

        replaceFragment(new RightFragment());
    }

    private void replaceFragment(Fragment Fragment) {
        FragmentManager fragmentManager =getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout,Fragment);
//FragmentTransaction中提供了一个addToBackStack()方法，可以用于
//     将一个事务添加到返回栈中
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                //调用replaceFragment（）方法将右侧碎片替换成AnotherRightFragment。
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;

        }
    }

}