package tw.idv.zoe.member.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

@RestController
@RequestMapping("/member")
public class LogoutController {

	@GetMapping("/logout")
	public void logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
	}

}