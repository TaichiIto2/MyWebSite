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
 * Servlet implementation class UpdateMastaServlet
 */
@WebServlet("/UpdateMastaServlet")
public class UpdateMastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMastaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// jspに表示
		String id = request.getParameter("id");
		int Id = Integer.valueOf(id).intValue();

		ItemDAO itemdao = new ItemDAO();
		ItemData item = itemdao.ChoseItem(Id);

		request.setAttribute("item", item);

		RequestDispatcher dipatcher = request.getRequestDispatcher("/WEB-INF/jsp/UpdateMasta.jsp");
		dipatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Update作成
		request.setCharacterEncoding("utf-8");

		//リクエストパラメータの入力項目を取得
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String prIce = request.getParameter("price");
		String detail = request.getParameter("detail");
		String fileName = request.getParameter("fileName");
		String stOck = request.getParameter("stock");

		int Id = Integer.parseInt(id);
		int price = Integer.parseInt(prIce);
		int stock = Integer.parseInt(stOck);

		ItemDAO itemdao = new ItemDAO();

		itemdao.UpdateItem(Id, name, price, detail, fileName, stock);

		response.sendRedirect("MastaServlet");
	}

}
