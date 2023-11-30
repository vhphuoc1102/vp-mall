package com.phuocvh.service;

import com.phuocvh.dto.MemberRegistrationByPhoneRequest;
import com.phuocvh.entity.UmsMember;

public interface UmsMemberService {
    UmsMember registerMemberByPhone(MemberRegistrationByPhoneRequest memberRegistrationByPhoneRequest);

    void updateMember(UmsMember umsMember);
}
