
package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Eluenai
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Entregador.findAll", query = "SELECT e FROM Entregador e"),
    @NamedQuery(name = "Entregador.findFilter", query = "SELECT e FROM Entregador e WHERE e.nome like :filtro"),
    @NamedQuery(name = "Entregador.logar", query = "SELECT e FROM Entregador e WHERE e.email = :email AND e.senha = :senha")
})
public class Entregador implements Serializable {

    @OneToMany(mappedBy = "entregador")
    private List<Pedido> pedidos;
    
       public List<Pedido> getPedidos() {
        return pedidos;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String email;
    private String senha;
    private Integer telefone;
    private String endFoto;
    private String endFoto2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEndFoto() {
        return endFoto;
    }

    public void setEndFoto(String endFoto) {
        this.endFoto = endFoto;
    }

    public String getEndFoto2() {
        return endFoto2;
    }

    public void setEndFoto2(String endFoto2) {
        this.endFoto2 = endFoto2;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entregador)) {
            return false;
        }
        Entregador other = (Entregador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Entregador[ id=" + id + " ]";
    }

   
}
