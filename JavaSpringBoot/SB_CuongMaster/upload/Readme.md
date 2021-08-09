![properties](img\properties.png)
- Bài này em sử dụng Database h2 để lưu thông tin nên trong file properties em khai báo thông tin của h2database test
#
![person](img\model_person.png)
![job](img\model_job.png)
- Em tạo 2 Entity tương ứng với mỗi bảng trong CSDL.
@ID @GeneratedValue để khai báo trường "id" là PK và tự tăng.
@NotNull, @Size là annotation để validate dữ liệu không null và khai báo size cũng như message trả ra với mỗi điều kiện.
@Transient là khai báo trường "file" sẽ không map với table trong CSDL.
#
![job](img\service.png)
- Ở đây em tạo 1 interface implement JpaRepository và sử dụng các method có sẵn để làm các thao tác CRUD (bên entity Job cũng tương tự)
#
![home](img\home.png)
![home](img\controller_home.png)
![home](img\homehtml.png)

`` PersonController ``
- Hàm getHome sử dụng model để lưu 1 đối tượng person và 1 list jobs dùng để hiển thị trong form và trả về trang home.html 
  - th:replace là em đã tạo 1 template header để sử dụng lại cho nhiều trang html khác.
  - form: vì là có chức năng upload file nên em khai báo enctype="multipart/form-data"
  - Mỗi input sẽ tương ứng với các trường của object person và khi bấm submit thì 1 đối tượng person được gửi đi và tìm hàm post trong controller có url mapping "/"

#
![postmapping](img\controller_post.png)
- Trong hàm createUser sẽ hứng lấy đối tượng Person trong form gửi lên vì có khai báo @modelAttribute , @Valid là khai báo bật chức năng Validate ( nếu dữ liệu gửi lên không đúng với điều kiện đã khai báo trong class Person thì sẽ trả lại về chính trang home.html)
- Nếu không có lỗi xác thực thì sẽ chạy vào phần code kiểm tra id của Person ( vì ở đây em dùng chung 1 form cho cả update và create nên em kiểm tra id có null không)
- tiếp đến gọi hàm uploadFile được viết trong storageService để lưu file và trả về trang success.html ( hiển thị thông tin vừa đăng ký)
![uploadfile](img\uploadfile.png)
![success](img\success.png)
#

- Khi bấm list people sẽ chuyển sang url /people tương ứng hàm getPeople() sẽ trả về people.html kèm theo 1 list people
![](img\controller_people.png)
![people](img\people.png)

# 
![people](img\deleteupdatehtml.png)
- Nút delete trả về đường dẫn /delete/{id} sẽ ứng với hàm delete() trong controller , hàm delete có tham số id được đánh dấu @PathVariable thì tham số sẽ tương ứng với {id} trên url . Sau khi xóa đối tượng thì chuyển sang trang /people ( chính là trang này nên sẽ tương đương với tải lại trang ).
![people](img\edit_delete.png) 

- hàm edit sẽ sử dụng model add đối tượng person có id = id trên url , mục đích để lấy dữ liệu sẵn của person đó cho form, trả về trang home( trang có form tạo person mới)

#
#

![people](img\controller_job.png) 
Bấm vào List Jobs (/jobs) thì request sẽ map vào hàm getJob trong JobController trả về trang html có danh sách job

![people](img\jobs.png) 

Khi điền tên job và bấm submit thì request map vào hàm addJob. Tại đây em kiểm tra nếu không có lỗi xác thực thì gọi hàm "add" của "jobService" 

![people](img\jobSerivce.png) 

Tại đây em kiểm tra nếu không trùng job có trong danh sách thì save vào CSDL.
Nếu bị trùng thì em không save và trả ra 1 message thông báo 

