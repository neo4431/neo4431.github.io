Demo1 : Dự án không có Controller, không mapping được bất cứ dữ liệu nào -> không có dữ liệu trả về

Demo2 : 2 phương thức có mapping là getHome và getAbout đều trả về dữ liệu dạng text
	- Cách dữ liệu hiển thị trên trình duyệt là: Trình duyệt gửi request -> Spring boot map dữ liệu và trả về ngay trình duyệt vì có @reponsebody trên 2 phương thức

Demo3 : có thêm 3 phương thức là:
	- getJson(): trả về dữ liệu dạng json(key:value);
	- getXml(): trả về dữ liệu dạng XML(thẻ);
	- getBooks(),getCar(),getPerson(): đều trả về kiểu dữ liệu kiểu json.
	- Cách dữ liệu hiển thị trên trình duyệt là: Trình duyệt gửi request -> Spring boot map dữ liệu và trả về ngay trình duyệt vì có @reponsebody trên phương thức

Demo4: 	Có 1 phương thức getHome() trả về dạng text 
	Có 2 Biến này được khởi tạo với Anonation @value . 
	Anonation này sẽ lấy giá trị của thuộc tính tương ứng trong file application.properties và application.yml ( nếu trùng thuộc tính thì file yml sẽ ghi đè lên file properties).
	- Cách dữ liệu hiển thị trên trình duyệt là: Trình duyệt gửi request -> Spring boot map dữ liệu và trả về ngay trình duyệt vì có @reponsebody trên phương thức

Demo5:  Bài này server sẽ  nên Spring boot sẽ không trả về dữ liệu ngay mà sẽ thông qua viewTemplate Engine, lấy dữ liệu ghép vào template.
	không dùng @reponsebody -> cách dữ liệu trả về là spring boot thông qua viewTemplate Engine rồi mới trả về trình duyệt
	Trình duyệt gửi request -> spring boot sẽ map dữ liệu theo đường dẫn request -> vào đối tượng Model -> trả về thymeleaf view Engine:ghép dữ liệu với trang html trong folder template.
	Các phương thức có @getMapping: đều trả về dạng text/html;charset=UTF-8
	/book3 và /book4 có thêm ảnh loại dữ liệu jpeg

Demo6:  Tương tự bài 5. Có thêm file style.css
