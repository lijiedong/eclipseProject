package com.dlj.a_jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.dlj.entity.User;

public class UserDaoImpl extends JdbcDaoSupport implements UserDao {
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user values(null,?,?,?)";
		super.getJdbcTemplate().update(sql, u.getUserName(), u.getPassword(), u.getAddress());
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		String sql = "delete from  t_user where uid=?";
		super.getJdbcTemplate().update(sql, id);
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		String sql = "update t_user set username=? ,password=? ,address=? where uid=?";
		super.getJdbcTemplate().update(sql, u.getUserName(), u.getPassword(), u.getAddress(), u.getUid());
	}

	@Override
	public User getById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_user where id = ? ";
		return super.getJdbcTemplate().queryForObject(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));

				return u;
			}
		}, id);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from t_user  ";
		Integer count = super.getJdbcTemplate().queryForObject(sql, Integer.class);
		return count;
	}

	@Override
	public List<User> getAll() {
		String sql = "select * from t_user  ";
		List<User> list = super.getJdbcTemplate().query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUserName(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				return u;
			}
		});
		return list;
	}

}
