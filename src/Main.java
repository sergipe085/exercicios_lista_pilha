import estudo.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        LinkedList<String> list = new LinkedList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("cu");

        System.out.println(list.toString());
        
        // System.out.println(list.removeByIndex(3));
        list.insert(2, "oi");
        list.clear();
        // list.get(3);
        // System.out.println(list.get(0));
        System.out.println(list.toString());

    }
}
