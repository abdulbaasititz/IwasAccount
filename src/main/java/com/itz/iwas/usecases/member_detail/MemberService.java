package com.itz.iwas.usecases.member_detail;

import com.itz.iwas.helpers.common.calc.DateTimeCalc;
import com.itz.iwas.models.Membership;
import com.itz.iwas.usecases.member_detail.dao.MemberDao;
import com.itz.iwas.usecases.member_detail.dao.PageableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public Membership getMemberDetail(int id) {
        return memberRepository.findById(id);
    }

    public List<Membership> getAllMember() {
        return memberRepository.findAll();
    }

    public Page<Membership> getMember(PageableDao pageableDao) {
        Pageable pg = PageRequest.of(pageableDao.getPageNumber(), pageableDao.getPageSize());
        return memberRepository.findAll(pg);
    }

    public Boolean checkMemberNumber(String memberNumber) {
        Membership membership = memberRepository.findByMemberNumber(memberNumber);
        return membership == null;
    }

    public String setMember(MemberDao memberDao) {
        Boolean checkNumber = checkMemberNumber(memberDao.getMemberNumber());
        if (checkNumber) {
            String formattedDate = new DateTimeCalc().getTodayDate();
            Membership membership = new Membership();
            membership.setId(0);
            membership.setMemberNumber(memberDao.getMemberNumber());
            membership.setMemberName(memberDao.getMemberName());
            membership.setFatherName(memberDao.getFatherName());
            membership.setDesignation(memberDao.getDesignation());
            membership.setPermanentAddress(memberDao.getPermanentAddress());
            membership.setIsActive(1);
            membership.setCrBy("test");
            membership.setCrAt(formattedDate);
            //memberRepository.save(membership);
            return "success";
        } else {
            return "data already present";
        }

    }

}
