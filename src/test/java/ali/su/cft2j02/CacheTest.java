package ali.su.cft2j02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CacheTest {

    @Test
    @DisplayName("Получение данных из кэша для вновь созданного объекта")
    void testCacheNewObject() {
        var fraction = new Fraction(2, 3);
        var loggedFraction = new LoggedFractionProxy(fraction);
        var cachedFraction = (Fractionable) CacheUtils.cache(loggedFraction);

        cachedFraction.doubleValue();
        Assertions.assertEquals(1, loggedFraction.getNoCacheInvokesCnt());
        cachedFraction.doubleValue();
        Assertions.assertEquals(1, loggedFraction.getNoCacheInvokesCnt());
    }
    @Test
    @DisplayName("Получение данных из кэша после вызова мутатора setNum")
    void testCacheAfterMutatorSetNum() {
        var fraction = new Fraction(2, 3);
        var loggedFraction = new LoggedFractionProxy(fraction);
        var cachedFraction = (Fractionable) CacheUtils.cache(loggedFraction);

        cachedFraction.doubleValue();
        Assertions.assertEquals(1, loggedFraction.getNoCacheInvokesCnt());
        cachedFraction.setNum(5);
        cachedFraction.doubleValue();
        Assertions.assertEquals(2, loggedFraction.getNoCacheInvokesCnt());
    }
    @Test
    @DisplayName("Получение данных из кэша после вызова мутатора setDenom")
    void testCacheAfterMutatorSetDenom() {
        var fraction = new Fraction(2, 3);
        var loggedFraction = new LoggedFractionProxy(fraction);
        var cachedFraction = (Fractionable) CacheUtils.cache(loggedFraction);

        cachedFraction.doubleValue();
        Assertions.assertEquals(1, loggedFraction.getNoCacheInvokesCnt());
        cachedFraction.setDenom(5);
        cachedFraction.doubleValue();
        Assertions.assertEquals(2, loggedFraction.getNoCacheInvokesCnt());
    }
}