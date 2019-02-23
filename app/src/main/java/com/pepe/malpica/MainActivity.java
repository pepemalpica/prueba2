package com.pepe.malpica;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.pepe.malpica.models.Persona;
import com.pepe.malpica.models.ResponseModel;

public class MainActivity extends AppCompatActivity {

    private Toolbar tbMain;
    private ResponseModel mResponse;
    private TextView tvName, tvFirstName, tvSecondName, tvAge, tvElector, tvCurp, tvSex, tvCalle,
            tvLocalidad, tvMunicipio, tvEstado, tvCiudad, tvSeccion, tvSubtipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        mResponse = (ResponseModel) intent.getSerializableExtra("ResponseModel");

        tbMain = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(tbMain);

        setData();

    }

    @SuppressLint("SetTextI18n")
    private void setData() {

        Persona mPerson = mResponse.getPersona();

        //find TextsViews
        tvName = findViewById(R.id.tv_name);
        tvFirstName = findViewById(R.id.tv_first_name);
        tvSecondName = findViewById(R.id.tv_second_name);
        tvAge = findViewById(R.id.tv_age);
        tvElector = findViewById(R.id.tv_elector);
        tvCurp = findViewById(R.id.tv_curp);
        tvSex = findViewById(R.id.tv_sex);
        tvCalle = findViewById(R.id.tv_calle);
        tvLocalidad = findViewById(R.id.tv_localidad);
        tvMunicipio = findViewById(R.id.tv_municipio);
        tvEstado = findViewById(R.id.tv_estado);
        tvCiudad = findViewById(R.id.tv_cuidad);
        tvSeccion = findViewById(R.id.tv_seccion);
        tvSubtipo = findViewById(R.id.tv_subtipo);

        //setData
        tvName.setText( "Nombre: " + mPerson.getNombres() );
        tvFirstName.setText( "Primer apellido: " + mPerson.getPrimerApellido() );
        tvSecondName.setText( "Segundo apellido: " + mPerson.getSegundoApellido() );
        tvAge.setText( "Edad: " + mPerson.getEdad() );
        tvElector.setText( "Clave elector: " + mPerson.getClaveElector() );
        tvCurp.setText( "Curp: " + mPerson.getCurp() );
        tvSex.setText( "Sexo: " + mPerson.getSexo() );
        tvCalle.setText( "Calle: " + mPerson.getCalle() );
        tvLocalidad.setText( "Localidad: " + mPerson.getLocalidad() );
        tvMunicipio.setText( "Municipio: " + mPerson.getMunicipio() );
        tvEstado.setText( "Estado: " + mPerson.getEstado() );
        tvCiudad.setText( "Ciudad: " + mPerson.getCiudad() );
        tvSeccion.setText( "Sección: " + mPerson.getSeccion() );
        tvSubtipo.setText( "Subtipo: " + mPerson.getSubTipo() );

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_array:
                goToArray();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void goToArray() {
        Intent intent = new Intent(this, ArrayActivity.class);
        startActivity(intent);
    }

}

