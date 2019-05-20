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
 * Servlet implementation class UserDetailServlet
 */
@WebServlet("/UserDetailServlet")
public class UserDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの入力項目を取得
		String id = request.getParameter("id");
		int Id = Integer.valueOf(id).intValue();

		UserDAO userdao = new UserDAO();
		UserData user = userdao.SelectUser(Id);
		request.setAttribute("user", user);

		//sessionをとって調べます
		HttpSession session = request.getSession();
		UserData userdata = (UserData)session.getAttribute("userInfo");

		if (userdata == null) {
			//リダイレクト
			response.sendRedirect("LoginServlet");
			return;
			}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserDetail.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
