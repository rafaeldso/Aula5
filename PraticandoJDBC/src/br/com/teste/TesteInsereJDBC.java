package br.com.teste;



import br.com.dao.MusicaDAO;
import br.com.modelo.Musica;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aluno
 */
public class TesteInsereJDBC {
        public static void main(String[] args) throws ParseException {
        
            MusicaDAO dao = new MusicaDAO();
            
            ExtraiExcel excel = new ExtraiExcel();
            
            String[][] text = excel.extraiPlanilha();
            int k = 0;
            for (int i = 1; i < text.length; i++) {
                int j = 0;
                Musica musica = new Musica();
                for (String item : text[i]) {
                    if(j == 0){
                        musica.setNome(item);
                        k++;
                        //System.out.println(item);
                    }else{
                          if (j == 1) {
                            musica.setArtista(item);
                            } else {
                                    if (j == 2){
                                        musica.setAlbum(item);
                                    }else {
                                        if (j == 3){
                                        musica.setEstilo(item);
                                        }else{
                                            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");                                          
                                            musica.setData(new java.sql.Date(format.parse(item).getTime()));
                                        }
                                        }
                                    }
                        
                                   
                }
                    
                    j++;
                    
                } 
                System.out.print(musica.getNome()+musica.getArtista()+musica.getAlbum()+musica.getEstilo());
                System.out.println(k);
                dao.adiciona(musica);
            }
            
    }
}
