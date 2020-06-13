package entities;

public class SanPham {
	private int maSP;
	private String tenSP;
	private int gia;
	private int soLuong;
	private String hinh;
	private int maDM;
	public int getMaSP() {
		return maSP;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public int getMaDM() {
		return maDM;
	}
	public void setMaDM(int maDM) {
		this.maDM = maDM;
	}
	public SanPham(int maSP, String tenSP, int gia, int soLuong, String hinh, int maDM) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.gia = gia;
		this.soLuong = soLuong;
		this.hinh = hinh;
		this.maDM = maDM;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
