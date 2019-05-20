package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserData;
import dao.UserDAO;

/**
 * Servlet implementation class NewMakeServlet
 */
@WebServlet("/NewMakeServlet")
public class NewMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMakeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewMake.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 新規登録

		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの入力項目を取得
		String Id = request.getParameter("id");
		String loginId = request.getParameter("loginid");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String postcode = request.getParameter("postcode");
		String metropolis = request.getParameter("metropolis");
		String districts = request.getParameter("districts");
		String addres = request.getParameter("addres");
		String create_date = request.getParameter("create_date");
		String update_date = request.getParameter("update_date");

		//postcodeをint型にします。
		int postCode = Integer.valueOf(postcode).intValue();

		//新規作成をdaoから使います
		UserDAO userdao = new UserDAO();
		UserData userdate = userdao.Make_New_User(name, loginId, password, email, postCode, metropolis, districts, addres);

		response.sendRedirect("HomeShopServlet");
	}

}
