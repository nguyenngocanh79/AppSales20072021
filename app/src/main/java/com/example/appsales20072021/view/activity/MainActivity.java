package com.example.appsales20072021.view.activity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.appsales20072021.R;

public class MainActivity extends AppCompatActivity {
    private FrameLayout redCircle;
    private TextView countTextView;
    private int numOfProduct = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        numOfProduct = 12;
//        updateCartIcon(numOfProduct);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.product_menu, menu);
        return true;
    }

    private void updateCartIcon(int product) {
        // if alert count extends into two digits, just show the red circle
        if (0 < product && product < 10) {
            countTextView.setText(String.valueOf(product));
        } else {
            countTextView.setText("9+");
        }
//        Visibility là thuộc tính của View: setVisible() hoặc android;
//        - VISIBLE: hiển thị
//        - INVISIBLE: Không hiển thị nhưng có chiếm chỗ trong layout
//        - GONE: không hiển thị, không chiếm chỗ trong layout
        redCircle.setVisibility((product > 0) ? VISIBLE : GONE);
    }
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        final MenuItem productMenuItem = menu.findItem(R.id.product_menu_cart_item);
        FrameLayout rootView = (FrameLayout) productMenuItem.getActionView();

        redCircle = (FrameLayout) rootView.findViewById(R.id.view_cart_red_circle);
        countTextView = (TextView) rootView.findViewById(R.id.view_cart_count_textview);

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(productMenuItem);
            }
        });
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.product_menu_cart_item:
                numOfProduct += 1;
                updateCartIcon(numOfProduct);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}