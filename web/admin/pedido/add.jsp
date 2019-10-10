<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../cabecalho.jsp" %>

<div class="card">
    <div class="card-header">
        <h5 class="title">Adiciona Pedido</h5>
    </div>
    <div class="card-body">
        <!--MODIFICAR PARA ADD-->
        <form action="PedidoWS" method="POST">
            <input type="hidden" name="urldestino" value="PedidoWS">
            <div class="row">
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                        <label>Entregador</label>
                        <select class="form-control" name="txtEntregador">
                            <c:forEach items="${entregador}" var="obj">
                                <option value="${obj.id}">${obj.nome}</option>
                            </c:forEach>
                        </select> 
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                        <label>Usuario</label>
                        <select class="form-control" name="txtUsuario">
                            <c:forEach items="${usuario}" var="obj">
                                <option value="${obj.id}">${obj.nome}</option>
                            </c:forEach>
                        </select>                        
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                        <label>Estabelecimento</label>
                        <select class="form-control" name="txtEstabelecimento">
                            <c:forEach items="${estabelecimento}" var="obj">
                                <option value="${obj.id}">${obj.nome}</option>
                            </c:forEach>
                        </select> 
                    </div>
                </div>
                <div class="col-md-6 pr-md-1">
                    
                </div>
            </div>
            <div class="row">
                
                <div class="col-md-6 pr-md-1">
                    <div class="form-group">
                        <label>Valor</label>
                        <input type="number" step="0.01" name="txtValor" required class="form-control" >
                    </div>
                </div>
            </div>
           
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group">
                            <label for="file">Lista de compras</label>
                            <textarea name="txtDescricao" required class="form-control"></textarea> 
                    </div>
                </div>
            </div>

            <button class="btn btn-primary btn-round text-center" type="submit">
                <i class="tim-icons icon-cloud-upload-94"></i> Salvar
            </button>
            <a class="btn btn-primary btn-round text-center" href="PedidoWS?acao=list">
                <i class="tim-icons icon-bullet-list-67"></i> Listar
            </a>
        </form>
    </div>

    <div class="card-footer">
        <c:if test = "${not empty msg}">
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                ${msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i class="tim-icons icon-simple-remove"></i>
                </button>
            </div>
        </c:if>
    </div>

</div>
<%@include file="../../rodape.jsp" %>