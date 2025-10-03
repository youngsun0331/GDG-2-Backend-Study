package com.example.shop.member.dto;

import lombok.Getter;

//memberId password phoneNumber address
@Getter
public class MemberCreateRequest {

    private String loginId;
    private String password;
    private String phoneNumber;
    private String address;

    public MemberCreateRequest(String loginId, String password, String phoneNumber, String address) {
        this.loginId = loginId;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
