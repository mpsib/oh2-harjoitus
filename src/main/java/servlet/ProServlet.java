package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BalsalevyDao;
import database.JDBCBalsalevyDao;
import model.Balsalevy;

@WebServlet("/sovellus")
public class ProServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pin = req.getParameter("pin");
		//pin-koodi on 424242
		if(pin != null && pin.equals("424242")) {
			req.setAttribute("tulosKg", req.getParameter("tulosKg"));
	    	req.setAttribute("a", req.getParameter("a"));
	    	req.setAttribute("b", req.getParameter("b"));
	    	req.setAttribute("c", req.getParameter("c"));
	    	req.setAttribute("d", req.getParameter("d"));
	    	req.setAttribute("e", req.getParameter("e"));
			BalsalevyDao dao = new JDBCBalsalevyDao();
			List<Balsalevy> daoList = dao.getAllItems();
			req.setAttribute("daolist", daoList);
			req.getRequestDispatcher("/WEB-INF/program.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("/WEB-INF/pin.jsp").forward(req, resp);
		}
		
	}
}
