package Calculator;

public class Add extends Operation {

    public float calculate(float a, float b, Operator operator) throws IllegalOperatorException {
        if(operator == Operator.ADD) {
            return a + b;
        } else {
            if(next != null) {
                return next.calculate(a, b, operator);
            } else {
                throw new IllegalOperatorException();
            }
        }
    }
}