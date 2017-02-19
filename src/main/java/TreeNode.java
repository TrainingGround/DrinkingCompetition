import java.util.ArrayList;
import java.util.List;

public class TreeNode{
    private ArrayList<TreeNode> nodes = new ArrayList<>();
    private Integer data;
    private Pair pair;
    private Integer index;
    public TreeNode(Integer nodeData, Integer index){
        data = nodeData;
        this.index = index;
    }
    public TreeNode insert(Integer insertValue, Integer index){
        TreeNode newNode = new TreeNode(insertValue, index);
        nodes.add(newNode);
        return newNode;
    }

    public Integer getData(){
        return data;
    }
    public Pair getSums(){
        if (nodes.isEmpty()){
            pair = new Pair(getData(), 0);
        } else {
            Integer incl=getData();
            Integer excl=0;
            for (TreeNode node:nodes){
                Pair iterPair= node.getSums();
                //calculating max sum including data in this subnode
                incl += iterPair.getExcl();
                //calculating max sum excluding data in this subnode
                if (iterPair.getIncl()>iterPair.getExcl()){
                    excl+= iterPair.getIncl();
                } else  excl+= iterPair.getExcl();

            }

            pair = new Pair(incl, excl);
        }
        return pair;

    }

    public void getTeamIndexes(List<Integer> list){//TODO Should I rather create new ArrayList and merge it with one of upper level?
        if (pair.getIncl()>pair.getExcl()){
            list.add(index);//add this to list and check all grandchild nodes (child nodes are not to be included)
            if (!nodes.isEmpty())
            for(TreeNode node:nodes)
                if (!node.nodes.isEmpty())//if there are grandchild nodes
                for (TreeNode subNode : node.nodes)
                    subNode.getTeamIndexes(list);
        }else{//call this function recursively in child nodes
            if(!nodes.isEmpty())
                for (TreeNode node:nodes)
                    node.getTeamIndexes(list);
        }
    }
    public int getDepth(){
        if (nodes.isEmpty())
            return 1;
        else{
            int max=0;
            for(TreeNode node:nodes){
                max = Math.max(max, node.getDepth());
            }
            return max+1;
        }
    }
}