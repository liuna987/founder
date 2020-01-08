package zhu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhu.dao.IEmpDao;
import zhu.po.TbEmp;
import zhu.service.ITbEmpDaoService;

@Service
public class EmpDaoServiceImpl implements ITbEmpDaoService {

	@Resource(name = "EmpDao")
	IEmpDao EmpDao; 
	 

	@Override
	public List<TbEmp> findAll() { 
		return EmpDao.findAll();
	}



	@Override
	public boolean save(TbEmp t) { 
		return EmpDao.save(t);
	}



	@Override
	public boolean update(TbEmp t) { 
		return EmpDao.update(t);
	}



	@Override
	public boolean delete(int id) { 
		return EmpDao.delete(id);
	}



	@Override
	public TbEmp findDataById(int id) { 
		return EmpDao.findDataById(id);
	}

}
