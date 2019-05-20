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
 * Servlet implementation class HomeShopServlet
 */
@WebServlet("/HomeShopServlet")
public class HomeShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//session
		HttpSession session = request.getSession();
		UserData user = (UserData)session.getAttribute("userInfo");
		request.setAttribute("userInfo", user);

		ItemDAO itemdao = new ItemDAO();
		//ランダムアイテム表示
		List<ItemData> itemList =itemdao.findALLItem(4);
		request.setAttribute("itemList", itemList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/HomeShop.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//

	}

}
