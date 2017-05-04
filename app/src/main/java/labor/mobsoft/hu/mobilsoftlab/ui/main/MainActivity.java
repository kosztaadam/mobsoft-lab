package labor.mobsoft.hu.mobilsoftlab.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import labor.mobsoft.hu.mobilsoftlab.MobSoftApplication;
import labor.mobsoft.hu.mobilsoftlab.R;
import labor.mobsoft.hu.mobilsoftlab.model.User;
import labor.mobsoft.hu.mobilsoftlab.ui.list.ListActivity;

public class MainActivity extends AppCompatActivity implements MainScreen {

    Button b1;
    EditText ed1, ed2;

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobSoftApplication.injector.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button);
        ed1 = (EditText) findViewById(R.id.editText);
        ed2 = (EditText) findViewById(R.id.editText2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!ed1.getText().toString().isEmpty() && !ed2.getText().toString().isEmpty()) {
                    mainPresenter.getUsers();

                } else {
                    Toast.makeText(getApplicationContext(), "A felhasznalonev es jelszo nem lehet ures!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainPresenter.detachScreen();
    }


    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getAuth(List<User> users) {

        for (User user : users) {
            if (ed1.getText().toString().equals(user.getUsername())) {
                startActivity(new Intent(this, ListActivity.class));
                return;
            }
        }

        Toast.makeText(this, "Helytelen felhasznalonev vagy jelszo!", Toast.LENGTH_SHORT).show();

    }
}
