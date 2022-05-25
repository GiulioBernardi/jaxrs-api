package br.com.evo.giulio.enterprise.dao.impl;

import br.com.evo.giulio.enterprise.model.Departamento;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class DepartamentoDAOImpl extends HibernateGenericDAO<Departamento, Long> {

    private static DepartamentoDAOImpl instance = null;

    public static DepartamentoDAOImpl getInstance(){
        if(instance == null){
            instance = new DepartamentoDAOImpl();
        }
        return instance;
    }


    public DepartamentoDAOImpl() {
        super(Departamento.class);
    }

    public List<Departamento> logicalList(EntityManager entityManager) {
        String jpql = "SELECT d FROM Departamento d WHERE d.status = :status";


        TypedQuery<Departamento> consulta = entityManager.createQuery(jpql, Departamento.class);
        consulta.setParameter("status", true);

        return consulta.getResultList();
    }

    public void logicalDelete(Long id, EntityManager entityManager){
        Query query= entityManager.createQuery("Update Departamento d Set d.status = false WHERE d.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }


//    public void remover(PK id, EntityManager entityManager) {
//        T instancia = this.obterPorId(id, entityManager);
//        entityManager.remove(instancia);
//    }



}
