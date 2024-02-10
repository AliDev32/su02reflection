package ali.su.cft2j02;

import lombok.Getter;

public class LoggedFractionProxy implements Fractionable {
    private final Fractionable originalObject;

    @Getter
    private int noCacheInvokesCnt;

    public LoggedFractionProxy(Fractionable originalObject) {
        this.originalObject = originalObject;
    }

    @Override
    @Cache
    public double doubleValue() {
        noCacheInvokesCnt++;
        return originalObject.doubleValue();
    }

    @Override
    @Mutator
    public void setNum(int num) {
        originalObject.setNum(num);
    }

    @Override
    @Mutator
    public void setDenom(int denom) {
        originalObject.setDenom(denom);
    }
}
