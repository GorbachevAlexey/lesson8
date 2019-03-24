public class Main {
    public static int SIZE = 20;
    public static void main(String[] args) {
        MyIterator<String> myIterator = new MyIterator<String>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            myIterator.put(i,"String " + i);
        }

        System.out.println("Output");
        for (String str : myIterator) {
            System.out.println(str);
        }
    }
}
