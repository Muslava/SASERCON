package com.hitomi.circlemenu;



import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.HashMap;
import java.util.Map;

public class contrasena extends AppCompatActivity {
    private static String NAMESPACE = "http://172.26.10.132/canisimo/";
    private static String URL = "http://172.26.10.132/canisimo/server.php?wsdl";
    private String respuesta;

    private TextView txtNC, txtCC;
    private Button btnAceptar, btnCancelar;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrasena);

        txtNC = (TextView)findViewById(R.id.txtNuevaContra);
        txtCC = (TextView)findViewById(R.id.txtConfirmarContra);

        btnAceptar = (Button)findViewById(R.id.btnICaceptar);
        btnCancelar = (Button)findViewById(R.id.btnICcancelar);

        email = getIntent().getStringExtra("correo");

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                asignarContrasena();
            }
        });
    }

    private void asignarContrasena()    {

        if(txtNC.length() >= 8) {
            if(txtNC.getText().length() == 0)    {
                Toast.makeText(getApplicationContext(), "Este campo no puede quedar vacío.", Toast.LENGTH_LONG).show();
            }
            if(txtCC.getText().length() == 0)    {
                Toast.makeText(getApplicationContext(), "Vuelva a repetir la contraseña.", Toast.LENGTH_LONG).show();
            }
            if(!(txtCC.getText().length() == 0 && txtNC.getText().length() == 0)) {
                    if(txtNC.equals(txtCC.getText()))   {
                        try {
                            contrasena.AsyncCallws task = new contrasena.AsyncCallws();
                            task.execute();
                        }
                        catch(Exception ex) {
                            Toast.makeText(getApplicationContext(), ""+ex, Toast.LENGTH_SHORT).show();
                        }
                    }
                    else    {
                        Toast.makeText(getApplicationContext(), "Las contraseñas deben coincidir.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        else    {
            Toast.makeText(getApplicationContext(), "La contraseña no debe ser menor a 8 caracteres.", Toast.LENGTH_LONG).show();
        }
    }


    private class AsyncCallws extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params)	{
            String METHOD_NAME = "newPass";
            String SOAP_ACTION = "newPassAction";
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

            request.addProperty("mail", email);

            String hash = "";

            SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
            byte[] digest = digestSHA3.digest(txtNC.getText().toString().getBytes());
            hash = Hex.toHexString(digest);

            request.addProperty("password", hash);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.setOutputSoapObject(request);
            try	{
                HttpTransportSE transporte = new HttpTransportSE(URL);
                transporte.call(SOAP_ACTION, soapEnvelope);
                //Se procesa el resultado devuelto
                SoapPrimitive resultado_xml = (SoapPrimitive) soapEnvelope.getResponse();
                respuesta = resultado_xml.toString();
            }
            catch(Exception e)	{
                e.printStackTrace();
                respuesta = "ERROR";
            }
            return null;
        }

        protected void onPostExecute(Void result)	{
            if(respuesta.equals("true"))   {
                AlertDialog.Builder builder = new AlertDialog.Builder(contrasena.this);
                builder.setTitle("Resultado");
                builder.setMessage("La constraseña fue correctamente actualizada.");
                builder.setNeutralButton("OK", null);
                AlertDialog dialogo = builder.create();
                dialogo.show();
                finish();
            }
            else    {
                AlertDialog.Builder builder = new AlertDialog.Builder(contrasena.this);
                builder.setTitle("Resultado");
                builder.setMessage("Hubo un problema. Favor de intentarlo más tarde o contactar a gerencia.");
                builder.setNeutralButton("OK", null);
                AlertDialog dialogo = builder.create();
                dialogo.show();
                finish();
            }
        }
    }
}
