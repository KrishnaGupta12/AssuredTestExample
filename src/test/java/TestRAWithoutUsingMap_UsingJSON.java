import org.json.simple.JSONObject;
import org.junit.Test;

public class TestRAWithoutUsingMap_UsingJSON {

    @Test
    public void test_Post()
    {
        JSONObject requuest= new JSONObject();
        requuest.put("name","Dhoni");
        requuest.put("job","Criketor");
        System.out.println(requuest);
        System.out.println(requuest.toJSONString());
    }
}
