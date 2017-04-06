package co.edu.udea.compumovil.gr11_20171.lab1.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import co.edu.udea.compumovil.gr11_20171.lab1.R;

public class OtherInfo extends AppCompatActivity {

    TextView txResumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_info);

        txResumen = (TextView) findViewById(R.id.textResumen);
    }

    public void mostrarInformacion(View view) {
        Bundle datos = getIntent().getBundleExtra("datos");

        String nombres = datos.getString("Nombres");
        String apellidos = datos.getString("Apellidos");
        String sexo = datos.getString("Sexo");
        String fechaNaci = datos.getString("FechaNaci");
        String gradoEscolar = datos.getString("Grado");
        String telefono = datos.getString("Telefono");
        String correo = datos.getString("Correo");
        String pais = datos.getString("Pais");
        String ciudad = datos.getString("Ciudad");
        String direccion = datos.getString("Direccion");

        txResumen.setText(
                "Nombres"+" : "+nombres+
                "\n"+"Apellidos"+" : "+apellidos+
                "\n"+"Sexo"+" : "+sexo+
                "\n"+"Fecha de Nacimiento"+" : "+fechaNaci+
                "\n"+"Grado de Escolaridad"+" : "+gradoEscolar+
                "\n"+"Telefono"+" : "+telefono+
                "\n"+"Correo"+" : "+correo+
                "\n"+"País"+" : "+pais+
                "\n"+"Ciudad"+" : "+ciudad+
                "\n"+"Dirección"+" : "+direccion
        );
    }
}
