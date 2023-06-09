package tw.idv.zoe.member.dao;

import java.util.List;

import tw.idv.zoe.core.CoreDao;
import tw.idv.zoe.member.vo.Member;

public interface MemberDao extends CoreDao {
	int insert(Member member);

	int deleteById(Integer userID);

	boolean updateById(Member member);

	Member selectById(Integer userID);

	List<Member> selectAll();

	Member selectForLogin(String email, String password); 

	Member selectByEmail(String email);
	
}