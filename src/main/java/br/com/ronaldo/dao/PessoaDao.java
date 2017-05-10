package br.com.ronaldo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import br.com.ronaldo.conexao.JDBCConection;
import br.com.ronaldo.entity.Pessoa;

@Repository
public class PessoaDao  {

	private static final String queryInsert = "INSERT INTO TB_PESSOA(nome,email,idade) VALUES(?,?,?)";

	
	public int save(Pessoa pessoa) {
		try {
			PreparedStatement stm = null;
			Connection con = JDBCConection.createConection();
			stm = con.prepareStatement(queryInsert,stm.RETURN_GENERATED_KEYS);
            stm.setString(1,new Pessoa().getNome());
            stm.setString(2, new Pessoa().getEmail());
            stm.setDate(3, new java.sql.Date(pessoa.getIdade().getTime()));
            stm.execute();
            ResultSet rs = stm.getGeneratedKeys();
            while(rs.next()){
            	
             return	rs.getInt(1);
            	
            }
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return 0;

	}

	public Pessoa savePerson(Pessoa pessoa){
		
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("jdbcjpa");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(pessoa);
		manager.getTransaction().commit();
		pessoa = manager.find(Pessoa.class, pessoa.getId());
		manager.close();
		factory.close();
		
		return pessoa;
		
	}
}
