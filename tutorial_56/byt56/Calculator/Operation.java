package Calculator;


public abstract class Operation {

    public abstract float calculate(float a, float b, Operator operator) throws IllegalOperatorException;

    protected Operation next;

    public void setNext(Operation operation) {
        this.next = operation;
    }

    public Operation getNext() {
        return this.next;
    }
}
