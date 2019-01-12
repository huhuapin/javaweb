package common;

import net.sf.json.JSONArray;

public class JSON {
    public static String[] toStringArray(String string) {
        JSONArray jsonArray = JSONArray.fromObject(string);
        String[] arr = new String[jsonArray.size()];
        for(int i=0;i<jsonArray.size();i++){
            arr[i]=jsonArray.getString(i);
        }
        return  arr;
    }
}
