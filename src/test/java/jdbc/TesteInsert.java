package jdbc;

import java.util.Calendar;

import javax.validation.constraints.AssertTrue;

import org.junit.Assert;
import org.junit.Test;

import br.com.ronaldo.dao.PessoaDao;
import br.com.ronaldo.entity.Pessoa;
import junit.framework.TestCase;

public class TesteInsert extends TestCase {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new TesteInsert().inseri();
		
	}

	@Test
	private void inseri() {
		
		Pessoa p = new Pessoa();
		p.setNome("ronaldo");
		p.setEmail("ronaldo@gmail.com");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, 04);
		c.set(Calendar.MONTH, Calendar.AUGUST);
		c.set(Calendar.YEAR, 1986);
		p.setIdade(c.getTime());
	    p =  new PessoaDao().savePerson(p);
	    
	    junit.framework.Assert.assertTrue((p.getId() != 0));
		
	}

}
