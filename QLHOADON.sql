create database QlHOADON;
use QLHOADON;

create table NhanVien
(
	MaNV char(4) primary key,
    HoTen nvarchar(50) not null,
    NgaySinh date not null,
    DiaChi nvarchar(100) not null,
    SDT char(15) not null,
    GioiTinh char(3) not null
);
create table SanPham
(
	MaSP char(4) primary key,
    TenSP nvarchar(100) not null,
    DonViTinh nvarchar(20) not null,
    GiaBan double not null
);
create table HoaDon
(
	MaHD char(4) primary key,
    MaNV char(4) not null,
    LoaiHD nvarchar(10) not null,
    NgayLap date not null,
    NgayGiaoNhan date not null,
    DienGiai nvarchar(200),
    foreign key (MaNV) references NhanVien(MaNV)
);
create table ChiTietHD
(
	MaHD char(4) not null,
    MaSP char(4) not null,
    SoLuong int not null,
    GiaBan double not null,
    primary key (MaHD, MaSP),
    foreign key (MaHD) references HoaDon(MaHD),
    foreign key (MaSP) references SanPham(MaSP)
);

insert into NhanVien
values("NV01","La Van Hoa","2020/04/20","Bac Giang","0358935645","nam");
insert into SanPham
values("SP01","May tinh","chiec",20000000);
insert into HoaDon
values("HD01","NV01","Nhap","2021/07/10","2021/07/15","Nhan du hang, hang dat chat luong");
insert into ChiTietHD
values("HD01","SP01","Nhap",20,200000000);

select * from NhanVien