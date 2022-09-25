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
 * Servlet implementation class AlterarPacoteServlet
 */
@WebServlet("/pacote-edit")
public class AlterarPacoteServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("id"));
		PacoteDAO pacoteDAO = new PacoteDAO();
		Pacote pacote = pacoteDAO.selectById(id);
		request.setAttribute("pacote", pacote);
		request.getRequestDispatcher("alterar-pacote.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String modal = request.getParameter("modal");
		int diaria = Integer.parseInt(request.getParameter("diaria"));
		double valor = Double.parseDouble(request.getParameter("valor"));
		int id_destino = Integer.parseInt(request.getParameter("diaria"));
		
		
		PacoteDAO pacoteDAO = new PacoteDAO();
		
		
		Pacote pacote = new Pacote();
		pacote.setId(id);
		pacote.setModal(modal);
		pacote.setDiaria(diaria);
		pacote.setValor(valor);
		pacote.setId_destino(id_destino);
		pacoteDAO.updateById(pacote);
		response.sendRedirect("pacote-lista");
		
	}

}
