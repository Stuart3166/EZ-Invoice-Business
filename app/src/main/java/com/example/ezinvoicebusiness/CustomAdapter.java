package com.example.ezinvoicebusiness;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

interface ClickListener<T> {
    void onItemClick(T data);
}

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Viewholder> {
    //    private Context context;
    private List<CustomerModel> customerModelArrayList;
    private ClickListener<CustomerModel> clickListener;

    CustomAdapter(FragmentActivity activity, List<CustomerModel> customerModelArrayList) {
        this.customerModelArrayList = customerModelArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a card view for each customer in RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.invoice_card, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        final CustomerModel customer = customerModelArrayList.get(position);

        holder.customerName.setText(customer.getcustomerName());
        holder.customerEmail.setText(customer.getcustomerEmail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(customer);
            }
        });
    }

//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    }

    @Override
    public int getItemCount() {
        return customerModelArrayList.size();
    }

    public void setOnItemClickListener(ClickListener<CustomerModel> movieClickListener) {
        this.clickListener = movieClickListener;
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        View view;
        private TextView customerName, customerEmail;
        private CardView cardView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
//            courseIV = itemView.findViewById(R.id.image);
//            title = itemView.findViewById(R.id.title);
//            image = itemView.findViewById(R.id.image);
            customerName = itemView.findViewById(R.id.cardViewCustomerName);
            customerEmail = itemView.findViewById(R.id.cardViewCustomerEmail);
//            price = itemView.findViewById(R.id.cardViewPrice);
//            paidStatus = itemView.findViewById(R.id.cardViewPaidStatus);
//            date = itemView.findViewById(R.id.cardViewDate);
            cardView = itemView.findViewById(R.id.invoiceCardView);
            view = itemView;
        }
    }
}