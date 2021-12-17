package com.help.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.help.member.model.vo.Member;
import com.help.project.model.service.ProjectService;
import com.help.project.model.vo.Project;

/**
 * Servlet implementation class SelectProjectMain
 */
@WebServlet("/project/select.do")
public class SelectProjectMain extends HttpServlet {
	//My Project List버튼 누르면 들어오는 첫번째 화면 
	//로그인 후 들어오는 첫번째 화면 
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectProjectMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면 전환용 
		
		//로그인한 사원이 참여중인 모든 프로젝트 
		HttpSession session=request.getSession();
		Member loginMember=(Member)session.getAttribute("loginMember");
		
		String memId=loginMember.getMemberId();
		List<Project> join= new ProjectService().selectJoin(memId);
		for(Project p:join) {
			System.out.println(p);
		}
		
		request.setAttribute("joinPro", join);
		request.getRequestDispatcher("/views/project/myProjectView.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
