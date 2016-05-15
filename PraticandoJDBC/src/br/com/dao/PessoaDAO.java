/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Pessoa;
import br.com.jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author aluno
 */
public class PessoaDAO {
    private Connection con;

	public PessoaDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Pessoa pessoa) {
		String sql = "insert into pessoas (nome,email,cpf,telefone,sexo,dataDeNascimento)" + " values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getCpf());
			stmt.setString(4, pessoa.getTelefone());
                        stmt.setString(5,pessoa.getSexo());
                        stmt.setDate(6, new Date(pessoa.getDataDeNascimento().getTime()));
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
                        throw new RuntimeException();
		}
	}
	public List<Pessoa> getLista(){
	
		try {
			 String sql = "select * from pessoas";
			 PreparedStatement stmt = con.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery();
			 
			 List<Pessoa> lista = new ArrayList<Pessoa>();
			 //Pessoa pessoa = new Pessoa();
			 while(rs.next()){
                                 Pessoa pessoa = new Pessoa();
				 pessoa.setNome(rs.getString("nome"));
				 pessoa.setEmail(rs.getString("email"));
				 pessoa.setCpf(rs.getString("cpf"));
				 pessoa.setTelefone(rs.getString("telefone"));
                                 pessoa.setSexo(rs.getString("sexo"));
                                 Calendar calendario = Calendar.getInstance();
                                 calendario.setTime(rs.getDate("dataNascimento"));
                                 pessoa.setDataDeNascimento(new Date(calendario.getTimeInMillis()));
                                 
				 
				 lista.add(pessoa);
			 }
			 stmt.close();
			 rs.close();
			 
			 return lista;
			 
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException();
		}

			 
			 
		
	}
        
        public void altera(Pessoa pessoa) {

                String sql = "update musicas set nome=?, email=?, cpf=?,"+"telefone=?, sexo=? where id=?";
                   //nome,artista,album,estilo
                try {

                    PreparedStatement stmt = con.prepareStatement(sql);

                    stmt.setString(1, pessoa.getNome());

                    stmt.setString(2, pessoa.getEmail());

                    stmt.setString(3, pessoa.getCpf());

                    stmt.setString(4, pessoa.getTelefone());
                    
                    stmt.setString(5, pessoa.getSexo());
                    
                    stmt.setDate(6, new Date(pessoa.getDataDeNascimento().getTime()));

                    stmt.setLong(7, pessoa.getId());

                    stmt.execute();

                    stmt.close();

                } catch (SQLException e) {

                    throw new RuntimeException(e);

                }

 }
        public void remove(Pessoa pessoa) {

            try {

                PreparedStatement stmt = con.prepareStatement("delete" + " from pessoas where id=?");

                stmt.setLong(1, pessoa.getId());

                stmt.execute();

                stmt.close();

            } catch (SQLException e) {

                throw new RuntimeException(e);

            }

 }
}
