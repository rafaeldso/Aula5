package br.com.modelo;

import java.util.Date;


public class Musica {
	private Long id;
	private String nome;
	private String artista;
	private String album;
	private String estilo;
        private Date data;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public String getEstilo() {
        return estilo;
    }

    public Date getData() {
        return data;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public void setData(Date data) {
        this.data = data;
    }
	

	
}
