import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class MyHashMap {
    private static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private Entry[] table;
    private static final int SIZE = 1000;

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Entry(key, value);
        } else {
            Entry current = table[index];
            while (true) {
                if (current.key == key) {
                    current.value = value;
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = new Entry(key, value);
        }
    }

    public int get(int key) {
        int index = hash(key);
        Entry current = table[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Entry current = table[index];
        Entry previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandsInput = scanner.nextLine();
        String valuesInput = scanner.nextLine();

        String[] commands = commandsInput.split(" ");
        String[] valuesArray = valuesInput.split(", ");

        MyHashMap myHashMap = new MyHashMap();
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (command.equals("MyHashMap")) {
                output.add(null);
            } else if (command.equals("put")) {
                String[] nums = valuesArray[i].replace("[", "").replace("]", "").split(",");
                int key = Integer.parseInt(nums[0].trim());
                int value = Integer.parseInt(nums[1].trim());
                myHashMap.put(key, value);
                output.add(null);
            } else if (command.equals("get")) {
                int key = Integer.parseInt(valuesArray[i].replace("[", "").replace("]", "").trim());
                output.add(myHashMap.get(key));
            } else if (command.equals("remove")) {
                int key = Integer.parseInt(valuesArray[i].replace("[", "").replace("]", "").trim());
                myHashMap.remove(key);
                output.add(null);
            }
        }
        System.out.println(output);
    }
}