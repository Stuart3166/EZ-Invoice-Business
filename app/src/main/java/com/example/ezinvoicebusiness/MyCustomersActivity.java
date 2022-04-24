package com.example.ezinvoicebusiness;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezinvoicebusiness.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
public class MyCustomersActivity extends AppCompatActivity {
//    public class ViewMyInvoicesActivity extends AppCompatActivity implements SecondFragment.OnFragmentInteractionListener {

    //    TextView displayInvoiceDetails;
//    ArrayList lstSavedInvoices = new ArrayList<>(Arrays.asList("Person 1", "Person 2", "Person 3", "Person 4", "Person 5", "Person 6", "Person 7"));
    BottomNavigationView navView;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_my_invoices);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        binding = ActivityMainBinding.inflate(getLayoutInflater());

//        setContentView(binding.getRoot());
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        NavController navController = Navigation.findNavController(ViewMyInvoicesActivity.this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupWithNavController(binding.navView, navController);

//        SecondFragment.newInstance();

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());

//        setContentView(R.layout.fragment_my_invoices);

//        Fragment fragment = null;
//        fragment = ViewMyInvoicesFragment.newInstance();
//        if (fragment != null) {
//            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//            System.out.println(fragmentTransaction);
//            fragmentTransaction.replace(R.id.container, fragment);
//            fragmentTransaction.commit();
//        }
//
//        // get the reference of RecyclerView
//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        // set a LinearLayoutManager with default orientation
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView
//
//        //  call the constructor of CustomAdapter to send the reference and data to Adapter
//        CustomAdapter customAdapter = new CustomAdapter(MyCustomersActivity.this, lstSavedInvoices);
//        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView

//        setContentView(binding.getRoot());
//        createNavbar();
    }

//    public void createNavbar() {
////        setContentView(binding.getRoot());
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
//        NavigationUI.setupWithNavController(binding.navView, navController);
//
//        navView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.navigation_scan_invoice:
//                    startActivity(new Intent(ViewMyInvoicesActivity.this, ScanInvoiceActivity.class));
////                case R.id.navigation_my_invoices:
////                    startActivity(new Intent(AccountDetailsActivity.this, ViewMyInvoicesActivity.class));
////                            return true;
//                case R.id.navigation_account_details:
//                    startActivity(new Intent(ViewMyInvoicesActivity.this, AccountDetailsActivity.class));
//            }
//            return false;
//        });
//    }
}