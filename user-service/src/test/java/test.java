import org.springframework.boot.ansi.AnsiOutput;

/**
 * @Author: Serendipity-li
 * @Date: 2022/5/13 - 05 - 13 - 23:56
 */
public class test {

    public static boolean fun(String userid){
        String s = userid.toLowerCase();

        String s1 = "no";
        String s2 = "no";
        System.out.println(s1==s2);
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println("-----------------------------------------");

        System.out.println(System.identityHashCode(s));
        System.out.println(System.identityHashCode("zzt"));
        return s == "zzt";
    }

    public static void main(String[] args) {

        System.out.println(fun("ZZT"));

    }
}
