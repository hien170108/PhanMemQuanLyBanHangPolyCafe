# PolyCafe ☕

![PolyCafe Poster](/photos/poster.png)

---

![MIT License](https://img.shields.io/badge/license-MIT-green)
![Build](https://img.shields.io/badge/build-passing-brightgreen)

## Mô tả

Một phần mềm quản lý bán hàng quán cafe, thiết kế tối giản, dễ sử dụng. Dự án sử dụng Java (Swing), kết nối cơ sở dữ liệu SQL, hướng tới việc hỗ trợ các nghiệp vụ bán hàng, quản lý kho, hóa đơn, người dùng, và báo cáo doanh thu.

Đây cũng là điểm khởi đầu để bạn phát triển thêm các tính năng hoặc giao diện cho phần mềm quản lý quán cafe của riêng mình.

### Mục lục

1. [Cách sử dụng](#cách-sử-dụng)
   - [Hướng dẫn thiết lập cơ sở dữ liệu](#hướng-dẫn-thiết-lập-cơ-sở-dữ-liệu)
   - [Người dùng](#người-dùng)
   - [Chạy phần mềm](#chạy-phần-mềm)
2. [Tính năng](#tính-năng)
3. [Giao diện phần mềm](#giao-diện-phần-mềm)
4. [Thông tin thêm](#thông-tin-thêm)

---

## Cách sử dụng

### Hướng dẫn thiết lập cơ sở dữ liệu

1. **Cài đặt SQL Server, XAMPP, hoặc MySQL Workbench**:

   - **SQL Server Management Studio (SSMS)**: Tải và cài đặt từ trang chính thức của Microsoft.
   - **XAMPP**: Đảm bảo MySQL đã được bật trong Control Panel của XAMPP.
   - **MySQL Workbench**: Tải và cài đặt từ trang chính thức của MySQL. Sau khi cài đặt, kết nối đến server MySQL của bạn.

   > 💡 **Lưu ý:** Nếu bạn sử dụng các trình quản lý cơ sở dữ liệu khác, hãy đảm bảo chúng hỗ trợ SQL và có khả năng chạy các script SQL.

2. **Tạo cơ sở dữ liệu**:

   - Mở **SSMS**, **phpMyAdmin**, **MySQL Workbench**, hoặc trình quản lý cơ sở dữ liệu khác.
   - Chạy file SQL `PolyCafe.sql` nằm trong thư mục `src/main/resources/database/` để tạo các bảng và dữ liệu mẫu.

     ```sql
     -- Mở file PolyCafe.sql và chạy toàn bộ nội dung
     ```

3. **Cấu hình kết nối cơ sở dữ liệu**:

   - Mở file cấu hình kết nối trong mã nguồn (nếu cần chỉnh sửa).
   - Đảm bảo thông tin kết nối (host, username, password) đúng với cơ sở dữ liệu của bạn.

### Người dùng

1. Tải bản phát hành phù hợp với hệ điều hành của bạn (file `.jar`).

2. Mở ứng dụng, đăng nhập bằng tài khoản được cấp. Dưới đây là hai tài khoản mẫu có sẵn để bạn thử nghiệm:

   #### Tài khoản Admin (Manager)

   - **Username:** `a`
   - **Password:** `1234$`

   #### Tài khoản Thường (Staff)

   - **Username:** `b`
   - **Password:** `1234$`

   > 💡 **Lưu ý:** Tài khoản Admin có quyền quản lý toàn bộ hệ thống, trong khi tài khoản Thường chỉ có quyền hạn giới hạn.

3. Sử dụng các chức năng: Quản lý bán hàng, hóa đơn, sản phẩm, người dùng, báo cáo doanh thu, v.v.

### Chạy phần mềm

1. **Clone repository về máy**:

   ```powershell
   git clone https://github.com/hien170108/PhanMemQuanLyBanHangPolyCafe.git
   ```

2. **Cài đặt các phụ thuộc**:

   ```powershell
   mvn install
   ```

3. **Chạy ứng dụng ở chế độ phát triển**:

   ```powershell
   mvn exec:java
   ```

4. **Đóng gói ứng dụng**:

   ```powershell
   mvn package
   ```

   File `.jar` sẽ nằm trong thư mục `target/`.

5. **Chạy file `.jar`**:

   - Mở terminal và chạy lệnh:

     ```powershell
     java -jar target/DuAnMau_NgoQuangHien_TH06730-1.0.jar
     ```

   - Hoặc nhấp đúp vào file `.jar` để mở ứng dụng.

> 💡 **Lưu ý:** Đảm bảo Java Runtime Environment (JRE) đã được cài đặt trên máy tính của bạn.

---

## Tính năng

- Quản lý sản phẩm, danh mục, kho hàng
- Quản lý hóa đơn, chi tiết hóa đơn
- Quản lý người dùng, phân quyền
- Báo cáo doanh thu, thống kê
- Giao diện thân thiện, dễ sử dụng
- Hỗ trợ kết nối cơ sở dữ liệu SQL

---

## Giao diện phần mềm

### Đăng nhập

![Login Light](/photos/UI-preview/login/light.png)

### Menu chính

![Main Menu Dark](/photos/UI-preview/main_menu/dark.png) ![Main Menu Light](/photos/UI-preview/main_menu/light.png)

### Quản lý hóa đơn

![Bill Manage Dark](/photos/UI-preview/manage/bill_manage/dark.png) ![Bill Manage Light](/photos/UI-preview/manage/bill_manage/light.png)

### Quản lý sản phẩm

![Drink Manage Dark](/photos/UI-preview/manage/drink_manage/dark.png) ![Drink Manage Light](/photos/UI-preview/manage/drink_manage/light.png)

### Quản lý loại sản phẩm

![Drink Type Manage Dark](/photos/UI-preview/manage/drinktype_manage/dark.png) ![Drink Type Manage Light](/photos/UI-preview/manage/drinktype_manage/light.png)

### Quản lý doanh thu

![Revenue Manage Staff Dark](/photos/UI-preview/manage/revenue_manage/staff_dark.png) ![Revenue Manage Staff Light](/photos/UI-preview/manage/revenue_manage/staff_light.png)
![Revenue Manage Drink Type Dark](/photos/UI-preview/manage/revenue_manage/drinktype_dark.png) ![Revenue Manage Drink Type Light](/photos/UI-preview/manage/revenue_manage/drinktype_light.png)

### Quản lý người dùng

![User Manage Dark](/photos/UI-preview/manage/user_manage/dark.png) ![User Manage Light](/photos/UI-preview/manage/user_manage/light.png)

### Lịch sử bán hàng

![Sale History Dark](/photos/UI-preview/sale_history/dark.png) ![Sale History Light](/photos/UI-preview/sale_history/light.png)

### Đổi mật khẩu

![Change Password Dark](/photos/UI-preview/changepass/dark.png) ![Change Password Light](/photos/UI-preview/changepass/light.png)

### Nhật ký hoạt động

![Activity Log Dark](/photos/UI-preview/activity_log/dark.png) ![Activity Log Light](/photos/UI-preview/activity_log/light.png)

### Giao diện Chat

![Chat Dark](/photos/UI-preview/chat/dark.png) ![Chat Light](/photos/UI-preview/chat/light.png)

---

## Thông tin thêm

- [Giấp phép MIT](LICENSE)
- Tác giả: Nhóm sinh viên trường FPT Polyschool

| STT | MSSV    | Họ và tên              |
|-----|---------|------------------------|
| 1   | TH06730 | Ngô Quang Hiển         |
| 2   | TH06430 | Nguyễn Văn Tùng        |
| 3   | TH04863 | Hoàng Thiên Bảo        |
| 4   | TH06564 | Nguyễn Đăng Tuấn Anh   |
| 5   | TH06168 | Trần Tuấn Hiệp         |
| 6   | TH00000 | Tô Đức Anh             |

- Đóng góp, báo lỗi hoặc đề xuất tính năng mới, vui lòng tạo issue trên GitHub.
