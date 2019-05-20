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
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UserData userdata = (UserData)session.getAttribute("userInfo");

		if (userdata != null) {
			//リダイレクト
			response.sendRedirect("HomeShopServlet");
		return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");

		//Daoのメソッドを実行 一致を探す
		UserDAO userDao = new UserDAO();
		UserData userdata = userDao.findByLoginInfo(loginId,  password);

		/** テーブルに該当のデータが見つからなかった場合 **/
		if (userdata == null) {
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);;
			return;
		}
		if (loginId == "") {
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);;
			return;
		}
		if (password == "") {
			request.setAttribute("errMsg", "ログインIDまたはパスワードが異なります。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
			dispatcher.forward(request, response);;
			return;
		}

		//セッションにユーザー情報をセット
		HttpSession session = request.getSession();
		session.setAttribute("userInfo", userdata);

		response.sendRedirect("HomeShopServlet");
	}

}
