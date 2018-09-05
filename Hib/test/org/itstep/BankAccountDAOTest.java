package org.itstep;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BankAccountDAOTest {
	
	
	
	private BankAccount accound = null;
	
	

	@Before
	public void setUp() throws Exception {
		BankAccountDAO accountDAO = new BankAccountDAO();
		accound = new BankAccount("Misha", "LLL", "00004000300", "WERKA@GMAIL.COM", 1234.0, 0.0, 0.0);
		accountDAO.saveBankAccount(accound);
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		BankAccountDAO accountDAO = new BankAccountDAO();
		accountDAO.deleteBankAccount(accound);
		
	}

	@Test
	public void testSaveBankAccount() {
		BankAccountDAO accountDAO = new BankAccountDAO();
		BankAccount res = accountDAO.getBankAccount(accound.getId());
		assertEquals("Misha", res.getId());
		
	
	}

	@Test
	public void testUpdateBankAccount() {
		BankAccountDAO accountDAO = new BankAccountDAO();
	BankAccount	accound1 = new BankAccount("Misha", "QQQ", "111111", "21263", 12.0, 13.0, 0.0);
	accountDAO.updateBankAccount(accound1);
	BankAccount res = accountDAO.getBankAccount(accound1.getId());
	assertEquals("QQQ",res.getFirstName());
		
	}

	@Test
	public void testGetBankAccount() {
		BankAccountDAO accountDAO = new BankAccountDAO();
		BankAccount n = accountDAO.getBankAccount(accound.getId());
		assertEquals("Misha", n.getFirstName());
		
		
		
		
		
	}

	@Test
	public void testDeleteBankAccount() {
		BankAccountDAO accountDAO = new BankAccountDAO();
		accountDAO.deleteBankAccount(accound);
		BankAccount n = accountDAO.getBankAccount(accound.getId());
		assertNull(n);
		
	}

	@Test
	public void testGetBankAccountByFirstNameAndSecondName() {
		BankAccountDAO accountDAO = new BankAccountDAO();
		BankAccount n = accountDAO.getBankAccountByFirstNameAndSecondName(accound.getFirstName(), accound.getSecondName());
		assertEquals("Misha", n.getFirstName());
		assertEquals("LLL", n.getSecondName());
		
		
	}

	@Test
	public void testGetBankAccountByTelephone() {
		BankAccountDAO accountDAO = new BankAccountDAO();
		List<BankAccount> n = accountDAO.getBankAccountByTelephone(accound.getTelephone());
		 for (BankAccount tel : n) {
			 if(tel.getFirstName().equals("Misha")) {
			assertEquals("00004000300", tel.getTelephone()); ;
			 }
		}
		
		
		
	}

	@Test
	public void testGetStudentToSecondName() {
		BankAccountDAO accountDAO = new BankAccountDAO();
		List<BankAccount> n = accountDAO.getStudentToSecondName(accound.getEmail());
		for (BankAccount mail : n) {
			if(mail.getSecondName().equals("LLL")) {
				assertEquals("WERKA@GMAIL.COM", mail.getEmail());
			}
			}
			
		}
		
	}


