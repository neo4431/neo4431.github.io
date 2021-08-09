`` Lý thuyết ``
- Mục đích của cookie là gì?
    - Mục đích của cookie là để , lưu trữ tạm thời các thông tin theo dạng key:value nhằm theo dõi các thông tin khác nhau của client.
- Cookie là công nghệ chỉ có trong Spring Boot. Đúng hay Sai?
    - Sai.
- Thuộc tính Expires/Max-Age tính bằng đơn vị gì? Ý nghĩa của nó là gì?
    - Tính bằng đơn vị giây, là thời gian tồn tại của cookie đó trên client.
- Thuộc tính Domain của Cookie có ý nghĩa gì?
    - Ý nghĩa cookie đó là của địa chỉ domain(tên miền) nào.
- Thuộc tính nào cho phép mã JavaScript ở client có thể đọc được giá trị của Cookie?
    - Thuộc tính HttpOnly. False thì JS có thể đọc được, True thì không.
- Thuộc tính Path có tác dụng như thế nào?
    - Thuộc tính Path chỉ ra cookie sẽ có hiệu lực bắt đầu từ đường dẫn nào.
    #
`` Thực hành ``

1. Tạo template.html có header fragment sẽ chứa internal css, menu fragment chứa đường link dẫn đến home, blog, setting. 
![fragment_menu](img\template_header_menu.png)

2. Trang setting có form đổi màu nền,...Khi ấn save setting sẽ lưu cookie
![run](img\cookie.png)

