package cn.zsza.data_structure.link;

public class LinkListOfBooks{



    public Book first;  // 头节点

    public Book last;   // 尾节点

    public int size;

    public LinkListOfBooks() {
        this.first = null;
        this.last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }
    /**(第一个版本不考虑尾节点)
     * 新加入的节点放入链表的头部
     * 链表初始化，first = null
     * 加入第一个节点:newLink.next = first, 新的节点.next指向first
     * 然后把新加入的节点作为first:first = newLink
     * @param bookName
     * @param millionsSold
     */

    public void insertfirst(String bookName, int millionsSold){
        Book newLink = new Book(bookName, millionsSold);
        newLink.next = first;
        first = newLink;
    }
    /**
     * 考虑尾节点
     * @param bookName
     * @param millionsSold
     */
    public void insertfirst2(String bookName, int millionsSold){
        Book newLink = new Book(bookName, millionsSold);
        if (size == 0){
            fillStart(newLink);
        }else {
            newLink.next = first;
            first = newLink;
        }
        size++;
    }

    private void fillStart(Book link) {
        first = link;
        last = first;
    }

    public void insertlast(String bookName, int millionsSold){
        Book newLink = new Book(bookName, millionsSold);
        if (first == null){
            first = newLink;
            last = first;
        }else {
            last.next = newLink;
            last = newLink;
        }
    }

    /**
     * 移除头元素,然后把first.next指向first
     * @return
     */
    public Book removefirst(){
        Book linkReference = first;
        if (!isEmpty()){
            first = first.next;
        }else {
            System.out.println("empty link");
        }

        return linkReference;
    }

    public void display(){
        Book theLink = first;

        while (theLink != null){
            System.out.println("Next link:" + theLink.next);
            theLink.display();
            theLink = theLink.next;
            System.out.println();
        }
    }
    public Book find(String bookName){
        Book theLink = first;
        if (!isEmpty()){
            while (theLink.bookName != bookName){
                if (theLink.next == null){
                    return null;
                }else {
                    theLink = theLink.next;
                }
            }
        }else {
            System.out.println("empty link");
        }
        return theLink;
    }

    public Book removeLink(String bookName){
        Book currentLink = first;
        Book previousLink = first;

        while (currentLink.bookName != bookName){
            if (currentLink.next == null){
                return null;
            }else {
                previousLink = currentLink;
                currentLink = currentLink.next;
            }
        }
        if (currentLink == first){
            first = first.next;
        }else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

    /**
     * Book作为LinkedListOfBooks链表的元素
     */
    static class Book {
        public String bookName;        // 书名
        public int millionsSold;       // 销量

        public Book next;

        public Book(String bookName, int millionsSold) {
            this.bookName = bookName;
            this.millionsSold = millionsSold;
        }
        @Override
        public String toString() {
            return "Book{" +
                    "bookName='" + bookName + '\'' +
                    '}';
        }
        public void display(){
            System.out.println(bookName + "...." + millionsSold);
        }
    }
    /**
     * @param args
     * 头插法
     * LinkListOfBooks:
       初始化 first为null
       插入一个新节点,first后移,newLink.next = first;
       把newLink作为头结点,first = newLink;
     */
    public static void main(String[] args) {
        LinkListOfBooks theLinkedList = new LinkListOfBooks();
        theLinkedList.insertfirst2("java",200);
        theLinkedList.insertfirst2("php",100);
        theLinkedList.insertfirst2("python",80);
        theLinkedList.insertfirst2("C++",60);

//        theLinkedList.insertlast("java",200);
//        theLinkedList.insertlast("php",100);
//        theLinkedList.insertlast("python",80);
//        theLinkedList.insertlast("C++",60);

//        theLinkedList.removefirst();
        theLinkedList.display();
    }
}
