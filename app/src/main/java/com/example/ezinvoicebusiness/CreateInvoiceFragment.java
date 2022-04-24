package com.example.ezinvoicebusiness;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class CreateInvoiceFragment extends Fragment {

    private OnFragmentInteractionListener listener;

    public static CreateInvoiceFragment newInstance() {
        return new CreateInvoiceFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
//        Button btnViewInvoices, btnCreateInvoice;
//        btnViewInvoices = getView().findViewById(R.id.btnViewInvoices);
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
//                startActivity(new Intent(getActivity(), RegisterActivity.class));
//            }
//        });
    }

    public interface OnFragmentInteractionListener {
    }
}