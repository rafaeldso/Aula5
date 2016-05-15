package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.com.modelo.Musica;
import br.com.jdbc.ConnectionFactory;
import java.util.Calendar;


public class MusicaDAO {

	private Connection con;

	public MusicaDAO() {
		this.con = new ConnectionFactory().getConnection();
	}

	public void adiciona(Musica musica) {
		String sql = "insert into musica (nome,artista,album,estilo)" + " values(?,?,?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, musica.getNome());
			stmt.setString(2, musica.getArtista());
			stmt.setString(3, musica.getAlbum());
			stmt.setString(4, musica.getEstilo());
			stmt.setDate(5, new Date(musica.getData().getTime()));
                        
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
                        throw new RuntimeException();
		}
	}
	public List<Musica> getLista(){
	
		try {
			 String sql = "select * from musicas";
			 PreparedStatement stmt = con.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery();
			 
			 List<Musica> lista = new ArrayList<Musica>();
			 Musica musica = new Musica();
			 while(rs.next()){
				 musica.setNome(rs.getString("nome"));
				 musica.setArtista(rs.getString("artista"));
				 musica.setAlbum(rs.getString("album"));
				 musica.setEstilo(rs.getString("estilo"));
                                 Calendar data = Calendar.getInstance();
                                 data.setTime(rs.getDate("data"));
                                 musica.setData(new Date(data.getTimeInMillis()));
				 
				 lista.add(musica);
			 }
			 stmt.close();
			 rs.close();
			 
			 return lista;
			 
		} catch (SQLException e) {
			// TODO: handle exception
			throw new RuntimeException();
		}

			 
			 
		
	}
        
        public void altera(Musica musica) {

                String sql = "update musicas set nome=?, artista=?, album=?,"+"estilo=? where id=?";
                   //nome,artista,album,estilo
                try {

                    PreparedStatement stmt = con.prepareStatement(sql);

                    stmt.setString(1, musica.getNome());

                    stmt.setString(2, musica.getArtista());

                    stmt.setString(3, musica.getAlbum());

                    stmt.setString(4, musica.getEstilo());

                    stmt.setLong(5, musica.getId());
                    
                    stmt.setDate(6, new Date(musica.getData().getTime()));

                    stmt.execute();

                    stmt.close();

                } catch (SQLException e) {

                    throw new RuntimeException(e);

                }

 }
        public void remove(Musica musica) {

            try {

                PreparedStatement stmt = con.prepareStatement("delete" + "from musicas where id=?");

                stmt.setLong(1, musica.getId());

                stmt.execute();

                stmt.close();

            } catch (SQLException e) {

                throw new RuntimeException(e);

            }

 }

}
