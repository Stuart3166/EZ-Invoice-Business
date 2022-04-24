// Generated by view binder compiler. Do not edit!
package com.example.ezinvoicebusiness.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ezinvoicebusiness.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class InvoiceCardBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView cardViewCustomerEmail;

  @NonNull
  public final TextView cardViewCustomerName;

  @NonNull
  public final CardView invoiceCardView;

  private InvoiceCardBinding(@NonNull CardView rootView, @NonNull TextView cardViewCustomerEmail,
      @NonNull TextView cardViewCustomerName, @NonNull CardView invoiceCardView) {
    this.rootView = rootView;
    this.cardViewCustomerEmail = cardViewCustomerEmail;
    this.cardViewCustomerName = cardViewCustomerName;
    this.invoiceCardView = invoiceCardView;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static InvoiceCardBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static InvoiceCardBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.invoice_card, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static InvoiceCardBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardViewCustomerEmail;
      TextView cardViewCustomerEmail = ViewBindings.findChildViewById(rootView, id);
      if (cardViewCustomerEmail == null) {
        break missingId;
      }

      id = R.id.cardViewCustomerName;
      TextView cardViewCustomerName = ViewBindings.findChildViewById(rootView, id);
      if (cardViewCustomerName == null) {
        break missingId;
      }

      CardView invoiceCardView = (CardView) rootView;

      return new InvoiceCardBinding((CardView) rootView, cardViewCustomerEmail,
          cardViewCustomerName, invoiceCardView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
