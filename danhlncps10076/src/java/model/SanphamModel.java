package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.DanhMuc;
import entities.SanPham;

public class SanphamModel {
	public ArrayList getList() {
		ArrayList<SanPham> list = new ArrayList<>();
		Connection con= new MyConnect().getcn();
		if(con==null) {
			return null;
		}
		String sql= "select * from SanPham";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				SanPham sp = new SanPham();
				sp.setMaSP(rs.getInt(1));
				sp.setTenSP(rs.getString(2));
				sp.setGia(rs.getInt(3));
				sp.setSoLuong(rs.getInt(4));
				sp.setHinh(rs.getString(5));
				sp.setMaDM(rs.getInt(6));
				list.add(sp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public int insertSanPham(SanPham a) {
		Connection con= new MyConnect().getcn();
		if(con==null) {
			return 0;
		}
		String sql= "SET IDENTITY_INSERT SANPHAM ON\r\n" + 
				"insert into SANPHAM(MaSP,TenSP,DonGia,SoLuong,Hinh,MaDM) values (?,?,?,?,?,?)"
				+ "\r\nSET IDENTITY_INSERT SANPHAM OFF ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, a.getMaSP());
			ps.setString(2, a.getTenSP());
			ps.setInt(3, a.getGia());
			ps.setInt(4, a.getSoLuong());
			ps.setString(5, a.getHinh());
			ps.setInt(6, a.getMaDM());
			if(ps.executeUpdate()>0) {
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}public int deleteSanPham(String maSP) {
		Connection con= new MyConnect().getcn();
		if(con==null) {
			return 0;
		}
		String sql= "SET IDENTITY_INSERT SANPHAM ON\r\n" + 
				"Delete SANPHAM where MaSP=?"
				+ "\r\nSET IDENTITY_INSERT SANPHAM OFF ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, maSP);
			if(ps.executeUpdate()>0) {
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	public int updateSanPham(SanPham a) {
		Connection con= new MyConnect().getcn();
		if(con==null) {
			return 0;
		}
		String sql= "SET IDENTITY_INSERT SANPHAM ON\r\n" + 
				"update SANPHAM set TenSP=?,DonGia=?,SoLuong=?,Hinh=?,MaDM=? where MaSP=?"
				+ "\r\nSET IDENTITY_INSERT SANPHAM OFF ";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, a.getTenSP());
			ps.setInt(2, a.getGia());
			ps.setInt(3, a.getSoLuong());
			ps.setString(4, a.getHinh());
			ps.setInt(5, a.getMaDM());
			ps.setInt(6, a.getMaSP());
			if(ps.executeUpdate()>0) {
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	public ArrayList<DanhMuc> danhMuc() {
		ArrayList<DanhMuc> list = new ArrayList<>();
		Connection con= new MyConnect().getcn();
		if(con==null) {
			return null;
		}
		String sql= "select * from DANHMUC";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				DanhMuc dm= new DanhMuc();
				dm.setMaDM(rs.getInt(1));
				dm.setTenDM(rs.getString(2));
				list.add(dm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList getListMSP() {
		ArrayList<Integer> list = new ArrayList<>();
		Connection con= new MyConnect().getcn();
		if(con==null) {
			return null;
		}
		String sql= "select * from SanPham";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int maSP= rs.getInt(1);
				list.add(maSP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public SanPham getSPByMSP(String maSP) {
		ArrayList<Integer> list = new ArrayList<>();
		Connection con= new MyConnect().getcn();
		SanPham sp = new SanPham();
		if(con==null) {
			return null;
		}else {
			String sql= "select * from SanPham where MaSP=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, maSP);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					 sp = new SanPham(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getInt(6));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return sp;
	}
}
