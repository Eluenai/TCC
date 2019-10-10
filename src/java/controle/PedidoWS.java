/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.EntregadorDAO;
import dao.EstabelecimentoDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Entregador;
import modelo.Estabelecimento;
import modelo.Pedido;
import modelo.Usuario;
import util.FormataData;

/**
 *
 * @author Eluenai
 */
@WebServlet(name = "PedidoWS", urlPatterns = {"/admin/pedido/PedidoWS"})
public class PedidoWS extends HttpServlet {
   
    private Pedido obj;
    private String pagina;
    private String acao;
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pedido> lista = null;
        acao = request.getParameter("acao");
        String id;
        PedidoDAO dao;
        switch(String.valueOf(acao)){
            case "add":
                request.setAttribute("entregador", this.listaEntregador());
                request.setAttribute("usuario", this.listaUsuario());
                request.setAttribute("estabelecimento", this.listaEstabelecimento());
                pagina = "add.jsp";
                break;
            case "del":
                id = request.getParameter("id");
                dao = new PedidoDAO();
                pagina = "index.jsp";
                obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                Boolean deucerto = dao.excluir(obj);
                if(deucerto){   
                    request.setAttribute("lista", this.listaPedidos());
                    request.setAttribute("msg", "Excluído com sucesso");
                }
                else{
                    request.setAttribute("msg", "Erro ao excluir");
                }
                break;
            case "edit":
                id = request.getParameter("id");
                dao = new PedidoDAO();
                Pedido obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);
                pagina = "edita.jsp";
                break;
            case "detalhe":
                dao = new PedidoDAO();
                Pedido pedido = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("id")));
                request.setAttribute("obj", pedido);
                request.setAttribute("entregador", this.listaEntregador());
                request.setAttribute("usuario", this.listaUsuario());
                request.setAttribute("estabelecimento", this.listaEstabelecimento());
                pagina = "detalhe.jsp";
                break;
            case "listPedidos":
                request.setAttribute("entregador", this.listaEntregador());
                request.setAttribute("usuario", this.listaUsuario());
                request.setAttribute("estabelecimento", this.listaEstabelecimento()); 
                
                try {
                    if(request.getParameter("entregador")!=null){
                        Entregador entregador;
                        EntregadorDAO gdao = new EntregadorDAO();
                        entregador = gdao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("entregador")));
                        lista = entregador.getPedidos();
                    }else if(request.getParameter("usuario")!=null){
                        Usuario usuario;
                        UsuarioDAO cdao = new UsuarioDAO();
                        usuario = cdao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("usuario")));
                        lista = usuario.getPedidos();
                    }else if(request.getParameter("estabelecimento")!=null){
                        Estabelecimento estabelecimento;
                        EstabelecimentoDAO edao = new EstabelecimentoDAO();
                        estabelecimento = edao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("estabelecimento")));
                        lista = estabelecimento.getPedidos();
                    }else{
                        lista = this.listaPedidos();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(PedidoWS.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista", lista);
                pagina = "index.jsp";
                break;
            default:
                dao = new PedidoDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(PedidoWS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    lista = this.listaPedidos();
                }
                //pra onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                break;
                
        }
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            EntregadorDAO gdao = new EntregadorDAO();
            UsuarioDAO cdao = new UsuarioDAO();
            EstabelecimentoDAO edao = new EstabelecimentoDAO();
            PedidoDAO dao;
            Entregador entregador;
            Usuario usuario;
            Estabelecimento estabelecimento;
            String msg;
            request.setCharacterEncoding("UTF-8");
            Long id_entregador = Long.parseLong(request.getParameter("txtEntregador"));
            Long id_usuario = Long.parseLong(request.getParameter("txtUsuario"));
            Long id_estabelecimento = Long.parseLong(request.getParameter("txtEstabelecimento"));
            String descricao = request.getParameter("txtDescricao");
            double valor = Double.parseDouble(request.getParameter("txtValor"));
            //verificar campos obrigatórios
            if(request.getParameter("txtDescricao") == null){
                msg = "Campos obrigatórios não informados";
            }
            else{
                dao = new PedidoDAO();
                obj = new Pedido();
                entregador = gdao.buscarPorChavePrimaria(id_entregador);
                usuario = cdao.buscarPorChavePrimaria(id_usuario);
                estabelecimento = edao.buscarPorChavePrimaria(id_estabelecimento);
                
                //preencho o objeto com o que vem do post
                
                Boolean deucerto;
                
                //se veio com a chave primaria então tem q alterar
                if(request.getParameter("txtId")!= null){
                    obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                    obj.setEntregador(entregador);
                    obj.setUsuario(usuario);
                    obj.setEstabelecimento(estabelecimento);
                    obj.setValor(valor);
                    obj.setDescricao(descricao);
                    deucerto = dao.alterar(obj);
                    pagina="edita.jsp";
                }
                else{
                    obj.setEntregador(entregador);
                    obj.setUsuario(usuario);
                    obj.setEstabelecimento(estabelecimento);
                    obj.setValor(valor);
                    obj.setDescricao(descricao);
                    deucerto = dao.incluir(obj);
                    pagina="add.jsp";   
                }
                if(deucerto){
                    msg = "Operação realizada com sucesso";    
                }
                else{
                    msg = "Erro ao realizar a operação";
                }
            }
            
            request.setAttribute("msg", msg);
            RequestDispatcher destino = request.getRequestDispatcher(pagina);
            destino.forward(request, response);
    }

    private List<Entregador> listaEntregador() {
        EntregadorDAO dao = new EntregadorDAO();
        List<Entregador> entregadores = dao.listar();
        dao.fecharConexao();
        return entregadores;
    }
   
    private List<Pedido> listaPedidos() {
        PedidoDAO dao = new PedidoDAO();
        List<Pedido> pedidos = dao.listar();
        dao.fecharConexao();
        return pedidos;
    }
    private List<Usuario> listaUsuario() {
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuario = dao.listar();
        dao.fecharConexao();
        return usuario;
    }
    private List<Estabelecimento> listaEstabelecimento() {
        EstabelecimentoDAO dao = new EstabelecimentoDAO();
        List<Estabelecimento> estabelecimentos = dao.listar();
        dao.fecharConexao();
        return estabelecimentos;
    }
  
    private Pedido buscaPorPK(Long id){
        PedidoDAO dao = new PedidoDAO();
        Pedido pedido = dao.buscarPorChavePrimaria(id);
         dao.fecharConexao();
         return pedido;
       
        
    }
    
    


}
