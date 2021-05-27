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

@WebServlet("/additem")
public class AddItemServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String korkeus = req.getParameter("korkeus");
		String pituus = req.getParameter("pituus");
    	String leveys = req.getParameter("leveys");
    	String paino = req.getParameter("paino");
    	String grain = req.getParameter("grain");
    	double korkeusMm, leveysMm, pituusMm, painoG, tulosKgM3;
    	if (korkeus != null && leveys != null && pituus != null && paino != null && grain != null) {
    		korkeusMm = Double.parseDouble(korkeus);
    		pituusMm = Double.parseDouble(pituus);
    		leveysMm = Double.parseDouble(leveys);
    		painoG = Double.parseDouble(paino);
    		tulosKgM3 = ((painoG / 1000) / (korkeusMm * pituusMm * leveysMm / 1000000000.0));
    		
    		BalsalevyDao dao = new JDBCBalsalevyDao();
    		dao.addItem(new Balsalevy(tulosKgM3, korkeusMm, leveysMm, painoG, pituusMm, grain));

    		resp.sendRedirect("/sovellus?pin=424242&tulosKg=" + tulosKgM3
    				+ "&a=" + korkeus + "&b=" + pituus + "&c=" + leveys + "&d=" + paino + "&e=" + grain);
    	} else {
    		resp.sendRedirect("/sovellus?pin=424242");
    	}
	}
}
