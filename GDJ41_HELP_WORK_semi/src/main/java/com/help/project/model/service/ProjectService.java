package com.help.project.model.service;

import com.help.project.model.dao.ProjectDao;
import com.help.project.model.vo.Project;
import static com.help.common.JDBCTemplate.getConnection;
import static com.help.common.JDBCTemplate.close;
import static com.help.common.JDBCTemplate.commit;
import static com.help.common.JDBCTemplate.rollback;

import java.sql.Connection;


public class ProjectService {

	
	private ProjectDao dao = new ProjectDao();
	
	public int insertProject(Project p) {
		Connection conn = getConnection();
		int result = dao.insertProject(conn,p);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);

		return result;
	}

	
	
	
}
