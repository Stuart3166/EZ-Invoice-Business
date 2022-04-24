package com.example.ezinvoicebusiness;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyInvoicesActivity extends AppCompatActivity {
    Button btnViewInvoices, btnCreateInvoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_my_invoices);
//
//        Button btnViewInvoices, btnCreateInvoice;
//        btnViewInvoices = findViewById(R.id.btnViewInvoices);
//
//        btnViewInvoices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MyInvoicesActivity.this, ViewMyInvoicesActivity.class));
//            }
//        });
//
//        btnCreateInvoice = findViewById(R.id.btnCreateInvoice);
//        btnCreateInvoice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MyInvoicesActivity.this, ViewMyInvoicesActivity.class));
//            }
//        });
    }
}


//}