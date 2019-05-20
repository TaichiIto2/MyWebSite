package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ItemData;
import beans.UserData;
import dao.ItemDAO;

/**
 * Servlet implementation class DeleteMastaServlet
 */
@WebServlet("/DeleteMastaServlet")
public class DeleteMastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMastaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sessionをとって調べます
		HttpSession session = request.getSession();
		UserData userdata = (UserData)session.getAttribute("userInfo");

		if (userdata == null) {
			//リダイレクト
			response.sendRedirect("LoginServlet");
			return;
			}

		//選択したitem表示
		String id = request.getParameter("id");
		int Id = Integer.valueOf(id).intValue();

		ItemDAO itemdao = new ItemDAO();
		ItemData item = itemdao.ChoseItem(Id);

		request.setAttribute("item", item);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/DeleteMasta.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// item削除機能
		String id = request.getParameter("id");
		int Id = Integer.valueOf(id).intValue();

		ItemDAO itemdao = new ItemDAO();
		ItemData item = itemdao.ItemDelete(Id);

		response.sendRedirect("MastaServlet");
	}

}
