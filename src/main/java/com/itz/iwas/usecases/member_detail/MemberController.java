package com.itz.iwas.usecases.member_detail;

import com.itz.iwas.models.Membership;
import com.itz.iwas.usecases.member_detail.dao.MemberDao;
import com.itz.iwas.usecases.member_detail.dao.PageableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("${spring.base.path}" + "/v1")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/get/member-detail")
    public ResponseEntity<?> getMemberDetails(HttpServletRequest request, @RequestParam int id) {
        String token = request.getHeader("Authorization");
        Membership getMember = memberService.getMemberDetail(id);
        return new ResponseEntity<>(getMember, HttpStatus.OK);
    }

    @GetMapping("/get/all-member")
    public ResponseEntity<?> getAllMember(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        List<Membership> getAllMember = memberService.getAllMember();
        return new ResponseEntity<>(getAllMember, HttpStatus.OK);
    }

    @PostMapping("/get/member")
    public ResponseEntity<?> getMember(HttpServletRequest request, @RequestBody PageableDao pageableDao) {
        Page<Membership> getMember = memberService.getMember(pageableDao);
        return new ResponseEntity<>(getMember, HttpStatus.OK);
    }

    @PostMapping("/set/member")
    public ResponseEntity<?> setMember(HttpServletRequest request, @RequestBody MemberDao memberDao) {
        String status = memberService.setMember(memberDao);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }

}
