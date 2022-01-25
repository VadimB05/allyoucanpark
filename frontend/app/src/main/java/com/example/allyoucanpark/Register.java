package com.example.allyoucanpark;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Register extends AppCompatActivity {

    String jsonUserStrg;

    TextView registerTitleTV;
    TextView registerDetailsTV;
    EditText registerUsernameEditText;
    EditText registerEmailEditText;
    EditText registerPaswortEditText;
    Button registerRegisterButton;

    // Instanzvariablen für HTTP Post Request
    // todo: put url here ask oskar
    private static String REGISTER_URL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerTitleTV = findViewById(R.id.textViewRegisterTitle);
        registerDetailsTV = findViewById(R.id.textViewRegisterDetails);
        registerUsernameEditText = findViewById(R.id.editTextRegisterUsername);
        registerEmailEditText = findViewById(R.id.editTextRegisterEmailAdress);
        registerPaswortEditText = findViewById(R.id.editTextRegisterPasswort);
        registerRegisterButton = findViewById(R.id.buttonRegisterRegister);

        // todo: Prüfen ob PW zu Eigenschaften passt

        // Input in JSONformat umwandeln
        JSONObject newUserJSON = new JSONObject();
        try {
            newUserJSON.put("userid","004");
            newUserJSON.put("username", registerUsernameEditText.toString());
            newUserJSON.put("passwort", registerPaswortEditText.toString());
            newUserJSON.put("email", registerEmailEditText.toString());

            jsonUserStrg = newUserJSON.toString();
            // todo, dass mit nem outputstream an eine url senden, what happend then?
            // Object muss

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public class sendData extends AsyncTask<String,String,String>{
        // Input, Progress and Output

        @Override
        protected String doInBackground(String... strings) {
            URL url;
            HttpURLConnection urlConnection = null;
            byte [] jsonStringByteArray = jsonUserStrg.getBytes(StandardCharsets.UTF_8);
            int lenght = jsonStringByteArray.length;

            try {
                url = new URL(REGISTER_URL);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setUseCaches(false);
                urlConnection.setDoOutput(true);

                urlConnection.setFixedLengthStreamingMode(lenght);
                urlConnection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
                urlConnection.connect();
                try (OutputStream os = urlConnection.getOutputStream()){
                    os.write(jsonStringByteArray);
                }

//                try {
//                    // Outputstream erstellen
//                    OutputStream ops = urlConnection.getOutputStream();
//                    OutputStreamWriter opsW = new OutputStreamWriter(ops);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }


}