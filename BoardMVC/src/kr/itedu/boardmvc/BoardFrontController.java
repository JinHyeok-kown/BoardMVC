package kr.itedu.boardmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.action.Action;
import kr.itedu.boardmvc.action.BoardListAction;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {
//유일한 서블릿(모든걸 관리하는)
	protected void doProc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//전체주소-루트주소값=comd
		String reqURI = request.getRequestURI(); //전체주소
		String ctxPath = request.getContextPath(); //루트주소값
		String comd = reqURI.substring(ctxPath.length());
		ActionForward forward = null; //변수명만 설정
		Action action = null; //변수명만 설정 (존재x)
		
		
		if(comd.equals("/boardList.bo")) {
			action =new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				//TODO:예외처리
				e.printStackTrace();
			}
		} else if(comd.equals("/boardDetail.bo")) {
			
		} 
		//모든컨트롤러가 리턴받는값--forward,어느방향으로갈지
		if(forward !=null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		} else {
			//TODO 없는 주소값 에러페이지 디스플레이 처리
		}
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);
	}
}
