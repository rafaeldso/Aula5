package br.com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.jdbc.ConnectionFactory;
import br.com.modelo.Contato;

public class ContatoDAO {

	// a conexão com o banco de dados
	private Connection con;

	public ContatoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "insert into contatos " + "(nome,email,endereco,dataNascimento)" + " values (?,?,?,?)";

		try {

			// prepared statement para inserção
			PreparedStatement stmt = con.prepareStatement(sql);

			// seta os valores

			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Contato> getLista(){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
				stmt = con.prepareStatement("select * from contatos");
				rs = stmt.executeQuery();
				
				List<Contato> contatos = new ArrayList<Contato>();
				
				while(rs.next()){
					
					// criando o objeto Contato
					Contato contato = new Contato();
					contato.setName(rs.getString("nome"));
					contato.setEmail(rs.getString("email"));
					contato.setEndereco(rs.getString("endereco"));
					
					Calendar data = Calendar.getInstance();
					data.setTime(rs.getDate("dataNascimento"));
					contato.setDataNascimento(data);
					
					// adicionando o objeto à lista
					contatos.add(contato);
					
				}
				rs.close();
				stmt.close();
				return contatos;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		
			
		
	}
}
