package com.example.allyoucanpark;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Login extends AppCompatActivity {

    // Instanzvariablen der xml-Elemente
    EditText usernameEditText;
    EditText passwortEditText;
    Button finalLoginBtn;

    TextView testTV;

    // Instanzvariablen für das einlesen des JSON Strings
    // todo: put the final url + test
    private static String LOGIN_URL = "localhost:8080/api/v1/benutzer";
    List<HashMap<String,String>> userList;
    private String useridStrg;
    private String userNameStrg;
    private String passwortStrg;
    private String emailStrg;

    Boolean input;

    // todo delete Testlistview
    ListView testListV;
    SimpleAdapter showUserAdapter;

    static String inputName;
    String inputPasswort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        // xml-Elemente verknüpfen per "find view by ID"
        usernameEditText = findViewById(R.id.usernameLoginEditText);
        passwortEditText = findViewById(R.id.passwortLoginEditText);
        finalLoginBtn = findViewById(R.id.finalLoginLoginBtn);
        testTV = findViewById(R.id.textViewLoginTest);

        // Initialisiere Userlist
        userList = new ArrayList<>();

        // OnClickListener für das Login, der
        // - prüft, ob die Logindaten korrekt sind
        // --> Wenn ja: todo weiterleitung zur verwaltung der user daten oder ins menü?
        // --> Wenn nicht: korrekte fehlermeldung, wenn
        //          - Passwort nicht stimmt
        //          - Username nicht stimmt
        //          - Account nicht existiert
        finalLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check in the user input
                inputName = usernameEditText.getText().toString();
                inputPasswort = passwortEditText.getText().toString();
                if (inputName.isEmpty()||inputPasswort.isEmpty()){
                    // Toast-Message for little pop up "Error"-Messages
                    Toast.makeText(Login.this,"Deine Angaben sind noch unvollständig. Bitte fülle alle Felder aus!", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Create an Object of getData Innerclass to run the background process of reading in the json
                    GetData getData = new GetData();
                    getData.execute();
                }

                // Test verarbeiten der Daten im Onclick
//                showUserAdapter = new SimpleAdapter(
//                        Login.this,
//                        userList,
//                        R.layout.row_layout,
//                        new String[]{"username","passwort"},
//                        new int[]{R.id.textViewRowLayout, R.id.textViewRowLayout2}
//                );
//                testListV.setAdapter(showUserAdapter);


                // Prüfen ob Username und Passwort korrekt eingegeben sind
                // - Ist eins der beiden Felder leer?

                // Stimmen die eingegebenen Userdaten?

            }
        });
    }

    // Innerclass for Async Task because URL Json read only works as a background process
    public class GetData extends AsyncTask<String,String,String> {

        // Create the Http Connection
        @Override
        protected String doInBackground(String... strings) {
            // String, der alle chars des jsons-Strings speichert
            String current = "";

            URL url;
            HttpURLConnection urlConnection = null;

            try {
                // Http Verbindung herstellen
                url = new URL(LOGIN_URL);
                urlConnection = (HttpURLConnection) url.openConnection();

                try {
                    // InputStream einlesen
                    InputStream in = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(in);

                    int data = isr.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isr.read();
                    }

                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                // Important to close and disconnect Url connection
                finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            try {


                // Initialisiere JSON Object und -Array
//                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = new JSONArray(s);

                // Iteriere über das JSON-Array, um die darin enthaltenen JSON-OBjects herauszubekommen und in der
                // HashMap-Liste zu speichern
                for (int i = 0; i < jsonArray.length(); i++) {
                    // get the json objekt in the json array at index i
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    // get the values and save them into the variables (changes with every iteration in this for loop
//                    useridStrg = jsonObject1.getString("userid");
                    userNameStrg = jsonObject1.getString("username");
                    passwortStrg = jsonObject1.getString("passwort");
//                    emailStrg = jsonObject1.getString("email");

                    // Making a HashMap
                    HashMap<String, String> users = new HashMap<>();

                    // Add the values to the Hashmap
                    // Eine Hashmap speichert so alle userdaten
//                    users.put("userid",useridStrg);
                    users.put("username", userNameStrg);
                    users.put("passwort", passwortStrg);
//                    users.put("email",emailStrg);

                    // add this hashmap to the Arraylist
                    userList.add(users);

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            Boolean input = validateValue(inputName, inputPasswort);
            if (input) {
                Toast.makeText(Login.this,"Login erfolgreich!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Login.this, Welcome.class);
                startActivity(intent);
                // Todo: show welcome page and they start activity but without login register part in the bottom region
            }
            else {
                Toast.makeText(Login.this,"Deine Angaben sind nicht korrekt! Username oder Passwort stimmen nicht.", Toast.LENGTH_SHORT).show();
            }


            // Test Darstellung im Listview
//            showUserAdapter = new SimpleAdapter(
//                    Login.this,
//                    userList,
//                    R.layout.row_layout,
//                    new String[]{"username","passwort"},
//                    new int[]{R.id.textViewRowLayout, R.id.textViewRowLayout2}
//            );
//            testListV.setAdapter(showUserAdapter);
        }
    }

    // Methode zum Prüfen des Usernames + Passwort auf Korrektheit (nur im Onclicklistener anwendbar, da Objekt der
    // Inner Class für das einlesen der JSON notwendig ist, sonst ist die Liste mit den user hashmaps nicht befüllt
    private Boolean validateValue(String username, String passwort) {
            int treffer = 0;

            // todo test with java, if it is written like this

            // mit for loop in die einzelnen hashmaps schauen
            for (HashMap i :
                    userList) {
                // check if key and value are in the hashmap
                String usernameMap = i.get("username").toString();
                String passwortMap = i.get("passwort").toString();

                testTV.setText(usernameMap + " " + passwortMap);

                if (username.equals(usernameMap)) {
                    if (passwort.equals(passwortMap)) {
                        treffer = 1;
                    }
                }
            }
            if (treffer == 1){
                return true;
            }
            else{
                return false;
            }

        }
    }