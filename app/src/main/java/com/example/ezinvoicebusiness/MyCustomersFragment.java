package com.example.ezinvoicebusiness;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MyCustomersFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    public static MyCustomersFragment newInstance() {
        return new MyCustomersFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_customers, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        auth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        TextView myInvoiceTitle;
//        myInvoiceTitle = getActivity().findViewById(R.id.myInvoiceTitle);
//        myInvoiceTitle.setText("Invoice saved: number");
        db.collection("customerList")
                .document(user.getUid())
                .get()
                .addOnCompleteListener(task -> {
//                                checkUserExists.addOnCompleteListener(task -> {
//                                        @Override
//                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {

//                    if (task.isSuccessful()) {
//                    int customerCount = 1;

                    // Set variables to be used
                    // Atomic variables are used by multiple threads
                    AtomicInteger customerCount = new AtomicInteger(0);
                    AtomicBoolean countedCustomers = new AtomicBoolean(false);
                    DocumentSnapshot customer = task.getResult();
                    List<CustomerModel> lstSavedCustomers = new ArrayList<>();
                    AtomicReference<String> customerNameAtomic = new AtomicReference<>();
                    AtomicReference<String> customerEmailAtomic = new AtomicReference<>();
//                    AtomicReference<RecyclerView> recyclerView = new AtomicReference<>();
                    ArrayList customerIDs = (ArrayList) customer.getData().get("customerIDs");
//                    TextView totalCustomers;
                    RecyclerView recyclerView;
                    recyclerView = getActivity().findViewById(R.id.recyclerView);

                    while (countedCustomers.get() == false) {
                        Object loadCustomerList = customer.get("customerIDs");
                        Log.d(" test", String.valueOf(loadCustomerList));
                        Log.d(" test", String.valueOf(customerIDs));
                        if (customerCount.intValue() == customerIDs.size()) {
                            countedCustomers.set(true);
                        } else {
                            Log.d(" The current customer number is ", String.valueOf(customerCount.get()));
                            String customerID = String.valueOf(customerIDs.get(customerCount.intValue()));
                            Log.d(" current customerID is: ", customerID);

                            db.collection("customers").document(customerID).get().addOnCompleteListener(checkCustomer -> {
                                if (checkCustomer.isSuccessful()) {
                                    DocumentSnapshot currentCustomer = checkCustomer.getResult();
                                    String matchedName = String.valueOf(currentCustomer.get("customerName"));
                                    String matchedEmail = String.valueOf(currentCustomer.get("customerEmail"));
                                    customerNameAtomic.getAndSet(matchedName);
                                    customerEmailAtomic.getAndSet(matchedEmail);

                                    String customerName = (customerNameAtomic.toString());
                                    String customerEmail = (customerEmailAtomic.toString());
//                                    RecyclerView recyclerView;

//                                Log.d(" The current invoice businessID is ", String.valueOf(customerList.get(0)));
                                    Log.d(" The current invoice customerName is ", customerName);
                                    Log.d(" The current invoice customerEmail is ", customerEmail);
//                                    recyclerView = getActivity().findViewById(R.id.recyclerView);
                                    CustomerModel CustomerModel = new CustomerModel(customerName, customerEmail);
                                    lstSavedCustomers.add(CustomerModel);
                                    TextView totalCustomers;

                                    CustomAdapter customAdapter;
                                    customAdapter = new CustomAdapter(getActivity(), lstSavedCustomers);
                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
                                    recyclerView.setLayoutManager(layoutManager);
//                                    recyclerView.setNestedScrollingEnabled(true);
                                    Log.d("Array List length: ", String.valueOf(lstSavedCustomers.size()));
                                    recyclerView.setAdapter(customAdapter);

                                    totalCustomers = getActivity().findViewById(R.id.customerCount);
                                    totalCustomers.setVisibility(View.VISIBLE);
                                    totalCustomers.setText("You currently have " + recyclerView.getAdapter().getItemCount() + " customers");
//                                    Log.d("You currently have ", recyclerView.getAdapter().getItemCount() + " customers");
                                }
                            });

                            customerCount.getAndIncrement();
                        }
                    }
                });
    }

    public interface OnFragmentInteractionListener {
    }
}