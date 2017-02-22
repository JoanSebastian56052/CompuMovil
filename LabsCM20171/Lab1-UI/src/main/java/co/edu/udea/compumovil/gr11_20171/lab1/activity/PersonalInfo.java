package co.edu.udea.compumovil.gr11_20171.lab1.activity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

import co.edu.udea.compumovil.gr11_20171.lab1.util.DatePickerFragment;
import co.edu.udea.compumovil.gr11_20171.lab1.R;


public class PersonalInfo extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    EditText input_nombres;
    EditText input_apellidos;
    RadioGroup rgSexo;
    Spinner sprGradoEscolaridad;
    Date fechaNaci;
    TextView fecha;
    RadioButton rbChecked;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        input_nombres = (EditText) findViewById(R.id.name);
        input_apellidos = (EditText) findViewById(R.id.lastName);
        rgSexo = (RadioGroup) findViewById(R.id.gender);
        sprGradoEscolaridad = (Spinner) findViewById(R.id.gradeSchool);
        sprGradoEscolaridad.setPrompt("Siguiente");
        sprGradoEscolaridad.setSelection(-1);
        fecha = (TextView) findViewById(R.id.txtDate);

    }

    public void showDatePicker(View view) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getFragmentManager(), "timePicker");
    }

    public void showNextActivity(View view) {
        if (validarCampos()) {
        Bundle datos = new Bundle();

        datos.putString("Nombres", input_nombres.getText().toString());
        datos.putString("Apellidos", input_apellidos.getText().toString());

        rbChecked = (RadioButton) findViewById(rgSexo.getCheckedRadioButtonId());
        datos.putString("Sexo", rbChecked.getText().toString());
        datos.putString("FechaNaci", fechaNaci.toString());
        datos.putString("Grado", sprGradoEscolaridad.getSelectedItem().toString());

        Intent otherInfo = new Intent(view.getContext(), ContactInfo.class);
        otherInfo.putExtra("datos", datos);
        startActivity(otherInfo);
    }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        fechaNaci = new Date(year,month,dayOfMonth);
        fecha.setText(dayOfMonth+"/"+month+"/"+year);
    }




    private boolean validarCampos() {
        if(input_nombres.getText().length()==0){
            input_nombres.setError("Coloca un nombre valido");
            return false;
        }
        if(input_apellidos.getText().length() == 0) {
            input_apellidos.setError("Coloca un apellido valido");
            return  false;
        }
        if (rbChecked.getText().length() == 0) {
            rbChecked.setError("Seleccione un genero");
            return false;
        }
        if (fecha.getText().length() == 0) {
            fecha.setError("Seleccione una fecha");
            return false;
            }
        return true;
    }
}
