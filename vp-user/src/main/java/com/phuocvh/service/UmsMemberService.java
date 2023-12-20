package com.phuocvh.service;

import com.phuocvh.dto.MemberRegistrationParam;
import com.phuocvh.entity.UmsMember;

public interface UmsMemberService {
    UmsMember registerMember(MemberRegistrationParam memberRegistrationParam);

    void updateMember(UmsMember umsMember);
}
