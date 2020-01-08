package zhu.dao.imp;

import java.util.Date;
import java.util.List;
 
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

 

import sun.launcher.resources.launcher;

import zhu.dao.IEmpDao;
 
import zhu.po.TbEmp;
@Repository(value="EmpDao")
@Transactional
public class EmpDaoImpl implements IEmpDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}
	boolean b=false;
	 
	@SuppressWarnings("unchecked")
	@Override
	public List<TbEmp> findAll() {
		String hql="from TbEmp c left outer join fetch  c.tbDept  ";
		Query query=getSession().createQuery(hql);
		List<TbEmp> lsitEmps=query.list();
	//	List<TbEmp> tbEmps=(List<TbEmp>) getSession().createQuery(hql);
		return lsitEmps;
	}
 
	@Override
	public boolean save(TbEmp t) {
		try {
			getSession().save(t);
			b=true;
		} catch (Exception e) { 
		}
		return b;
	}
	
	/**查询一条数据还可以这样
	 * String hql = "FROM User WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		User user = (User) query.list().get(0);
	 */
	@Override
	public TbEmp findDataById(int id) {
		String hql="from TbEmp e left outer join fetch  e.tbDept  where eid= "+id;
		Query query=getSession().createQuery(hql);
		TbEmp tbEmp=(TbEmp) query.uniqueResult();
	 return tbEmp;
	}
	  /** 删除还可以这样
	   * String hql = "DELETE FROM User WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
	   */
	@Override
	public boolean delete(int id) {
		String hql="delete from TbEmp c  where c.eid= "+id;
		Query query=getSession().createQuery(hql);
		try {
			 query.executeUpdate();
			 b=true;
		} catch (Exception e) {
			 
		}
		return b;
	}
	 
	@Override
	public boolean update(TbEmp t) {
		String hql="update TbEmp  set ename=:ename,did=:did,gende=:gende,age=:age,workDate=:workDate,password=:password where eid=:eid ";
		Query query=getSession().createQuery(hql);
		query.setString("ename", t.getEname());
		 query.setInteger("did", t.getDid());
		query.setString("gende", t.getGende());
		query.setInteger("age", t.getAge());
		query.setDate("workDate", t.getWorkDate());
		query.setString("password", t.getPassword());
		query.setInteger("eid", t.getEid());
		try {
			 query.executeUpdate();
			b=true;
		} catch (Exception e) {
			 
		}
		return b;
	}
  /* 修改还可以这样
   *1---- Query query = session.createQuery(hql);
		query.setParameter("name", user.getName());
		query.setParameter("sex", user.isSex());
		query.setParameter("birthday", user.getBirthday());
		query.setParameter("balance", user.getBalance());
		query.setParameter("id", user.getId()); 
   *
   * 
   * */

	 

	 

}
