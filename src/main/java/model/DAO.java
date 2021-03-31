package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	/** M�dulo de Conex�o **/

	// Par�metros de Conex�o.
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://127.0.0.1:5432/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "postgres";
	private String password = "ornq933a";

	// M�todo de Conex�o.
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}

	}

	/**
	 * CRUD - CREATE
	 */
	public void inserirContato(JavaBeans contato) {
		String create = "INSERT INTO public.contatos (nome, fone, email) VALUES(?, ?, ?);";
		try {
			// Abrir a conex�o
			Connection con = this.conectar();
			// Preparar a query para execu��o no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os par�metros (?) pelo conte�do das vari�veis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// Executar a query
			pst.executeUpdate();
			// Encerrar conex�o com o banco de dados
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
