package me.yangyong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Cross join implementation
 * 
 * @author yangyong
 * @since 2015-4-30 
 */
public class CrossJoin {

    /**
     * 产生笛卡尔积组合.
     * 
     * @param crossArgs 信息组合。
     * 
     *        <pre>
     * 格式：{
     *     { 1, 2, 3 },
     *     { a, b, c, d },
     *     { A, B, C },
     *     ...
     *  }
     * </pre>
     * @return 笛卡尔积组合结果
     */
    public static List<List<String>> cross(List<List<String>> crossArgs) {

        // 计算出笛卡尔积行数
        int rows = crossArgs.size() > 0 ? 1 : 0;

        for (List<String> data : crossArgs) {
            rows *= data.size();
        }

        // 笛卡尔积索引记录
        int[] record = new int[crossArgs.size()];

        List<List<String>> results = new ArrayList<List<String>>();

        // 产生笛卡尔积
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<String>();

            // 生成笛卡尔积的每组数据
            for (int index = 0; index < record.length; index++) {
                row.add(crossArgs.get(index).get(record[index]));
            }

            results.add(row);
            crossRecord(crossArgs, record, crossArgs.size() - 1);
        }

        return results;
    }

    // 保存笛卡尔结果集的全局变量
    public static List<List<String>> result = new ArrayList<List<String>>();

    // / <summary>
    // / 求集合的笛卡尔积递归算法
    // / </summary>
    // / <param name="temp">用于保存求得的某条笛卡尔记录的临时变量</param>
    // / <param name="words">包含要求笛卡尔积的集合数组</param>
    public static void cartesianProduct(List<String> temp, List<List<String>> words) {
        // 递归结束条件，当集合数组中只剩最后一个数组时，说明已经递归到最里层
        // 此时只需将该数组中的元素依次添加到temp中。
        if (words.size() == 1) {
            for (String item : words.get(0)) {
                List<String> t = new ArrayList<String>(temp);
                t.add(item);
                result.add(t);
            }
            return;
        }
        // 取出第一个数组中的元素和子集的笛卡尔积进行组合，就是所求笛卡尔积
        List<String> row = words.get(0);
        for (String item : row) {
            List<String> t = new ArrayList<String>(temp);
            List<List<String>> w = new ArrayList<List<String>>(words);
            w.remove(row);
            t.add(item);
            cartesianProduct(t, w);
        }
    }

    /**
     * 产生笛卡尔积当前行索引记录.
     * 
     * @param sourceArgs 要产生笛卡尔积的源数据
     * @param record 每行笛卡尔积的索引组合
     * @param level 索引组合的当前计算层级
     */
    private static void crossRecord(List<List<String>> sourceArgs, int[] record, int level) {
        record[level] = record[level] + 1;

        if (record[level] >= sourceArgs.get(level).size() && level > 0) {
            record[level] = 0;
            crossRecord(sourceArgs, record, level - 1);
        }
    }

    public static void main(String[] args) {
        final String[] arr1 = {
            "1",
            "2",
            "3"
        };
        final String[] arr2 = {
            "a",
            "b",
            "c",
            "d"
        };
        final String[] arr3 = {
            "A",
            "B",
            "C"
        };

        System.out.println(cross(new ArrayList<List<String>>() {

            private static final long serialVersionUID = 1L;

            {
                add(Arrays.asList(arr1));
                add(Arrays.asList(arr2));
                add(Arrays.asList(arr3));
            }
        }));

        cartesianProduct(new ArrayList<String>(), new ArrayList<List<String>>() {

            private static final long serialVersionUID = 1L;

            {
                add(Arrays.asList(arr1));
                add(Arrays.asList(arr2));
                add(Arrays.asList(arr3));
            }
        });

        System.out.println(result);
    }
}
