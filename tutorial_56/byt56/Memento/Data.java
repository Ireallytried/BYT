package Memento;

public class Data {
    private String data;

    public Data(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void returnData(Memory memory) {
        this.data = memory.getSpaceName();
    }

}
