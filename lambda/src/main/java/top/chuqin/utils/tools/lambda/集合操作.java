package top.chuqin.utils.tools.lambda;

import com.google.common.collect.Lists;
import org.junit.Test;
import top.chuqin.utils.tools.lambda.domain.Artist;
import top.chuqin.utils.tools.lambda.domain.Human;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 集合操作 {
    @Test
    public void test(){
        Stream.of("1", "2").collect(toCollection(HashSet::new));


        List<Artist> artists = new ArrayList<>();

        //找到乐队
        Function<Artist, Integer> getCount = artist -> artist.count();
        artists.stream().collect(maxBy(comparing(getCount)));
    }

    @Test
    public void test1(){
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
        humans.sort(Comparator.comparing(Human::getAge).thenComparing(Human::getName));
        System.out.println(humans);
    }

    //找到年龄最大的human
    @Test
    public void test2(){
        List<Human> humans = Lists.newArrayList(new Human("Sarah", 10), new Human("Jack", 12));
        Human human = humans.stream().collect(maxBy(comparing(Human::getAge))).get();
        System.out.println(human);
    }

    //根据年龄分组
    @Test
    public void test3(){
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah1", 1),
                new Human("Sarah1-copy", 1),
                new Human("Sarah2", 2),
                new Human("Sarah3", 3),
                new Human("Sarah4", 4),
                new Human("Sarah5", 5));

        Map<Integer, List<Human>> humanMap = humans.stream().collect(groupingBy(human -> human.getAge()));
        System.out.println(humanMap);
    }

    //输出所有人的名字 [Sarah1, Sarah2, Sarah3, Sarah4, Sarah5]
    @Test
    public void test4(){
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah1", 1),
                new Human("Sarah2", 2),
                new Human("Sarah3", 3),
                new Human("Sarah4", 4),
                new Human("Sarah5", 5));

        String s = humans.stream().map(Human::getName).
                collect(Collectors.joining(", ", "[", "]"));
        System.out.println(s);
    }

    //同年龄的人的人数
    @Test
    public void test5(){
        List<Human> humans = Lists.newArrayList(
                new Human("Sarah1", 1),
                new Human("Sarah1-copy", 1),
                new Human("Sarah2", 2),
                new Human("Sarah3", 3),
                new Human("Sarah4", 4),
                new Human("Sarah5", 5));

        Map<Integer, Long> map = humans.stream().collect(groupingBy(Human::getAge, counting()));
        System.out.println(map);

    }
}
