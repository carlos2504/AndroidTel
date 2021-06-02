package com.ceoc.telefono;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.Toast;

import java.security.acl.Permission;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CALL = 1;
    private Button contacto_1;
    private Button contacto_2;
    private Button contacto_3;
    private Button contacto_4;
    private Button contacto_5;
    private Button contacto_6;
    private Button fin;
    private String seleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacto_1 = findViewById(R.id.btn_1);
        contacto_1.setOnClickListener(this);
        contacto_2 = findViewById(R.id.btn_2);
        contacto_2.setOnClickListener(this);
        contacto_3 = findViewById(R.id.btn_3);
        contacto_3.setOnClickListener(this);
        contacto_4 = findViewById(R.id.btn_4);
        contacto_4.setOnClickListener(this);
        contacto_5 = findViewById(R.id.btn_5);
        contacto_5.setOnClickListener(this);
        contacto_6 = findViewById(R.id.btn_6);
        contacto_6.setOnClickListener(this);
    }


    public void openPhone(String phone) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse(phone));
            startActivity(intent);
        } else {
            seleccionado = phone;
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
        }
    }

    public void onRequestPermissionsResult(int requestcode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestcode, permissions, grantResults);
        switch (requestcode) {
            case REQUEST_CALL:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openPhone(seleccionado);
                } else {
                    Toast.makeText(this, "La aplicación no tiene permiso para usar el teléfono", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public void onClick(View view) {
        if (view.equals(contacto_1)) {
            openPhone("tel:551498637");
        } else if (view.equals(contacto_2)) {
            openPhone("tel:553691254");
        } else if (view.equals(contacto_3)) {
            openPhone("tel:553481255");
        } else if (view.equals(contacto_4)) {
            openPhone("tel:55397841");
        } else if (view.equals(contacto_5)) {
            openPhone("tel:558715963");
        } else if (view.equals(contacto_6)) {
            openPhone("tel:558935621");

        }
    }
}