package accesdonnees;

import entite.Quizz;

public interface QuizzDAO {

	public Quizz getQuestions(String theme) throws DBExceptions;
}
