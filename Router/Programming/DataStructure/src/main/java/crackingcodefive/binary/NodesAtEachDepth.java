package crackingcodefive.binary;

import assistant.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ritesh on 8/25/16.
 */
public class NodesAtEachDepth {

    public static void main(String args[]) {

        final Map<Integer, List<Tree>> depthAtEachLevel =  new HashMap<>();
        final Tree root = new Tree(null,6,null);
        nodesAtEachDepth(root,depthAtEachLevel,0);
    }

    public static void nodesAtEachDepth(final Tree root, final Map<Integer,List<Tree>> nodesAtDepth,int depth) {

        if(root == null) {
            return;
        }

        if(nodesAtDepth.get(depth) !=null) {
            final List<Tree> treesAtDepth = nodesAtDepth.get(depth);
            treesAtDepth.add(root);
        }else {
            final List<Tree> treesAtDepth = new ArrayList<>();
            treesAtDepth.add(root);
            nodesAtDepth.put(depth,treesAtDepth);
        }

        nodesAtEachDepth(root.left,nodesAtDepth,depth+1);
        nodesAtEachDepth(root.right,nodesAtDepth,depth+1);
    }



    private static class Tree {

        int data;
        Tree left;
        Tree right;

        Tree(Tree left, int data, Tree right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
