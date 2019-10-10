/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Entregador;

/**
 *
 * @author dappo
 */
public class EntregadorDAO extends GenericDAO<Entregador, Long>{
    
    public EntregadorDAO(){
        super(Entregador.class);
    }
    
}