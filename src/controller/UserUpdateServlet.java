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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");

		int num = Integer.valueOf(id).intValue();

		UserDAO userDao = new UserDAO();
		UserData user = userDao.SelectUser(num);

		request.setAttribute("user", user);

		RequestDispatcher dipatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
		dipatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Update
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");

		//user_id 所得 (仮)
		UserData ud = (UserData) session.getAttribute("userInfo");
		int uid = ud.getId();

		//リクエストパラメータの入力項目を取得
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		String post = request.getParameter("post");
		String metropolis = request.getParameter("metropolis");
		String districts = request.getParameter("districts");
		String addres = request.getParameter("addres");

		int Id = Integer.parseInt(id);
		int postcode = Integer.parseInt(post);

		UserData u = new UserData();
		UserDAO userdao = new UserDAO();

		if (password.isEmpty()) {
			if (email.isEmpty()) {
				userdao.NewUpdateNoemailPass(Id, name, loginId, postcode, metropolis,
						districts, addres);
			}
			else {
				userdao.NewUpdateNopas(Id, name, loginId, email, postcode, metropolis,
					districts, addres);
			}
		}
		else if (email.isEmpty()){
			userdao.NewUpdateNoemail(Id, name, loginId, password, postcode, metropolis,
					districts, addres);
		}
		else {
			userdao.NewUpdate(Id, name, loginId, password, email, postcode, metropolis,
					districts, addres);
		}
		response.sendRedirect("AllUserServlet");

	}

}
