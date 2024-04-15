package it.prova.lavoratorejbdc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.prova.lavoratorejbdc.model.Lavoratore;

public class TestLavoratore {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/lavoratoredb";
		String username = "root";
		String password = "root";

		String select = "SELECT * FROM lavoratoredb.lavoratore";

		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			Statement stat = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(select);
			System.out.println(pstmt);
			conn.close();
		} catch (SQLException e) {
			System.out.println("Ci sono problemi...");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connesso al database");
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(select);

			while (res.next()) {
				Lavoratore lavoratore = new Lavoratore();
				lavoratore.setIdlavoratore(res.getInt("idlavoratore"));
				lavoratore.setNome(res.getString("nome"));
				lavoratore.setCognome(res.getString("cognome"));
				lavoratore.setDataDiNascita(res.getDate("data_di_nascita"));
				lavoratore.setRal(res.getInt("ral"));

				System.out.println(lavoratore);
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("Errore durante la connessione");
			e.printStackTrace();
		}
		
		
		// ---------

		
		String insert = "INSERT INTO lavoratore (nome, cognome, data_di_nascita, ral) VALUES ('Ugo', 'Fantocci', '1931-08-12', 55000)";
		
//		try {
//			Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
//			System.out.println("Connesso al database");
//			Statement stat = conn.createStatement(); 
//			PreparedStatement pstmt = conn.prepareStatement(insert);
//			System.out.println(pstmt);
//			stat.executeUpdate(insert); 
//			
//			System.out.println("Lavoratore inserito con successo");
//			
//			conn.close();
//		} catch (SQLException e) {
//			System.out.println("Inserimento impossibile...");
//			e.printStackTrace();
//		}
		
		
		// ---------
	
		
		String update = "UPDATE lavoratore SET cognome = 'Fantozzi' WHERE idlavoratore = 37";
		
//		try {
//			Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
//			System.out.println("Connesso al database");
//			Statement stat = conn.createStatement(); 
//			PreparedStatement pstmt = conn.prepareStatement(update);
//			System.out.println(pstmt);
//			stat.executeUpdate(update); 
//			
//			System.out.println("Lavoratore aggiornato con successo");
//			
//			conn.close();
//		} catch (SQLException e) {
//			System.out.println("Aggiornamento impossibile...");
//			e.printStackTrace();
//		}
		
		// ---------
		
		
		String delete = "DELETE FROM lavoratore WHERE idlavoratore = 37"; 
		
//		try {
//			Connection conn = DriverManager.getConnection(jdbcUrl, username, password); 
//			System.out.println("Connesso al database");
//			Statement stat = conn.createStatement(); 
//			PreparedStatement pstmt = conn.prepareStatement(delete);
//			System.out.println(pstmt);
//			stat.executeUpdate(delete); 
//			
//			System.out.println("Lavoratore eliminato con successo");
//			
//			conn.close();
//		} catch (SQLException e) {
//			System.out.println("Eliminazione impossibile...");
//			e.printStackTrace();
//		}
		
		String trovaNati = "SELECT * FROM lavoratore WHERE data_di_nascita BETWEEN '1992-01-01' AND '1996-12-31';";
		
		String trovaNomiIniziano = "SELECT * FROM lavoratore WHERE nome LIKE 'M%'; ";
		
		String quantiCognome = "SELECT COUNT(cognome) FROM lavoratore WHERE cognome = 'Bianchi';";
		
		
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			Statement stat = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(trovaNati);
			System.out.println(pstmt);
			conn.close();
		} catch (SQLException e) {
			System.out.println("Ci sono problemi...");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connesso al database. Provo a trovare i nati nell'intervallo...");
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(trovaNati);

			while (res.next()) {
				Lavoratore lavoratore = new Lavoratore();
				lavoratore.setIdlavoratore(res.getInt("idlavoratore"));
				lavoratore.setNome(res.getString("nome"));
				lavoratore.setCognome(res.getString("cognome"));
				lavoratore.setDataDiNascita(res.getDate("data_di_nascita"));
				lavoratore.setRal(res.getInt("ral"));

				System.out.println(lavoratore);
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("Errore durante la connessione");
			e.printStackTrace();
		}
		
// ---------
		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			Statement stat = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(trovaNomiIniziano);
			System.out.println(pstmt);
			conn.close();
		} catch (SQLException e) {
			System.out.println("Ci sono problemi...");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connesso al database. Provo a trovare tutti quelli che hanno l'iniziale del nome...");
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(trovaNomiIniziano);

			while (res.next()) {
				Lavoratore lavoratore = new Lavoratore();
				lavoratore.setIdlavoratore(res.getInt("idlavoratore"));
				lavoratore.setNome(res.getString("nome"));
				lavoratore.setCognome(res.getString("cognome"));
				lavoratore.setDataDiNascita(res.getDate("data_di_nascita"));
				lavoratore.setRal(res.getInt("ral"));

				System.out.println(lavoratore);
			}
			conn.close();

		} catch (SQLException e) {
			System.out.println("Errore durante la connessione");
			e.printStackTrace();
		}
		
// ---------

		
		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			Statement stat = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(quantiCognome);
			System.out.println(pstmt);
			conn.close();
		} catch (SQLException e) {
			System.out.println("Ci sono problemi...");
			e.printStackTrace();
		}

		try {
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connesso al database. Provo a trovare tutti quelli con il cognome...");
			Statement stat = conn.createStatement();
			ResultSet res = stat.executeQuery(quantiCognome);
			
			if (res.next()) {
				int count = res.getInt(1);
			    System.out.println("Numero di lavoratori con cognome 'Bianchi': " + count);
			} else {
			    System.out.println("Nessun risultato trovato");
			}
			
			conn.close();

		} catch (SQLException e) {
			System.out.println("Errore durante la connessione");
			e.printStackTrace();
		}
	}

}
