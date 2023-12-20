package com.phuocvh.controller;

import com.phuocvh.api.CommonResult;
import com.phuocvh.dto.MemberRegistrationParam;
import com.phuocvh.entity.UmsMember;
import com.phuocvh.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/users")
public class UmsMemberController {
    @Autowired
    UmsMemberService umsMemberService;

    @PostMapping("/register")
    public CommonResult<UmsMember> registerMember(@RequestBody MemberRegistrationParam memberRegistrationParam) {
        try {
            UmsMember umsMember = umsMemberService.registerMember(memberRegistrationParam);
            return CommonResult.success(umsMember);
        } catch (Exception e) {
            System.out.println(e);
            return CommonResult.failed(e.getMessage());
        }
    }

    @GetMapping("/login")
    public CommonResult<UmsMember> login() {
        return null;
    }
}
