package tw.idv.zoe.member.service;

import java.io.IOException;
import java.util.List;

import tw.idv.zoe.member.vo.Member;

public interface MemberService {
	
	Member register(Member member);

	Member login(String email, String password);
	
	String genAuthCode();
	
	Member forgotPassword(Member member);
	
	String getHtmlContent(String filePath) throws IOException;

	Member infoChange(Member member);
	
	Member checkPassword(Member member);

	Member passwordChange(Member member);

	List<Member> findAll();

	Member findOne(Integer userID);
	
	Member settings(Member member);
	
}