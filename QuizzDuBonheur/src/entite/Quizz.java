package entite;

import java.util.ArrayList;
import java.util.List;

public class Quizz {
	private List <Question> liste;
	private String theme;
	
	Quizz() {
		liste = new ArrayList<Question>();
	}

	Quizz( String theme) {
		super();
		this.liste = new ArrayList<Question>();
		this.theme = theme;
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
