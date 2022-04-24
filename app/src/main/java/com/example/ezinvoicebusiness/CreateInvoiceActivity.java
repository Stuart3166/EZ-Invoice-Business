package com.example.ezinvoicebusiness;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.SimpleDateFormat;
import java.util.Date;

import androidmads.library.qrgenearator.QRGContents;
import androidmads.library.qrgenearator.QRGEncoder;

public class CreateInvoiceActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private CreateInvoiceActivity binding;
    private EditText businessName, businessEmail, description, cost, invoiceDate;
    private Spinner status;
    private ImageView qrImage;
    private TextView invoiceShareable, createInvoice, dueDate, pageLabel;
    private String invoiceValues, invoiceValue1, invoiceValue2, invoiceValue3, invoiceValue4, invoiceValue5, invoiceValue6, invoiceValue7;
    //    private String savePath = Environment.getExternalStorageDirectory().getPath() + "/QRCode/";
    private Bitmap bitmap;
    private QRGEncoder qrgEncoder;
    private String[] paidStatus = {"Paid", "Unpaid"};
    private Date date = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_create_invoice);

        // Configuring drop down list
        Spinner dropdownList = findViewById(R.id.paidStatus);
        dropdownList.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, paidStatus);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdownList.setAdapter(aa);

        // Identify the current logged in user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        // Link variables to UI components
        pageLabel = findViewById(R.id.pageLabel);
        qrImage = findViewById(R.id.qrImage);
        description = findViewById(R.id.description);
        cost = findViewById(R.id.cost);
        status = findViewById(R.id.paidStatus);
        invoiceDate = findViewById(R.id.date);
        dueDate = findViewById(R.id.lblDueDate);
        createInvoice = findViewById(R.id.createInvoice);
        invoiceShareable = findViewById(R.id.invoiceShareable);
        invoiceShareable.setVisibility(View.INVISIBLE);

        findViewById(R.id.btnGenerateQrcode).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Data Validation
                if (TextUtils.isEmpty(description.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter a description", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(cost.getText())) {
                    Toast.makeText(getApplicationContext(), "Enter cost", Toast.LENGTH_SHORT).show();
                    return;
                }

                invoiceValue1 = user.getUid();
                invoiceValue2 = user.getDisplayName();
                invoiceValue3 = user.getEmail();
//                invoiceValue3 = user.getPhoneNumber();
                invoiceValue4 = description.getText().toString().trim();
                invoiceValue5 = cost.getText().toString().trim();
                invoiceValue6 = status.getSelectedItem().toString();
                invoiceValue7 = invoiceDate.getText().toString().trim();
//                invoiceValues = "Business Name: " + invoiceValue1 + "\n" + "Email" + invoiceValue2 + "\n" + "Description: " + invoiceValue3 + "\n" + "Cost: " + invoiceValue4 + "\n" + "Status: " + invoiceValue5;
                invoiceValues = invoiceValue1 + "," + "\n" + invoiceValue2 + "," + "\n" + invoiceValue3 + "," + "\n" + invoiceValue4 + "," + "\n" + invoiceValue5 + "," + "\n" + invoiceValue6 + "," + "\n" + invoiceValue7;
                invoiceShareable.setVisibility(View.VISIBLE);

                // Hide input fields
                pageLabel.setText("Invoice successfully convert to QR Code");
                createInvoice.setVisibility(View.INVISIBLE);
                description.setVisibility(View.INVISIBLE);
                cost.setVisibility(View.INVISIBLE);
                dropdownList.setVisibility(View.INVISIBLE);
                invoiceDate.setVisibility(View.INVISIBLE);
                dueDate.setVisibility(View.INVISIBLE);

                // Check invoice contains data before generating
                if (invoiceValues.length() > 0) {
                    // Set qr code size
                    WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
                    Display display = manager.getDefaultDisplay();
                    Point point = new Point();
                    display.getSize(point);
                    int width = point.x;
                    int height = point.y;
                    int smallerDimension = width < height ? width : height;
                    smallerDimension = smallerDimension * 3 / 4;

                    qrgEncoder = new QRGEncoder(
                            invoiceValues, null,
                            QRGContents.Type.TEXT,
                            smallerDimension);
                    try {
                        bitmap = qrgEncoder.getBitmap();
                        qrImage.setImageBitmap(bitmap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    businessName.setError(getResources().getString(R.string.value_required));
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        // Get the current date
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy");
        String currentDate = formatter.format(date);

        // Create date format hint
        SimpleDateFormat formatterHint = new SimpleDateFormat("dd/MM/yy");
        String currentDateHint = formatterHint.format(date);

        // When paid is selected set the date to today
        if (status.getSelectedItem().toString().equals("Paid")) {
            invoiceDate.setText(currentDate);
            invoiceDate.setEnabled(false);
            dueDate.setVisibility(View.INVISIBLE);
        }

        // Set hint showing input mask and allow date to be edited
        else {
            invoiceDate.setText("");
            invoiceDate.setEnabled(true);
            invoiceDate.setHint(currentDateHint);
            dueDate.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}