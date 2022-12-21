/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Interface.Interface;
import javax.swing.JOptionPane;

/**
 *
 * @author jp_te
 */
public class Centrecap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int op = 0;
        int op2 = 0;
        Interface GUI = new Interface(); 
        do{
            op = GUI.telaPrincipal();
            switch(op){
                case 1:{
                    do{
                        op2 = GUI.telasCadastro();
                        switch(op2){
                            case 1:{
                                GUI.registrarEmpresa();
                                break;
                            }
                            case 2:{
                                GUI.registrarAluno();
                                break;
                            }
                            case 3:{
                                GUI.registrarTurma();
                                break;
                            }
                            case 4:{
                                GUI.registrarCurso();
                                break;
                            }
                            case 5:{
                                break;
                            }
                            default:{
                                JOptionPane.showMessageDialog (null, "Insira um valor válido");
                                break;
                            }
                        }
                    }while(op2 != 5);
                    break;
                }
                case 2:{
                    do{
                        op2 = GUI.telasBusca();
                        switch(op2){
                            case 1:{
                                GUI.buscarEmpresa();
                                break;
                            }
                            case 2:{
                                GUI.buscarAluno();
                                break;
                            }
                            case 3:{
                                GUI.buscarTurma();
                                break;
                            }
                            case 4:{
                                GUI.buscarCurso();
                                break;
                            }
                            case 5:{
                                break;
                            }
                            default:{
                                JOptionPane.showMessageDialog (null, "Insira um valor válido");
                                break;
                            }
                        }
                    }while(op2 != 5);
                    break;
                }
                case 3:{
                    break;
                }
                default:{
                    JOptionPane.showMessageDialog (null, "Insira um valor válido");
                    break;
                }
            }
        }while(op != 3);
    }
    
}
