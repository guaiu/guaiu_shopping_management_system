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
 * ���ݿ�goods�����
 * 
 * @author other,guaiu
 */
public final class GoodsDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * �����Ʒ�����ݿ�goods��
	 * 
	 * @author other
	 * @param goods ��Ʒ����
	 * @return boolean
	 */
	public boolean addGoods(Goods goods) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "INSERT INTO GOODS(GNAME,GPRICE,GNUM) VALUES(?,?,?)";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, goods.getGname());
			pstmt.setDouble(2, goods.getGprice());
			pstmt.setInt(3, goods.getGnum());
			System.out.println("prepareStatement�������óɹ�");

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement����ִ�гɹ�");
			} else {
				System.out.println("prepareStatement����ִ��ʧ��");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.addClose(pstmt, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����booleanֵ");
		return bool;
	}

	/**
	 * ������Ʒ��Ϣ�����ݿ�goods��
	 * 
	 * @author guaiu
	 * @param goods ��Ʒ����
	 * @return boolean
	 */
	public boolean updateGoods(Goods goods) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sqlName = "UPDATE GOODS SET GNAME=?,GPRICE=?,GNUM=? WHERE GID=?";

		try {
			pstmt = conn.prepareStatement(sqlName);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, goods.getGname());
			pstmt.setDouble(2, goods.getGprice());
			pstmt.setInt(3, goods.getGnum());
			pstmt.setInt(4, goods.getGid());
			System.out.println("prepareStatement�������óɹ�");

			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement����ִ�гɹ�");
			} else {
				System.out.println("prepareStatement����ִ��ʧ��");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.addClose(pstmt, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����booleanֵ");
		return bool;
	}

	/**
	 * �����ݿ�goods����-�h����Ʒ
	 * 
	 * @author other
	 * @param gid ��Ʒ���
	 * @return boolean
	 */
	public boolean deleteGoods(int gid) {
		boolean bool = false;
		conn = DbConn.getconn();
		String sql = "DELETE FROM GOODS WHERE GID=?";

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setInt(1, gid);
			System.out.println("prepareStatement�������óɹ�");
			int rs = pstmt.executeUpdate();
			if (rs > 0) {
				bool = true;
				System.out.println("prepareStatement����ִ�гɹ�");
			} else {
				System.out.println("prepareStatement����ִ��ʧ��");
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.addClose(pstmt, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����booleanֵ");
		return bool;
	}

	/**
	 * ��ʾ������Ʒ��Ϣ,Ĭ������
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
			System.out.println("prepareStatement�����ȡ�ɹ�");
			System.out.println("prepareStatement�������óɹ�"); // ������

			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");

			while (rs.next()) {
				int gid = rs.getInt(1);
//				int gid = rs.getInt("gid"); //˫����+������,Ҳ�������ֱ�ʾ.
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);

				Goods goods = new Goods(gid, gname, gprice, gnum); // ����Goods���󣬲���ֵ.
				goodsList.add(goods); // �����Ϣ��ArrayList<Goods>��.
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<Goods> goodsList");
		return goodsList;

	}

	/**
	 * ������Ʒ gid��ѯ��Ʒ
	 * 
	 * @author guaiu
	 * @param ��Ʒid
	 * @return ��Ʒ��Ϣ
	 */
	public ArrayList<Goods> queryGoodsId(int gId) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM GOODS WHERE GID=?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setInt(1, gId);
			System.out.println("prepareStatement�������óɹ�");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");
			while (rs.next()) {
				int gid = rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);

				Goods goods = new Goods(gid, gname, gprice, gnum);
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<Goods> goodsList");
		return goodsList;
	}

	/**
	 * ������Ʒ gName��ѯ��Ʒ(ģ����ѯ)
	 * 
	 * @author guaiu
	 * @param ��Ʒ����
	 * @return ��Ʒ��Ϣ
	 */
	public ArrayList<Goods> queryGoodsNameFuzzy(String gName) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM GOODS WHERE GNAME LIKE ?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, "%" + gName + "%");
			System.out.println("prepareStatement�������óɹ�");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");
			while (rs.next()) {
				int gid = rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid, gname, gprice, gnum);
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<Goods> goodsList");
		return goodsList;
	}
	
	/**
	 * ������Ʒ gName��ѯ��Ʒ(��ȷ��ѯ)
	 * 
	 * @author guaiu
	 * @param ��Ʒ����
	 * @return ��Ʒ��Ϣ
	 */
	public ArrayList<Goods> queryGoodsNameExact(String gName) {
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		conn = DbConn.getconn();

		String sql = "SELECT * FROM GOODS WHERE GNAME=?";
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println("prepareStatement�����ȡ�ɹ�");
			pstmt.setString(1, gName);
			System.out.println("prepareStatement�������óɹ�");
			rs = pstmt.executeQuery();
			System.out.println("prepareStatement����ִ�гɹ�");
			while (rs.next()) {
				int gid = rs.getInt(1);
				String gname = rs.getString(2);
				double gprice = rs.getDouble(3);
				int gnum = rs.getInt(4);
				
				Goods goods = new Goods(gid, gname, gprice, gnum);
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			System.out.println("prepareStatement�������쳣");
			e.printStackTrace();
		} finally {
			System.out.println("��ʼ�رղ������ݿ�ʱ��������Դ��");
			DbClose.queryClose(pstmt, rs, conn);
			System.out.println("��Դ���ѹر�");
		}
		System.out.println("����ArrayList<Goods> goodsList");
		return goodsList;
	}

}

//	/**
//	 * ������Ʒ��Ϣ�����ݿ�goods��
//	 * 
//	 * @author other
//	 * @param key   ѡ��Ҫ������Ʒ��Ϣ
//	 * @param goods ��Ʒ����
//	 * @return boolean
//	 */
//	public boolean updateGoods(int key, Goods goods) {
//		boolean bool = false;
//		conn = DbConn.getconn();
//		switch (key) {
//		case 1: // key=1,������Ʒ����
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
//		case 2: // key=2,������Ʒ�۸�
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
//		case 3: // key=3,������Ʒ����
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
//	 * ��ѯ��Ʒ��Ϣ
//	 * @author other
//	 * @param key ��ѯ��ʽ
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
//					//	key=1��Ʒ ���� �����ѯ
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
//				 	//	key=2��Ʒ �۸� �����ѯ
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
//					//	key=3��Ʒ �ؼ��� ��ѯ
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