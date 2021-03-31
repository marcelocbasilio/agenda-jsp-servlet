package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DAO {

	/** Módulo de Conexão **/

	// Parâmetros de Conexão.
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://127.0.0.1:5432/dbagenda?useTimezone=true&serverTimezone=UTC";
	private String user = "postgres";
	private String password = "ornq933a";

	// Método de Conexão.
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
			// Abrir a conexão
			Connection con = this.conectar();
			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// Substituir os parâmetros (?) pelo conteúdo das variáveis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			// Executar a query
			pst.executeUpdate();
			// Encerrar conexão com o banco de dados
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
