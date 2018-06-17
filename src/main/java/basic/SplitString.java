package basic;

import net.sf.json.JSONArray;

import java.util.HashSet;
import java.util.Set;

public class SplitString {

    private JSONArray jsonArrayRet = new JSONArray();
    private Set<String> hashSetRet = new HashSet<String>();

    public void splitStr(String str) {

        jsonArrayRet = new JSONArray();
        hashSetRet = new HashSet<String>();

        if(str != null) {
            String[] list = str.split(",");
            for(String s : list) {
                jsonArrayRet.add(s);
                hashSetRet.add(s);
            }
        }
    }

    public JSONArray getJsonArrayRet() {
        return jsonArrayRet;
    }

    public void setJsonArrayRet(JSONArray jsonArrayRet) {
        this.jsonArrayRet = jsonArrayRet;
    }

    public Set<String> getHashSetRet() {
        return hashSetRet;
    }

    public void setHashSetRet(Set<String> hashSetRet) {
        this.hashSetRet = hashSetRet;
    }


}
