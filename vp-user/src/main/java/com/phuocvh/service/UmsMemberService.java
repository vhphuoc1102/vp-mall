package com.phuocvh.service;

import com.phuocvh.dto.MemberRegistrationRequest;
import com.phuocvh.entity.UmsMember;

public interface UmsMemberService {
    UmsMember registerMember(MemberRegistrationRequest memberRegistrationRequest);

    void updateMember(UmsMember umsMember);
}
