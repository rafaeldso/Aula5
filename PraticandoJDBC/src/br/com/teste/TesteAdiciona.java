package br.com.teste;


import br.com.dao.MusicaDAO;
import br.com.modelo.Musica;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class TesteAdiciona {
    public static void main(String[] args) {
        MusicaDAO dao = new MusicaDAO();
        Musica teste = new Musica();
        
        teste.setNome("Teste");
        teste.setArtista("Unicarioca");
        teste.setAlbum("Rio Comprido");
        teste.setEstilo("Rock");
        
        dao.adiciona(teste);
    }
}
