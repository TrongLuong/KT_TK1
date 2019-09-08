package com.example.kt_tk;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText tk, mk;
    CheckBox cb;
    Button dn, close;
    TextView tt;
    public void anhXa(){
        tk = findViewById(R.id.edtTK);
        mk = findViewById(R.id.edtPass);
        cb = findViewById(R.id.checkbox1);
        dn = findViewById(R.id.btnDN);
        close = findViewById(R.id.btnClose);
        tt = findViewById(R.id.txtTT);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();

        dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb.isChecked()==true){
                    Toast.makeText(MainActivity.this,"Thông tin đã được lưu!", Toast.LENGTH_LONG).show();
                    tt.setText( tk.getText().toString());


                }else {
                    Toast.makeText(MainActivity.this, "Không lưu thông tin!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());

                builder.setTitle("Xác nhận!");
                builder.setMessage("Bạn có muốn thoát không!");

                builder.setPositiveButton(getResources().getString(R.string.y), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton(getResources().getString(R.string.n), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog , int i) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
    }
}
