package entite;

import java.util.List;

public class Factory {
	
	public static Question getQuestion () {
		Question q = new Question();
		return q;
	}
	
	
	public static Question getQuestion (String intit,String bonnrep, String mauv1, String mauv2, String mauv3) {
		Question q = new Question(intit, bonnrep, mauv1, mauv2, mauv3);
		return q;
	}
	
	public static Quizz getQuizz() {
		Quizz q = new Quizz();
		return q;
	}
	
	public static Quizz getQuizz(String theme) {
		Quizz q = new Quizz(theme);
		return q;
	} 
	
	public static Quizz getQuizz (List<Question> liste, String theme) {
		Quizz q = new Quizz(liste, theme);
		return q;
	}
}
