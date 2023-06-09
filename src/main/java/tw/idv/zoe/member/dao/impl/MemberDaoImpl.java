package tw.idv.zoe.member.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import tw.idv.zoe.member.dao.MemberDao;
import tw.idv.zoe.member.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	@PersistenceContext
	private Session session;

	@Override
	public int insert(Member member) {
		session.persist(member);
		return member.getUserID();
		
	}

	@Override
	public int deleteById(Integer userID) {
		Member member = session.get(Member.class, userID);
		session.remove(member);
		return 1;
	}

	@Override
	public boolean updateById(Member nMember) {
		try {
			Member oMember = session.get(Member.class, nMember.getUserID());
			
			final String email = nMember.getEmail();
			if (email != null && !email.isEmpty()) {
				oMember.setEmail(email);
			}
			final String passowrd = nMember.getPassword();
			if (passowrd != null && !passowrd.isEmpty()) {
				oMember.setPassword(passowrd);
			}
			final String userName = nMember.getUserName();
			if (userName != null && !userName.isEmpty()) {
				oMember.setUserName(userName);
			}
			final String nickName = nMember.getNickName();
			if (nickName != null && !nickName.isEmpty()) {
				oMember.setNickName(nickName);
			}
			final String gender = nMember.getGender();
			if (gender != null && !gender.isEmpty()) {
				oMember.setGender(gender);
			}
			final Date birthDate = nMember.getBirthDate();
			if (birthDate != null) {
				oMember.setBirthDate(birthDate);
			}
			final String personID = nMember.getPersonID();
			if (personID != null) {
				oMember.setPersonID(personID);
			}
			final String phone = nMember.getPhone();
			if (phone != null) {
				oMember.setPhone(phone);
			}
			final String address = nMember.getAddress();
			if (address != null) {
				oMember.setAddress(address);
			}
			final String level = nMember.getLevel();
			if (level != null && !level.isEmpty()) {
				oMember.setLevel(level);
			}
			final byte[] photo = nMember.getPhoto();
			if (photo != null && photo.length > 0) {
				oMember.setPhoto(photo);
			}
			final String userStatus = nMember.getUserStatus();
			if (userStatus != null && !userStatus.isEmpty()) {
				oMember.setUserStatus(userStatus);
			}
			return true;
		} catch (Exception e) {
			System.out.println("updateById方法發生錯誤：" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Member selectById(Integer userID) {
		return session.get(Member.class, userID);
	}

	@Override
	public List<Member> selectAll() {
		final String hql = "FROM Member ORDER BY userID";
		return session
			.createQuery(hql, Member.class)
			.getResultList();
	}

	@Override
	public Member selectForLogin(String email, String password) {
		final String sql = "SELECT * FROM Member WHERE email = :email AND password = :password";
		return session.createNativeQuery(sql, Member.class)
				.setParameter("email", email)
				.setParameter("password", password)
				.uniqueResult();
	}

	@Override
	public Member selectByEmail(String email) {
		final String sql = "SELECT * FROM Member WHERE email = :email";
		return session
				.createNativeQuery(sql, Member.class)
				.setParameter("email", email)
				.uniqueResult();
	}

}