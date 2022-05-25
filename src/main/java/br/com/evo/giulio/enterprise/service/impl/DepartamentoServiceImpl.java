package br.com.evo.giulio.enterprise.service.impl;

import br.com.evo.giulio.enterprise.dao.impl.DepartamentoDAOImpl;
import br.com.evo.giulio.enterprise.model.Departamento;
import br.com.evo.giulio.enterprise.service.GenericService;

import java.util.List;

public class DepartamentoServiceImpl extends GenericService<Departamento, Long> {
    private static DepartamentoServiceImpl instance = null;

    private DepartamentoDAOImpl departamentoDAO;

    private DepartamentoServiceImpl() {
        departamentoDAO = DepartamentoDAOImpl.getInstance();
    }

    public static DepartamentoServiceImpl getInstance() {

        if (instance == null) {
            instance = new DepartamentoServiceImpl();
        }

        return instance;
    }


    @Override
    public void inserir(Departamento departamento) {
        try {
            departamentoDAO.salvar(departamento, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Departamento departamento) {
        try {
            departamentoDAO.atualizar(departamento, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void remover(Long id) {
        try {
            departamentoDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public Departamento obter(Long id) {
        Departamento departamento = null;

        try {
            departamento = departamentoDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return departamento;
    }

    @Override
    public List<Departamento> listar() {
        List<Departamento> departamentos = null;

        try {
            departamentos = departamentoDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return departamentos;
    }

    public List<Departamento> logicalList(){
        List<Departamento> departamentos = null;

        try {
            departamentos = departamentoDAO.logicalList(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return departamentos;
    }

    public void logicalDelete(Long id){
        try {
            departamentoDAO.logicalDelete(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }
}
