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
import beans.UserData;
import dao.BuyDAO;
import dao.UserDAO;

/**
 * Servlet implementation class BuyHistoryServlet
 */
@WebServlet("/BuyHistoryServlet")
public class BuyHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyHistoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// セッション開始
		HttpSession session = request.getSession();
		try {
			UserData ud = (UserData) session.getAttribute("userInfo");
		   	int uid = ud.getId();
			// 更新確認画面から戻ってきた場合Sessionから取得。それ以外はuserIdでユーザーを取得
		   	UserData usd = session.getAttribute("returnUSD") == null ? UserDAO.getUserByUserId(uid) : (UserData) BuyDAO.cutSessionAttribute(session, "returnUDB");

		   	List<BuyData> buyList = BuyDAO.getBuyByUserId(uid);
		   	request.setAttribute("buyList", buyList);

			request.setAttribute("ud", ud);

		   	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BuyHistory.jsp");
	    	dispatcher.forward(request, response);
		}catch (Exception e) {
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
		doGet(request, response);
	}

}
