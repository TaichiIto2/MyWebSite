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

import beans.ItemData;
import beans.UserData;
import dao.ItemDAO;

/**
 * Servlet implementation class MastaServlet
 */
@WebServlet("/MastaServlet")
public class MastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MastaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//sessionを調べます
		HttpSession session = request.getSession();
		UserData user = (UserData)session.getAttribute("userInfo");

		if (user == null) {
			//リダイレクト
			response.sendRedirect("LoginServlet");
			return;
			}

		// Item一覧
		ItemDAO itemdao = new ItemDAO();
		List<ItemData> itemList =itemdao.findALLMasta();
		request.setAttribute("itemList", itemList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Masta.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//検索機能
		String nameP = request.getParameter("nameP");
		String sprice = request.getParameter("sprice");
		String eprice = request.getParameter("eprice");
		String screatedate = request.getParameter("screatedate");
		String ecreatedate = request.getParameter("ecreatedate");

		ItemDAO itemdao = new ItemDAO();
		List<ItemData> itemList = itemdao.ItemSearch(nameP, sprice, eprice, screatedate, ecreatedate);

		request.setAttribute("itemList", itemList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Masta.jsp");
		dispatcher.forward(request,  response);
	}

}
