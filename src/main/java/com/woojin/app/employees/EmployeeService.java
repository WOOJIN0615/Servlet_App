    package com.woojin.app.employees;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.woojin.app.ActionForward;

public class EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		this.employeeDAO=new EmployeeDAO();
	}
	
//	public void updateProcess (HttpServletRequest request, ActionForward af) throws Exception {
//		EmployeeDTO employeeDTO = new EmployeeDTO();
//		String id = request.getParameter("employee_id");
//		String fname = request.getParameter("first_name");
//		String lname = request.getParameter("last_name");
//		
//		employeeDTO.setEmployee_id(Long.parseLong(id));
//		employeeDTO.setFirst_name(fname);
//		employeeDTO.setLast_name(lname);
//		int result = employeeDAO.update(employeeDTO);
//		String str = "정보 수정 실패";
//		if (result > 0) {
//			str="정보 수정 성공";
//		}
//		request.setAttribute("result", str);
//		request.setAttribute("path", "./mypage.do");
//		af.setFlag(true);
//		af.setPath("/WEB-INF/views/commons/result.jsp");
//	}
	
	public void update (HttpServletRequest request, ActionForward af) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		EmployeeDTO session = (EmployeeDTO)request.getSession().getAttribute("user");
		employeeDTO.setFirst_name(request.getParameter("first_name"));
		employeeDTO.setLast_name(request.getParameter("last_name"));
		employeeDTO.setEmployee_id(session.getEmployee_id());

		int result=employeeDAO.update(employeeDTO);
		if (result>0) {
			session.setFirst_name(employeeDTO.getFirst_name());
		}
		
		af.setFlag(false);
		af.setPath("mypage.do");
	}
	
	public void detail(HttpServletRequest request, ActionForward af) throws Exception {
		EmployeeDTO employeeDTO=(EmployeeDTO)request.getSession().getAttribute("user");
		
		EmployeeDTO result=employeeDAO.detail(employeeDTO);
		request.setAttribute("user", result);
		
		
	}
	
	public void login(HttpServletRequest request, ActionForward af) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployee_id(Long.parseLong(request.getParameter("employee_id")));
		employeeDTO.setPassword(request.getParameter("password"));
		employeeDTO=employeeDAO.login(employeeDTO);
		
		if (employeeDTO!=null) {
			//index
			HttpSession session=request.getSession();
			
			session.setAttribute("user", employeeDTO);
			af.setFlag(false);
			af.setPath("../index.do");
		}else {
			request.setAttribute("result", "로그인에 실패했습니다.");
			request.setAttribute("path", "login.do");
			af.setFlag(true);
			af.setPath("/WEB-INF/views/employees/login.jsp");
			
		}
	}
	
	public void add(HttpServletRequest request, ActionForward af) throws Exception {
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone_number");
		String job = request.getParameter("job_id");
		String salary = request.getParameter("salary");
		String pct = request.getParameter("commission_pct");
		String man = request.getParameter("manager_id");
		String department = request.getParameter("department_id");
		String pw = request.getParameter("password");
		
		employeeDTO.setFirst_name(fname);
		employeeDTO.setLast_name(lname);
		employeeDTO.setEmail(email);
		employeeDTO.setPhone_number(phone);
		employeeDTO.setJob_id(job);
		employeeDTO.setSalary(Double.parseDouble(salary));
		employeeDTO.setCommission_pct(Double.parseDouble(pct));
		employeeDTO.setManager_id(Long.parseLong(man));
		employeeDTO.setDepartment_id(Long.parseLong(department));
		employeeDTO.setPassword(pw);
		
		int result = employeeDAO.add(employeeDTO);
		String str="사원 등록 실패";
		if (result>0) {
			str="사원 등록 성공";
		}
		request.setAttribute("result", str);
		request.setAttribute("path", "../index.do");
		af.setFlag(true);
		af.setPath("/WEB-INF/views/commons/result.jsp");

	}

}
