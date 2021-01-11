package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DbClose;
import db.DbConn;
import entity.Goods;

/**
 * 数据库goods表操作
 * 
 * @author other,guaiu
 */
public final class GoodsDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 添加商品到数据库goods表
	 * 
	 * @author other
	 * @param goods 商品对象
	 * @return boolean
	 */
	public boolean addGoods(Goods goods) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "INSERT INTO GOODS(GNAME,GPRICE,GNUM) VALUES(?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, goods.getGname());
			pstmt.setDouble(2, goods.getGprice());
			pstmt.setInt(3, goods.getGnum());
			System.out.println("prepareStatement对象设置成功");

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement对象执行成功");
			} else {
				System.out.println("prepareStatement对象执行失败");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.addClose(pstmt, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回boolean值");
		return bool;
	}

	/**
	 * 更改商品信息到数据库goods表
	 * 
	 * @author guaiu
	 * @param goods 商品对象
	 * @return boolean
	 */
	public boolean updateGoods(Goods goods) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sqlName = "UPDATE GOODS SET GNAME=?,GPRICE=?,GNUM=? WHERE GID=?";

		try {
			pstmt = conn.prepareStatement(sqlName);
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, goods.getGname());
			pstmt.setDouble(2, goods.getGprice());
			pstmt.setInt(3, goods.getGnum());
			pstmt.setInt(4, goods.getGid());
			System.out.println("prepareStatement对象设置成功");

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement对象执行成功");
			} else {
				System.out.println("prepareStatement对象执行失败");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.addClose(pstmt, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回boolean值");
		return bool;
	}

	/**
	 * 从数据库goods表中-刪除商品
	 * 
	 * @author other
	 * @param gid 商品编号
	 * @return boolean
	 */
	public boolean deleteGoods(int gid) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "DELETE FROM GOODS WHERE GID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement对象获取成功");
			pstmt.setInt(1, gid);
			System.out.println("prepareStatement对象设置成功");
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement对象执行成功");
			} else {
				System.out.println("prepareStatement对象执行失败");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.addClose(pstmt, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回boolean值");
		return bool;
	}

	/**
	 * 显示所有商品信息,默认排序
	 * 
	 * @author ohter,guaiu
	 * @return ArrayList<Goods>
	 */
	public ArrayList<Goods> displayGoods() {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();
		String sql = "SELECT * FROM GOODS";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement对象获取成功");
			System.out.println("prepareStatement对象设置成功"); // 已设置

			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");

			while (rs.next()) {
				int gid = rs.getInt(1);
//				int gid = rs.getInt("gid"); //双引号+主键名,也可用数字表示.
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);

				Goods goods = new Goods(gid, gname, gprice, gnum); // 创建Goods对象，并赋值.
				goodsList.add(goods); // 添加信息到ArrayList<Goods>中.
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<Goods> goodsList");
		return goodsList;

	}

	/**
	 * 根据商品 gid查询商品
	 * 
	 * @author guaiu
	 * @param 商品id
	 * @return 商品信息
	 */
	public ArrayList<Goods> queryGoodsId(int gId) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM GOODS WHERE GID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement对象获取成功");
			pstmt.setInt(1, gId);
			System.out.println("prepareStatement对象设置成功");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");
			while (rs.next()) {
				int gid = rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);

				Goods goods = new Goods(gid, gname, gprice, gnum);
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<Goods> goodsList");
		return goodsList;
	}

	/**
	 * 根据商品 gName查询商品(模糊查询)
	 * 
	 * @author guaiu
	 * @param 商品名称
	 * @return 商品信息
	 */
	public ArrayList<Goods> queryGoodsNameFuzzy(String gName) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM GOODS WHERE GNAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, "%" + gName + "%");
			System.out.println("prepareStatement对象设置成功");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");
			while (rs.next()) {
				int gid = rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid, gname, gprice, gnum);
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<Goods> goodsList");
		return goodsList;
	}
	
	/**
	 * 根据商品 gName查询商品(精确查询)
	 * 
	 * @author guaiu
	 * @param 商品名称
	 * @return 商品信息
	 */
	public ArrayList<Goods> queryGoodsNameExact(String gName) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM GOODS WHERE GNAME=?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement对象获取成功");
			pstmt.setString(1, gName);
			System.out.println("prepareStatement对象设置成功");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement对象执行成功");
			while (rs.next()) {
				int gid = rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid, gname, gprice, gnum);
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement对象发生异常");
			e.printStackTrace();
		} finally {
			System.out.println("开始关闭操作数据库时产生的资源流");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("资源流已关闭");
		}
		System.out.println("返回ArrayList<Goods> goodsList");
		return goodsList;
	}

}

//	/**
//	 * 更改商品信息到数据库goods表
//	 * 
//	 * @author other
//	 * @param key   选择要更改商品信息
//	 * @param goods 商品对象
//	 * @return boolean
//	 */
//	public boolean updateGoods(int key, Goods goods) {
//		boolean bool = false;
//		conn = DbConn.getconn();
//		switch (key) {
//		case 1: // key=1,更改商品名称
//			String sqlName = "UPDATE GOODS SET GNAME=? WHERE GID=?";
//
//			try {
//				pstmt = conn.prepareStatement(sqlName);
//				pstmt.setString(1, goods.getGname());
//				pstmt.setInt(2, goods.getGid());
//
//				int rs = pstmt.executeUpdate();
//				if (rs > 0) {
//					bool = true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				DbClose.addClose(pstmt, conn);
//			}
//			break;
//		case 2: // key=2,更改商品价格
//			String sqlPrice = "UPDATE GOODS SET GPRICE=? WHERE GID=?";
//
//			try {
//				pstmt = conn.prepareStatement(sqlPrice);
//				pstmt.setDouble(1, goods.getGprice());
//				pstmt.setInt(2, goods.getGid());
//
//				int rs = pstmt.executeUpdate();
//				if (rs > 0) {
//					bool = true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				DbClose.addClose(pstmt, conn);
//			}
//			break;
//		case 3: // key=3,更改商品数量
//			String sqlNum = "UPDATE GOODS SET GNUM=? WHERE GID=?";
//
//			try {
//				pstmt = conn.prepareStatement(sqlNum);
//				pstmt.setInt(1, goods.getGnum());
//				pstmt.setInt(2, goods.getGid());
//
//				int rs = pstmt.executeUpdate();
//				if (rs > 0) {
//					bool = true;
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				DbClose.addClose(pstmt, conn);
//			}
//			break;
//		default:
//			break;
//		}
//		return bool;
//	}

//	/**
//	 * 查询商品信息
//	 * @author other
//	 * @param key 查询方式
//	 * @return ArrayList<Goods>
//	 */
//	public ArrayList<Goods> queryGoods(int key) 
//	{										
//		ArrayList<Goods> goodsList = new ArrayList<Goods>();
//		conn = DbConn.getconn();	
//
//		switch (key)
//		{
//			case 1:
//					//	key=1商品 数量 升序查询
//					String sqlGnum = "SELECT * FROM GOODS ORDER BY GNUM ASC";
//					try
//					{
//						pstmt = conn.prepareStatement(sqlGnum);
//						rs = pstmt.executeQuery();
//						while (rs.next())
//						{
//							int gid = rs.getInt("gid");
//							String gname = rs.getString(2);
//							double gprice = rs.getDouble(3);
//							int gnum = rs.getInt(4);
//							
//							Goods goods = new Goods(gid,gname,gprice,gnum);
//							goodsList.add(goods);
//						}
//					} catch (SQLException e)
//					{
//						e.printStackTrace();
//					}finally
//							{
//								DbClose.queryClose(pstmt, rs, conn);
//							}
//				break;
//			case 2:
//				 	//	key=2商品 价格 升序查询
//					String sqlGprice = "SELECT * FROM GOODS ORDER BY GPRICE ASC";
//					try
//					{
//						pstmt = conn.prepareStatement(sqlGprice);
//						rs = pstmt.executeQuery();
//						while (rs.next())
//						{
//							int gid = rs.getInt("gid");
//							String gname = rs.getString(2);
//							double gprice = rs.getDouble(3);
//							int gnum = rs.getInt(4);
//							
//							Goods goods = new Goods(gid,gname,gprice,gnum);
//							goodsList.add(goods);
//						}
//					} catch (SQLException e)
//					{
//						e.printStackTrace();
//					}finally
//							{
//								DbClose.queryClose(pstmt, rs, conn);
//							}
//				break;
//			case 3:
//					//	key=3商品 关键字 查询
//					String nameGet = ScannerChoice.ScannerInfoString();
//					String sqlGname = "SELECT * FROM GOODS WHERE GNAME LIKE '%'||?||'%'";
//					try
//					{
//						pstmt = conn.prepareStatement(sqlGname);
//						pstmt.setString(1, nameGet);
//						rs = pstmt.executeQuery();
//						while (rs.next())
//						{
//							int gid = rs.getInt("gid");
//							String gname = rs.getString(2);
//							double gprice = rs.getDouble(3);
//							int gnum = rs.getInt(4);
//							
//							Goods goods = new Goods(gid,gname,gprice,gnum);
//							goodsList.add(goods);
//						}
//					} catch (SQLException e)
//					{
//						e.printStackTrace();
//					}finally
//					{
//						DbClose.queryClose(pstmt, rs, conn);
//					}
//					break;
//			default:
//				break;
//		}
//		return goodsList;
//	}