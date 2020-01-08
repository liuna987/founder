package zhu.po;

import java.util.Date;

//员工表
public class TbEmp {
	private Integer eid;
	private String ename;
	private int did;
	private String gende;
	private int age;
	private Date workDate;
	private String password;

	// 部门
	private TbDept tbDept;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getGende() {
		return gende;
	}

	public void setGende(String gende) {
		this.gende = gende;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TbDept getTbDept() {
		return tbDept;
	}

	public void setTbDept(TbDept tbDept) {
		this.tbDept = tbDept;
	}

}
