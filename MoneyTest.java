import org.junit.Test;
import static org.junit.Assert.*;

import java.beans.Transient;

public class MoneyTest {
    @Test 
    public void testMultiplication() {
        Dollar five = Money.dollar(5);
        assertEquals(Money.dollar (10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test 
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }

    @Test
    public void testFrancMultiplication() {
        Franc five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }
}

class Money {
    protected int amount;

    abstract Money times(int multiplier);

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount);
    }

    @Override 
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }
}

class Dollar extends Money {
    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }
}

class Franc extends Money {
    Fran(int amount) {
        this.amount = amount;
    }

    Money times(int multiplier) {
        return new Franc(amount * multiplier);
    }
}