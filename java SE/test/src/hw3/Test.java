package hw3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<Integer,Student> studentMap = new HashMap<>();
        studentMap.put(1,new Student("熊大",18,99));
        studentMap.put(2,new Student("王二",19,98));
        studentMap.put(3,new Student("张三",20,97));
        studentMap.put(4,new Student("李四",21,96));
        studentMap.put(5,new Student("赵五",22,95));
        System.out.println("----------entrySet遍历----------");
        Set<Map.Entry<Integer, Student>> set = studentMap.entrySet();
        Iterator<Map.Entry<Integer, Student>> it = set.iterator();
        while (it.hasNext()){
            Map.Entry<Integer,Student> e = it.next();
            System.out.println(e.getKey()+"-->"+e.getValue());
        }
        System.out.println("----------Lambda遍历-------------");
        studentMap.forEach((k,v)->{ System.out.println(k+"==>"+v); });
    }
}
