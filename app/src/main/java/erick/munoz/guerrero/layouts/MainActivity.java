package erick.munoz.guerrero.layouts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private EditText userName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText) findViewById(R.id.usernameEditText);
        password = (EditText) findViewById(R.id.passwordEditText);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(passValidation()){
                    checkCredentials();
                }
            }
        });
    }

    private boolean checkCredentials() {
        boolean rightCredentials=true;
        userName.setError(null);
        password.setError(null);
        String usernameText = userName.getText().toString();
        String passwordText = password.getText().toString();
        if(usernameText.equalsIgnoreCase("Erick")){
            if(passwordText.equalsIgnoreCase("admin")){
                //las credenciales son correctas
                Toast.makeText(this, "Bienvenido :v", Toast.LENGTH_SHORT).show();
            }else{
                password.setError("Contraseña incorrecta");
                rightCredentials=false;
            }
        }else{
            userName.setError("El usuario no es correcto");
            rightCredentials=false;
        }
        return rightCredentials;
    }

    private boolean passValidation() {
        boolean passValidation=true;
        userName.setError(null);//si no hacemos esto, cada no se le va a quitar el error
        password.setError(null);//le quitamos el error :v
        String userNameText = userName.getText().toString();
        String passText = password.getText().toString();

        if(userNameText.length()==0){
            userName.setError("Username no puede quedar vacío");//ta vergas, no lo conocía
            passValidation=false;
        }
        if(passText.length()==0){
            password.setError("Password no puede quedar vacío");//le ponemos el error
            passValidation=false;
        }

        return passValidation;
    }


}
