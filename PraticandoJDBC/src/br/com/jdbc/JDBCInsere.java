package br.com.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		// Statement é o código SQL que será executado 
		
		Connection con = null;
		
		// As clásulas são executadas em um banco de dados através da interface PreparedStatement
		
		PreparedStatement stmt = null;
		
		try{
		// conectando
		con =	new ConnectionFactory().getConnection();
		
		// cria um preparedStatement
		String sql = "insert into contatos"+"(nome, email, endereco, dataNascimento)"+"values(?,?,?,?)";
		stmt = con.prepareStatement(sql);
		
		//preenche os valores
		stmt.setString(1, "Caelum");
		stmt.setString(2, "contato@caelum.com.br");
		stmt.setString(3, "R. Vergueiro 3185 cj57");
		stmt.setDate(4, new Date(Calendar.getInstance().getTimeInMillis()));
		
		//executa
		stmt.execute();
		
		
	
		System.out.println("Gravado");
		
		} catch(SQLException e){
			System.out.println(e);
			
		}finally{
			stmt.close();
			con.close();
		}
		
		

	}

}
