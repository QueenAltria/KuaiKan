package com.jiang.kuaikan.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xutils.common.util.LogUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 * 查看网页源代码，对源代码进行解析
 */
public class JsoupImage{
    public static void getImage(){

        new Thread(new Runnable() {
            List<String> list=new ArrayList<>();
            @Override
            public void run() {
                try {
                    Document doc=Jsoup.connect("http://www.kuaikanmanhua.com/web/comic/11891").get();
                    String title = doc.title();
                    Element content = doc.getElementById("main");
                    Elements links = content.getElementsByTag("img");

                    for (Element link : links) {
                        String linkHref = link.attr("data-kksrc");
                        LogUtil.e(linkHref);
                        String linkText = link.text();
                        list.add(linkHref);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}
