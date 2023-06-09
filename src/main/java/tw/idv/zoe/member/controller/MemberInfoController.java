package tw.idv.zoe.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.zoe.member.service.MemberService;
import tw.idv.zoe.member.vo.Member;

@RestController
@RequestMapping("/member")
public class MemberInfoController {
	@Autowired
	private MemberService service;

    @GetMapping("/memberInfo/{userID}")
    public ResponseEntity<Member> read(@PathVariable Integer userID) {
    	Member member = service.findOne(userID);
        return ResponseEntity.status(200).body(member);
    }
}