/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Account;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author home
 */
public class AccountModel {

    public AccountModel() {
    }
   
    //1. ham checkLogin
    // - input : mot tai khoan Account acc
    // - output :
    // + return -1 : ket noi khong duoc
    // + return 1 : dang nhap thanh cong
    // + reurn 0 : dang nhap that bai
    public int checkLogin(Account acc)
    {
        //1. tao 1 doi tuong ket noi
        Connection con = new MyConnect().getcn();
        if (con == null)
            return -1; // ket noi khong duoc ===> ket thuc ham luon
        
        try {
            String sql = "select * from Account where username =?  and password= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            //2. truyen vao cho hai tham so ...
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            //3. thuc thi
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                return 1; // dang nhap thanh cong
            }
            else
            {
                return 0; // dang nhap that bai
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0; // dang nhap that bai
        }        
        
    }
    
    //2. hàm lấy danh sách tài khoản getList
    public ArrayList getList(){
        //1. khai báo
        ArrayList<Account> list = new ArrayList<>();
        //2. tạo doi tuong ket nối
        Connection con = new MyConnect().getcn();
        if (con == null){
            return null; // khong kết nối được==> kêt thúc hàm
        }
        try {
            String sql = "select * from Account";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); // thực thi
            while (rs.next()){
                //1. tạo 1 đối tượng tài khoản
                Account acc = new Account();
                //2. gán giá trị vào cho acc
                acc.setUsername(rs.getString(1));
                acc.setPassword(rs.getString(2));
                //3. thêm tài khoản acc vào list
                list.add(acc);
            }
            ps.close();
            con.close(); // 4. đóng kết nối
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; //5 trả về danh sách tài khoản
    }
    //3. hàm thêm tài khoản insertAccount
    public int insertAccount(Account acc){
        int kq = 0;
        //1. kết nối
        Connection con = new MyConnect().getcn();
        if (con == null){
            return -1; // không ket noi duoc csdl
        }
        try {
            String sql = "insert into Account values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            kq = ps.executeUpdate(); // kq = 1 thêm thành công kq = 0 thêm thất bại
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
    public int deleteAccount(Account acc){
        int kq = 0;
        //1. kết nối
        Connection con = new MyConnect().getcn();
        if (con == null){
            return -1; // không ket noi duoc csdl
        }
        try {
            String sql = "Delete from account where username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            kq = ps.executeUpdate(); // kq = 1 thêm thành công kq = 0 thêm thất bại
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }
    public int updateAccount(Account acc, Account accNew){
        int kq = 0;
        //1. kết nối
        Connection con = new MyConnect().getcn();
        if (con == null){
            return -1; // không ket noi duoc csdl
        }
        try {
            String sql = "update account set password=? where username=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, accNew.getPassword());
            ps.setString(2, acc.getUsername());
            kq = ps.executeUpdate(); // kq = 1 thêm thành công kq = 0 thêm thất bại
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

}
