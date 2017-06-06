package coderhann.singlelinkedlist;


/**
 * Created by roki on 2017/5/27.
 */
public class test {

    public static void main(String[] args) {
        SingleLinkedList<String> singleList = new SingleLinkedList<>();
        singleList.add("A");
        singleList.add("B");
        singleList.add("C");
        singleList.add("D");


        singleList.delete(3);

        singleList.add(1,"F");
        singleList.add(0,"G");
        singleList.add("E");

        singleList.delete("A");


        singleList.printSingleLinkedList();

        singleList.reverseSingleLinkedList();
        singleList.printSingleLinkedList();

    }
}
