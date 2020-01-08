package zhu.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import zhu.common.BaseAction;
import zhu.po.TbDept;
import zhu.po.TbEmp;
import zhu.service.ITbEmpDaoService;
import zhu.utils.JsonDateValueProcessor;

import com.opensymphony.xwork2.ActionContext;

public class EmpAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public ITbEmpDaoService mysServiceImpl;

	TbEmp tbEmp1;
    
	//声明对象
	@Override
	public TbEmp getModel() {
		if (tbEmp1 == null) {
			tbEmp1 = new TbEmp();
		}
		return tbEmp1;
	}
   
	//登录
	public String login() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (request.getParameter("password") != null) {
			return "login";
		}
		return "fail";
	}
   //查收所有的数据
	@Override
	public String listfindAll() { 
		List<TbEmp> list = mysServiceImpl.findAll();
		Map<String, String> map= new HashMap<String, String>();
		ActionContext actionContext = ServletActionContext.getContext(); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		for (int i = 0; i < list.size(); i++) { 
		 String dateString = sdf.format(list.get(i).getWorkDate());
		 map.put("data", dateString);
		}   
	    actionContext.put("list", list); 
	    actionContext.put("date", map.get("data")); 
		 return "findAll";
	}
  //新增
	@Override
	public String sava() {
		HttpServletRequest request = ServletActionContext.getRequest();
		 TbEmp emp=new TbEmp();  
		 emp.setEname(request.getParameter("ename"));
		 emp.setPassword(request.getParameter("password"));
		 emp.setGende(request.getParameter("gende")); 
		  emp.setDid(Integer.parseInt(request.getParameter("did")));
		 emp.setAge(Integer.parseInt(request.getParameter("age")));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(request.getParameter("workDate"));
			emp.setWorkDate(date);
			if (mysServiceImpl.save(emp)) {
				return "login";
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return "fail";
	}
 
 
    //查询一条数据
	@Override
	public String findById() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer id = Integer.parseInt(request.getParameter("id"));
		tbEmp1 = mysServiceImpl.findDataById(id);
		ActionContext actionContext = ServletActionContext.getContext();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateString = sdf.format(tbEmp1.getWorkDate());
		actionContext.put("tb", tbEmp1);
		 actionContext.put("date", dateString); 
		return "update";
	}
    //修改数据
	@Override
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Integer id = Integer.parseInt(request.getParameter("eid"));
		tbEmp1.setEname(request.getParameter("ename"));
		tbEmp1.setPassword(request.getParameter("password"));
		tbEmp1.setGende(request.getParameter("gende"));
		tbEmp1.setDid(Integer.parseInt(request.getParameter("did")));
		tbEmp1.setAge(Integer.parseInt(request.getParameter("age")));
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		tbEmp1.setEid(id);
		try {
			Date date = dateFormat.parse(request.getParameter("workDate"));
			if (mysServiceImpl.update(tbEmp1)) {
				return "login";
			}
		} catch (ParseException e) {

			e.printStackTrace();
		}

		return "fail";
	}
   //删除数据
	@Override
	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		if (mysServiceImpl.delete(id)) {
			return "login";
		}
		return "fail";
	}
 
}
