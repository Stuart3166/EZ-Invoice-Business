package com.example.ezinvoicebusiness;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AccountDetailsFragment extends Fragment {
    int btnDeleteClicks = 0;

    EditText inputCurrentPassword, inputNewPassword, inputNewEmail;
    TextView Email, DisplayName, CurrentEmail;
    Button btnUpdateEmail, btnUpdatePassword, btnChangePassword, btnChangeEmail, btnDeleteAccount, btnSignOut, btnCancelUpdate;

    private OnFragmentInteractionListener listener;

    public static AccountDetailsFragment newInstance() {
        return new AccountDetailsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_account_details, container, false);
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

    public void HideMenu() {
        DisplayName = getView().findViewById(R.id.lblDisplayName);
        Email = getView().findViewById(R.id.lblEmail);
        btnChangeEmail = getView().findViewById(R.id.btnChangeEmail);
        btnChangePassword = getView().findViewById(R.id.btnChangePassword);
        btnDeleteAccount = getView().findViewById(R.id.btnDeleteAccount);
        btnSignOut = getView().findViewById(R.id.btnSignOut);

        DisplayName.setVisibility(View.INVISIBLE);
        Email.setVisibility(View.INVISIBLE);
        btnChangeEmail.setVisibility(View.INVISIBLE);
        btnChangePassword.setVisibility(View.INVISIBLE);
        btnDeleteAccount.setVisibility(View.INVISIBLE);
        btnSignOut.setVisibility(View.INVISIBLE);
    }

    public void ResetMenu() {
        DisplayName = getView().findViewById(R.id.lblDisplayName);
        Email = getView().findViewById(R.id.lblEmail);
        CurrentEmail = getView().findViewById(R.id.currentEmail);
        btnChangeEmail = getView().findViewById(R.id.btnChangeEmail);
        inputNewEmail = getView().findViewById(R.id.newEmail);
        btnUpdateEmail = getView().findViewById(R.id.btnUpdateEmail);
        btnChangePassword = getView().findViewById(R.id.btnChangePassword);
        inputCurrentPassword = getView().findViewById(R.id.currentPassword);
        inputNewPassword = getView().findViewById(R.id.newPassword);
        btnUpdatePassword = getView().findViewById(R.id.btnUpdatePassword);
        btnDeleteAccount = getView().findViewById(R.id.btnDeleteAccount);
        btnSignOut = getView().findViewById(R.id.btnSignOut);
        btnCancelUpdate = getView().findViewById(R.id.btnCancelUpdate);

        DisplayName.setVisibility(View.VISIBLE);
        Email.setVisibility(View.VISIBLE);
        btnChangeEmail.setVisibility(View.VISIBLE);
        btnChangePassword.setVisibility(View.VISIBLE);
        btnDeleteAccount.setVisibility(View.VISIBLE);
        btnSignOut.setVisibility(View.VISIBLE);

        inputCurrentPassword.setVisibility(View.INVISIBLE);
        inputNewEmail.setVisibility(View.INVISIBLE);
        btnUpdateEmail.setVisibility(View.INVISIBLE);
        CurrentEmail.setVisibility(View.INVISIBLE);
        btnCancelUpdate.setVisibility(View.INVISIBLE);
        inputCurrentPassword.setVisibility(View.INVISIBLE);
        inputNewPassword.setVisibility(View.INVISIBLE);
        btnUpdatePassword.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        FirebaseAuth auth;
        EditText inputCurrentPassword, inputNewPassword, inputNewEmail;
        TextView Email, DisplayName, CurrentEmail;
        Button btnUpdateEmail, btnUpdatePassword, btnChangePassword, btnChangeEmail, btnDeleteAccount, btnSignOut, btnCancelUpdate;

        auth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Email = getView().findViewById(R.id.lblEmail);
        DisplayName = getView().findViewById(R.id.lblDisplayName);
        CurrentEmail = getView().findViewById(R.id.currentEmail);
        btnChangeEmail = getView().findViewById(R.id.btnChangeEmail);
        inputNewEmail = getView().findViewById(R.id.newEmail);
        btnUpdateEmail = getView().findViewById(R.id.btnUpdateEmail);
        btnChangePassword = getView().findViewById(R.id.btnChangePassword);
        inputCurrentPassword = getView().findViewById(R.id.currentPassword);
        inputNewPassword = getView().findViewById(R.id.newPassword);
        btnUpdatePassword = getView().findViewById(R.id.btnUpdatePassword);
        btnDeleteAccount = getView().findViewById(R.id.btnDeleteAccount);
        btnSignOut = getView().findViewById(R.id.btnSignOut);
        btnCancelUpdate = getView().findViewById(R.id.btnCancelUpdate);

//        assert user != null;

        // Populating Account Details with labels
        CharSequence lblEmail, lblDisplayName;
        lblEmail = Email.getText();
        lblDisplayName = DisplayName.getText();

        Email.setText(((lblEmail + "  " + user.getEmail())));
        DisplayName.setText(lblDisplayName + " " + user.getDisplayName());

        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
                startActivity(new Intent(getActivity(), LoginActivity.class));

//                startActivity(new Intent(getActivity(), ViewMyInvoicesActivity.class));
//                Log.d("Button View Invoice", "click received");

//                Fragment fragment = null;
//                fragment = CreateInvoiceFragment.newInstance();
//
//                if (fragment != null) {
//                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//                    fragmentTransaction.replace(R.id.container, fragment);
//                    fragmentTransaction.commit();
//                }
            }
        });

        btnDeleteAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDeleteClicks += 1;

                if (btnDeleteClicks == 1) {
                    Toast.makeText(getActivity(), "Click again to confirm", Toast.LENGTH_LONG).show();
//                    btnDeleteClicks+=2;
                } else if (btnDeleteClicks == 2) {
                    user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Log.d("Firebase", "User account deleted.");
//                                    Log.d(TAG, "User account deleted.");
                            }
                            Toast.makeText(getActivity(), "Your account has been deleted", Toast.LENGTH_LONG).show();
                            auth.signOut();
                            startActivity(new Intent(getActivity(), LoginActivity.class));
                        }
                    });

                }
            }
        });

        btnCancelUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            DisplayName.setVisibility(View.VISIBLE);
//            Email.setVisibility(View.VISIBLE);
//            btnChangeEmail.setVisibility(View.VISIBLE);
//            btnChangePassword.setVisibility(View.VISIBLE);
//            btnDeleteAccount.setVisibility(View.VISIBLE);
//            btnSignOut.setVisibility(View.VISIBLE);
//
//            inputCurrentPassword.setVisibility(View.INVISIBLE);
//            inputNewEmail.setVisibility(View.INVISIBLE);
//            btnUpdateEmail.setVisibility(View.INVISIBLE);
//            CurrentEmail.setVisibility(View.INVISIBLE);
//            btnCancelUpdate.setVisibility(View.INVISIBLE);
//            inputCurrentPassword.setVisibility(View.INVISIBLE);
//            inputNewPassword.setVisibility(View.INVISIBLE);
//            btnUpdatePassword.setVisibility(View.INVISIBLE);
                ResetMenu();
            }
        });

        btnChangeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputNewEmail.setVisibility(View.VISIBLE);
                CurrentEmail.setVisibility(View.VISIBLE);
                btnUpdateEmail.setVisibility(View.VISIBLE);
                btnCancelUpdate.setVisibility(View.VISIBLE);
                CurrentEmail.setVisibility(View.VISIBLE);

//                DisplayName.setVisibility(View.INVISIBLE);
//                Email.setVisibility(View.INVISIBLE);
//                btnChangeEmail.setVisibility(View.INVISIBLE);
//                btnChangePassword.setVisibility(View.INVISIBLE);
//                btnDeleteAccount.setVisibility(View.INVISIBLE);
//                btnSignOut.setVisibility(View.INVISIBLE);

                HideMenu();
                CurrentEmail.setText((("Current:" + "  " + user.getEmail())));
            }
        });

        btnUpdateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.updateEmail(inputNewEmail.getText().toString());
                Email.setText(((lblEmail + "  " + inputNewEmail.getText().toString())));
                ResetMenu();
                Toast.makeText(getActivity(), "Email Updated", Toast.LENGTH_LONG).show();
            }
        });

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputCurrentPassword.setVisibility(View.VISIBLE);
                inputNewPassword.setVisibility(View.VISIBLE);
                btnUpdatePassword.setVisibility(View.VISIBLE);
                btnCancelUpdate.setVisibility(View.VISIBLE);

//                DisplayName.setVisibility(View.INVISIBLE);
//                Email.setVisibility(View.INVISIBLE);
//                btnChangeEmail.setVisibility(View.INVISIBLE);
//                btnChangePassword.setVisibility(View.INVISIBLE);
//                btnDeleteAccount.setVisibility(View.INVISIBLE);
//                btnSignOut.setVisibility(View.INVISIBLE);
                HideMenu();
            }
        });

        btnUpdatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthCredential credential = EmailAuthProvider.getCredential(
                        user.getEmail(),
                        inputCurrentPassword.getText().toString()
                );
                user.reauthenticate(credential)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
//                                user.updatePassword(some)
                                if (task.isSuccessful()) {
                                    Log.d("TAG", "User successfully re-authenticated.");
                                    Toast.makeText(getActivity(), "Password Updated", Toast.LENGTH_LONG).show();
                                    user.updatePassword(inputNewPassword.getText().toString());
                                    ResetMenu();
                                } else {
                                    inputCurrentPassword.setBackgroundColor(Color.RED);
                                    inputCurrentPassword.setText("");
                                    inputCurrentPassword.setError("Incorrect password");
                                    Toast.makeText(getActivity(), "Failed to update", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }

    public interface OnFragmentInteractionListener {
    }
}