/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;

/**
 *
 * @author dappo
 */
public class UsuarioDAO extends GenericDAO<Usuario, Long>{
    
    public UsuarioDAO(){
        super(Usuario.class);
    }
    
}