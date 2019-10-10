<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../cabecalho.jsp" %>
<div class="card">
    <div class="card-header">
        <h5 class="title">Adiciona Entregador</h5>
    </div>
    <div class="card-body">
        <!--MODIFICAR PARA ADD-->
        <form action="EntregadorWS" method="POST" >
            <input type="hidden" name="urldestino" value="EntregadorWS">
            <div class="row">
                <div class="col-md-3 pr-md-1">
                    <div class="form-group">
                        <label>Id</label>
                        <input type="text" class="form-control" name="txtId" placeholder="Id" value="${obj.id}" readonly="true">
                    </div>
                </div>
            </div>
                    <div class="row">
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Nome</label>
                        <input type="text" name="txtNome" required class="form-control" placeholder="Nome" value="${obj.nome}">
                    </div>
                </div>
            </div>
                          <div class="row">
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>CPF</label>
                        <input type="text" name="txtCpf" required class="form-control" placeholder="Cpf" value="${obj.cpf}">
                    </div>
                </div>
            </div>
                          <div class="row">
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>RG</label>
                        <input type="text" name="txtRg" required class="form-control" placeholder="Rg" value="${obj.rg}">
                    </div>
                </div>
            </div>
                          <div class="row">
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="text" name="txtEmail" required class="form-control" placeholder="Email" value="${obj.email}">
                    </div>
                </div>
            </div>
                                              <div class="row">
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Senha</label>
                        <input type="text" name="txtSenha" required class="form-control" placeholder="Senha" value="${obj.senha}">
                    </div>
                </div>
                                              </div>
            <div class="row">
                <div class="col-md-5 pr-md-1">
                    <div class="form-group">
                        <label>Telefone</label>
                        <input type="text" name="txtTelefone" required class="form-control" placeholder="Telefone" value="${obj.telefone}">
                    </div>
                </div>
               <div class="col-md-7">
                    <div class="form-group-file">
                        <label for="file">Foto</label>
                        <input type="file" id="file" name="txtFoto" required class="form-control form-control-file" value="./../../arquivos/${obj.endFoto}">
                    </div>
                </div>
            </div>
            <button class="btn btn-primary btn-round text-center" type="submit">
                <i class="tim-icons icon-cloud-upload-94"></i> Salvar
            </button>
            <a class="btn btn-primary btn-round text-center" href="EntregadorWS?acao=list">
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
