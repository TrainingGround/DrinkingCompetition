/**
 * Created by roma on 15.02.17.
 */
public class Pair {
    private Integer excl;
    private Integer incl;
    public Pair(Integer inclusive, Integer exclusive){
        excl = exclusive;
        incl = inclusive;
    }

    public void setExcl(Integer excl) {
        this.excl = excl;
    }

    public void setIncl(Integer incl) {
        this.incl = incl;
    }

    public Integer getExcl() {
        return excl;
    }

    public Integer getIncl() {
        return incl;
    }
}
