package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pacote;
import model.PacoteDAO;

/**
 * Servlet implementation class InserirPacoteServlet
 */
@WebServlet("/pacote-insert")
public class InserirPacoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String modal = request.getParameter("modal");
		int diaria = Integer.parseInt(request.getParameter("diaria"));
		double valor = Double.parseDouble(request.getParameter("valor"));
		int id_destino = Integer.parseInt(request.getParameter("diaria"));
		
		
		PacoteDAO pacoteDAO = new PacoteDAO();
		
		Pacote pacote = new Pacote();
		pacote.setModal(modal);
		pacote.setDiaria(diaria);
		pacote.setValor(valor);
		pacote.setId_destino(id_destino);
		pacoteDAO.insert(pacote);
		response.sendRedirect("pacote-lista");

	}

}
