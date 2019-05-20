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

import beans.BuyData;
import dao.BuyDAO;

/**
 * Servlet implementation class BuyHistoryDetailServlet
 */
@WebServlet("/BuyHistoryDetailServlet")
public class BuyHistoryDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyHistoryDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッション開始
		HttpSession session = request.getSession();

		try {
			//パロメーター所得
			String id = request.getParameter("buy_id"); //jspのurlのとこで繋がってる
			int Id = Integer.valueOf(id).intValue();

			//詳細画面 上部部分作成
			BuyData bdh = BuyDAO.getBuyhistory(Id);
			request.setAttribute("bdh", bdh);

			//詳細画面 詳細表示
			List<BuyData> bdl = BuyDAO.buyDetail(Id);
			request.setAttribute("bdl", bdl);

	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyHistoryDetail.jsp");
	    	dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
