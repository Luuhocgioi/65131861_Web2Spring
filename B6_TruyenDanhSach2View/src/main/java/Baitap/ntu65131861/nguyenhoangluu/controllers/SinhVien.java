package Baitap.ntu65131861.nguyenhoangluu.controllers;

public class SinhVien {
	String mssv, name, namsinh, gtinh;

	public SinhVien(String mssv, String name, String namsinh, String gtinh) {
		this.mssv = mssv;
		this.name = name;
		this.namsinh = namsinh;
		this.gtinh = gtinh;
	}
	public SinhVien() {}
	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(String namsinh) {
		this.namsinh = namsinh;
	}

	public String getGtinh() {
		return gtinh;
	}

	public void setGtinh(String gtinh) {
		this.gtinh = gtinh;
	}
	
}
