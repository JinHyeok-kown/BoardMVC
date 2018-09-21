package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import kr.itedu.boardmvc.BoardVO;

public class BoardDAO {
	private static BoardDAO dao;

	private BoardDAO() {
	} // private 생성자

	public static BoardDAO getInstance() { // 싱글톤
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = " select bid,btitle," + " bregdate, "
					+ " to_char(updatedate, 'yyy-mm-dd hh24:mi:ss') as updatedate " + " from t_board" + btype
					+ " order by bid desc ";
			con = getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				String updatedate = rs.getString("updatedate");

				result.add(new BoardVO(bid, btitle, bregdate, updatedate));
			}

		} catch (SQLException e) {
			// TODO:예외처리
		} catch (Exception e) {
			// TODO:예외처리
		} finally {
			DBConnector.close(con, ps, rs);
		}

		return result;
	}

	public ArrayList<BoardVO> getPage(int btype, int page) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = String.format(
					" select * from (select rownum as rnum, z.*from (select * from t_board%d order by bid desc) z where rownum <=%d) where rnum >=%d ",
					btype, page * 10, ((page - 1) * 10) + 1);
			con = getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");
				String updatedate = rs.getString("updatedate");

				result.add(new BoardVO(bid, btitle, bregdate, updatedate));
			}

		} catch (SQLException e) {
			// TODO:예외처리
		} catch (Exception e) {
			// TODO:예외처리
		} finally {
			DBConnector.close(con, ps, rs);
		}

		return result;
	}
}
