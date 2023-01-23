package Calculator;

public class Substract extends Operation {

    public float calculate(float a, float b, Operator operator) throws IllegalOperatorException {
        if(operator == Operator.SUBSTRACT) {
            return a - b;
        } else {
            if(next != null) {
                return next.calculate(a, b, operator);
            } else {
                throw new IllegalOperatorException();
            }
        }
    }
}
