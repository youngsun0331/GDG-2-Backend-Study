package com.example.shop.member.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

//memberId password phoneNumber address
@Getter
public class MemberCreateRequest {


    @NotNull(message = "멤버는 필수입니다")
    @Size(min = 4,max = 20,message = "로그인 아이디는 4자이상20자 이하입니다.")
    private String loginId;
    private String password;

    @NotNull(message = "전화번호는 필수입니다.")
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", message = "전화번호 형식은 010-xxxx-xxxx입니다")
    private String phoneNumber;
    private String address;

    public MemberCreateRequest(String loginId, String password, String phoneNumber, String address) {
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
