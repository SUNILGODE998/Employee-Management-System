package bankaccount;

import org.example.bankaccount.BankAccount;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount(100.0); // Start with $100
    }

    @Test
    @DisplayName("Initial balance should be correct")
    void testInitialBalance() {
        assertEquals(100.0, account.getBalance());
    }

    @Test
    @DisplayName("Deposit positive amount should increase balance")
    void testDepositPositiveAmount() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    @DisplayName("Multiple deposits should accumulate correctly")
    void testMultipleDeposits() {
        account.deposit(25.0);
        account.deposit(75.0);
        assertEquals(200.0, account.getBalance());
    }

    @Test
    @DisplayName("Deposit zero should throw IllegalArgumentException")
    void testDepositZero() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> account.deposit(0)
        );
        assertEquals("Deposit amount must be positive", exception.getMessage());
        assertEquals(100.0, account.getBalance()); // Balance unchanged
    }

    @Test
    @DisplayName("Deposit negative amount should throw IllegalArgumentException")
    void testDepositNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
        assertEquals(100.0, account.getBalance()); // Balance unchanged
    }

    @Test
    @DisplayName("Withdraw valid amount should decrease balance")
    void testWithdrawValidAmount() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance());
    }

    @Test
    @DisplayName("Withdraw exact balance should result in zero balance")
    void testWithdrawExactBalance() {
        account.withdraw(100.0);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    @DisplayName("Withdraw more than balance should throw IllegalStateException")
    void testWithdrawMoreThanBalance() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> account.withdraw(150.0)
        );
        assertEquals("Insufficient funds", exception.getMessage());
        assertEquals(100.0, account.getBalance()); // Balance unchanged
    }

    @Test
    @DisplayName("Withdraw negative amount should throw IllegalArgumentException")
    void testWithdrawNegativeAmount() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-20.0));
    }

    @Test
    @DisplayName("Withdraw zero should throw IllegalArgumentException")
    void testWithdrawZero() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
    }

    @Test
    @DisplayName("Complex transaction sequence should work correctly")
    void testComplexTransactions() {
        account.deposit(50.0);  // Balance: 150.0
        account.withdraw(75.0); // Balance: 75.0
        account.deposit(25.0);  // Balance: 100.0

        assertEquals(100.0, account.getBalance());
    }
}
