package zhu.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import zhu.po.TbEmp; 
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseAction extends ActionSupport implements  ModelDriven  {
	 
	//抽取统一命名方法开始
	public abstract String sava();
	public abstract String delete();
	public abstract String update();
	public abstract String findById();
   public abstract String listfindAll(); 
	
	
}
