package br.com.evo.giulio.enterprise.service.impl;

import br.com.evo.giulio.enterprise.dao.impl.DepartamentoDAOImpl;
import br.com.evo.giulio.enterprise.dao.impl.FuncionarioDAOImpl;
import br.com.evo.giulio.enterprise.model.Departamento;
import br.com.evo.giulio.enterprise.model.Funcionario;
import br.com.evo.giulio.enterprise.service.GenericService;

import java.util.List;

public class FuncionarioServiceImpl extends GenericService<Funcionario, Long> {
    private static FuncionarioServiceImpl instance = null;

    private FuncionarioDAOImpl funcionarioDAO;

    private FuncionarioServiceImpl() {
        funcionarioDAO = FuncionarioDAOImpl.getInstance();
    }

    public static FuncionarioServiceImpl getInstance() {

        if (instance == null) {
            instance = new FuncionarioServiceImpl();
        }

        return instance;
    }

    @Override
    public void inserir(Funcionario funcionario) {
        try {
            funcionarioDAO.salvar(funcionario, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public void atualizar(Funcionario funcionario) {
        try {
            funcionarioDAO.atualizar(funcionario, getEntityManager());
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
            funcionarioDAO.remover(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    @Override
    public Funcionario obter(Long id) {
        Funcionario funcionario = null;

        try {
            funcionario = funcionarioDAO.obterPorId(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return funcionario;
    }

    @Override
    public List<Funcionario> listar() {
        List<Funcionario> funcionarios = null;

        try {
            funcionarios = funcionarioDAO.listar(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return funcionarios;
    }

    public void logicalDelete(Long id){
        try {
            funcionarioDAO.logicalDelete(id, getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
            getEntityManager().getTransaction().rollback();
        } finally {
            closeEntityManager();
        }
    }

    public List<Funcionario> logicalList(){
        List<Funcionario> funcionarios = null;

        try {
            funcionarios = funcionarioDAO.logicalList(getEntityManager());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeEntityManager();
        }

        return funcionarios;
    }
}
