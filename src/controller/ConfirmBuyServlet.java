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
import beans.DeliveryMethodData;
import beans.ShopCartData;
import beans.UserData;
import dao.BuyDAO;
import dao.DeliveryMethodDAO;
import dao.ShopCartDAO;

/**
 * Servlet implementation class ConfirmBuyServlet
 */
@WebServlet("/ConfirmBuyServlet")
public class ConfirmBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

    	//user_id 所得 (仮)
    	UserData ud = (UserData) session.getAttribute("userInfo");
    	System.out.println(ud);
    	int uid = ud.getId();
    	System.out.println(uid);

    	// カート表示
    	ShopCartDAO shopcartdao = new ShopCartDAO();
    	List<ShopCartData> cartList = shopcartdao.findCartList(uid);

    	request.setAttribute("cartList", cartList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			//user_id 所得 (仮)
			UserData ud = (UserData) session.getAttribute("userInfo");
			System.out.println(ud);
			int uid = ud.getId();
			System.out.println(uid);

			// 選択された配送方法IDを取得
			String inputDeliveryId = request.getParameter("delivery_method_id");
			int deliveryId = Integer.valueOf(inputDeliveryId).intValue();

			//選択されたIDをもとに配送方法所得
			DeliveryMethodData userSelectDMB = DeliveryMethodDAO.getDeliveryaByID(deliveryId);

	    	// カート表示
	    	ShopCartDAO shopcartdao = new ShopCartDAO();
	    	List<ShopCartData> cartList = shopcartdao.findCartList(uid);

	    	request.setAttribute("cartList", cartList);

	    	//合計金額
	    	int totalPrice = BuyDAO.getTotalItemPrice(cartList);
	    	int totalItem = BuyDAO.getTotalItem(cartList);

			BuyData bd = new BuyData();
			bd.setUserId(uid);
		   	bd.setTotalPrice(totalPrice);
	    	bd.setCartitemNum(totalItem);

			bd.setDeliveryMethodId(userSelectDMB.getId());
			bd.setDeliveryMethodName(userSelectDMB.getName());
			bd.setDeliveryMethodPrice(userSelectDMB.getPrice());

			session.setAttribute("bd", bd);
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ConfirmBuy.jsp");
	    	dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}

}
