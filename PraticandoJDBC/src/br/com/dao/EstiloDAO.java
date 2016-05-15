/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.modelo.Estilo;
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
public class EstiloDAO {
     private Connection con;

	public EstiloDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Estilo estilo) {
		String sql = "insert into estilos (nome)" + " values(?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, estilo.getNome());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
                        throw new RuntimeException();
		}
	}
	public List<Estilo> getLista(){
	
		try {
			 String sql = "select * from estilos";
			 PreparedStatement stmt = con.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery();
			 
			 List<Estilo> lista = new ArrayList<Estilo>();
			 //Pessoa estilo = new Pessoa();
			 while(rs.next()){
                                 Estilo estilo = new Estilo();
				 estilo.setNome(rs.getString("nome"));
                            	 lista.add(estilo);
			 }
			 stmt.close();
			 rs.close();
			 
			 return lista;
			 
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException();
		}

			 
			 
		
	}
        
        public void altera(Estilo estilo) {

                String sql = "update estilos set nome=?, email=?, cpf=?,"+"telefone=?, sexo=? where id=?";
                   //nome,artista,album,estilo
                try {

                    PreparedStatement stmt = con.prepareStatement(sql);

                    stmt.setString(1, estilo.getNome());

                    stmt.execute();

                    stmt.close();

                } catch (SQLException e) {

                    throw new RuntimeException(e);

                }

 }
        public void remove(Estilo estilo) {

            try {

                PreparedStatement stmt = con.prepareStatement("delete" + " from estilos where nome=?");

                stmt.setString(1, estilo.getNome());

                stmt.execute();

                stmt.close();

            } catch (SQLException e) {

                throw new RuntimeException(e);

            }

 }
}
