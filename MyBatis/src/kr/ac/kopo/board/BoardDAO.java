package kr.ac.kopo.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;

public class BoardDAO {
	
	private SqlSession session;

	public BoardDAO() {
		session = new MyConfig().getInstance();
		System.out.println("session : " + session);
				
	}	
	
	public void work() {
		//selectWhere();
		selectNos();
		//selectOne4();
		//selectOne3();
		//selectOne2();
		//selectOne();
		//selectAll();
		//insert();
	}
	
	public void selectWhere() {
//		List<BoardVO> list  = session.selectList("board.BoardDAO.selectWhere" , "ad");
//		for(BoardVO b : list) {
//			System.out.println(b);
//		}
		
		BoardVO vo = new BoardVO();
		vo.setTitle("ad");
//		vo.setWriter("admin");
		List<BoardVO> list  = session.selectList("board.BoardDAO.selectWhere2" , vo);
		for(BoardVO b : list) {
			System.out.println(b);
		}			
	}
	
	
	public void selectNos() {
//		BoardVO board = new BoardVO();
//		board.setNos(new int[] {1,21,22,87,5,19,20,253});
//		List<BoardVO> list =  session.selectList("board.BoardDAO.selectNos" ,  board);
		
//		List<Integer> nos = new ArrayList<>();
//		nos.add(1);
//		nos.add(21);
//		nos.add(22);
//		nos.add(77);
//		nos.add(232);
//		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos2", nos);

		int[] nos = new int[] {1,21,22,77,232};						
		List<BoardVO> list =  session.selectList("board.BoardDAO.selectNos3" ,  nos);

		for(BoardVO b : list) {
			System.out.println(b);
		}
	}
	
	public void insert() {
		BoardVO board = new BoardVO();
		board.setTitle("객체로 삽입 ... ");
		board.setWriter("홍길동");
		board.setContent("삽입되었나???");
				
		session.insert("board.BoardDAO.newBoard" , board);
		session.commit();
		System.out.println("삽입 완료");
	}
	
	public void selectAll() {
		List<BoardVO> list =  session.selectList("board.BoardDAO.selectAllMap");
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	public void selectOne() {
		BoardVO board = new BoardVO();
		board.setNo(22);
		
		BoardVO result = session.selectOne("board.BoardDAO.selectOne",board);
		System.out.println(result);
	}
	
	public void selectOne2() {

		BoardVO result = session.selectOne("board.BoardDAO.selectOne2",22);
		System.out.println(result);
	}
	
	public void selectOne3() {

		BoardVO result = session.selectOne("board.BoardDAO.selectOne3",22);
		System.out.println(result);
	}
	
	public void selectOne4() {		
		Map<String,Object> map = session.selectOne("board.BoardDAO.selectOne4",1);
		Set<String> keys =map.keySet();
		for(String key : keys) {
			System.out.println(key + " : " + map.get(key));
		}
	}
	
	
}
