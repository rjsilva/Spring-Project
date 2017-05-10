package br.com.ronaldo;

import java.util.Calendar;

import br.com.ronaldo.dao.PessoaDao;
import br.com.ronaldo.entity.Pessoa;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pessoa p = new Pessoa();
		p.setNome("ronaldo");
		p.setEmail("ronaldo@gmail.com");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 04);
		c.set(Calendar.MONTH, Calendar.AUGUST);
		c.set(Calendar.YEAR, 1986);
		p.setIdade(c.getTime());
	    int id = new PessoaDao().save(p);
	    System.out.println(id);
	}

}
