package com.busraciftlik.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoginDto {
    private Long loginId;

    @Email(message = "Uygun formatta e-mail girmediniz. Examples: deneme@com")
    private String loginEmail;

    @NotEmpty(message = "Username boş bırakılamaz.")
    private String loginUsername;

    @NotEmpty(message = "Şifre boş bırakılamaz.")
    private String loginPassword;


    public String getNowDate(){
        Locale locale=new Locale("tr","TR");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss",locale);
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    private String creationDate=getNowDate();
}