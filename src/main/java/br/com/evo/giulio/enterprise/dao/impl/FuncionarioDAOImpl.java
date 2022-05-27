package br.com.evo.giulio.enterprise.dao.impl;

import br.com.evo.giulio.enterprise.model.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class FuncionarioDAOImpl extends HibernateGenericDAO<Funcionario, Long>{

    private static FuncionarioDAOImpl instance = null;

    public static FuncionarioDAOImpl getInstance(){
        if(instance == null){
            instance = new FuncionarioDAOImpl();
        }
        return instance;
    }

    public FuncionarioDAOImpl() {
        super(Funcionario.class);
    }

    public void logicalDelete(Long id, EntityManager entityManager) {
        Query query= entityManager.createQuery("Update Funcionario f Set f.status = false WHERE f.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    public List<Funcionario> logicalList(EntityManager entityManager) {
        String jpql = "SELECT f FROM Funcionario f WHERE f.status = :status";


        TypedQuery<Funcionario> consulta = entityManager.createQuery(jpql, Funcionario.class);
        consulta.setParameter("status", true);

        return consulta.getResultList();
    }

    public List<Funcionario> listarRgs(EntityManager entityManager){
        String jpql = "SELECT new Funcionario(f.rg) FROM Funcionario f";

        Query consulta = entityManager.createQuery(jpql, Funcionario.class);

        return consulta.getResultList();
    }

    public Funcionario verificaParaDeletar(Long id, EntityManager entityManager){
        String jpql = "SELECT f FROM Funcionario f WHERE id = :id";
        TypedQuery<Funcionario> consulta = entityManager.createQuery(jpql, Funcionario.class);
        consulta.setParameter("id", id);
        return consulta.getSingleResult();

    }

}
