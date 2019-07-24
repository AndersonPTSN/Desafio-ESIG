/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web.bean;

import br.com.web.pojos.Notas;
import br.com.web.pojos.dao.NotasDao;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author ander
 */
@ManagedBean
@SessionScoped
public class NotasBean {

    /**
     * Creates a new instance of NotasBean
     */
    private Notas nota = new Notas();
    private NotasDao notadao = new NotasDao();
    private List<Notas> listaNotas;
    
    public NotasBean() {
    }

    public String adicionarNota(){
        notadao.addNota(nota);
        nota.setDescricao(null);
        return "index";
    }
    
    public String removerNota(Notas n){
        this.nota = n;
        notadao.removeNota(this.nota);
        nota.setDescricao(null);
        return "index";
    }
    
    public String carregarNota(Notas n){
        nota = n;
        return "editar";
    }
    
    public String atualizarNota(){
        notadao.updateNota(nota);
        nota.setDescricao(null);
        return "index";
    }
    
    public Notas getNota() {
        return nota;
    }

    public void setNota(Notas nota) {
        this.nota = nota;
    }
    
    public List listarNotas(){
        listaNotas = notadao.getList();
        return this.listaNotas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nota);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NotasBean other = (NotasBean) obj;
        if (!Objects.equals(this.nota, other.nota)) {
            return false;
        }
        return true;
    }
    
    
}
