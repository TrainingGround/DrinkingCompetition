import org.junit.Test;
import java.util.Arrays;
import java.util.List;

public class DrinkingTest {
    // test arrays {1 1 1 1 1 1 1 1 1 1 1} {0 0 0 1 2 3 1 2 3}. Should be 0, 4 ,5 ,6 ,7 ,8, 9 with total of 7 DC
    @Test
    public void testHomogenArray(){
        Company comp = new Company(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                                    new Integer[]{0, 0 ,0, 1, 2, 3, 1, 2, 3,});
        comp.makeTree();
        // getBestValue() should always be run before get getTeam()
        assert(comp.getBestTeamValue()==7);
        List<Integer> shouldBe = Arrays.asList(0,4,5,6,7,8,9);
        assert(comp.getTeam().equals(shouldBe));
    }
    //test arrays {8,5,6,4,3,2,1,0,0,4,3} {0,0,1,1,1,2,6,6,8,8}
    @Test
    public void testComplexArray(){
        Company comp = new Company(new Integer[]{8,5,6,4,3,2,1,0,0,4,3},
                new Integer[]{0,0,1,1,1,2,6,6,8,8});
        comp.makeTree();
        // getBestValue() should always be run before get getTeam()
        assert(comp.getBestTeamValue()==25);
        List<Integer> shouldBe = Arrays.asList(0,3,4,5,6,9,10);
        assert(comp.getTeam().equals(shouldBe));
    }
}
