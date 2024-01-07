package com.phuocvh.service;

import com.phuocvh.entity.UmsMemberLevel;

public interface UmsMemberLevelService {
    UmsMemberLevel create(String name);

    UmsMemberLevel find(String name);
}
