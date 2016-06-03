package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import accesdonnees.DBExceptions;
import accesdonnees.QuizzDAOImpl;
import entite.Factory;
import entite.Quizz;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/ControlerServlet")
public class ControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControlerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		// Est ce que je suis loggué ?
		if (request.getSession().getAttribute("login") == null) {
			// Je ne suis pas loggué

			// Est ce que je reviens de mon écran de loggin
			if (request.getParameter("login") == null) {
				// Je lance l'écran
				
					request.getRequestDispatcher("loggin.jsp").forward(request, response);
				
			} else {
				// mettre l'information en session
				request.getSession().setAttribute("login", request.getParameter("login"));
				request.getRequestDispatcher("ControlerServlet").forward(request, response);
			
			}

		} else {
			
			//J'ai le choix entre différents thèmes
			String theme = request.getParameter("theme");
			
			
			// Je suis loggué j'execute mon quizz
			Quizz quizz = Factory.getQuizz();
			try {
				quizz = QuizzDAOImpl.getInstance().getQuestions(theme);
			} catch (DBExceptions e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			request.setAttribute("bean", quizz);

			try {
				request.getRequestDispatcher("/vue.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
