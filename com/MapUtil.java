package com;

import java.util.*;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

import android.os.DropBoxManager;

public class MapUtil {

//    public static class ValueThenKeyComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
//        implements Comparator<Map.Entry<K, V>> {
//
//        public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
//            int cmp1 = a.getValue().size().compareTo(b.getValue().size());
//            if (cmp1 != 0) {
//                return cmp1;
//            } else {
//                return (-1)*a.getKey().compareTo(b.getKey());
//            }
//        }
//
////        Map<Integer, List<Integer>> sorted = map.entrySet().stream() // String, List<String> originally
////            .sorted(comparingInt(e -> e.getValue().size()).thenComparing(DropBoxManager.Entry::getKey))
////            .collect(toMap(
////                         Map.Entry::getKey,
////                         Map.Entry::getValue,
////                         (a, b) -> { throw new AssertionError(); },
////                         LinkedHashMap::new
////                         ));
//        // LinkedHashMap sortedByValueMap = map.entrySet().stream()
//        //     .sorted(comparing(Entry<Key,Value>::getValue).thenComparing(Entry::getKey))     //first sorting by Value, then sorting by Key(entries with same value)
//        //     .collect(LinkedHashMap::new,(map,entry) -> map.put(entry.getKey(),entry.getValue()),LinkedHashMap::putAll);
//
//        // Map<Integer, List<Integer>> sorted = res.entrySet().stream() // String, List<String> originally
//        //     // .sorted(comparingInt(e -> e.getValue().size()).thenComparing(Map.Entry::getKey))
//        //     .sorted(comparingInt(e -> e.getValue().size()))
//        //     .collect(LinkedHashMap::new, (map, entry) -> res.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);
//        // // .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> { throw new AssertionError(); }, LinkedHashMap::new));
//
//
////        public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
////            int cmp1 = a.getValue().compareTo(b.getValue());
////            if (cmp1 != 0) {
////                return cmp1;
////            } else {
////                return a.getKey().compareTo(b.getKey());
////            }
////        }
//
//    }
//
//    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean desc) {
//        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
//        if (!desc) {
//            // list.sort(Map.Entry.comparingByValue());
//            Collections.sort(list, new ValueThenKeyComparator<K, V>());
//        } else {
//            list.sort(Map.Entry.<K, V>comparingByValue().reversed());
//        }
//        Map<K, V> result = new LinkedHashMap<>();
//        for (Map.Entry<K, V> entry : list) {
//            result.put(entry.getKey(), entry.getValue());
//        }
//        return result;
//    }
}