package com.phuocvh.controller;

import com.phuocvh.api.CommonResult;
import com.phuocvh.dto.MemberRegistrationRequest;
import com.phuocvh.entity.UmsMember;
import com.phuocvh.service.impl.UmsMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UmsMemberController {
    @Autowired
    UmsMemberServiceImpl umsMemberService;

    @PostMapping("/register")
    public CommonResult<UmsMember> registerMember(@RequestBody MemberRegistrationRequest memberRegistrationRequest) {
        UmsMember umsMember = umsMemberService.registerMember(memberRegistrationRequest);
        try {
            return CommonResult.success(umsMember);
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.failed();
        }
    }

    @GetMapping("/login")
    public CommonResult<UmsMember> login() {
        return null;
    }
}
