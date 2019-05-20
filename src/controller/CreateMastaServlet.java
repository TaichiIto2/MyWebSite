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
 * Servlet implementation class CreateMastaServlet
 */
@WebServlet("/CreateMastaServlet")
public class CreateMastaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMastaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/CreateMasta.jsp");
		dispatcher.forward(request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// item新規作成
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの入力項目を取得
		String name = request.getParameter("name");
		String detail = request.getParameter("detail");
		String price = request.getParameter("price");
		String filename = request.getParameter("file_name");
		String stock = request.getParameter("stock");
		String createdate = request.getParameter("create_date");

		//intに直す
		int priceInt = Integer.valueOf(price).intValue();
		int stockInt = Integer.valueOf(stock).intValue();

		//新規作成
		ItemDAO itemdao = new ItemDAO();
		ItemData itemdata = itemdao.New_Make_Item(name, detail, priceInt, filename, stockInt);

		response.sendRedirect("MastaServlet");
	}

}
