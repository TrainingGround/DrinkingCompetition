import java.util.ArrayList;
import java.util.List;

public class TreeNode{
    private ArrayList<TreeNode> nodes = new ArrayList<>();
    private Integer data;
    private boolean isInTeam;
    private Integer index;
    public TreeNode(Integer nodeData, Integer index){
        data = nodeData;
        isInTeam = false;
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
        Pair pair;
        if (nodes.isEmpty()){
            pair = new Pair(data, 0);
        } else {
            Integer incl=0;
            Integer excl=0;
            for (TreeNode node:nodes){
                Pair iterPair= node.getSums();
                //calculating max sum including data in this node
                incl += iterPair.getExcl();
                //calculating max sum excluding data in this node
                //excl += Math.max(iterPair.getExcl(),iterPair.getIncl());
                if (iterPair.getIncl()>iterPair.getExcl()){
                    node.setInTeam(true);// ERROR - for excl sum is not necessarily the biggest one
                    excl+= iterPair.getIncl();
                } else {
                    setInTeam(false);
                    excl+= iterPair.getExcl();
                }

            }
            incl+=data;
            pair = new Pair(incl, excl);
        }
        return pair;

    }
    public boolean getInTeam(){
        return isInTeam;
    }
    public void setInTeam(boolean isInTeam){
        this.isInTeam = isInTeam;
    }
    public void getTeamIndexes(List<Integer> list){//TODO Should I rather create new ArrayList and merge it with one of upper level?
        if (getInTeam()) list.add(index);
        if (!nodes.isEmpty())
            for (TreeNode node:nodes)
                node.getTeamIndexes(list);
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