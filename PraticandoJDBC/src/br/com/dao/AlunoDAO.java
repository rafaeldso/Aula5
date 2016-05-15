/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Aluno;
import br.com.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class AlunoDAO {
    private Connection con;

	public AlunoDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Aluno aluno) {
		String sql = "insert into aluno (nome,codigo)" + " values(?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getCodigo());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
                        throw new RuntimeException();
		}
	}
	public List<Aluno> getLista(){
	
		try {
			 String sql = "select * from aluno";
			 PreparedStatement stmt = con.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery();
			 
			 List<Aluno> lista = new ArrayList<Aluno>();
			 //Pessoa pessoa = new Pessoa();
			 while(rs.next()){
                                 Aluno aluno = new Aluno();
				 aluno.setNome(rs.getString("nome"));
				 aluno.setCodigo(rs.getInt("codigo"));
				 lista.add(aluno);
			 }
			 stmt.close();
			 rs.close();
			 
			 return lista;
			 
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException();
		}

			 
			 
		
	}
        
        public void altera(Aluno aluno) {

                String sql = "update aluno set nome=?, codigo=?"+" where id=?";
                   //nome,artista,album,estilo
                try {

                    PreparedStatement stmt = con.prepareStatement(sql);

                    stmt.setString(1, aluno.getNome());

                    stmt.setInt(2, aluno.getCodigo());
                    
                    stmt.setInt(3, aluno.getCodigo());


                    stmt.execute();

                    stmt.close();

                } catch (SQLException e) {

                    throw new RuntimeException(e);

                }

 }
        public void remove(Aluno aluno) {

            try {

                PreparedStatement stmt = con.prepareStatement("delete" + "from aluno where id=?");

                stmt.setInt(1, aluno.getCodigo());

                stmt.execute();

                stmt.close();

            } catch (SQLException e) {

                throw new RuntimeException(e);

            }

 }
}
