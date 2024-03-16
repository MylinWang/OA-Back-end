import com.gelin.oa.utils.MybatisUtil;
import org.junit.Test;

public class test {
    @Test
    public void test(){
        String result=(String) MybatisUtil.executeQuery(sqlSession -> {
            String s = (String) sqlSession.selectOne("test.selectOne");
            return s;
        });
        System.out.println(result);
    }
}
