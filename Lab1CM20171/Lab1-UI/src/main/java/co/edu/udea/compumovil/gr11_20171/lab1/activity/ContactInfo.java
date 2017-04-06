package co.edu.udea.compumovil.gr11_20171.lab1.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import co.edu.udea.compumovil.gr11_20171.lab1.R;

public class ContactInfo extends AppCompatActivity {

    EditText telefonoInfoContact, correoInfoContact, direccionInfoContact;
    AutoCompleteTextView autoCompletePais, autoCompleteCiudad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        telefonoInfoContact = (EditText) findViewById(R.id.phone);
        correoInfoContact = (EditText) findViewById(R.id.email);
        direccionInfoContact = (EditText) findViewById(R.id.address);
        autoCompletePais = (AutoCompleteTextView) findViewById(R.id.country);
        autoCompleteCiudad = (AutoCompleteTextView) findViewById(R.id.city);

        String[] paises = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> adapterCountries = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, paises);
        autoCompletePais.setAdapter(adapterCountries);

        String[] ciudades = getResources().getStringArray(R.array.cities_arrays);
        ArrayAdapter<String> adapterCities = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ciudades);
        autoCompleteCiudad.setAdapter(adapterCities);
    }

    public void showNextActivity(View view) {
        if (validarCampos()) {
            Bundle datos = getIntent().getBundleExtra("datos");

            datos.putString("Telefono", telefonoInfoContact.getText().toString());
            datos.putString("Correo", correoInfoContact.getText().toString());
            datos.putString("Direccion", direccionInfoContact.getText().toString());
            datos.putString("Ciudad", autoCompleteCiudad.getText().toString());
            datos.putString("Pais", autoCompletePais.getText().toString());

            Intent otherInfo = new Intent(view.getContext(), OtherInfo.class);
            otherInfo.putExtra("datos", datos);
            startActivity(otherInfo);
        }
    }

    private boolean validarCampos() {
        if(telefonoInfoContact.getText().length() == 0) {
            telefonoInfoContact.setError("Coloca un telefono valido");
            return false;
        }
        if(autoCompletePais.getText().length() == 0) {
            autoCompletePais.setError("Seleccionar un país");
            return  false;
        }
        if (autoCompleteCiudad.getText().length() == 0) {
            autoCompleteCiudad.setError("Seleccionar una Ciudad");
            return false;
        }
        if (direccionInfoContact.getText().length() == 0) {
            direccionInfoContact.setError("Coloca una direccion valida");
            return false;
        }
        if (correoInfoContact.getText().length() == 0) {
            correoInfoContact.setError("Coloca un correo valido");
            return false;
        }
        return true;
    }
}
