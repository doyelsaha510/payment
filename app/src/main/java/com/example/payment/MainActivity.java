package com.example.payment;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.tuann.floatingactionbuttonexpandable.FloatingActionButtonExpandable;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    FloatingActionButtonExpandable add_money;
    NestedScrollView nestedScrollView;
    CollapsingToolbarLayout collapsingToolbarLayout;
    AppBarLayout appBarLayout;
CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list);
        add_money=findViewById(R.id.bt_float);
        nestedScrollView=findViewById(R.id.nested);
        collapsingToolbarLayout=findViewById(R.id.collapsingtoolbar);
        appBarLayout=findViewById(R.id.appbar);


        String[] maintitle={"Phone Number","Balance"};
        String[] subtitle={"8777568979","$10.0"};
        Integer[] imgid={R.drawable.ic_phone_iphone_black_24dp,R.drawable.ic_account_balance_black_24dp};

        MyListAdapter adapter=new MyListAdapter(this,R.layout.scrolling_list, maintitle, subtitle,imgid);
        listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int firstvisible, int visibleitem, int totalitem) {

                int lastitem=firstvisible+visibleitem;
                if (lastitem==totalitem)
                {
                    add_money.expand(false);
                }
                else
                {
                    add_money.expand(true);
                }
            }
        });
        add_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_money.expand(false);
                Intent intent=new Intent(MainActivity.this,MoneyPayment.class);
                startActivity(intent);
            }
        });




    }
}
