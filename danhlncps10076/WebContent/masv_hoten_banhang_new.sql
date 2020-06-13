use master
go
drop database masv_hoten
go
create database masv_hoten
go
use masv_hoten
go
create table account
(
	username varchar(50) primary key,
	password varchar(50)
)
go
insert into account values('admin','123')
go
select * from account
go


create table DanhMuc
(
	MaDM int identity(1,1) primary key,
	TenDM nvarchar(100) not null
)
go
create table SanPham
(
	MaSP int identity(1,1) primary key,
	TenSP nvarchar(50) not null,
	DonGia int,
	SoLuong int,
	Hinh varchar(50),
	MaDM int references DanhMuc(MaDM)
)
go
create table KhachHang
(
	MaKH int identity(1,1) primary key,
	TenKH nvarchar(50) not null,
	DiaChi nvarchar(100),
	DienThoai varchar(15),
)
go



create table DonHang
(
	MaDH int identity(1,1) primary key,
	NgayDatHang date,
	MaKH int references KhachHang(MaKH)
	
)
go
create table ChiTietDonHang
(
	MaDH int references DonHang(MaDH),
	MaSP int references SanPham(MaSP),
	DonGia int,
	SoLuong int
	Constraint pk_CTDH primary key(MaDH,MaSP)
)
go






insert into KhachHang values(N'Đinh Đạt Thông',N'Trần Duy Hưng','01356789')
insert into KhachHang values(N'Dinh Nokia',N'Sầm Sơn','01234789')
go
insert into DanhMuc values(N'Quần Áo')
insert into DanhMuc values(N'Đồ Gia Dụng')
go
insert into SanPham values(N'Vải 1',100000,5,'vai-ao-dai-1.jpg',1)
insert into SanPham values(N'Vải 2',100000,5,'vai-ao-dai-2.jpg',1)
insert into SanPham values(N'Vải 3',100000,5,'vai-ao-dai-3.jpg',1)
insert into SanPham values(N'Vải 4',100000,5,'vai-ao-dai-4.jpg',1)
insert into SanPham values(N'Vải 5',100000,5,'vai-ao-dai-5.jpg',1)
insert into SanPham values(N'Vải 6',100000,5,'vai-ao-dai-6.jpg',1)
insert into SanPham values(N'Vải 7',100000,5,'vai-ao-dai-7.jpg',1)
insert into SanPham values(N'Vải 8',100000,5,'vai-ao-dai-8.jpg',1)
select * from DanhMuc
go
insert into DonHang values('12/12/2018',2)
insert into DonHang values('12/10/2017',1)
go
insert into ChiTietDonHang values(1,2,13000,4)
insert into ChiTietDonHang values(2,1,190000,5)
go