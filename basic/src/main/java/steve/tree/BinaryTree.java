package steve.tree;

/**
 * @author steve
 */
public class BinaryTree {
    private Integer val;
    private BinaryTree parent;
    private BinaryTree child1;
    private BinaryTree child2;

    public BinaryTree() {
    }

    public BinaryTree(Integer val) {
        this.val = val;
    }

    public BinaryTree(Integer val, BinaryTree child1, BinaryTree child2) {
        this.val = val;
        this.child1 = child1;
        this.child2 = child2;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public BinaryTree getParent() {
        return parent;
    }

    public void setParent(BinaryTree parent) {
        this.parent = parent;
    }

    public BinaryTree getChild1() {
        return child1;
    }

    public void setChild1(BinaryTree child1) {
        this.child1 = child1;
    }

    public BinaryTree getChild2() {
        return child2;
    }

    public void setChild2(BinaryTree child2) {
        this.child2 = child2;
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(1, new BinaryTree(2), new BinaryTree(3));

    }
}
