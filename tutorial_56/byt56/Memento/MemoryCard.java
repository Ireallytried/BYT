package Memento;

import java.util.ArrayList;
import java.util.List;

public class MemoryCard {
    private List<Memory> memories = new ArrayList<>();

    public void saveTo(Memory memory) {
        this.memories.add(memory);
    }

    public Memory returnFrom(int index) {
        return this.memories.get(index);
    }
}


