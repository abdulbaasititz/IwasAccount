package com.itz.iwas.usecases.member_detail;

import com.itz.iwas.helpers.common.calc.DateTimeCalc;
import com.itz.iwas.models.Membership;
import com.itz.iwas.usecases.member_detail.dao.MemberDao;
import com.itz.iwas.usecases.member_detail.pojo.MembershipPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public MembershipPojo getMemberDetail(int id) {
        return memberRepository.findById(id);
    }

    public List<Membership> getAllMember() {
        return memberRepository.findAll();
    }

    public Page<Membership> getMember(int pn, int ps) {
        Pageable pg = PageRequest.of(pn, ps);
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

    public List<MembershipPojo> getMemberByDate(Date fromDate, Date toDate) {
        List<MembershipPojo> getMember = memberRepository.findByJoiningDateBetween(fromDate, toDate);
        return getMember;
    }

    public String getMemberCount() {
        return memberRepository.countMemberNumber();
    }

}
