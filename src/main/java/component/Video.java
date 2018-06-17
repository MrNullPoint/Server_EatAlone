package component;

import dto.FoodVideo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.ws.rs.*;


@Path("/video")
public class Video {

    /**
     * 根据食材列表返回美食视频及相关信息
     * @param content 食材列表
     * @return 美食视频及相关信息
     */
    @GET
    public String getVideoDetail(
            @DefaultValue("None") @QueryParam("content") String content
    ) {

        System.out.println(content);

        FoodVideo food = new FoodVideo();

        JSONObject result = new JSONObject();

        // 如果没有 content 就返回最新的一个视频
        // 如果有 content 就返回符合 content 的视频列表
        if(content.equals("None")) {
            result = food.getFoodVideo();
        } else {
            JSONArray valueArray = JSONArray.fromObject(content);
            result = food.getFoodVideo(valueArray);
        }

        return result.toString();

    }

}
