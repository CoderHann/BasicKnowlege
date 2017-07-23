package coderhann.doublelinkedlist;


/**
 * Created by roki on 2017/6/16.
 */
public class Test {

    public static void main(String[] args) {

        DoubleLinkedList<String> singleList = new DoubleLinkedList<>();
        singleList.add("A");
        singleList.add("B");
        singleList.add("C");
        singleList.add("D");


        singleList.delete(3);

        singleList.add(1,"F");
        singleList.add(0,"G");
        singleList.add("E");

        singleList.delete("A");


        singleList.printListFront();

        singleList.reverseDoubleLinkedList();
        singleList.printListFront();
        singleList.printListBack();
    }
}
