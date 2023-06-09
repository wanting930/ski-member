package tw.idv.zoe.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.zoe.member.service.MemberService;
import tw.idv.zoe.member.vo.Member;

@RestController
@RequestMapping("/member")
public class LoginController {
	@Autowired
	private MemberService service;
	
	@PostMapping("/login")
	public ResponseEntity<Member> login(@RequestBody Member member) {
		member = service.login(member.getEmail(), member.getPassword());
		
		if (member == null) {
			member = new Member();
			member.setMessage("無會員資訊");
			member.setSuccessful(false);
			return ResponseEntity.status(200).body(member);
		}

		return ResponseEntity.status(200).body(member);
	}
}