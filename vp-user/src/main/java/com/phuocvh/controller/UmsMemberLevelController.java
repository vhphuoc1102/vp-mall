package com.phuocvh.controller;

import com.phuocvh.entity.UmsMemberLevel;
import com.phuocvh.service.UmsMemberLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/users/level")
public class UmsMemberLevelController {
    @Autowired
    UmsMemberLevelService umsMemberLevelService;

    @PostMapping("create")
    public ResponseEntity<UmsMemberLevel> createUmsMemberLevel(@RequestBody String name) {
        UmsMemberLevel level = umsMemberLevelService.create(name);
        return ResponseEntity.ok(level);
    }
}
