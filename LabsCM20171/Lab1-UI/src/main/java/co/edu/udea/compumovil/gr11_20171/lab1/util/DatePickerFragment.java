package co.edu.udea.compumovil.gr11_20171.lab1.util;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar calendario = Calendar.getInstance();
        int dia = calendario.get(Calendar.DAY_OF_MONTH);
        int mes = calendario.get(Calendar.MONTH);
        int ano = calendario.get(Calendar.YEAR);

        // Create a new instance of TimePickerDialog and return it
        DatePickerDialog dialogoFecha = new DatePickerDialog(getActivity(),this,ano,mes,dia);
        return dialogoFecha;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        ((DatePickerDialog.OnDateSetListener)getActivity()).onDateSet(view,year,month,dayOfMonth);
    }
}
