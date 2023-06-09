package tw.idv.zoe.core;

import org.hibernate.Session;

public interface CoreDao {

	default Session getSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

}
