import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

///// creat a tree class
public class Tree implements Serializable {

    private static final long serialVersionUID = -7101579102934745505L;

    private List<Grid> treeList = null;

    public Tree() {
        treeList = new ArrayList<Grid>();
    }

    public void draw(Graphics2D g2) {
        for (Grid grid : treeList) {
            grid.draw(g2);
        }
    }

    /**
     * @return the TreesList
     */
    public List<Grid> getTreeList() {
        return treeList;
    }

    /**
     * @param treeList
     *            the treeList to set
     */
    public void setTreeList(List<Grid> treeList) {
        this.treeList = treeList;
    }

}
