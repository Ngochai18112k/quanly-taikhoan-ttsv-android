package com.example.quanlytaikhoanthanhtoansinhvien.TrangChu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quanlytaikhoanthanhtoansinhvien.DangKyMonHoc.MonHocController;
import com.example.quanlytaikhoanthanhtoansinhvien.Login.LoginController;
import com.example.quanlytaikhoanthanhtoansinhvien.NapTienTaiKhoan.NapTienController;
import com.example.quanlytaikhoanthanhtoansinhvien.R;
import com.example.quanlytaikhoanthanhtoansinhvien.ThongTinDangKyLop.TTDangKyLopController;

public class TrangChuController extends AppCompatActivity {
    Button btnDangKyMonHoc,btnCacKhoan,btnNapTien, btnMonHocDaDangKy,btnTTDangKyLop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWitget();

        dangKyMonHoc();
        cacKhoan();
        napTien();
        monHocDaDangKy();
        thongTinDKLop();
    }
    private void getWitget(){
        btnDangKyMonHoc=(Button)findViewById(R.id.btnDangKyMonHoc);
        btnCacKhoan=(Button)findViewById(R.id.btnCacKhoan);
        btnNapTien=(Button)findViewById(R.id.btnNapTien);
        btnMonHocDaDangKy=(Button)findViewById(R.id.btnMonHocDaDangKy);
        btnTTDangKyLop=(Button)findViewById(R.id.btnTTDangKyLop);
    }
    private void dangKyMonHoc(){
        btnDangKyMonHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getBaseContext(), MonHocController.class);
                startActivity(intent1);
            }
        });
    }
    private void cacKhoan(){
        btnCacKhoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getBaseContext(), com.example.quanlytaikhoanthanhtoansinhvien.DanhSachCacKhoanDaThanhToan.MainActivity.class);
                startActivity(intent2);
            }
        });
    }
    private void napTien(){
        btnNapTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getBaseContext(), NapTienController.class);
                startActivity(intent3);
            }
        });
    }
    private void monHocDaDangKy(){
        btnMonHocDaDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getBaseContext(), com.example.quanlytaikhoanthanhtoansinhvien.QuanLyMonHocDaDangKy.MainActivity.class);
                startActivity(intent4);
            }
        });
    }
    private void thongTinDKLop(){
        btnTTDangKyLop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(getBaseContext(), TTDangKyLopController.class);
                startActivity(intent5);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_trangchu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_trangchuadmin_thoat:
                dangxuat();
                break;
            default:
                Toast.makeText(this, "không co", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
    private void dangxuat(){
        Intent intent=new Intent(TrangChuController.this, LoginController.class);
        startActivity(intent);
    }
}
