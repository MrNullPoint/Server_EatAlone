package dto;

import basic.CommonFunction;
import basic.SplitString;
import db.Food;
import db.HibernateSessionFactory;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.hibernate.Session;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FoodVideo {

    /**
     * 默认返回最新美食视频相关信息
     * @return id 最大的美食视频相关信息
     */
    public JSONObject getFoodVideo() {

        Session session = HibernateSessionFactory.getSession();
        Food food = (Food) session.createQuery("from Food where id = (select max(id) from Food )").uniqueResult();
        session.close();

        JSONObject ret = new JSONObject();
        JSONArray dataJSONArray = new JSONArray();

        // 根据 food 是否为空返回不同的结果
        if(food == null) {

            ret.put("data",dataJSONArray);
            return ret;

        } else {

            JSONObject data = new JSONObject();

            // 将 step 和 content 从数据库中读出来并解析成 JSONArray
            SplitString splitString = new SplitString();

            splitString.splitStr(food.getContent());
            JSONArray contentJSONArray = splitString.getJsonArrayRet();

            splitString.splitStr(food.getStep());
            JSONArray stepJSONArray = splitString.getJsonArrayRet();

            // 构造返回的 JSONObject
            data.put("title",food.getTitle());
            data.put("url",food.getUrl());
            data.put("image",food.getImage());
            data.put("content",contentJSONArray);
            data.put("steps",stepJSONArray);
            dataJSONArray.add(data);

            ret.put("data",dataJSONArray);

            return ret;

        }

    }

    /**
     * 根据食材列表返回美食视频相关信息列表
     * @param valueList 食材列表
     * @return 包含食材列表中食材的美食视频相关信息列表
     */
    public JSONObject getFoodVideo(JSONArray valueList) {

        JSONObject ret = new JSONObject();
        JSONArray dataJSONArray = new JSONArray();

        Session session = HibernateSessionFactory.getSession();
        List<Food> foodList = session.createQuery("from Food ").list();
        session.close();

        if(valueList.size() > 0) {
            Set<String> valueSet = new HashSet<String>();
            for(Object value : valueList) {
                valueSet.add(value.toString());
            }

            SplitString splitString = new SplitString();

            for(Food food : foodList) {

                splitString.splitStr(food.getContent());

                Set<String> foodContent = splitString.getHashSetRet();
                JSONArray contentJSONArray = splitString.getJsonArrayRet();

                splitString.splitStr(food.getStep());
                JSONArray stepJSONArray = splitString.getJsonArrayRet();

                if(foodContent.containsAll(valueSet)) {

                    // 构造返回的 JSONObject
                    JSONObject data = new JSONObject();

                    data.put("title",food.getTitle());
                    data.put("url",food.getUrl());
                    data.put("image",food.getImage());
                    data.put("content",contentJSONArray);
                    data.put("steps",stepJSONArray);

                    dataJSONArray.add(data);

                }

            }
        }

        ret.put("data",dataJSONArray);

        return ret;
    }

}
