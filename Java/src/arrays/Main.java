//package arrays;
//
///**
// * @ Author: Xuelong Liao
// * @ Description:
// * @ Date: created in 15:00 2018/3/6
// * @ ModifiedBy:
// */
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//    /** 请完成下面这个函数，实现题目要求的功能 **/
//    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
//    public static void main(String[] args) {
//
//        List<Integer> order = new ArrayList<Integer>();
//        Map<String, List<Integer>> boms = new HashMap<String, List<Integer>>();
//
//        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
//
//        Integer n = Integer.parseInt(line.split(",")[0]);
//        Integer m = Integer.parseInt(line.split(",")[1]);
//
//        line = in.nextLine();
//        String[] itemCnt = line.split(",");
//        for(int i = 0; i < n ; i++){
//            order.add(Integer.parseInt(itemCnt[i]));
//        }
//
//        for(int i = 0; i < m; i++){
//            line = in.nextLine();
//            String[] bomInput = line.split(",");
//            List<Integer> bomDetail = new ArrayList<Integer>();
//
//            for(int j = 1; j <= n; j++ ){
//                bomDetail.add(Integer.parseInt(bomInput[j]));
//            }
//            boms.put(bomInput[0], bomDetail);
//        }
//        in.close();
//
//        Map<String, Integer> res = resolve(order, boms);
//
//        System.out.println("match result:");
//        for(String key : res.keySet()){
//            System.out.println(key+"*"+res.get(key));
//        }
//    }
//
//    // write your code here
//    public static Map<String, Integer> resolve(List<Integer> order, Map<String, List<Integer>> boms) {
////        Map<String, Integer> res = new HashMap<String, Integer>();
////        int bomsMin = 0, index = 0, count=0;
////        int n = order.size();
////        List<List<Integer>> list = new ArrayList<>();
////        for (String l : boms.keySet()) {
////            list.add(boms.get(l));
////        }
////        for (int i = 0; i < n; i++) {
////            bomsMin = Math.min(order.get(i), bomsMin);
////            index = i;
////        }
////        for (int i = 0; i < n; i++) {
////            for (int j = 0; j < boms.size(); j++) {
////                if (list.get(i).get(index) == 1) {
////                    while(bomsMin != 0){
////                        count++;
////                        bomsMin--;
////                    }
////                }
////            }
////        }
////        res.put(boms.get(),count);
//    }
//}