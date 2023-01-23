package Calculator;

public class Main {

    public static void main(String[] argv) {
        Operation calculator = new Add();
        calculator.setNext(new Substract());
        calculator.getNext().setNext(new Multiply());
        calculator.getNext().getNext().setNext(new Divide());


        try {
            System.out.println(calculator.calculate(1, 10, Operator.ADD));
            System.out.println(calculator.calculate(20, 5, Operator.SUBSTRACT));
            System.out.println(calculator.calculate(10, 10, Operator.MULTIPLY));
            System.out.println(calculator.calculate(6, 2, Operator.DIVIDE));
        } catch (IllegalOperatorException e) {

            System.err.println("Illegal operation specified.");
        }
    }
}
