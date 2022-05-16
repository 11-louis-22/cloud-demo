import java.util.*;

/**
 * @Author: Serendipity-li
 * @Date: 2022/5/12 - 05 - 12 - 21:14
 */
public class MapTest {

    public static void main(String[] args) {

      HashMap<String,Integer> hashMap = new HashMap<>();
      hashMap.put("中",12);
      hashMap.put("国",17);
      hashMap.put("你",56);
      hashMap.put("好",13);
      hashMap.put("呀",7);

     /* hashMap.entrySet().stream().forEach((e)->{

          System.out.println(e.getKey());
          System.out.println(e.getValue());
      });*/

        for (String key : hashMap.keySet()) {
            System.out.println(key);
            hashMap.get(key);
        }
    }
}
