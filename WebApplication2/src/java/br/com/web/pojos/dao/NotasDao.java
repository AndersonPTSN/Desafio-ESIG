/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web.pojos.dao;

import br.com.web.pojos.Notas;
import br.com.web.pojos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ander
 */
public class NotasDao {
    
    private Session sessao;
    private Transaction trans;
    private List<Notas> list;

    public List<Notas> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        
        Criteria cri = sessao.createCriteria(Notas.class);
        this.list = cri.list();
        return list;
    } 
    
    public void addNota(Notas n){
        try{
            
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Notas nota = new Notas();
            nota.setDescricao(n.getDescricao());

            sessao.save(n);
            trans.commit();
            
        }catch (Exception c){
            
            c.printStackTrace();
            
        }finally{
            
            sessao.close();
        }
    }
    public void removeNota(Notas n){
        try{
            
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(n);
            trans.commit();
            
        }catch (Exception c){
            
            c.printStackTrace();
            
        }finally{
            
            sessao.close();
        }
    }
    
    public void updateNota(Notas n){
        try{
            
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.update(n);
            trans.commit();
            
        }catch (Exception c){
            
            c.printStackTrace();
            
        }finally{
            
            sessao.close();
        }
    }
    
}
