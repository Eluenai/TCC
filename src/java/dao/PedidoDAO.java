/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Pedido;

/**
 *
 * @author dappo
 */
public class PedidoDAO extends GenericDAO<Pedido, Long>{
    
    public PedidoDAO(){
        super(Pedido.class);
    }
    
}
