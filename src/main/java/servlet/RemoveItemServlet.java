package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BalsalevyDao;
import database.JDBCBalsalevyDao;
import model.Balsalevy;

@WebServlet("/removeitem")
public class RemoveItemServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		BalsalevyDao dao = new JDBCBalsalevyDao();
		dao.removeItem(new Balsalevy(Long.valueOf(id)));
		resp.sendRedirect("/sovellus?pin=424242");
	}
}
