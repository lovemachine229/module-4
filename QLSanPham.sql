create database QLSanPham;
use QLSanPham;

create table LoaiSanPham
(
	MaLoaiSP char(4) primary key,
    TenLoaiSP nvarchar(100) not null
);
create table SanPham
(
	MaSP char(4) primary key,
    TenSP nvarchar(100) not null,
    NhaSanXuat nvarchar(100) not null,
    MaLoaiSP char(4) not null,
    foreign key (MaLoaiSP) references LoaiSanPham(MaLoaiSP)
);

insert into LoaiSanPham
values("LS01","Đồ nội thất");
insert into LoaiSanPham
values("LS02","Dụng cụ học tập");
insert into LoaiSanPham
values("LS03","Thực phẩm");

insert into Sanpham
values("SP01","Ghế đơn","Công ty nội thất Tân An","LS01");
insert into Sanpham
values("SP02","Tủ quần áo","Công ty nội thất Đại Nam","LS01");
insert into Sanpham
values("SP03","Thước kẻ","Công ty Hải Tiến","LS02");
insert into Sanpham
values("SP04","Vở kẻ ngang","Công ty Hải Tiến","LS02");
insert into Sanpham
values("SP05","Bánh mỳ","Công ty Thanh Hải","LS03");

select MaSP,TenSp,TenLoaiSP from SanPham s inner join LoaiSanPham l where s.MaLoaiSP=l.MaLoaiSP;
select * from LoaiSanPham
