package com.homework.shopingcart.util;

import java.util.Locale;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.homework.shopingcart.model.Cart;
import com.homework.shopingcart.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class MailConstructor {
    @Autowired
    private TemplateEngine templateEngine;

    //Cấu hình mail gửi đến khách hàng
    public MimeMessagePreparator constructOrderConfirmationEmail(User user, Cart cart, Locale local){
        Context context = new Context();
        context.setVariable("user",user); 
        context.setVariable("cart",cart);
        String text = templateEngine.process("template_mail", context);

        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                //Địa chỉ nhận mail
                email.setTo(user.getEmail());
                //Thông tin tiêu đề mail
                email.setSubject("Xác nhận đơn hàng -"+ user.getName());
                //Nội dung mail
                email.setText(text,true);
                //Thông tin người gửi mail
                email.setFrom(new InternetAddress("neo4431@gmail.com"));
            }
        };
        return messagePreparator;
    }
}