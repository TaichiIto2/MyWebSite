package controller;

import java.io.IOException;

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
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDeleteServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserData userdata = (UserData) session.getAttribute("userInfo");

		if (userdata == null) {
			//リダイレクト
			response.sendRedirect("LoginServlet");
			return;
		}

		// ユーザーをidで選択
		String id = request.getParameter("id");

		int Id = Integer.valueOf(id).intValue();

		UserDAO userdao = new UserDAO();
		UserData user = userdao.SelectUser(Id);

		request.setAttribute("user", user);

		//sessionをとって調べます

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDelete.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ユーザー削除機能実装
		String id = request.getParameter("id");
		int Id = Integer.valueOf(id).intValue();

		//UserDeleteメソッド
		UserDAO userdao = new UserDAO();
		UserData userdata = userdao.UserDelete(Id);

		response.sendRedirect("AllUserServlet");
	}

}
