package entities;

public class Item {
	private SanPham sanpham;
	private int count;
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int gia() {
		return sanpham.getGia()*count;
	}
	public Item(SanPham sanpham, int count) {
		super();
		this.sanpham = sanpham;
		this.count = count;
	}
	
}
