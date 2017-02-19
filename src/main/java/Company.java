import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Company {
    private Integer[] endurance;
    private Integer[] boss;
    private Tree tree = new Tree();
    public Company(Integer[] endurance, Integer[] boss){
        if (endurance.length-boss.length==1){
            this.endurance = endurance;
            this.boss = boss;
        } else System.out.println("Array lengths are not valid! Endurance array should be" +
                " 1 element longer than boss array");
    }
    //if no limit for participants
    public List<Integer> getTeam(){
        return tree.getTeamList().stream().sorted().collect(Collectors.toList());
    }
    public void makeTree(){
        TreeNode treeNode = tree.insertNode(endurance[0]);
        makeNode(treeNode, 0);
        System.out.printf("%nA tree created with depth of %d",tree.getDepth());
    }
    public int getBestTeamValue(){
        return tree.getNonAdjSum();
    }
    private void makeNode(TreeNode node, Integer index){
        for (int i =0; i<boss.length;i++){
            if (boss[i] == index) {
                makeNode(node.insert(endurance[i+1],i+1), i+1);
            }
        }

    }
    public void printDrinkingTeam(){
        System.out.printf("%n Indexes of team members: %n");
        tree.getTeamList().stream().sorted().forEach(x->System.out.printf(" %d",x));
    }
}
