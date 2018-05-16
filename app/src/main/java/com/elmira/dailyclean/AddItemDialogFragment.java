package com.elmira.dailyclean;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddItemDialogFragment extends DialogFragment {
    ArrayList<String> selectedItems;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        selectedItems = new ArrayList();
        setCancelable(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.add_item);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View formElementsView = inflater.inflate(R.layout.dialog_add_item, null);

        EditText itemEditText = formElementsView.findViewById(R.id.item_edit_text);
        EditText roomEditText = formElementsView.findViewById(R.id.room_edit_text);
        CheckBox washCheckBox = formElementsView.findViewById(R.id.wash_checkBox);
        CheckBox dustCheckBox = formElementsView.findViewById(R.id.dust_checkBox);
        CheckBox sweepCheckBox = formElementsView.findViewById(R.id.sweep_checkBox);
        CheckBox vacuumCheckBox = formElementsView.findViewById(R.id.vacuum_checkBox);
        final CheckBox[] checkBoxes = {washCheckBox, dustCheckBox, sweepCheckBox, vacuumCheckBox};

        builder.setView(formElementsView)
                .setPositiveButton(R.string.add_item, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        for (CheckBox checkBox : checkBoxes) {
                            String checkBoxText = checkBox.getText().toString();
                            if (checkBox.isChecked()) {
                                selectedItems.add(checkBoxText);
                            }
                        }
                        for (String item : selectedItems) {
                            System.out.println("selected item: " + item);
                        }
                        // Save to sharedPreferences
                        Toast.makeText(getActivity(), "You clicked the add item button", Toast.LENGTH_SHORT).show();
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
}
