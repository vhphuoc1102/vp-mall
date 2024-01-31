package com.phuocvh.controller;

import com.phuocvh.dto.MemberRegistrationParam;
import com.phuocvh.entity.UmsMember;
import com.phuocvh.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v0/users")
public class UmsMemberController {
    @Autowired
    UmsMemberService umsMemberService;

    @PostMapping("/register")
    public ResponseEntity<?> registerMember(@RequestBody MemberRegistrationParam memberRegistrationParam) {
        try {
            UmsMember umsMember = umsMemberService.registerMember(memberRegistrationParam);
            return ResponseEntity.ok(umsMember);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/login")
    public ResponseEntity<UmsMember> login() {
        return null;
    }
}
