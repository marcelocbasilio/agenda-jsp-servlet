package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	/**
	 * CRUD - READ
	 */
	public ArrayList<JavaBeans> listarContatos() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "SELECT * FROM contatos ORDER BY nome ASC;";
		try {
			Connection con = this.conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// O laço abaixo será executado enquanto houver contatos
			while(rs.next()) {
				// Variáveis de apoio que recebem os dados do banco
				Long id = rs.getLong(1);
				//String id = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				// Populando o ArrayList
				contatos.add(new JavaBeans(id, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
	
	/**
	 * CRUD - UPDATE
	 */
	// Selecionar o contato
	public void selecionarContato(JavaBeans contato) {
		String read2 = "SELECT * FROM contatos WHERE id = ?";
		
		try {
			Connection con = this.conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setLong(1, contato.getId());
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				// Setar as variáveis JavaBeans
				contato.setId(rs.getLong(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
