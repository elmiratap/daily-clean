package com.elmira.dailyclean;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;

public class AddItemDialogFragment extends DialogFragment {
    HashSet<String> selectedItems = new HashSet<>();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View formElementsView = inflater.inflate(R.layout.dialog_add_item, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(formElementsView)
                .setTitle(R.string.add_item)
                .setCancelable(false)
                .setPositiveButton(R.string.add_item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AddItemDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        final AlertDialog dialog = (AlertDialog) getDialog();
        if (dialog != null) {
            final EditText itemEditText = dialog.findViewById(R.id.item_edit_text);
            final EditText roomEditText = dialog.findViewById(R.id.room_edit_text);
            final CheckBox washCheckBox = dialog.findViewById(R.id.wash_checkBox);
            final CheckBox dustCheckBox = dialog.findViewById(R.id.dust_checkBox);
            final CheckBox sweepCheckBox = dialog.findViewById(R.id.sweep_checkBox);
            final CheckBox vacuumCheckBox = dialog.findViewById(R.id.vacuum_checkBox);
            final Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            final CheckBox[] checkBoxes = {washCheckBox, dustCheckBox, sweepCheckBox, vacuumCheckBox};
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean canDismissDialog = true;
                    if (itemEditText.getText().toString().length() < 1) {
                        canDismissDialog = false;
                        Toast.makeText(getActivity(), "Please enter an item to clean", Toast.LENGTH_SHORT).show();
                    }
                    if (roomEditText.getText().toString().length() < 1) {
                        canDismissDialog = false;
                        Toast.makeText(getActivity(), "Please select a room", Toast.LENGTH_SHORT).show();
                    }
                    for (CheckBox checkBox : checkBoxes) {
                        String checkBoxText = checkBox.getText().toString();
                        if (checkBox.isChecked()) {
                            selectedItems.add(checkBoxText);
                        } else if(selectedItems.contains(checkBoxText)) {
                            selectedItems.remove(checkBoxText);
                        }
                    }
                    if (selectedItems.isEmpty()) {
                        canDismissDialog = false;
                        Toast.makeText(getActivity(), "Please select a cleaning action", Toast.LENGTH_SHORT).show();
                    }
                    if (canDismissDialog) {
                        dialog.dismiss();
                    }
                }
            });
        }
    }
}
