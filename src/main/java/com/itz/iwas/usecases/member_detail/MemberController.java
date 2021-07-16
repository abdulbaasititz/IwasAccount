package com.itz.iwas.usecases.member_detail;

import com.itz.iwas.models.Membership;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("${spring.base.path}" + "/v1")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping
    public ResponseEntity<?> testValue() {
        return new ResponseEntity<>("Working", HttpStatus.OK);
    }

    @GetMapping("/get-member")
    public ResponseEntity<?> getMemberDetails(@RequestParam int id) {
        Membership getMember = memberService.getMemberDetail(id);
        return new ResponseEntity<>(getMember, HttpStatus.OK);
    }
}
