package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc
import java.sql.*;

public class TestJDBC {
	// Chaine de connexion
	static final String CONNECT_URL = "jdbc:mysql://mysql-dev-iut.alwaysdata.net/dev-iut_tp";
	static final String LOGIN = "dev-iut";
	static final String PASSWORD = "123";
	// La requete de test
	static final String req = "SELECT NUM_PROF, NOM_PROF, PRENOM_PROF " +
	                          "FROM PROF " +
	                          "WHERE VILLE_PROF = 'AIX-EN-PROVENCE'";

	public static void main(String[] args) throws SQLException {
		// Connexion a la base
		System.out.println("Connexion a " + CONNECT_URL);
		try (Connection conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD)){
			System.out.println("Connecte\n");
			// Creation d'une instruction SQL
			Statement stmt = conn.createStatement();
			// Execution de la requete
			System.out.println("Execution de la requete : " + req );
			ResultSet rset = stmt.executeQuery(req);
			// Affichage du resultat
			while (rset.next()){	
				System.out.print(rset.getInt("NUM_PROF") + " ");
				System.out.print(rset.getString("NOM_PROF") + " ");
				System.out.println(rset.getString("PRENOM_PROF"));
			}
			// Fermeture de l'instruction (liberation des ressources)
			stmt.close();
			System.out.println("\nOk.\n");
		} catch (SQLException e) {
			e.printStackTrace();// Arggg!!!
			System.out.println(e.getMessage() + "\n");
		}
	}
}
