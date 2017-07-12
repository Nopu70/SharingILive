package com.hehe.sharingilive.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表界面显示的临时数据
 * Created by tarena on 2017/7/12.
 */

public class DemoLiveList {
    static String[] names = {"马暄芳","成恒","李松潮","LPL","EDG-Scount","EDG-Mekio","韩振","金浩","EDG-Clearlove7","EDG-Koro1","EDG-Deft","EDG-Zet"};
    static String[] images = {"http://img.crawler.qq.com/lolwebvideo/20170620172437/bdf66f2cca5de2cc203fb02f06670d55/0",
            "http://img.crawler.qq.com/lolwebvideo/20170620172537/9fd211a5b9eac1c33ff741f31440be2c/0",
            "http://img.crawler.qq.com/lolwebvideo/20170620172507/a25e2484323f85b155e64ecb4cd363db/0",
            "http://img.crawler.qq.com/lolwebvideo/20170620172350/d4c56313793abdbe6e6641dfba901563/0",
            "http://img.crawler.qq.com/lolwebvideo/20170620172450/105da992ff9cfe09ce783fd19b35df0a/0",
            "http://shp.qpic.cn/lolwebvideo/201501/3708dedf16445ca17ee9ed0782e7841d/0",
            "http://img.crawler.qq.com/lolwebvideo/20170621092104/59e5deb3d4c65378444cf0cc7cf2698f/0",
            "http://img.crawler.qq.com/lolwebvideo/20170620172537/9fd211a5b9eac1c33ff741f31440be2c/0",
            "http://img.crawler.qq.com/lolwebvideo/20170620172350/d4c56313793abdbe6e6641dfba901563/0",
            "http://shp.qpic.cn/lolwebvideo/201501/3708dedf16445ca17ee9ed0782e7841d/0",
            "http://shp.qpic.cn/lolwebvideo/201501/3708dedf16445ca17ee9ed0782e7841d/0",
            "http://img.crawler.qq.com/lolwebvideo/20170621092104/59e5deb3d4c65378444cf0cc7cf2698f/0"
    };
    public static List<LiveList> getDemoLiveList(){
        List<LiveList> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            LiveList liveList = new LiveList();
            User user = new User();
            user.setUsername(names[i]);
            user.setHeaderImg(images[i]);
            liveList.setOpenLive(false);
            liveList.setUser(user);
            liveList.setRoomDescription("大家都来直播"+i+i);
            liveList.setRoomId("房间号:66666"+i);
            list.add(liveList);
        }
        return list;
    }
}
