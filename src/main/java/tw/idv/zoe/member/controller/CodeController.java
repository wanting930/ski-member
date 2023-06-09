package tw.idv.zoe.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Getter;
import lombok.Setter;
import tw.idv.zoe.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class CodeController {
	@Autowired
	private MemberService service;
	private String code = null;
	@Getter
	@Setter
	private boolean codeSuccess;
	
    @GetMapping("/getCode")
    public String getCode() {
        code = service.genAuthCode();
        return code;
    }

    @GetMapping("/verifyCode/{code}")
    public boolean verifyCode(@PathVariable String code) {
        if (!(this.code.equals(code))) {
            setCodeSuccess(false);
        } else {
            setCodeSuccess(true);
        }
        return codeSuccess;
    }
	
}