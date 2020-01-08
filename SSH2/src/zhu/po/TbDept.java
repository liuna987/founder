package zhu.po;

import java.util.HashSet;
import java.util.Set;

 

//部门表
public class TbDept {
	private Integer did;
	private String dname;

	//部门包含员工
	private Set<TbEmp> setEmps = new HashSet<TbEmp>(); 
	 
	public Set<TbEmp> getSetEmps() {
		return setEmps;
	}

	public void setSetEmps(Set<TbEmp> setEmps) {
		this.setEmps = setEmps;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	 

}
