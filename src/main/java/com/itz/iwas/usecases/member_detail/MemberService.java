package com.itz.iwas.usecases.member_detail;

import com.itz.iwas.models.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Membership getMemberDetail(int id) {
        return memberRepository.findById(id);
    }
}
