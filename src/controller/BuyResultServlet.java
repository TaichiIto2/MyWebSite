package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.BuyData;
import beans.BuyDetailData;
import beans.ItemData;
import beans.ShopCartData;
import beans.UserData;
import dao.BuyDAO;
import dao.BuyDetailDAO;
import dao.ItemDAO;
import dao.ShopCartDAO;

/**
 * Servlet implementation class BuyResultServlet
 */
@WebServlet("/BuyResultServlet")
public class BuyResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();

		try {
			//user_id 所得 (仮)
			UserData ud = (UserData) session.getAttribute("userInfo");
			int uid = ud.getId();
	    	// カート表示
	    	ShopCartDAO shopcartdao = new ShopCartDAO();
	    	List<ShopCartData> cartList = shopcartdao.findCartList(uid);

			BuyData bd = (BuyData) BuyDAO.cutSessionAttribute(session, "bd");
			//購入情報登録
			int buyId = BuyDAO.insertBuy(bd);

			// 購入詳細情報を購入情報IDに紐づけして登録
			for (ShopCartData cartInItem : cartList) {
				BuyDetailData buyitem = new BuyDetailData();
				buyitem.setBuyId(buyId);
				buyitem.setItemId(cartInItem.getItemId());
				buyitem.setCart_item_num(cartInItem.getCartitemNum());
				BuyDetailDAO.insertBuyDetail(buyitem);
			}
			//在庫を減らす
			for (ShopCartData cartInItem : cartList) {
				BuyDetailData itemDetail = new BuyDetailData();
				ItemData item = new ItemData();
				itemDetail.setItemId(cartInItem.getItemId());
				//アイテム情報を取得
				item = ItemDAO.datatoItem(itemDetail);

				itemDetail.setCart_item_num(cartInItem.getCartitemNum());
				BuyDetailDAO.decreaseItem(itemDetail, item);
			}
			//購入完了ページ表示
			BuyData resultBD = BuyDAO.getDataByBuyId(buyId);
			request.setAttribute("resultBD", resultBD);

			//購入アイテム情報
			List<ItemData> buyIBList = BuyDetailDAO.getItemListByBuyId(buyId);
			request.setAttribute("buyIBList", buyIBList);

			//カート削除
			ShopCartDAO cartdao = new ShopCartDAO();
			cartdao.deleteInCartItem(uid);

			response.sendRedirect("HomeShopServlet");
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("errorMessage", e.toString());
			response.sendRedirect("Error");
		}
	}
}
