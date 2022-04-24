package com.example.ezinvoicebusiness;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.ezinvoicebusiness.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements MyInvoicesFragment.OnFragmentInteractionListener, CreateInvoiceFragment.OnFragmentInteractionListener, MyCustomersFragment.OnFragmentInteractionListener, AccountDetailsFragment.OnFragmentInteractionListener {
//public class MainActivity extends AppCompatActivity implements MyInvoicesFragment.OnFragmentInteractionListener, AccountDetailsFragment.OnFragmentInteractionListener {

    TextView displayInvoiceDetails;
    private ActivityMainBinding binding;
    private Button btnViewInvoices, btnCreateInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setContentView(R.layout.fragment_my_invoices);
//        ViewInvoices = findViewById(R.id.btnViewInvoices);
//        Log.d("btn contents", String.valueOf(ViewInvoices));
//        ViewInvoices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                        Fragment fragment = null;
//                        fragment = ViewMyInvoicesFragment.newInstance();
//                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.container, fragment);
//                        fragmentTransaction.commit();
//                Log.d("btn has been clicked", String.valueOf(ViewInvoices));
////                startActivity(new Intent(MainActivity.this, ViewMyInvoicesActivity.class));
//            }
//        });

//        btnViewInvoices = findViewById(R.id.btnViewInvoices);
//        btnViewInvoices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, ViewMyInvoicesActivity.class));
//            }
//        });

//        btnViewInvoices = findViewById(R.id.btnViewInvoices);
//        btnViewInvoices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                startActivity(new Intent(MainActivity.this, CreateInvoiceActivity.class));
//
//                Fragment fragment = null;
//                fragment = AccountDetailsFragment.newInstance();
//
//                if (fragment != null) {
//                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.container, fragment);
//                    fragmentTransaction.commit();
//                }
//            }
//        });

//        btnCreateInvoice = findViewById(R.id.btnCreateInvoice);
//        btnCreateInvoice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                startActivity(new Intent(MainActivity.this, CreateInvoiceActivity.class));
//
//                Fragment fragment = null;
//                fragment = AccountDetailsFragment.newInstance();
//
//                if (fragment != null) {
//                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.container, fragment);
//                    fragmentTransaction.commit();
//                }
//            }
//        });

        setContentView(binding.getRoot());
        BottomNavigationView navView = findViewById(R.id.nav_view);
        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(binding.navView, navController);

//        FragmentTransaction fragmentTransactionInitial = getSupportFragmentManager().beginTransaction();
//        fragmentTransactionInitial.replace(R.id.container, MyInvoicesFragment.newInstance());
//        fragmentTransactionInitial.commit();

        navView.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_my_invoices:
                    fragment = MyInvoicesFragment.newInstance();
                    break;
                case R.id.navigation_my_customers:
                    fragment = MyCustomersFragment.newInstance();
                    break;
                case R.id.navigation_account_details:
                    fragment = AccountDetailsFragment.newInstance();
//                        fragment = ThirdFragment.newInstance();
                    break;
            }
            if (fragment != null) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container, fragment);
                fragmentTransaction.commit();
            }
            return true;
        });

//        ViewInvoices = findViewById(R.id.btnViewInvoices);
//        Log.d("btn contents", String.valueOf(ViewInvoices));
//        ViewInvoices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Fragment fragment = null;
////                fragment = ViewMyInvoicesFragment.newInstance();
////                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
////                fragmentTransaction.replace(R.id.container, fragment);
////                fragmentTransaction.commit();
//                Log.d("btn contents", String.valueOf(ViewInvoices));
//                startActivity(new Intent(MainActivity.this, ViewMyInvoicesActivity.class));
//            }

//                startActivity(new Intent(MainActivity.this, ViewMyInvoicesActivity.class));
//            Log.d("btn clicked", "ViewInvoices");
//            Fragment fragment = null;
//            fragment = ViewMyInvoicesFragment.newInstance();
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.container, fragment);
//            fragmentTransaction.commit();
//        });


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.bottom_nav_menu, menu);
//        return true;
//    }
}
