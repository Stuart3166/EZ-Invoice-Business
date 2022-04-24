// Generated by view binder compiler. Do not edit!
package com.example.ezinvoicebusiness.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ezinvoicebusiness.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText businessName;

  @NonNull
  public final EditText email;

  @NonNull
  public final ImageView logo;

  @NonNull
  public final EditText password;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final Button signInButton;

  @NonNull
  public final Button signUpButton;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull EditText businessName, @NonNull EditText email, @NonNull ImageView logo,
      @NonNull EditText password, @NonNull ProgressBar progressBar, @NonNull Button signInButton,
      @NonNull Button signUpButton) {
    this.rootView = rootView;
    this.businessName = businessName;
    this.email = email;
    this.logo = logo;
    this.password = password;
    this.progressBar = progressBar;
    this.signInButton = signInButton;
    this.signUpButton = signUpButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.businessName;
      EditText businessName = ViewBindings.findChildViewById(rootView, id);
      if (businessName == null) {
        break missingId;
      }

      id = R.id.email;
      EditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.logo;
      ImageView logo = ViewBindings.findChildViewById(rootView, id);
      if (logo == null) {
        break missingId;
      }

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.progressBar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.sign_in_button;
      Button signInButton = ViewBindings.findChildViewById(rootView, id);
      if (signInButton == null) {
        break missingId;
      }

      id = R.id.sign_up_button;
      Button signUpButton = ViewBindings.findChildViewById(rootView, id);
      if (signUpButton == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, businessName, email, logo,
          password, progressBar, signInButton, signUpButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
