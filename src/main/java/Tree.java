import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Tree{
	private TreeNode root;
	public Tree(){
		root=null;
	}
	public TreeNode insertNode(Integer insertValue){
		if (root==null) 
			return root = new TreeNode(insertValue,0);
		else return root.insert(insertValue,0); //TODO remove

	}
	public List<Integer> getTeamList(){
		List<Integer> list = new ArrayList<>();
		root.getTeamIndexes(list);
		return list;
	}
	public Integer getNonAdjSum(){
		Pair pair = root.getSums();
		if(pair.getIncl()>pair.getExcl()){
			root.setInTeam(true);
			return pair.getIncl();
		} else {
			root.setInTeam(false);
			return pair.getExcl();
		}

	}
	public int getDepth(){
		return root.getDepth();	
	}
}
