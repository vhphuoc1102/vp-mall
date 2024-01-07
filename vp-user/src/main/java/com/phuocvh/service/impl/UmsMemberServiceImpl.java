package com.phuocvh.service.impl;

import com.phuocvh.dto.MemberRegistrationParam;
import com.phuocvh.entity.UmsMember;
import com.phuocvh.repository.UmsMemberLevelRepository;
import com.phuocvh.repository.UmsMemberRepository;
import com.phuocvh.service.UmsMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UmsMemberServiceImpl implements UmsMemberService {
    private final UmsMemberRepository umsMemberRepository;
    private final UmsMemberLevelRepository umsMemberLevelRepository;
    private final String LEVEL_1 = "1";

    @Override
    public UmsMember registerMember(MemberRegistrationParam memberRegistrationParam) {
        UmsMember newUmsMember = UmsMember.builder()
                .email(memberRegistrationParam.getEmail())
                .password(memberRegistrationParam.getPassword())
                .build();
        newUmsMember.setUmsMemberLevel(umsMemberLevelRepository.findByName(LEVEL_1));
        umsMemberRepository.save(newUmsMember);
        return newUmsMember;
    }

    @Override
    public void updateMember(UmsMember umsMember) {
        Optional<UmsMember> member = umsMemberRepository.findById(umsMember.getId());

    }
}
