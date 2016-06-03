package entite;

import java.util.List;

public class Quizz {
	List <Question> liste;
	String theme;
	
	Quizz() {
		// TODO Auto-generated constructor stub
	}

	Quizz(List<Question> liste, String theme) {
		super();
		this.liste = liste;
		this.theme = theme;
	}

	public List<Question> getListe() {
		return liste;
	}

	public void setListe(List<Question> liste) {
		this.liste = liste;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Quizz [liste=" + liste + ", theme=" + theme + "]";
	}
	
	
}
