package com.zzq.util;

import com.zzq.config.IndexSch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.*;

/**
 * @author maxwell
 * @Description: TODO
 * @date 2020/1/9 15:19
 */
@Configuration
public class PageStatic {

    @Autowired
    private IndexSch indexSch;

    public void staticMethod(){
        RestTemplate template = new RestTemplate();

        ArrayList<Map<String,String>> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Map<String,String> map = new HashMap<>();
            map.put("这是标题+>"+i, System.currentTimeMillis()+"<>");

            list.add(map);

            ResponseEntity<String> entity = template.getForEntity("http://localhost:8089/getDetile?title=" + map.keySet().iterator().next() + "&content=" + map.get(map.keySet().iterator().next()), String.class);

            URL url = PageStatic.class.getResource("/");
            String p1 = url.getFile();

            String path = p1+"/static/"+getTimeF()+indexSch.index.getAndIncrement()+".html";

            File f = new File(path);
            if(!f.getParentFile().exists()){
                f.getParentFile().mkdirs();
            }

            System.out.println(path);

            try{
                FileOutputStream stream = new FileOutputStream(f);
                stream.write(entity.getBody().getBytes("UTF-8"));
                stream.flush();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public String getTimeF(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        return calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+"/";
    }

}
