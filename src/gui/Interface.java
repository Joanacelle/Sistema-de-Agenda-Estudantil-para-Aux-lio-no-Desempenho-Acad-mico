/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author Joanacelle
 */
public class Interface implements FactoryInterface{

    @Override
    public Janela criaInterfaceJanela() {
        return new Janela();
    }

    @Override
    public Linha criaInterfaceLinha() {
        return new Linha();
    }
    
    
    
}
