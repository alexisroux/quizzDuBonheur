package accesdonnees;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entite.Factory;
import entite.Question;
import entite.Quizz;

public class QuizzDAOImpl implements QuizzDAO {
	
    private Connection con = null;
    
    //Constructeurs
    QuizzDAOImpl() {
		super();
	}

	public static QuizzDAO instance;
	
	/**
	 * M�thode pour r�aliser l'instanciation de la BDD (singleton)
	 * @return
	 * @throws DBException
	 */
    public static QuizzDAO getInstance() throws DBExceptions {
    	//chargement des pilotes
    	try{
    	Class.forName("com.mysql.jdbc.Driver");
    	} catch(ClassNotFoundException e){
    		throw new DBExceptions("Driver corrompu ou inexistant");
    	}
    	 
		// singleton
		if (instance == null) {
			instance = new QuizzDAOImpl();
		}
		return instance;
	}
	
    
    /**
     * M�thode permettant de r�aliser la connexion � la BDD
     * @throws DBException
     */
    public void dataBaseConnexion() throws DBExceptions {
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys", "root", "0000");
		} catch (SQLException e) {
			throw new DBExceptions("Utilisateur ou mot de passe inconnu");
		}
	}
    
    /**
     * M�thode permettant d'avoir 20 questions et leurs reponses en fonction du theme entr�
     * @param theme
     * @throws DBException
     */
    public Quizz getQuestions(String theme) throws DBExceptions{
    	//ouverture de la BDD
    	dataBaseConnexion();
    	PreparedStatement stmt = null;
    	ResultSet resultat = null;
    	
    	//cr�ation du quizz
    	Quizz quizz = Factory.getQuizz();
    	quizz.setTheme(theme);
    	
 	
    	//Cr�ation de la liste de questions
    	List<Question> lstQuestion = new ArrayList<Question>();

    	
    	/* Cr�ation du query
    	*  on selectionne toutes les questions li�es au th�me selon les colonnes suivantes ordonn�es de mani�re al�atoire
        *  |id question|intitul�|reponse|mauvaise1|mauvaise2|mauvaise3|
        */
    	 
    	String query = "SELECT T1.id, T1.intitule, T2.reponse, T2.mauvaise1, T2.mauvaise2, T2.mauvaise3 FROM quizz.theme as T0 INNER JOIN quizz.question as T1  ON T0.id=T1.fk_theme INNER JOIN quizz.reponse as T2 ON T1.fk_reponse = T2.id  WHERE T0.theme = ? ORDER BY rand()";
    	
    	try{
    		stmt = this.con.prepareStatement(query);
			stmt.setString(1, theme);
			resultat = stmt.executeQuery();

			while (resultat.next()) {
				
				lstQuestion.add(Factory.getQuestion(resultat.getString("intitule"),resultat.getString("reponse"),resultat.getString("mauvaise1"),resultat.getString("mauvaise2"),resultat.getString("mauvaise3")));
				
			}
			//cr�ation de la liste de 20 questions du quizz
			quizz.setListe(lstQuestion);
				
		} catch (SQLException e) {
			throw new DBExceptions("Erreur dans la syntaxe SQL");
		}

    	
    	// Fermeture de la requ�te et de la connexion
    	try {
    		resultat.close();
    		stmt.close();
    		this.con.close();
    	} catch (SQLException e) {
    		throw new DBExceptions("Erreur dans la fermeture de la BDD");
    	}
    	
    	return quizz;
    }
	

}
