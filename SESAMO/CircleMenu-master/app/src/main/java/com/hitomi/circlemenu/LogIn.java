package com.hitomi.circlemenu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class LogIn extends AppCompatActivity {
    private static String NAMESPACE = "http://172.26.10.132/canisimo/";
    private static String URL = "http://172.26.10.132/canisimo/server.php?wsdl";
    private String respuesta;

    private TextView txtMail;
    private TextView txtPass;
    private Button btnAcceder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        txtMail = (TextView)findViewById(R.id.correoLogin);
        txtPass = (TextView)findViewById(R.id.contraLogin);
        btnAcceder = (Button)findViewById(R.id.accederLogin);

        btnAcceder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AsyncCallws task = new AsyncCallws();
                task.execute();
            }
        });
    }

    private class AsyncCallws extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params)	{
            String METHOD_NAME = "login";
            String SOAP_ACTION = "loginAction";
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("mail", txtMail.getText().toString());

            String hash = "";

            SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
            byte[] digest = digestSHA3.digest(txtPass.getText().toString().getBytes());
            hash = Hex.toHexString(digest);

            request.addProperty("password", hash);
            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.setOutputSoapObject(request);
            try	{
                HttpTransportSE transporte = new HttpTransportSE(URL);
                transporte.call(SOAP_ACTION, soapEnvelope);
                // Se procesa el resultado devuelto
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
            //Toast.makeText(getApplicationContext(), "s."+respuesta, Toast.LENGTH_LONG).show();
            if(!respuesta.equals("false"))   {
                Intent a = new Intent(getApplicationContext(), MenuTecnicos.class);
                a.putExtra("permiso",respuesta);
                startActivity(a);
            }
            else if(respuesta.equals("ERROR"))    {
                Toast.makeText(getApplicationContext(), "Hubo un problema de conexión", Toast.LENGTH_LONG).show();
            }
            else    {
                /*AsyncCallws2 task = new AsyncCallws2();
                task.execute();*/
            }
        }
    }

    /*private class AsyncCallws2 extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params)	{
            String METHOD_NAME = "checkContrasena";
            String SOAP_ACTION = "checkContrasenaAction";
            SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
            request.addProperty("mail", txtMail.getText().toString());
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
            AlertDialog.Builder builder = new AlertDialog.Builder(LogIn.this);
            builder.setTitle("Primer ingreso");
            builder.setMessage("Primera vez de ingreso, ¿desea registrar su contraseña?");
            builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent a = new Intent(getApplicationContext(), contrasena.class);
                    a.putExtra("correo",txtMail.getText().toString());
                    startActivity(a);
                }
            });
            builder.setNegativeButton("Cancel", null);
            AlertDialog dialogo = builder.create();

            if(respuesta.equals(false))   {
                dialogo.show();
            }
            else    {
                showToast();
            }
        }
    }*/

    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup)findViewById(R.id.toast_root));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);

        toast.setView(layout);

        toast.show();
    }

}

