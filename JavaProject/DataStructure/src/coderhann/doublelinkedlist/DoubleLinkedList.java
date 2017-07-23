package coderhann.doublelinkedlist;

/**
 * Created by roki on 2017/6/14.
 */
public class DoubleLinkedList<E> {

    /**
     * 存储结点数量
     */
    private int length;

    /**
     * 头结点引用
     */
    private Node<E> header;

    /**
     * 尾结点引用
     */
    private Node<E> footer;


    /**
     * 在链表最后的位置添加对象
     * @param e 泛型对象
     */
    public void add(E e) {

        Node<E> indexNode = footer;
        try {
            addElement(indexNode,new Node<>(e));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    /**
     * 在index位置的对象后面添加对象
     * @param index 索引从0开始，1表示header
     * @param e 泛型对象
     */
    public void add(int index,E e) {


        Node<E> indexNode = null;

        try {
            indexNode = getNode(index);
            addElement(indexNode,new Node<>(e));
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }

    /**
     * 添加对象的集中处理代码块
     * @param frontElement 在这个对象上执行添加操作
     * @param element 要添加的对象
     */
    private void addElement(Node<E> frontElement,Node<E> element) throws Exception{

        if (element.data == null) {
            throw new Exception("添加数据为空");
        }

        if (frontElement == null) {
            if (header != null) { //插入位置为0，链表不为空
                element.next = header;
                header.previous = element;
                header = element;
            } else { //链表长度为0，在首位添加数据
                header = element;
            }
        } else {
            element.next = frontElement.next;
            if (frontElement.hasNext()) {
                frontElement.next.previous = element;
            }
            frontElement.next = element;
            element.previous = frontElement;
        }

        if (!element.hasNext()) {
            footer = element;
        }

        length++;
    }

    /**
     * 链表的删除操作 索引
     * @param index 将要删除的对象索引 （1-length）
     * @return 删除掉的对象
     */
    public E delete(int index) {

        if (index < 1 || index > this.length) {
            return null;
        }

        Node<E> deletedNode = null;
        Node<E> indexNode = header;

        while (index > 0) {

            if (index == 1) {
                deletedNode = deleteElement(indexNode.previous,indexNode);
                break;
            }

            index--;
            indexNode = indexNode.next;
        }
        return deletedNode.data;

    }

    /**
     * 链表的删除操作 指定对象
     * @param e 将要删除的对象
     * @return 删除掉的对象
     */
    public E delete(E e) {

        Node<E> deletedNode = null;
        Node<E> indexNode = header;

        while (indexNode != null) {
            if (indexNode.data == e) {

                deletedNode = deleteElement(indexNode.previous,indexNode);
                break;
            }

            indexNode = indexNode.next;
        }
        return deletedNode.data;

    }

    /**
     * 删除操作集中处理
     * @param frontElement 前一个对象Node
     * @param element 要删除的对象Node
     * @return 删除掉的对象Node
     */
    private Node<E> deleteElement(Node<E> frontElement,Node<E> element) {

        Node<E> deletedNode = element;
        if (frontElement == null) {

            header = element.next;
            if (header != null) {
                header.previous = null;
            }

        } else {

            frontElement.next = element.next;
            if (element.next != null) {
                element.next.previous = frontElement;
            }
        }

        if (!deletedNode.hasNext()) {
            footer = deletedNode.previous;
        }
        length--;

        return deletedNode;
    }





    /**
     * 链表的反转[A,B,C,D]->[D,C,B,A]
     */
    public void reverseDoubleLinkedList() {

        Node<E> tempNode = header;
        while (tempNode != null) {
            Node<E> nextNode = tempNode.next;

            Node<E> temp = tempNode.previous;
            tempNode.previous = tempNode.next;
            tempNode.next = temp;

            tempNode = nextNode;
        }

        Node<E> temp = header;
        header = footer;
        footer = temp;

    }


    /**
     * 获取指定索引位置的对象
     * @param index 索引
     * @return 链表存储的对象
     */
    public E getObject(int index) {
        if (index < 1 || index > this.length) {
            return null;

        }

        Node<E> node = null;
        try {
            node = getNode(index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return node.data;
    }


    /**
     * 获取对应index的结点对象element
     * @param index 指定索引
     * @return Node<E> 对象
     * @throws Exception
     */
    private Node<E> getNode(int index) throws Exception{

        if (index < 0 || index > this.length) {
            throw new Exception("索引值越界");
        }

        Node<E> node = null;

        if (index == 0) {
            return node;
        }

        Node<E> indexNode = header;
        for (int i = 0;i < index - 1;i++) {
            indexNode = indexNode.next;
        }
        node = indexNode;


        return node;

    }

    /**
     * 正向打印双链表的数据
     */
    public void printListFront() {

        Node<E> node = header;
        System.out.print("DoubleLinkedList:[");
        while (node != null) {

            System.out.print(node.data);
            if (node.hasNext()) {
                System.out.print(",");
            }
            node = node.next;

        }
        System.out.println("]");
    }
    /**
     * 反向打印双链表的数据
     */
    public void printListBack() {

        Node<E> node = footer;
        System.out.print("DoubleLinkedList:[");
        while (node != null) {

            System.out.print(node.data);
            if (node.hasPrevious()) {
                System.out.print(",");
            }
            node = node.previous;

        }
        System.out.println("]");
    }
}


// 结点类
class Node<E> {

    /**
     * 数据区
     */
    public E data;

    /**
     * 前一个结点引用
     */
    public Node<E> previous;

    /**
     * 下一个结点引用
     */
    public Node<E> next;

    public Node(E e) {
        data = e;
        previous = null;
        next = null;
    }

    /**
     * 判断该结点后是否有下一个结点
     * @return
     */
    public boolean hasNext() {
        return this.next != null;
    }

    /**
     * 判断该结点是否有前置结点
     * @return
     */
    public boolean hasPrevious() {
        return this.previous != null;
    }
}