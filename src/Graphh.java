import java.util.*;

public class Graphh<Vertex> {
    private final boolean undirected;
    private Map<Vertex, List<Vertex>> map = new HashMap<>();

    public Graphh(){
        this.undirected = true;
    }

    public Graphh(boolean undirected){
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        Set<Vertex> set = new HashSet<>();
        Set keySet = map.keySet();
        for(Object vertex : keySet){
            count += map.get(vertex).size();
        }
        if(undirected==true){
            return count;
        }
        return count/2;
    }

    public boolean hasVertex(Vertex v) {
        if(map.containsKey(v)){
            return true;
        }
        return false;
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if(map.get(source).contains(dest)){
            return true;
        }
        return false;
    }

    /*public Iterable<Vertex> adj() {
    }*/
    public Iterable<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;

        return map.get(v);
    }

}
