// Generated by view binder compiler. Do not edit!
package com.example.ezinvoicebusiness.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
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
import org.eazegraph.lib.charts.PieChart;

public final class FragmentMyInvoicesBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button btnCreateInvoice;

  @NonNull
  public final CardView cardViewGraph;

  @NonNull
  public final CardView cardViewStats;

  @NonNull
  public final CardView cardViewTotalProfit;

  @NonNull
  public final TextView lblPaidInvoices;

  @NonNull
  public final TextView lblTotalInvoices;

  @NonNull
  public final TextView lblTotalProfit;

  @NonNull
  public final TextView lblUnpaidInvoices;

  @NonNull
  public final PieChart paidStatusChart;

  @NonNull
  public final TextView titleMyInvoices;

  private FragmentMyInvoicesBinding(@NonNull RelativeLayout rootView,
      @NonNull Button btnCreateInvoice, @NonNull CardView cardViewGraph,
      @NonNull CardView cardViewStats, @NonNull CardView cardViewTotalProfit,
      @NonNull TextView lblPaidInvoices, @NonNull TextView lblTotalInvoices,
      @NonNull TextView lblTotalProfit, @NonNull TextView lblUnpaidInvoices,
      @NonNull PieChart paidStatusChart, @NonNull TextView titleMyInvoices) {
    this.rootView = rootView;
    this.btnCreateInvoice = btnCreateInvoice;
    this.cardViewGraph = cardViewGraph;
    this.cardViewStats = cardViewStats;
    this.cardViewTotalProfit = cardViewTotalProfit;
    this.lblPaidInvoices = lblPaidInvoices;
    this.lblTotalInvoices = lblTotalInvoices;
    this.lblTotalProfit = lblTotalProfit;
    this.lblUnpaidInvoices = lblUnpaidInvoices;
    this.paidStatusChart = paidStatusChart;
    this.titleMyInvoices = titleMyInvoices;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMyInvoicesBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMyInvoicesBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_my_invoices, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMyInvoicesBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnCreateInvoice;
      Button btnCreateInvoice = ViewBindings.findChildViewById(rootView, id);
      if (btnCreateInvoice == null) {
        break missingId;
      }

      id = R.id.cardViewGraph;
      CardView cardViewGraph = ViewBindings.findChildViewById(rootView, id);
      if (cardViewGraph == null) {
        break missingId;
      }

      id = R.id.cardViewStats;
      CardView cardViewStats = ViewBindings.findChildViewById(rootView, id);
      if (cardViewStats == null) {
        break missingId;
      }

      id = R.id.cardViewTotalProfit;
      CardView cardViewTotalProfit = ViewBindings.findChildViewById(rootView, id);
      if (cardViewTotalProfit == null) {
        break missingId;
      }

      id = R.id.lblPaidInvoices;
      TextView lblPaidInvoices = ViewBindings.findChildViewById(rootView, id);
      if (lblPaidInvoices == null) {
        break missingId;
      }

      id = R.id.lblTotalInvoices;
      TextView lblTotalInvoices = ViewBindings.findChildViewById(rootView, id);
      if (lblTotalInvoices == null) {
        break missingId;
      }

      id = R.id.lblTotalProfit;
      TextView lblTotalProfit = ViewBindings.findChildViewById(rootView, id);
      if (lblTotalProfit == null) {
        break missingId;
      }

      id = R.id.lblUnpaidInvoices;
      TextView lblUnpaidInvoices = ViewBindings.findChildViewById(rootView, id);
      if (lblUnpaidInvoices == null) {
        break missingId;
      }

      id = R.id.paidStatusChart;
      PieChart paidStatusChart = ViewBindings.findChildViewById(rootView, id);
      if (paidStatusChart == null) {
        break missingId;
      }

      id = R.id.titleMyInvoices;
      TextView titleMyInvoices = ViewBindings.findChildViewById(rootView, id);
      if (titleMyInvoices == null) {
        break missingId;
      }

      return new FragmentMyInvoicesBinding((RelativeLayout) rootView, btnCreateInvoice,
          cardViewGraph, cardViewStats, cardViewTotalProfit, lblPaidInvoices, lblTotalInvoices,
          lblTotalProfit, lblUnpaidInvoices, paidStatusChart, titleMyInvoices);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
