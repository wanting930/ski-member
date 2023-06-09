package tw.idv.zoe.member.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.idv.zoe.member.service.MemberService;
import tw.idv.zoe.member.vo.Member;

@RestController
@RequestMapping("/member")
public class DefaultPhotoController {
	@Autowired
	private MemberService service;
	
	@PostMapping("/defaultPhoto")
	public ResponseEntity<Member>  defaultPhoto(@RequestBody Integer userID) throws IOException {
		Member member = new Member();
		member.setUserID(userID);

		String filePath = "static/img/default_photo.png";
		ClassPathResource resource = new ClassPathResource(filePath);
		
	    byte[] buf = StreamUtils.copyToByteArray(resource.getInputStream());
	    member.setPhoto(buf);
				
		member = service.infoChange(member);

		if (member == null) {
			member = new Member();
			member.setMessage("無會員資訊");
			member.setSuccessful(false);
			return ResponseEntity.status(200).body(member);
		}

		return ResponseEntity.status(200).body(member);
	}
}