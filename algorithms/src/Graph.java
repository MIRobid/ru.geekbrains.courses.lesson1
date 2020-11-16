/*
Задание 7.1
Приведите пример графа.

Это может быть вызов такси, алгоритм определяет такси близкое к клиенту.

Задание 7.2
Реализуйте базовые методы графа.
Задание 7.3
В программный код из задания 7.2 добавьте реализацию метода обхода в глубину.
Выполните оценку времени с помощью System.nanoTime().
Задание 7.4
В базовом графе из задания 7.2 реализуйте метод обхода в ширину.
Выполните оценку времени с помощью System.nanoTime().

 */

import java.util.LinkedList;
import java.util.Queue;

class Vertex{
    public char label;
    public boolean wasVisited;
    public Vertex(char label){
        this.label=label;
        this.wasVisited=false;
    }

}

class stack{
    private int maxSize;
    private int[] stackArr;
    private int top;

    public stack(int size){
        this.maxSize=size;
        this.stackArr=new int[size];
        this.top=-1;
    }

    public static void push(int i) {stackArr[++top]=i;}

    public static int pop() {return stackArr[top--];}

    public static boolean isEmpty(){return (top==-1);}

    public static int peek() {return stackArr[top];}
}


class GraphA{
    private final int MAX_VERTS=32;
    private Vertex[] vertexList;
    private int[][] adMat;

    private int size;

    public GraphA(){
        vertexList=new Vertex[MAX_VERTS];
        adMat=new int[MAX_VERTS][MAX_VERTS];
        size=0;
        for(int i=0;i<MAX_VERTS;i++){
            for(int j=0;j<MAX_VERTS;j++){
                adMat[i][j]=0;
            }
        }
    }

    public void addVertex(char label) {vertexList[size++]=new Vertex(label);}

    public void addEdge(int start, int end){
        adMat[start][end]=1;
        adMat[end][start]=1;
    }

    public void displayVertex(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    public void fullDisplayVertex(int vertex1, int vertex2){
        System.out.println("Вершины "+vertexList[vertex1].label+"-"+vertexList[vertex2].label);
    }

    private int getAdjUnvisitedVertex(int ver){
        for(int i=0;i<size;i++){
            if(adMat[ver][i]==1 && vertexList[i].wasVisited==false){
                return i;
            }
        }
        return -1;
    }



    public void dfs(){
        vertexList[0].wasVisited=true;
        displayVertex(0);
        stack.push(0);
        while(!stack.isEmpty()){
            int v=getAdjUnvisitedVertex(stack.peek());
            if(v==-1){
                stack.pop();
            }else{
                vertexList[v].wasVisited=true;
                displayVertex(v);
                stack.push(v);
            }
        }

        for(int i=0; i<size;i++){
            vertexList[i].wasVisited=false;
        }
    }

    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited=true;
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()){
            int v1=queue.remove();
            while((v2=getAdjUnvisitedVertex(v1))!=-1){
                vertexList[v2].wasVisited=true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for(int i=0;i<size;i++)
            vertexList[i].wasVisited=false;
    }

}


public class Graph {
    public static void main(String[] args) {
        GraphA graph = new GraphA();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,3);
        graph.addEdge(3,4);

        int start= (int) System.nanoTime();
        graph.dfs();
        System.out.println((int)System.nanoTime()-start);

        int start2= (int) System.nanoTime();
        graph.bfs();
        System.out.println((int)System.nanoTime()-start2);

    }

}
