package com.dlj.dao.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.dlj.dao.UserDao;
import com.dlj.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void saveUser(User u) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(u);
	}

	@Override
	public com.dlj.entity.User getByUserCode(String username) {
		// HQL
		/*
		 * return getHibernateTemplate().execute(new HibernateCallback<User>() {
		 * 
		 * @Override public User doInHibernate(Session session) throws
		 * HibernateException { // TODO Auto-generated method stub String hql =
		 * "from User where username=?"; Query query = session.createQuery(hql);
		 * query.setParameter(0, username); User user = (User)
		 * query.uniqueResult(); return user; }
		 * 
		 * });
		 */
		// Criteria
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("username", username));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}

	}

}
