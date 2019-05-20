package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ShopCartData;
import dao.ShopCartDAO;

/**
 * Servlet implementation class ItemDeleteServlet
 */
@WebServlet("/ItemDeleteServlet")
public class ItemDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 削除機能
		String id = request.getParameter("id");
		int Id = Integer.valueOf(id).intValue();

		ShopCartDAO cartdao = new ShopCartDAO();
		ShopCartData cartitem = cartdao.CartItemDelete(Id);

		response.sendRedirect("ShopCartServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
