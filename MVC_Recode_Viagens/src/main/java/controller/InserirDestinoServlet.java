package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Destino;
import model.DestinoDAO;

/**
 * Servlet implementation class InserirDestinoServlet
 */
@WebServlet("/destino-insert")
public class InserirDestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cidade = request.getParameter("cidade");
		String pais = request.getParameter("pais");
		DestinoDAO destinoDAO = new DestinoDAO();
		Destino destino = new Destino();
		destino.setCidade(cidade);
		destino.setPais(pais);
		destinoDAO.insert(destino);
		response.sendRedirect("destino-lista");
	}

}
