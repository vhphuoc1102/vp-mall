package com.phuocvh.controller;

import com.phuocvh.api.CommonResult;
import com.phuocvh.dto.MemberRegistrationByPhoneRequest;
import com.phuocvh.entity.UmsMember;
import com.phuocvh.service.impl.UmsMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UmsMemberController {
    @Autowired
    UmsMemberServiceImpl umsMemberService;

    @PostMapping("/register")
    public CommonResult<UmsMember> registerUmsMemberByPhone(@RequestBody MemberRegistrationByPhoneRequest memberRegistrationByPhoneRequest) {
        try {
            UmsMember umsMember = umsMemberService.registerMemberByPhone(memberRegistrationByPhoneRequest);
            return CommonResult.success(umsMember);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
