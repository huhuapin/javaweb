import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String args[]) {
        Map<String,String> map = new HashMap<>();
        map.put("code","-1");
        map.put("message","参数无效");
        map.put("status","PARAM_ERR");
        JSONObject jsonObject =  JSONObject.fromObject(map);
        System.out.println(jsonObject);
    }
}
