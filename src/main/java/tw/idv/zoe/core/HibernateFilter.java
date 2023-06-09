package tw.idv.zoe.core;

import javax.servlet.FilterChain;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

// 此做法是為了保持連線，把交易控制拉到Filter裡面做
@WebFilter("/*")
public class HibernateFilter extends HttpFilter {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			Transaction transaction = session.beginTransaction();
			chain.doFilter(req, res);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
}
