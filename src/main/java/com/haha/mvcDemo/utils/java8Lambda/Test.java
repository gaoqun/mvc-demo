package com.haha.mvcDemo.utils.java8Lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Test {


    /**
     * *************stream java8操作集合的一种方式并发用parallelStream不支持线程安全
     */
    private static String[] arrays = {"java1", "javb", "c++", "c#", "php", "js", "python"};
    private static Integer[] arrays1 = {1, 2, 25, 22, 33, 123, 456};

    private static List<TestUser> testUsers = new ArrayList<>();

    static {

        List<String> tags1 = new ArrayList<>();
        tags1.add("tag1");
        tags1.add("tag2");
        tags1.add("tag3");

        List<String> tags2 = new ArrayList<>();
        tags1.add("tag1");
        tags1.add("tag2");
        tags1.add("tag4");

        TestUser testUser = new TestUser("张三1", "123", "1");
        testUser.setTags(tags1);
        TestUser testUser1 = new TestUser("张三2", "1231", "1");
        testUser1.setTags(tags2);
        TestUser testUser2 = new TestUser("张三1", "123", "1");
        testUser2.setTags(tags1);
        TestUser testUser3 = new TestUser("张三1", "123", "1");
        testUser3.setTags(tags2);
        TestUser testUser4 = new TestUser("张三2", "123", "1");
        testUser4.setTags(tags1);
        testUsers.add(testUser);
        testUsers.add(testUser1);
        testUsers.add(testUser2);
        testUsers.add(testUser3);
        testUsers.add(testUser4);

    }

    public static void main(String[] args) {

//        Arrays.stream(arrays).forEach(System.out::println);
//        if (!getStr().isPresent()){
//            System.out.println(" is null");
//        }else
//        System.out.println(getStr());

//        System.out.println(getMyList().size());
//        System.out.println(putUsersByUsername().size());
//        System.out.println(getTestUserByUsername().size());
//        System.out.println(sum());
//        System.out.println(sum1());
//        System.out.println(max());
//
//        Arrays.asList(arrays).forEach(System.out::println);
//        Arrays.stream(arrays).forEach(System.out::println);
//        Arrays.stream(arrays).forEach(s -> {
//            s = s+",";
//            System.out.println(s);
//        });
//
//        Arrays.stream(arrays1).sorted((i,j)->j.compareTo(i)).forEach(System.out::println);//从大到小
//        Arrays.stream(arrays1).sorted().forEach(System.out::println);//默认排序从小到大


//        IntStream.range(0, 10).forEach(System.out::println);//遍历10次

        //并发执行,非线程安全
        IntStream.range(0, 100).parallel().forEach(System.out::println);
//        Lock lock = new ReentrantLock();
//        IntStream.range(0, 100).forEach(s -> {
//            lock.lock();
//            try {
//                System.out.println(s);
//            } finally {
//                lock.unlock();
//            }
//        });
    }

    public static void print() {
        Arrays.stream(arrays).forEach(System.out::println);
    }

    /**
     * 判断optional is null  isPresent true 存在值 否则就是不存在该值
     *
     * @return
     */
    public static Optional<String> getStr() {
        return Arrays.stream(arrays).filter(s -> s.contains("java")).findFirst();
    }


    /**
     * 筛选出符合条件的集合数据
     *
     * @return
     */
    public static List<String> getMyList() {
        return Arrays.asList(arrays).stream().filter(s -> s.contains("java")).collect(toList());
    }


    /**
     * 通过用户名字分类
     *
     * @return
     */
    public static Map<String, List<TestUser>> putUsersByUsername() {
        return testUsers.stream().collect(Collectors.groupingBy(TestUser::getUsername));
    }

    /**
     * 将流转换成另一种流
     *
     * @return
     */
    public static Set<String> getTestUserByUsername() {
        return testUsers.stream()
                .flatMap(testUser -> testUser.getTags().stream())
                .collect(Collectors.toSet());
    }

    /**
     * 去重
     */
    public static List<String> distinct() {
        return Arrays.stream(arrays).distinct().collect(toList());
    }

    /**
     * 截取前几个元素
     */
    public static List<String> limit() {
        return Arrays.stream(arrays).limit(3).collect(toList());
    }

    /**
     * 跳过
     */
    public static List<String> skip() {
        return Arrays.stream(arrays).skip(2).collect(toList());
    }


    /**
     * 映射  流中的每个元素都执行这个map中函数 将执行结果输送到一个新的流中
     */
    public static List<String> map() {
        return Arrays.stream(arrays).map(s -> s = s + "..").collect(toList());
    }

    /**
     * 合并流
     */
    public static List<String> flatMap() {
        return Arrays.stream(arrays)
                .map(s -> s.split("a"))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
    }

    /**
     * 判断流中至少有一个元素满足条件
     */
    public static boolean matchAny() {
        return Arrays.stream(arrays).anyMatch(s -> s.equals("java1"));
//        return Arrays.stream(arrays).allMatch(s -> s.equals("java1"));//所有的元素都是Java1
//        return Arrays.stream(arrays).noneMatch(s -> s.equals("java1"));//没有元素是Java1
    }

    /**
     * 返回Optional,这个元素中只能存在一个或者另个元素 get()元素如果为空的话则抛出异常NoSuchElement
     */
    public static Optional<String> findAny() {
        return Arrays.stream(arrays).findAny();
    }

    /**
     * findFirst
     *
     * @return
     */
    public static Optional<String> findFirst() {
        return Arrays.stream(arrays).findFirst();
    }

    /*********************归约  将集合中的元素折叠中一个元素输出   一般求最值、平均值、和之类的，在流中reduce实现归约，俩参数（初始值，lambda表达式）
     * *******************************/

    /**
     * 求和
     */
    public static int sum() {
//        return Arrays.stream(arrays).reduce("0",(user1,user2)-> String.valueOf(user1.length()+user2.length()));
        return Arrays.stream(arrays1).reduce(0, Integer::sum);
    }

    /**
     * 数值流，例如In天Stream、Double、   ：：：：：：禁用低效率的拆箱和装箱  基础数据类型和其引用类型
     */
    //新流中的求和
    public static int sum1() {
        return Arrays.stream(arrays).mapToInt(i -> i.length()).reduce(0, (user1, user2) -> user1 + user2);
//        return Arrays.stream(arrays).mapToInt(i->i.length()).reduce(0,Integer::sum);
    }

    //最大值
    public static int max() {
        return Arrays.stream(arrays).mapToInt(i -> i.length()).max().getAsInt();
    }


}
