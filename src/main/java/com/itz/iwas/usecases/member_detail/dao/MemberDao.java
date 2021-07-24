package com.itz.iwas.usecases.member_detail.dao;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MemberDao {
    private Date joiningDate;
    private String memberNumber;
    private String designation;
    private String memberName;
    private String fatherName;
    private String permanentAddress;
    private String permanentCity;
    private String mobileNumber;
    private String whatsappNumber;
    private String aadharNumber;
    private String currentAddress;
    private String currentCity;
    private String subscriberType;
    private String amount;
}
