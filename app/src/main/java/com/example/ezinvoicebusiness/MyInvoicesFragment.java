package com.example.ezinvoicebusiness;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

//public class MyInvoicesFragment extends Fragment implements ViewMyInvoicesFragment.OnFragmentInteractionListener, CreateInvoiceFragment.OnFragmentInteractionListener{
public class MyInvoicesFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    public static MyInvoicesFragment newInstance() {
        return new MyInvoicesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Button btnViewInvoices, btnCreateInvoice;
//        btnViewInvoices = getView().findViewById(R.id.btnViewInvoices);
//
//        btnViewInvoices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ViewMyInvoicesActivity.class));
//            }
//        });
//
//        btnCreateInvoice = getView().findViewById(R.id.btnCreateInvoice);
//        btnCreateInvoice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), ViewMyInvoicesActivity.class));
//            }
//        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_invoices, container, false);
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button btnViewInvoices, btnCreateInvoice;
//        btnViewInvoices = getView().findViewById(R.id.btnViewInvoices);
        btnCreateInvoice = getView().findViewById(R.id.btnCreateInvoice);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
//        auth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//        db.collection("invoices").whereArrayContains("businessID",user.getUid()).get().addOnCompleteListener(task -> {
//            Log.d(" it worked btw", "yay");
//            Log.d(" it worked btw", String.valueOf(task.getResult().getDocuments().size()));
//            Log.d(" it worked btw", String.valueOf(task.getResult()));
////            Log.d(" it worked btw", String.valueOf(task.getResult()).matches(user.getUid()));
//        });

        AtomicInteger paidCount = new AtomicInteger(0);
        AtomicInteger unpaidCount = new AtomicInteger(0);
        AtomicInteger matchedBusinessCount = new AtomicInteger(0);

        // Set variables to be used by multiple threads
        AtomicInteger invoiceCount = new AtomicInteger(1);

        AtomicReference businessID = new AtomicReference();
        AtomicReference paidStatus = new AtomicReference();
        AtomicBoolean countedInvoices = new AtomicBoolean(false);
        AtomicBoolean countedCustomerInvoices = new AtomicBoolean(false);

        AtomicInteger currentCustomer = new AtomicInteger(0);
        db.collection("customerList")
                .document(user.getUid())
                .get()
                .addOnCompleteListener(foundCustomerList -> {
                    AtomicReference customerID = new AtomicReference();
                    DocumentSnapshot customerList = foundCustomerList.getResult();
                    ArrayList customerListArray = (ArrayList) customerList.get("customerIDs");
                    customerID.getAndSet(customerListArray.get(currentCustomer.get()));
//                    AtomicInteger paidCount = new AtomicInteger(0);
//                    AtomicInteger unpaidCount = new AtomicInteger(0);
//                    AtomicInteger matchedBusinessCount = new AtomicInteger(0);
//
//                    // Set variables to be used by multiple threads
//                    AtomicInteger invoiceCount = new AtomicInteger(1);
//                    Log.d(" donut", String.valueOf((customerListArray).getClass()));
//                    Log.d(" donut0", String.valueOf(customerListArray.get(currentCustomer.get())));
//                    currentCustomer.getAndIncrement();
//                    Log.d(" donut1", String.valueOf(customerListArray.get(currentCustomer.get())));
//                    currentCustomer.getAndIncrement();
//                    Log.d(" donut2", String.valueOf(customerListArray.get(currentCustomer.get())));
                    Log.d(" donut3", String.valueOf(customerListArray.size()));
                    Log.d(" donut", String.valueOf(customerListArray.get(currentCustomer.get())));
//                    AtomicReference businessID = new AtomicReference();
//                    AtomicReference paidStatus = new AtomicReference();
//                    AtomicBoolean countedInvoices = new AtomicBoolean(false);
//                    AtomicBoolean countedCustomerInvoices = new AtomicBoolean(false);
//                });
//                    while (currentCustomer.get() < customerListArray.size()) {
                    Object queryCurrentCustomer = customerListArray.get(currentCustomer.get());
//                    Log.d(" queryCurrentCustomer", String.valueOf(queryCurrentCustomer));
                    Log.d(" queryCurrentCustomer", String.valueOf(currentCustomer.intValue()));
//                    while (countedInvoices.get() == false) {
                    if (currentCustomer.intValue() < customerListArray.size() && countedInvoices.get() == false) {
//                        if (currentCustomer.intValue() < customerListArray.size() && countedInvoices.get() == false) {
                        db.collection("invoices")
                                .document(String.valueOf(queryCurrentCustomer))
//                            .document("IPNCwXjLKAc41Sbzo0NPcd2UL0s1")
                                .get()
                                .addOnCompleteListener(task -> {
//                                checkUserExists.addOnCompleteListener(task -> {
//                                        @Override
//                                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {

//                    if (task.isSuccessful()) {
//                    int invoiceCount = 1;


                                    // below is critical
//                                // Set variables to be used by multiple threads
//                                AtomicInteger invoiceCount = new AtomicInteger(1);
//
//                                AtomicReference businessID = new AtomicReference();
//                                AtomicReference paidStatus = new AtomicReference();
//                                AtomicBoolean countedInvoices = new AtomicBoolean(false);
                                    Log.d("Next available ID: ", String.valueOf(invoiceCount.get()));


//                    myInvoiceTitle = getActivity().findViewById(R.id.myInvoiceTitle);
//                    Log.d("C checkpoint 1", "welcome");
//                    myInvoiceTitle.setText("Invoice saved: " + invoiceCount);
//                    AtomicReference<Double> totalCost = new AtomicReference<>(0.0);
                                    DocumentSnapshot customer = task.getResult();
//                    List<InvoiceModel> lstSavedInvoices = new ArrayList<>();
                                    AtomicReference<String> businessNameAtomic = new AtomicReference<>();
                                    AtomicReference<Double> totalProfit = new AtomicReference<>(0.0);

                                    while (countedCustomerInvoices.get() == false) {
//                        try {
                                        customer.getData().get(String.valueOf(invoiceCount.get()));
                                        if (customer.getData().get(String.valueOf(invoiceCount.get())) == null) {
                                            Log.d("Next available ID: ", String.valueOf(invoiceCount.get()));
                                            Log.d(" Cloud Firestore", "loading " + invoiceCount.getAndDecrement() + " invoices");
//                                    newInvoiceWithID.put(String.valueOf(invoiceCount), newInvoice);
//                                                Map<String, Object> map = new HashMap<>();
//                                                map.put("customerIDs", user.getUid());
//                                    db.collection("invoices").document(user.getUid()).update(String.valueOf(invoiceCount), newInvoice);
//                                                if (db.collection("customerList").document(finalStrArray[0]) == null) {
//                                    db.collection("customerList").document(finalStrArray[0]).update(map);
//                                                } else {
//                                                    db.collection("customerList").document(finalStrArray[0]).update("customerIDs", FieldValue.arrayUnion(user.getUid()));
//                                                }
//                                invoiceCount = 0;
//                                myInvoiceTitle.setText("Invoice saved: " + invoiceCount);

                                            invoiceCount.getAndDecrement();
                                            Log.d(" paid", String.valueOf(paidCount));
                                            Log.d(" unpaid", String.valueOf(unpaidCount));
                                            Log.d(" matchedBusinessCount", String.valueOf(matchedBusinessCount));
//                            myInvoiceTitle.setText("You have saved " + (invoiceCount.get()) + " invoices");
//                            myInvoiceTitle.setText("Total Cost: ");
//                            TextView lblTotalCost;
//                            lblTotalCost = getView().findViewById(R.id.totalCost);
//                            lblTotalCost.setVisibility(View.VISIBLE);
//                            lblTotalCost.bringToFront();
//                            lblTotalCost.setText("Total Cost: £" + totalCost.get());
//                            try {
//                                TimeUnit.SECONDS.sleep(3);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                                            countedCustomerInvoices.set(true);
//                                           break;
                                        } else {
//                            int currentInvoiceNumber = invoiceCount.get();
                                            HashMap selectedInvoice = (HashMap) customer.getData().get(String.valueOf(invoiceCount));
//                            HashMap testhash = new HashMap<>();
//                            List<InvoiceModel> lstSavedInvoices = new ArrayList<>();
//                            lstSavedInvoices = new ArrayList<>();

//                            selectedInvoice.get("price");
                                            Log.d(" current invoice no.", String.valueOf(invoiceCount));
//                            String querybusinessID = (String.valueOf(selectedInvoice.get("businessID")));
                                            businessID.getAndSet(selectedInvoice.get("businessID"));
//                            String paidStatus = String.valueOf(selectedInvoice.get("paidStatus"));
                                            Log.d(" findbusiness id", String.valueOf(businessID));

////                            String businessID = String.valueOf(selectedInvoice.get("businessID"));
////                            Task<DocumentSnapshot> lookupBusiness = db.collection("businesses").document(businessID).get().addOnCompleteListener(checkBusiness -> {
//                            db.collection("businesses").document(String.valueOf(businessID)).get().addOnCompleteListener(checkBusiness -> {
//                                if (checkBusiness.isSuccessful()) {
//                                    DocumentSnapshot business = checkBusiness.getResult();
////                                    Log.d(" findbusiness", String.valueOf(business.getClass()));
////                                    Log.d(" findbusiness", String.valueOf(business.getData()));
////                                    Log.d(" findbusiness", String.valueOf(business.get("businessName")));
////                                    Object matchedName = business.get("businessName");
////                                    String some = matchedName.toString();
//
////                                    String matchedName = String.valueOf(business.get("businessName"));
////                                    String spicy = String.valueOf(business.get("businessName"));
////                                    businessNameAtomic.getAndSet(matchedName);
////                                    if (business.getData().get(String.valueOf(invoiceCount)) == null) {
////                                    Log.d(" current invoice ", matchedName);
////                                    Log.d(" The current invoice businessName is ", String.valueOf(businessNameAtomic));
////                                    TextView lblTotalCost;
////                                    lblTotalCost = getView().findViewById(R.id.totalCost);
////                                    lblTotalCost.setVisibility(View.VISIBLE);
////                                    lblTotalCost.setText("Total Cost: £" + totalCost);
////                                    Log.d(" The current cost is £", String.valueOf(totalCost));
////                                    }
////                                }
////                            });
////                            Task<DocumentSnapshot> lookupBusiness = db.collection("businesses").document(businessID).get();
////                            lookupBusiness.getResult().getData();

//                            String businessName = String.valueOf(task);
//                                    String businessID = (String.valueOf(selectedInvoice.get("businessID")));
                                            String description = String.valueOf(selectedInvoice.get("description"));
                                            String price = String.valueOf(selectedInvoice.get("price"));
//                            String paidStatus = String.valueOf(selectedInvoice.get("paidStatus"));
                                            paidStatus.getAndSet(String.valueOf(selectedInvoice.get("paidStatus")));
                                            String date = String.valueOf(selectedInvoice.get("date"));
                                            String businessName = String.valueOf(businessNameAtomic);
                                            totalProfit.getAndUpdate(v -> v + Double.parseDouble(price));

                                            TextView lblTotalCost;
//                                    Log.d(" checkpoint", businessID + " " + paidStatus);
//                                    Log.d(" checkpoint uid", user.getUid());
//                                    Log.d(" paidStatus", paidStatus);
//                                    paidCount.getAndIncrement();

//                                    if (businessID.equals(user.getUid())) {
//                                        Log.d(" checkpoint", businessID + " " + paidStatus);
////                                        Assert.assertEquals("Paid");
////                                        Objects.equals(paidStatus, "Paid");
//                                        if (paidStatus.trim().equals("Paid")) {
//                                            Log.d(" paidCount", businessID + " " + paidStatus);
//                                            paidCount.getAndIncrement();
//                                        } else if (paidStatus.trim().equals("Unpaid")) {
//                                            Log.d(" unpaidCount", businessID + " " + paidStatus);
//                                            unpaidCount.getAndIncrement();
////                                            unpaidCount.()
//                                        }
//                                        matchedBusinessCount.getAndIncrement();
//                                        Log.d(" matchedBusinessCount", businessID + " " + paidStatus);
//                                    }
//                                    invoiceCount.getAndIncrement();

//                                    else{
//                                        invoiceCount.getAndIncrement();
//                                    }
//                                    totalCost.getAndUpdate(v -> v + Double.parseDouble(price));

//                                    lblTotalCost = getView().findViewById(R.id.totalCost);
//                                    lblTotalCost.setVisibility(View.VISIBLE);
//                                    lblTotalCost.bringToFront();
//                                    DecimalFormat decimalFormat = new DecimalFormat("###.##");
//                                    lblTotalCost.setText("Total Cost: £" + decimalFormat.format(totalCost.get()));

//                                    Log.d(" total cost is ", decimalFormat.format(totalCost.get()));

//                                Log.d(" The current invoice businessID is ", String.valueOf(selectedInvoice.get("businessID")));
//                                Log.d(" The current invoice businessName is ", String.valueOf(businessName));
//                                Log.d(" The current invoice businessName is ", String.valueOf(businessNameAtomic));
//                                Log.d(" The current invoice description is ", String.valueOf(selectedInvoice.get("description")));
//                                    Log.d(" The current invoice price is ", String.valueOf(selectedInvoice.get("price")));
////                                Log.d(" The current invoice paidStatus is ", String.valueOf(selectedInvoice.get("paidStatus")));
////                                Log.d(" The current invoice date is ", String.valueOf(selectedInvoice.get("date")));
//                                    AtomicReference<RecyclerView> recyclerView = new AtomicReference<>();
//                                    recyclerView.set(getActivity().findViewById(R.id.recyclerView));
//                                    InvoiceModel InvoiceModel = new InvoiceModel(businessName, description, price, paidStatus, date);
//                                    lstSavedInvoices.add(InvoiceModel);
//
//                                    CustomAdapter customAdapter;
//                                    customAdapter = new CustomAdapter(getActivity(), lstSavedInvoices);
//                                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
//                                    recyclerView.get().setLayoutManager(layoutManager);
//                                    Log.d("Array List length: ", String.valueOf(lstSavedInvoices.size()));
//                                    customAdapter.setOnItemClickListener(new ClickListener<InvoiceModel>(){
//                                        @Override
//                                        public void onItemClick(com.example.ezinvoicecustomer.InvoiceModel data) {
//                                            Toast.makeText(getActivity(), "Price: £" + data.getprice(), Toast.LENGTH_SHORT).show();
//                                        }
//
////                                        @Override
////                                        public void onItemClick(Movie data) {
////                                            Toast.makeText(getActivity(), data.getTitle(), Toast.LENGTH_SHORT).show();
////                                        }
//                                    });
//
//                                    recyclerView.get().setAdapter(customAdapter);


//                                    NestedScrollView nestedScroll;
//                                    nestedScroll =  getActivity().findViewById(R.id.nestedScroll);
//                                    final int[] count = {0};
//
//                                    nestedScroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//                                        @Override
//                                        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                                            // on scroll change we are checking when users scroll as bottom.
//                                            if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
//                                                // in this method we are incrementing page number,
//                                                // making progress bar visible and calling get data method.
//                                                count[0]++;
//                                                // on below line we are making our progress bar visible.
////                                                loadingPB.setVisibility(View.VISIBLE);
////                                                if (count[0] < 20) {
////                                                    // on below line we are again calling
////                                                    // a method to load data in our array list.
////                                                    getData();
////                                                }
//                                            }
//                                        }
//                                    });
//                        }
//                            });

                                            // Here we are checking if the business id on the invoice matches the logged in business
                                            if (businessID.get().equals(user.getUid())) {
//                                                Log.d(" checkpoint", businessID + " " + paidStatus);
//                                        Assert.assertEquals("Paid");
//                                        Objects.equals(paidStatus, "Paid");
//                                                Log.d(" compare me to paid", paidStatus.toString());

                                                // Update the paid counter if it is marked as paid
                                                if (String.valueOf(paidStatus).trim().equals("Paid")) {
                                                    Log.d(" paidCount", businessID + " " + paidStatus);
                                                    paidCount.getAndIncrement();
                                                }
                                                // Update the unpaid counter if it is marked as unpaid
                                                else {
                                                    Log.d(" unpaidCount", businessID + " " + paidStatus);
                                                    unpaidCount.getAndIncrement();
//                                            unpaidCount.()
                                                }
                                                // Updating the total invoices counter for this business
                                                matchedBusinessCount.getAndIncrement();
                                                Log.d(" matchedBusinessCount", String.valueOf(matchedBusinessCount.get()));
                                            }
//                        else{
//
//                        }

                                            invoiceCount.getAndIncrement();
                                        }
//                                        currentCustomer.getAndIncrement();

//                                        currentCustomer.getAndIncrement();

//                                    }
//                                        if (currentCustomer.get() > customerListArray.size()) {
//                                            countedInvoices.getAndSet(true);
                                        // Declare variables
//                                        TextView totalCost, lblTotalInvoices, lblPaidInvoices, lblUnpaidInvoices;
//                                        PieChart pieChart;
//
//                                        // Set variables to UI elements
//                                        pieChart = getActivity().findViewById(R.id.paidStatusChart);
//                                        lblTotalInvoices = getActivity().findViewById(R.id.lblTotalInvoices);
//                                        lblPaidInvoices = getActivity().findViewById(R.id.lblPaidInvoices);
//                                        lblUnpaidInvoices = getActivity().findViewById(R.id.lblUnpaidInvoices);
//
//                                        // Adding statistics
//                                        lblTotalInvoices.append(matchedBusinessCount + " invoices:");
//                                        lblPaidInvoices.setText(paidCount + " Paid");
//                                        lblUnpaidInvoices.setText(unpaidCount + " Unpaid");
//
//                                        // Display statistics
//                                        lblTotalInvoices.setVisibility(View.VISIBLE);
//                                        lblPaidInvoices.setVisibility(View.VISIBLE);
//                                        lblUnpaidInvoices.setVisibility(View.VISIBLE);
//
//// Set the data and color to the pie chart
//                                        pieChart.addPieSlice(
//                                                new PieModel(
//                                                        "Paid",
//                                                        Integer.parseInt(String.valueOf(paidCount)),
//                                                        Color.parseColor("#66BB6A")));
//                                        pieChart.addPieSlice(
//                                                new PieModel(
//                                                        "Unpaid",
//                                                        Integer.parseInt(String.valueOf(unpaidCount)),
//                                                        Color.parseColor("#CB4154")));
//
//// To animate the pie chart
//                                        pieChart.startAnimation();

//                                        } else {
//                                            currentCustomer.getAndIncrement();
//                                        }
                                    }

//                                    currentCustomer.getAndIncrement();

//                                        countedCustomerInvoices.getAndSet(true);
                                    Log.d(" checkmeout", String.valueOf(currentCustomer.intValue()));
                                    Log.d(" checkmeout", String.valueOf(customerListArray.size()));

                                    // Once all customers have been checked, display the statistics
                                    if (currentCustomer.intValue() < customerListArray.size()) {
                                        countedInvoices.getAndSet(true);

                                        TextView lblTotalInvoices, lblPaidInvoices, lblUnpaidInvoices, lblTotalProfit;
                                        PieChart pieChart;

                                        // Set variables to UI elements
                                        pieChart = getActivity().findViewById(R.id.paidStatusChart);
                                        lblTotalInvoices = getActivity().findViewById(R.id.lblTotalInvoices);
                                        lblPaidInvoices = getActivity().findViewById(R.id.lblPaidInvoices);
                                        lblUnpaidInvoices = getActivity().findViewById(R.id.lblUnpaidInvoices);
                                        lblTotalProfit = getActivity().findViewById(R.id.lblTotalProfit);

                                        // Adding statistics
                                        lblTotalInvoices.append(matchedBusinessCount + " invoices:");
                                        lblPaidInvoices.setText(paidCount + " Paid");
                                        lblUnpaidInvoices.setText(unpaidCount + " Unpaid");
                                        lblTotalProfit.append(totalProfit.toString());

                                        // Display statistics
                                        lblTotalInvoices.setVisibility(View.VISIBLE);
                                        lblPaidInvoices.setVisibility(View.VISIBLE);
                                        lblUnpaidInvoices.setVisibility(View.VISIBLE);
                                        lblTotalProfit.setVisibility(View.VISIBLE);

                                        // Plot pie chart for paid v unpaid invoices
                                        pieChart.addPieSlice(
                                                new PieModel(
                                                        "Paid",
                                                        Integer.parseInt(String.valueOf(paidCount)),
                                                        Color.parseColor("#66BB6A")));
                                        pieChart.addPieSlice(
                                                new PieModel(
                                                        "Unpaid",
                                                        Integer.parseInt(String.valueOf(unpaidCount)),
                                                        Color.parseColor("#CB4154")));

// To animate the pie chart
                                        pieChart.startAnimation();
                                        countedCustomerInvoices.getAndSet(true);

//                                        currentCustomer.getAndIncrement();
                                    }
                                    // Move on to the next customer
                                    else {
//                                        currentCustomer.getAndIncrement();
                                        currentCustomer.getAndIncrement();
//                                        countedCustomerInvoices.getAndSet(true);
                                    }


                                });

                    }

                });

//        btnViewInvoices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                startActivity(new Intent(getActivity(), ViewMyInvoicesActivity.class));
//            }
//        });

        btnCreateInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CreateInvoiceActivity.class));
                Log.d("Button Create Invoice", "click received");
            }
        });
    }


    public interface OnFragmentInteractionListener {
    }
}