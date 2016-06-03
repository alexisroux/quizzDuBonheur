package entite;

public class Question {

	private String intitule;
	private String bonne_rep;
	private String mauv_rep1;
	private String mauv_rep2;
	private String mauv_rep3;

	Question() {

	}
	
	Question(String intitule, String bonne_rep, String mauv_rep1, String mauv_rep2, String mauv_rep3) {
		super();
		this.intitule = intitule;
		this.bonne_rep = bonne_rep;
		this.mauv_rep1 = mauv_rep1;
		this.mauv_rep2 = mauv_rep2;
		this.mauv_rep3 = mauv_rep3;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getBonne_rep() {
		return bonne_rep;
	}

	public void setBonne_rep(String bonne_rep) {
		this.bonne_rep = bonne_rep;
	}

	public String getMauv_rep1() {
		return mauv_rep1;
	}

	public void setMauv_rep1(String mauv_rep1) {
		this.mauv_rep1 = mauv_rep1;
	}

	public String getMauv_rep2() {
		return mauv_rep2;
	}

	public void setMauv_rep2(String mauv_rep2) {
		this.mauv_rep2 = mauv_rep2;
	}

	public String getMauv_rep3() {
		return mauv_rep3;
	}

	public void setMauv_rep3(String mauv_rep3) {
		this.mauv_rep3 = mauv_rep3;
	}

	@Override
	public String toString() {

		return "Question [intitule=" + intitule + ", bonne_rep=" + bonne_rep + ", mauv_rep1=" + mauv_rep1 + ", mauv_rep2=" + mauv_rep2 + ", mauv_rep3=" + mauv_rep3 + "]";
	}
}
