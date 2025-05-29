# PolyCafe ☕

---

![MIT License](https://img.shields.io/badge/license-MIT-green)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

Một phần mềm quản lý bán hàng quán cafe, thiết kế tối giản, dễ sử dụng. Dự án sử dụng Java (Swing), kết nối cơ sở dữ liệu SQL, hướng tới việc hỗ trợ các nghiệp vụ bán hàng, quản lý kho, hóa đơn, người dùng, và báo cáo doanh thu.

Đây cũng là điểm khởi đầu để bạn phát triển thêm các tính năng hoặc giao diện cho phần mềm quản lý quán cafe của riêng mình.

---

## Cách sử dụng

### Người dùng

1. Tải bản phát hành phù hợp với hệ điều hành của bạn (file `.jar`).
2. Mở ứng dụng, đăng nhập bằng tài khoản được cấp.
3. Sử dụng các chức năng: Quản lý bán hàng, hóa đơn, sản phẩm, người dùng, báo cáo doanh thu, v.v.

### Xây dựng từ mã nguồn

1. Clone repository về máy:
   ```powershell
   git clone <link-repo>
   ```
2. Cài đặt các phụ thuộc:
   ```powershell
   mvn install
   ```
3. Chạy ứng dụng ở chế độ phát triển:
   ```powershell
   mvn exec:java
   ```
4. Đóng gói ứng dụng:
   ```powershell
   mvn package
   ```
   File `.jar` sẽ nằm trong thư mục `target/`.

---

## Tính năng

- Quản lý sản phẩm, danh mục, kho hàng
- Quản lý hóa đơn, chi tiết hóa đơn
- Quản lý người dùng, phân quyền
- Báo cáo doanh thu, thống kê
- Giao diện thân thiện, dễ sử dụng
- Hỗ trợ kết nối cơ sở dữ liệu SQL

---

## Thông tin thêm

- [MIT License](LICENSE)
- Tác giả: Nhóm phát triển PolyCafe
- Đóng góp, báo lỗi hoặc đề xuất tính năng mới vui lòng tạo issue trên GitHub.
