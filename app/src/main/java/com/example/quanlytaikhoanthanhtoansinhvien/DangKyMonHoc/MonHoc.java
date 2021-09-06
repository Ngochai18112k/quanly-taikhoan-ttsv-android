package com.example.quanlytaikhoanthanhtoansinhvien.DangKyMonHoc;

public class MonHoc {
    private int Id;
    private String TenMon;
    private String NgayDangKy;
    private int SoTin;
    private double Tien;

    public MonHoc(int id, String tenMon, String ngayDangKy, int soTin, double tien) {
        Id = id;
        TenMon = tenMon;
        NgayDangKy = ngayDangKy;
        SoTin = soTin;
        Tien = tien;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public String getTenMon() {
        return TenMon;
    }

    public String getNgayDangKy() {
        return NgayDangKy;
    }

    public int getSoTin() {
        return SoTin;
    }

    public double getTien() {
        return Tien;
    }



    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public void setNgayDangKy(String ngayDangKy) {
        NgayDangKy = ngayDangKy;
    }

    public void setSoTin(int soTin) {
        SoTin = soTin;
    }

    @Override
    public String toString() {
        return
                "Mã môn học: " + Id + "\n"+
                        "Tên Môn: '" + TenMon + "\n" +
                        "Ngày đăng kí: '" + NgayDangKy + "\n" +
                        "Số tín: " + SoTin +
                        "Giá tiền: " + Tien + "VND"+"\n"+
                "------------------------------------------------------------------";
    }

    public void setTien(double tien) {
        Tien = tien;
    }
}
