/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DMI;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import com.google.crypto.tink.aead.AeadConfig;
import java.security.GeneralSecurityException;
import com.google.crypto.tink.Aead;
import com.google.crypto.tink.CleartextKeysetHandle;
import com.google.crypto.tink.JsonKeysetReader;
import com.google.crypto.tink.JsonKeysetWriter;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;
import com.mysql.jdbc.Blob;
import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import net.java.balloontip.BalloonTip;
import net.java.balloontip.styles.ModernBalloonStyle;

/**
 *
 * @author coner
 */
public class Comprobacion {

//private KeysetHandle keysetHandle = null;
private final String keysetFilename = "keyset.json";
    
    public boolean vacio(String a) {
        return a==null;
    }

    public boolean valtext(String a)    {
        return a.matches("[a-zA-Z]*")&&vacio(a)==false;
    }
    
    public boolean valint(String a) {
        return a.matches("[0-9]*")&&vacio(a)==false;
    }

    public boolean valchar(String a)    {
        return a.matches("[^0-9]*[a-zA-Z]{1}")&&vacio(a)==false;
    }
    
    public boolean valfloat(String a)   {
        return a.matches("[^a-zA-Z]*[0-9]*[.]?[0-9]{1,2}")&&vacio(a)==false;
    }
    
    public boolean valmail(String a)    {
        return a.matches("[-\\w\\.]+\\@{1}\\w+\\.\\w+")&&vacio(a)==false;
    }
    
    public boolean valhr(String a)  {
        return a.matches("[-\\w\\.]+\\:{1}\\w\\w+")&&vacio(a)==false;
    }
    
    public boolean valtel (String a)    {
        return a.length()==10&&valint(a)==true&&vacio(a)==false;
    }
    
    public boolean valmatricula(String a)   {
        return a.matches("[^a-zA-Z]{3}")&&vacio(a)==false;
    }
    
    public boolean valnss (String a)    {
        return a.length()==12&&valint(a)==true&&vacio(a)==false;
    }

    public boolean valcurp (String a)   {
        return a.matches("[^0-9]{4}[^a-zA-Z]{6}[^0-9]{6}[A-Z0-9]{2}")&&vacio(a)==false;
    }
    
    public boolean valrfc (String a)  {
        return a.matches("[^0-9]{4}[^a-zA-Z]{6}[a-zA-Z0-9]{3}")&&vacio(a)==false;
    }
    
    public boolean valne (String a) {
        return (a.matches("[0-9]*\\-{1}[a-zA-Z]{2}")||a.matches("[0-9]*")||a.matches("[0-9]*\\-{1}[a-zA-Z]*"))&&vacio(a)==false;
    }
    
    public boolean valni (String a) {
        return (a.matches("[0-9]*\\-{1}[a-zA-Z]{2}")||a.matches("[0-9]*")||a.matches("[0-9]*\\-{1}[a-zA-Z]*"))&&vacio(a)==false;
    }
    
    public boolean valcp (String a)    {
        return a.length()==5&&valint(a)==true&&vacio(a)==false;
    }
    
    public boolean valcel (String a)    {
        return a.length()==12&&valint(a)==true&&vacio(a)==false;
    }
    
    /* getSHA3 encrypt a string and returns a String data type
    */
    public String getSHA3 (String a) {
        SHA3.DigestSHA3 digestSHA3 = new SHA3.Digest512();
        byte[] digest = digestSHA3.digest(a.getBytes());
        return Hex.toHexString(digest);
    }
    
    /*
    NoClassDefFoundError? Try declaring the used libraries into the CLASSPATH variable environment!
    */
    public String getEncrypted(String a)   {
        try {
            KeysetHandle keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(new File(keysetFilename)));
            AeadConfig.register();
            Aead aead = keysetHandle.getPrimitive(Aead.class);
            byte[] ciphertext = aead.encrypt(a.getBytes(), associatedData.getBytes());
            String readable = new String(java.util.Base64.getEncoder().encode(ciphertext));
            return readable;
        }
        catch(GeneralSecurityException e) {
            Logger.getLogger(Comprobacion.class.getName()).log(Level.SEVERE, null, e);
            System.out.println("Security error: "+e);
            return "ERROR";
        }
        catch(IOException e) {
            Logger.getLogger(Comprobacion.class.getName()).log(Level.WARNING, null, e);
            System.out.println("File io error: "+e);
            System.out.println("Retrying...");
            NuevoKH();
            return getEncrypted(a);
        }
    }
    
    public String getDecrypted(String a) {
        try {
            KeysetHandle keysetHandle = CleartextKeysetHandle.read(JsonKeysetReader.withFile(new File(keysetFilename)));
            AeadConfig.register();
            Aead aead = keysetHandle.getPrimitive(Aead.class);
            byte[] bytesToDecrypt = java.util.Base64.getDecoder().decode(a.getBytes());
            String decrypted = new String(aead.decrypt(bytesToDecrypt, associatedData.getBytes()));
            return decrypted;
        }
        catch(GeneralSecurityException e) {
            //Logger.getLogger(encriptacion.class.getName()).log(Level.SEVERS, null, ex);
            System.out.println("Security error: "+e);
            return "ERROR";
        }
        catch(IOException e) {
            //Logger.getLogger(archivos.class.getName()).log(Level.MEDIUM, null, ex);
            System.out.println("File io error: "+e);
            return "ERROR";
        }
    }
    
    public void NuevoKH()   {
        try {
            AeadConfig.register();
            KeysetHandle keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES256_GCM);
            //Aead aead = keysetHandle.getPrimitive(Aead.class);
            CleartextKeysetHandle.write(keysetHandle, JsonKeysetWriter.withFile(new File(keysetFilename)));
            System.out.println("New KeysetHandle generated.");
        }
        catch(GeneralSecurityException e) {
            //Logger.getLogger(encriptacion.class.getName()).log(Level.SEVERS, null, ex);
            System.out.println("Security error: "+e);
        }
        catch(IOException e) {
            //Logger.getLogger(archivos.class.getName()).log(Level.MEDIUM, null, ex);
            System.out.println("File io error: "+e);
        }
    }
    
    public String enviarCorreo(String a, int b)   {
        
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host","smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable","true");
            props.setProperty("mail.smtp.port","587");
            props.setProperty("mail.smtp.auth","true");

            Session session = Session.getDefaultInstance(props);

            String correoRemitente = "elevadoresyderivadoss.sercon@gmail.com";
            String passwordRemitente = "contrasena123";
            String correoReceptor = "muslava@bk.ru";//cristianarg18@gmail.com";

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor));
            message.setSubject("Recuperación de cuenta");
            message.setText("Desde dónde\n" +
                    "Fecha y hora\n" +
                    "Haz solicitado la recuperación de tu cuenta.\n" +
                    "Este es tu código para la recuperación: "+b+
                    "\nATTE.: Área de sistemas de SERCON");

            Transport t = session.getTransport("smtp");
            t.connect(correoRemitente, passwordRemitente);
            t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
            
            return "";
        }
        /*catch(AddressException ex)	{
            //Logger.getLogger(envio.class.getName()).log(Level.SEVERS, null, ex);
            return false;
        }
        catch(MessagingException ex)    {
            //Logger.getLogger(envio.class.getName()).log(Level.SEVERS, null, ex);
            return false;
        }*/
        catch(Exception e)  {
            return "e";
        }
    }
    
    public BalloonTip balloontip(Component com, String tx, int gp, int pest)    {
        BalloonTip btLvalida = new BalloonTip(
            (JComponent) com,
            new JLabel(tx),
            new ModernBalloonStyle(2/*Contorno*/, 1/*Padding*/,
                new Color(146, 150, 153),   //Color1
                new Color(191, 192, 194),   //Color2
                new Color(178, 179, 179)),  //Contorno
            BalloonTip.Orientation.LEFT_BELOW,
            BalloonTip.AttachLocation.SOUTH,
            gp, // Espacio entre inicio del globo y la pestaña
            pest, // Tamaño de la pestaña
            true
        );
        return btLvalida;
    }
    
    public static void main(String []args)   {
        Comprobacion al = new Comprobacion();
        Scanner sc = new Scanner(System.in);
        //al.NuevoKH();
        String correo = "valentin@gmail.com",nombre = "Valentin",app = "Rodriguez", apm = "Mellado";
        System.out.println(al.getEncrypted(correo)+"\n"+al.getEncrypted(nombre)+"\n"+al.getEncrypted(app)+"\n"+al.getEncrypted(apm));
        correo = "juan@gmail.com";
        nombre = "christian@gmail.com";
        app = "david@gmail.com";
        apm = "brenda@gmail.com";
        String ampere = "julio@gmail.com";
        System.out.println(al.getEncrypted(correo)+"\n"+al.getEncrypted(nombre)+"\n"+al.getEncrypted(app)+"\n"+al.getEncrypted(apm)+"\n"+al.getEncrypted(ampere));
        //System.out.println(encr);
        //String back = new String(bait);
        //System.out.println(back);
        
        //String back = new String(al.getEncrypted(asd));
        //byte[] asdd = (sc.next()).getBytes();
        //System.out.println(asdd);
        //String asda = sc.next();
        //System.out.println(al.getDecrypted(asda));
        
        /*Comprobacion al = new Comprobacion();
        try {
            ConexionMySQL cmysql = new ConexionMySQL();
            Connection conec = (Connection) cmysql.Conectar();

            String senSQL = "INSERT INTO prueba VALUES('"+al.getEncrypted(asd)+"')";
            PreparedStatement ps = conec.prepareStatement(senSQL);
            int n = ps.executeUpdate();
            if (n > 0)  {
                System.out.println("Success!!");
            }
            Statement st = conec.createStatement();
            ResultSet rs = st.executeQuery("SELECT b FROM prueba");
            while(rs.next()) {
                System.out.println(al.getDecrypted(rs.getString("b")));
            }
        }
        catch( SQLException ex )    {
            JOptionPane.showMessageDialog(null,ex,"SQL error",2);
        }*/
        
    }
    
private final String associatedData = "26669,46663,56663";//.getBytes();
}
