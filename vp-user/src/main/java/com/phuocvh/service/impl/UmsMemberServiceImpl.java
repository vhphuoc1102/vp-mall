package com.phuocvh.service.impl;

import com.phuocvh.dto.MemberRegistrationRequest;
import com.phuocvh.entity.UmsMember;
import com.phuocvh.repository.UmsMemberRepository;
import com.phuocvh.service.UmsMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UmsMemberServiceImpl implements UmsMemberService {
    private final UmsMemberRepository umsMemberRepository;

    @Override
    public UmsMember registerMember(MemberRegistrationRequest memberRegistrationRequest) {
        UmsMember newUmsMember = UmsMember.builder()
                .email(memberRegistrationRequest.getEmail())
                .password(memberRegistrationRequest.getPassword())
                .build();
        try {
            umsMemberRepository.save(newUmsMember);
        } catch (Exception e) {
            try {
                umsMemberRepository.save(newUmsMember);
            } catch (Exception e2) {
                System.out.println(e2);
            }
        }
        return newUmsMember;
    }

    @Override
    public void updateMember(UmsMember umsMember) {
        Optional<UmsMember> member = umsMemberRepository.findById(umsMember.getId());

    }
}
