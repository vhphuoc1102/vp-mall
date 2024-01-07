package com.phuocvh.service.impl;

import com.phuocvh.entity.UmsMemberLevel;
import com.phuocvh.repository.UmsMemberLevelRepository;
import com.phuocvh.service.UmsMemberLevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UmsMemberLevelServiceImpl implements UmsMemberLevelService {
    @Autowired
    UmsMemberLevelRepository umsMemberLevelRepository;

    @Override
    public UmsMemberLevel create(String name) {
        UmsMemberLevel level = UmsMemberLevel.builder().name(name).build();
        return umsMemberLevelRepository.save(level);
    }

    @Override
    public UmsMemberLevel find(String name) {
        return umsMemberLevelRepository.findByName(name);
    }
}
