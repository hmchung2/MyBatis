package kr.ac.kopo;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.board.BoardDAO;

public class MybatisMain {
	
	
	public static void main(String[] args) {
		
//		SqlSession session = new MyConfig().getInstance();
//		System.out.println("session : " + session);
		BoardDAO dao = new BoardDAO();
		dao.work();
	}
}
 