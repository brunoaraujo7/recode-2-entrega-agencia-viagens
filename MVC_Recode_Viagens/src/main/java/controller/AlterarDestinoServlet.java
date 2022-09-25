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
 * Servlet implementation class AlterarDestinoServlet
 */
@WebServlet("/destino-edit")
public class AlterarDestinoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		DestinoDAO destinoDAO = new DestinoDAO();
		Destino destino = destinoDAO.selectById(id);
		request.setAttribute("destino", destino);
		request.getRequestDispatcher("alterar-destino.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String cidade = request.getParameter("cidade");
		String pais = request.getParameter("pais");
		DestinoDAO destinoDAO = new DestinoDAO();
		Destino destino = new Destino();
		destino.setCidade(cidade);
		destino.setPais(pais);
		destino.setId(id);
		destinoDAO.updateById(destino);
		response.sendRedirect("destino-lista");
	}

}
