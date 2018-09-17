package com.example.bookstore.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookstore.R;
import com.example.bookstore.fragment.Fragment01;
import com.example.bookstore.fragment.Fragment02;
import com.example.bookstore.fragment.Fragment03;
import com.example.bookstore.fragment.Fragment04;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import static com.example.bookstore.R.layout.fragment01;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @ViewInject(R.id.llChat)
    LinearLayout llChat;

    @ViewInject(R.id.llFriends)
    LinearLayout llFriends;

    @ViewInject(R.id.llContacts)
    LinearLayout llContacts;

    @ViewInject(R.id.llSettings)
    LinearLayout llSettings;

    @ViewInject(R.id.ivChat)
    ImageView ivChat;

    @ViewInject(R.id.ivFriends)
    ImageView ivFriends;

    @ViewInject(R.id.ivContacts)
    ImageView ivContacts;

    @ViewInject(R.id.ivSettings)
    ImageView ivSettings;

    @ViewInject(R.id.tvChat)
    TextView tvChat;

    @ViewInject(R.id.tvFriends)
    TextView tvFriends;

    @ViewInject(R.id.tvContacts)
    TextView tvContacts;

    @ViewInject(R.id.tvSettings)
    TextView tvSettings;

    @ViewInject(R.id.main_content)
    FrameLayout main_content;

    private ImageView ivCurrent;

    private TextView tvCurrent;

    private FragmentManager fragmentManager;

    private Fragment01 fragment01;
    private Fragment02 fragment02;
    private Fragment03 fragment03;
    private Fragment04 fragment04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        initView();
    }

    private void initView() {

        ivChat.setSelected(true);
        tvChat.setSelected(true);
        ivCurrent = ivChat;
        tvCurrent = tvChat;

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment01 = new Fragment01();
        fragmentTransaction.add(R.id.main_content,fragment01);
        fragmentTransaction.commit();

    }

    @Event({R.id.llChat,R.id.llFriends,R.id.llContacts,R.id.llSettings})
    private void onClick(View v){
        ivCurrent.setSelected(false);
        tvCurrent.setSelected(false);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideAllFragment(transaction);
        switch (v.getId()){
            case R.id.llChat:
                    ivChat.setSelected(true);
                    ivCurrent = ivChat;
                    tvChat.setSelected(true);
                    tvCurrent = tvChat;
                    if (fragment01 == null){
                        fragment01 = new Fragment01();
                        transaction.add(R.id.main_content,fragment01);
                    }else {
                        transaction.show(fragment01);
                    }
                    break;
                case R.id.llFriends:
                    ivFriends.setSelected(true);
                    ivCurrent = ivFriends;
                    tvFriends.setSelected(true);
                    tvCurrent = tvFriends;
                    if (fragment02 == null){
                        fragment02 = new Fragment02();
                        transaction.add(R.id.main_content,fragment02);
                    }else {
                        transaction.show(fragment02);
                    }
                    break;
                case R.id.llContacts:
                    ivContacts.setSelected(true);
                    ivCurrent = ivContacts;
                    tvContacts.setSelected(true);
                    tvCurrent = tvContacts;
                    if (fragment03 == null){
                        fragment03 = new Fragment03();
                        transaction.add(R.id.main_content,fragment03);
                    }else {
                        transaction.show(fragment03);
                    }
                    break;
                case R.id.llSettings:
                    ivSettings.setSelected(true);
                    ivCurrent = ivSettings;
                    tvSettings.setSelected(true);
                    tvCurrent = tvSettings;
                    if (fragment04 == null){
                        fragment04 = new Fragment04();
                        transaction.add(R.id.main_content,fragment04);
                    }else {
                        transaction.show(fragment04);
                    }
                    break;

            }
            transaction.commit();
        }

    private void hideAllFragment(FragmentTransaction transaction) {
        if (fragment01 != null){
            transaction.hide(fragment01);
        }
        if (fragment02 != null){
            transaction.hide(fragment02);
        }
        if (fragment03 != null){
            transaction.hide(fragment03);
        }
        if (fragment04 != null){
            transaction.hide(fragment04);
        }
    }
}
