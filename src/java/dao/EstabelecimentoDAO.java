/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Estabelecimento;

/**
 *
 * @author dappo
 */
public class EstabelecimentoDAO extends GenericDAO<Estabelecimento, Long>{
    
    public EstabelecimentoDAO(){
        super(Estabelecimento.class);
    }
    
}
