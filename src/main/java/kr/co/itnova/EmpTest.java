package kr.co.itnova;

import java.util.List;

public class EmpTest {

	public static void main(String[] args) {
		DbHelper helper = new DbHelper();
		EmpDao empDao = new EmpDao();
		empDao.setConnection(helper.getConnection());
		List<EmpVo> emps = empDao.getList();
		for(EmpVo emp : emps) {
			System.out.println(emp.getNum() + ":" + emp.getName());
		}
	}

}
