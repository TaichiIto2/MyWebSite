package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ItemData;
import dao.ItemDAO;

/**
 * Servlet implementation class DetailMastaServlet
 */
@WebServlet("/DetailMastaServlet")
public class DetailMastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailMastaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 商品詳細を表示
		String id = request.getParameter("id");
		int Id = Integer.valueOf(id).intValue();

		ItemDAO itemdao = new ItemDAO();
		ItemData item= itemdao.ChoseItem(Id);
		request.setAttribute("item", item);

		//sessionをとって調べます


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/DetailMasta.jsp");
		dispatcher.forward(request,  response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
