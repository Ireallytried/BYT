package Memento;

public class Main {
    public static void main(String[] args) {
        MemoryCard memoryCard = new MemoryCard();
        Data data1 = new Data("first data");
        System.out.println(data1.getData());
        memoryCard.saveTo(new Memory(data1.getData()));
        data1 = new Data("second data");
        memoryCard.saveTo(new Memory(data1.getData()));
        System.out.println(data1.getData());
        data1.returnData(memoryCard.returnFrom(0));
        System.out.println(data1.getData());

    }
}
