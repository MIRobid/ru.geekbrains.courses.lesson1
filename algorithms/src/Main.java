
/*
Задание 6.1
Приведите пример использования древовидной структуры.

Товарные категории. Например, "Электроника-Компьютеры-Планшеты".

Задание 6.2
Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
Задание 6.3
Реализуйте методы поиска и вставки узла в дерево.
Задание 6.4
Реализуйте базовые методы обхода дерева и метода дисплей.
Реализуйте поиск максимума и минимума.
Задание 6.5
Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью System.nanoTime().
Задание 6.6
Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией бинарной пирамиды.
Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните с предыдущими алгоритмами сортировки.

Задание 6.7
Приведите пример сбалансированного дерева и его применения.
Это задача где нужно быстро искать и изменять данные в базе. Например, база контактов клиентов.


 */

import java.util.Arrays;
import java.util.Random;

class Person{
    public String name;
    public int id;
    public int age;

    public Person(int id, String name, int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
}



class Node{

    public Person person;
    public Node left;
    public Node right;

    public void display(){
        System.out.println("Name "+person.name+" Age: "+person.age);
    }
}

class Tree{
    private Node root;
    public void insert (Person person){
        Node node = new Node();
        node.person=person;
        if (root==null)
            root=node;
        else {
            Node current = root;
            Node parent;
            while(true){
                parent=current;
                if(person.id<current.person.id){
                    current=current.left;
                    if(current==null){
                        parent.left=node;
                        return;
                    }
                }else{
                    current=current.right;
                    if (current==null){
                        parent.right=node;
                        return;
                    }
                }
            }
        }

    }

    public Node find (int key){
        Node current=root;
        while (current.person.id!=key){
            if(key<current.person.id)
                current=current.left;
            else
                current=current.right;
            if(current==null)
                return null;
        }
        return current;

    }

    private void preOrder (Node rootNode){
        if(rootNode!=null){
            rootNode.display();
            preOrder(rootNode.left);
            preOrder(rootNode.right);
        }
    }

    private void postOrder(Node rootNode){
        if(rootNode!=null){
            postOrder(rootNode.left);
            postOrder(rootNode.right);
            rootNode.display();
        }
    }


    private void inOrder(Node rootNode){
        if(rootNode!=null){
            inOrder(rootNode.left);
            rootNode.display();
            inOrder(rootNode.right);
        }
    }

    public Node min(){
        Node current, last=null;
        current = root;
        while(current!=null){
            last=current;
            current=current.left;
        }
        return last;
    }

    public Node max(){
        Node current, last=null;
        current=root;
        while(current!=null){
            last=current;
            current=current.right;
        }
        return last;
    }

    public boolean delete(int id){
        Node current=root;
        Node parent=root;
        boolean isLeft=true;

        while(current.person.id!=id){
            parent=current;
            if(id<current.person.id){
                isLeft=true;
                current=current.left;
            }else{
                isLeft=false;
                current=current.right;
            }
            if(current==null){
                return false;
            }
        }
        if (current.left==null && current.right==null){
            if(current==root){
                root=null;
            }else if(isLeft){
                parent.left=null;
            }else{
                parent.right=null;
            }
        }else if(current.right==null){
            if(current==null){
                root=current.left;
            }else if(isLeft){
                parent.left=current.left;
            }else {
                parent.right=current.left;
            }
        }else if(current.left==null){
            if(current==null){
                root=current.right;
            }else if(current.left==null){
                if(current==null){
                    root=current.right;
                }else if(isLeft){
                    parent.left=current.left;
                }else{
                    parent.right=current.right;
                }
            }else{
                Node successor=getSuccessor(current);
                if(current==root){
                    root=successor;
                }else if(isLeft){
                    parent.left=successor;
                }else{
                    parent.right=successor;
                }
                successor.left=current.left;
            }
            return true;
        }



    }

    public Node getSuccessor(Node node){
        Node successorParent=node;
        Node successor=node;
        Node current=node.right;

        while (current!=null){
            successorParent=successor;
            successor=current;
            current=current.left;
        }
        if(successor!=node.right){
            successorParent.left=successor.right;
            successor.right=node.right;
        }
        return successor;
    }

    public void displayTree(){
        Node current=root;
        System.out.println("Symmetric");
        inOrder(root);
        System.out.println("Liner");
        preOrder(root);
        System.out.println("Reverse");
        postOrder(current);

    }
}

public class Main {
    public static void main(String[] args) {
        int start=(int) System.nanoTime();
        Tree tree=new Tree();

        tree.insert(new Person(4,"AAA",30));

        tree.max().display();
        tree.min().display();

        tree.find(3).display();

        tree.delete(2);

        System.out.println();

        tree.displayTree();
        int finish=(int) System.nanoTime();
        System.out.println(finish-start);

        int start2=(int) System.nanoTime();
        int[] arr=new int[10];
        Random rand=new Random();

        for (int i=0;i<arr.length;i++){
            arr[i]=rand.nextInt(10);
        }

        System.out.println(Arrays.toString(arr));
        HeapSort arrsort=new HeapSort();

        arrsort.sort(arr);

        System.out.println(Arrays.toString(arr));

        int finish2=(int) System.nanoTime();
        System.out.println(finish2-start2);

    }
}

class HeapSort{
    private static int heapSize;

    public static void sort(int[] a){
        buildHeap(a);
        while(heapSize>1){
            swap(a,0,heapSize-1);
            heapSize--;
            heapify(a,0);
        }
    }

    private static void buildHeap(int[] a){
        heapSize=a.length;
        for(int i=a.length/2;i>=0;i--){
            heapify(a,i);
        }
    }

    private static void heapify(int[] a,int i){
        int l=left(i);
        int r=right(i);
        int largest=i;
        if(l<heapSize && a[i]<a[l]){
            largest=l;
        }
        if (r < heapSize && a[largest]<a[r]){
            largest=r;
        }
        if(i!=largest){
            swap(a,i,largest);
            heapify(a,largest);
        }
    }

    private static int right(int i) {return i+2;}
    private static int left(int i) {return i+1;}

    private static void swap(int[] a, int i, int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

