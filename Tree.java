package week12;
import java.util.*;


public class Tree<T> {
    
    private T rootValue;
    private List<Tree<T>> children;
    
    public Tree(T rootValue, List<Tree<T>> children) {
        this.rootValue = rootValue;
        this.children = children;
    }

    public Tree(T rootValue) {
        this(rootValue, new ArrayList<Tree<T>>());
    }
    
    public int size() {

        int size = 1;
        if(children.isEmpty()){
            return 1;
        }else{
            for(int i =0; i < children.size(); i++){
                size += children.get(i).size();
            }
        }
        return size;
    }
    
    public int maxDegree() {
        int max = children.size();
        if(children.isEmpty()){
            return max;
        }else{
            for(int i = 0; i < children.size(); i++){
                if(children.get(i).maxDegree() > max){
                    max = children.get(i).maxDegree();
                }
            }
        }
        return max;
    }
    
    public void add(Tree<T> child) {
        children.add(child);
    }

    public Tree<T> find(T value) {
        if (rootValue.equals(value)) {
            return this;
        }
        for (Tree<T> child : children) {
            Tree<T> match = child.find(value);
            if (match != null) {
                return match;
            }
        }
        return null;
    }
    
    public List<T> postOrder() {
        ArrayList<T> list = new ArrayList<T>();

        if(children.isEmpty()){
            list.add(rootValue);
        }else{
            for(int i =0; i < children.size(); i++){
                list.addAll(children.get(i).postOrder());
            }
            list.add(rootValue);
        }
        return list;
    }
    
    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }
    
    public String toIndentedString() {
        return indentString(1) + "\n";
    }

    public String indentString(int l){
        StringBuilder s = new StringBuilder(rootValue.toString());
        
        if(children.isEmpty()){
            return s.toString();
        }else{
            for(int i =0; i < children.size(); i++){
                s.append("\n" + level(l) + children.get(i).indentString(l+1));
            }
        }
        return s.toString();
    }

    public String level(int l){
        String s = "";
        for(int i =0; i < l; i++){
            s += "  ";
        }
        return s;
    }

    /** A helper method for testing (used by main).  Searches tree for
     *  the given target and adds white space separated children to
     *  the tree matching target if there is one.
     *
     * @param target the root value to seach for.
     * @param children a white space separated list of children to add
     * to the tree whose value matches target.
     */
    private static void addChildren(String target, String children) {
        Tree<String> parent = tree.find(target);
        if (parent != null) {
            for (String child : children.split(" ")) {
                parent.add(new Tree<>(child));
            }
        }
    }

    /** A tree instance used for testing. */
    private static Tree<String> tree;

    /**
     * Entry point of the program (used for testing).
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        System.out.println("Creating tree\n-------------");
        tree = new Tree<>("food");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding children\n----------------");
        addChildren("food", "meat fruit vegetable");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding deeper children\n----------------------");
        addChildren("meat", "chicken beef fish");
        addChildren("fish", "salmon cod tuna shark");
        addChildren("vegetable", "cabbage");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nPostorder\n---------");
        System.out.println(tree.postOrder());
        System.out.println("\nIndented string\n---------------");
        System.out.print(tree.toIndentedString());
    }

}
