package org.example.account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountManagerTest {

  Customer customer = new Customer();
  AccountManager accountManager = new AccountManagerImpl();

  @Test
  void givenAmountBelowMaxCreditForNormalCustomerWhenWithdrawThenSubtractFromBalance() {
    // Arrange
    customer.setBalance(100);

    // Act
    String result = accountManager.withdraw(customer, 80);

    // Assert
    int expectedBalance = customer.getBalance();
    Assertions.assertEquals(20, expectedBalance);
    Assertions.assertEquals("success", result);
  }

  @Test
  void givenAmountForCustomerIsCreditNotAllowed_WhenWithdraw_ThenReturnMessageWithoutSubtractFromBalance() {

    //Arrange
    customer.setBalance(200);

    //Act
    String result = accountManager.withdraw(customer, 220);

    //Assert
    int expectedBalance = customer.getBalance(); // Balance of user not updated so method not complete execution
    Assertions.assertEquals(200, expectedBalance);
    Assertions.assertEquals("insufficient account balance", result);
  }

  @Test
  void givenAmountAboveMaxCreditForNormalCustomer_WhenWithdraw_ThenReturnMessageWithoutSubtractFromBalance() {

    //Arrange
    customer.setBalance(1000);
    customer.setCreditAllowed(true);
    customer.setVip(false);
    //Act
    String result = accountManager.withdraw(customer, 2200);

    //Assert
    int expectedBalance = customer.getBalance(); // Balance of user not updated so method not complete execution
    Assertions.assertEquals(1000, expectedBalance);
    Assertions.assertEquals("maximum credit exceeded", result);
  }

  @Test
  void givenAmount_whenDeposit_thenAddInBalance(){
    //Arrange
    customer.setBalance(1000);

    //Act
    accountManager.deposit(customer,12000);

    Assertions.assertEquals(13000,customer.getBalance());

  }



}
