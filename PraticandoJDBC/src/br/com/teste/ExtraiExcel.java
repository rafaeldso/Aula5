package br.com.teste;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;

import java.io.IOException;

import jxl.Cell;

import jxl.Sheet;

import jxl.Workbook;

import jxl.read.biff.BiffException;



/**
 *
 * @author aluno
 */
public class ExtraiExcel {
    
    public String[][] extraiPlanilha(){
        
        try {
                    Workbook workbook = Workbook.getWorkbook(new File("basededadosmusicas.xls"));
        
                    Sheet sheet = workbook.getSheet(0);

                    int linhas = sheet.getRows();

                    int colunas = sheet.getColumns();

                    Cell[][] cell = new Cell[linhas][colunas]; 
                    String[][] texto = new String[linhas][colunas];
                    System.out.println("Iniciando a leitura da planilha XLS:");

                    for(int i = 1; i < linhas; i++){
                        for (int j = 0; j < colunas; j++) {
                            cell[i][j] = sheet.getCell(j,i);
                            texto[i][j] = cell[i][j].getContents();
                           // System.out.println(texto[i][j]);
                        }
                    }

                    return texto; 
             } catch (IOException | BiffException e) {
                 throw new RuntimeException();
             }
             
             }
    }
    

