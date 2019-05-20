package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.UserData;
import dao.UserDAO;

/**
 * Servlet implementation class AllUserServlet
 */
@WebServlet("/AllUserServlet")
public class AllUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ユーザー一覧表示 dao実装
		UserDAO userdao = new UserDAO();
		List<UserData> userList = userdao.findALLUser();
		request.setAttribute("userlist", userList);

		//sessionをとって調べます
		HttpSession session = request.getSession();
		UserData user = (UserData)session.getAttribute("userInfo");

		if (user == null) {
			//リダイレクト
			response.sendRedirect("LoginServlet");
			return;
			}


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AllUser.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//jspから入力項目を取得 名前合わせる
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");

		//検索機能追加
		UserDAO userdao = new UserDAO();
		List<UserData> userlist = userdao.UserSearch(loginId, name);

		request.setAttribute("userlist", userlist);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/AllUser.jsp");
		dispatcher.forward(request, response);

	}

}
