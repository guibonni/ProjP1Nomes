package br.com.ProjP1Nomes.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.ProjP1Nomes.model.Nome;
import br.com.ProjP1Nomes.data.NomeDB;

@WebServlet("/NomeCtrl")
public class NomeCtrl extends HttpServlet {

	private static final long serialVersionUID = 1365604600878623804L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		
		if (request.getParameter("nome") != null) {
			Nome n = new Nome(request.getParameter("nome"));
			
			try {
				msg = new NomeDB().inserir(n) ? "Nome salvo com sucesso." : "Erro ao salvar o nome";
			} catch(SQLException exc) {
				msg = exc.getMessage();
			}
		} else {
			msg = "O nome não pode ser nulo";
		}
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
