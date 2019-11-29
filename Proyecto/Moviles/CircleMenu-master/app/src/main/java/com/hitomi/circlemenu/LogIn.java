package com.hitomi.circlemenu;

import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class LogIn extends AppCompatActivity {
    private static String NAMESPACE = "http://172.26.10.109/canisimo/";
    private static String URL = "http://172.26.10.109/canisimo/server.php?wsdl";
    //private String respuesta;

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
            private Object Intent;

            @Override
            public void onClick(View v) {
                AsyncCallws task = new AsyncCallws();
                task.execute();
            }
        });
    }

    private void consultarBasicaWs()	{
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
            //Se procesa el resultado devuelto
            SoapPrimitive resultado_xml = (SoapPrimitive) soapEnvelope.getResponse();
            respuesta = resultado_xml.toString();
        }
        catch(Exception e)	{
            e.printStackTrace();
           respuesta = "ERROR";
        }
    }

    private class AsyncCallws extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params)	{
            consultarBasicaWs();
            return null;
        }

       protected void onPostExecute(Void result)	{
            AlertDialog.Builder builder = new AlertDialog.Builder(LogIn.this);
            builder.setTitle("Resultado");
            builder.setMessage(respuesta);
            builder.setNeutralButton("OK", null);
            AlertDialog dialogo = builder.create();
            dialogo.show();
        }
    }

}

