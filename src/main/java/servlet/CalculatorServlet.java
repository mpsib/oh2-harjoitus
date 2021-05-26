package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class CalculatorServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    	req.setAttribute("tulosKg", req.getParameter("tulosKg"));
    	req.setAttribute("tulosLb", req.getParameter("tulosLb"));
    	req.setAttribute("a", req.getParameter("a"));
    	req.setAttribute("b", req.getParameter("b"));
    	req.setAttribute("c", req.getParameter("c"));
    	req.setAttribute("d", req.getParameter("d"));
    	
    	req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String paksuus = req.getParameter("paksuus");
    	String pituus = req.getParameter("pituus");
    	String leveys = req.getParameter("leveys");
    	String paino = req.getParameter("paino");
    	double paksuusMm, leveysMm, pituusMm, painoG, tulosKgM3, tulosLbFt3;
    	if(paksuus != null && pituus != null && leveys != null && paino != null) {
    		paksuusMm = Double.parseDouble(paksuus);
    		pituusMm = Double.parseDouble(pituus);
    		leveysMm = Double.parseDouble(leveys);
    		painoG = Double.parseDouble(paino);
    		
    		
    		tulosKgM3 = ((painoG / 1000) / (paksuusMm * pituusMm * leveysMm / 1000000000.0));
    		//1 lb/ft^3 = 16.018463 Kg/m^3 from https://www.convertunits.com/from/kilograms+per+cubic+meter/to/pounds+per+cubic+foot
    		tulosLbFt3 = tulosKgM3 * (1 / 16.018463);

			resp.sendRedirect("/?tulosKg=" + tulosKgM3 + "&tulosLb=" + tulosLbFt3
					+ "&a=" + paksuus + "&b=" + pituus + "&c=" + leveys + "&d=" + paino);
			
    	}
    	
    	
    }
}
