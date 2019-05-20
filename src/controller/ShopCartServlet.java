package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DeliveryMethodData;
import beans.ShopCartData;
import beans.UserData;
import dao.DeliveryMethodDAO;
import dao.ShopCartDAO;

/**
 * Servlet implementation class ShopCartServlet
 */
@WebServlet("/ShopCartServlet")
public class ShopCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();

    	//user_id 所得 (仮)
    	UserData ud = (UserData) session.getAttribute("userInfo");
    	System.out.println(ud);
    	int uid = ud.getId();
    	System.out.println(uid);


    	//選択した商品をIDに変換
    	    String id = request.getParameter("id");
        if (id != null) {
    	    int Id = Integer.valueOf(id).intValue();
    	    String itempices = request.getParameter("item_pieces");
    	    int itemPices = Integer.valueOf(itempices).intValue();

    	    System.out.println(Id);

    	ShopCartDAO cartdao = new ShopCartDAO();
			try {
				cartdao.CreateCart(uid, Id, itemPices);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
        }
    	// カート表示
    	ShopCartDAO shopcartdao = new ShopCartDAO();
    	List<ShopCartData> cartList = shopcartdao.findCartList(uid);
    	request.setAttribute("cartList", cartList);

    	// 配送方法をDBから取得
    	ArrayList<DeliveryMethodData> dMDBList = null;
		try {
			dMDBList = DeliveryMethodDAO.getDeliveryMethod();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    	request.setAttribute("dmdbList", dMDBList);

    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/ShopCart.jsp");
    	dispatcher.forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// アイテム情報所得しカートへ

    	//ItemDAO itemdao = new ItemDAO();
    	//ItemData item = itemdao.ChoseItem(Id);
    }
}
