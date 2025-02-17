public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);

        System.out.println(list.contains(3));

    }

}
