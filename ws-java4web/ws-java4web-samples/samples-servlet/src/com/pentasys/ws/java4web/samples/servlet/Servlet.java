package com.pentasys.ws.java4web.samples.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 * URL: http://localhost:8080/ServletExample/Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // MIME-Typ der Antwort bestimmen
	      response.setContentType("text/html");

	      // Writer holen
	      PrintWriter out = response.getWriter();

	      // HTML-Seite ausgeben
	      out.println("<html>");
	      out.println("<head>");

	      out.println("<title>Test</title>");
	      out.println("</head>");
	      out.println("<body bgcolor=\"white\">");
	      out.println("<h1>Testen ist schön... <br /><span style=\"color:red;\">Fehler suchen noch schöner.. *g*</span></h1>");
	      out.println("</body>");
	      out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
