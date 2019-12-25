package com.luckyboy.sun.test;

import org.apache.commons.lang3.StringUtils;
/**
 * 测试两个list取差值
 * **/
public class OneTest {
    private Integer num;

    public OneTest() {
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "OneTest{" +
                "num=" + num +
                '}';
    }

    public static void main(String[] args) {
/*        List<OneTest> oneTests1 = new ArrayList<>();
        List<OneTest> oneTests2 = new ArrayList<>();

        OneTest oneTest1= new OneTest(1);
        OneTest oneTest2= new OneTest(2);
        OneTest oneTest3= new OneTest(3);
        OneTest oneTest4= new OneTest(4);
        OneTest oneTest5= new OneTest(9);
        OneTest oneTest12= new OneTest(12);OneTest oneTest13= new OneTest(13);
        oneTests1.add(oneTest1);oneTests1.add(oneTest2);oneTests1.add(oneTest3);oneTests1.add(oneTest4);oneTests1.add(oneTest5);
        oneTests1.add(oneTest12);oneTests1.add(oneTest13);

        OneTest oneTest11= new OneTest(1);
        OneTest oneTest6= new OneTest(2);
        OneTest oneTest7= new OneTest(3);
        OneTest oneTest8= new OneTest(4);
        oneTests2.add(oneTest11);oneTests2.add(oneTest6);oneTests2.add(oneTest7);oneTests2.add(oneTest8);

        List<OneTest> list = oneTests1.stream().filter(oneTest -> {
            boolean f = false;
            int count = 0;
            for(OneTest oneTest9 : oneTests2) {
                if(oneTest9.getNum().equals(oneTest.getNum())) {
                    break;
                }
                if(count == oneTests2.size() - 1) {
                    f = true;
                }
                count++;
            }
            return f;
        }).collect(Collectors.toList());

        System.out.println(list);

        //其实还有另一种简单的方法，使用strem直接搞就行
        List<OneTest> collect = oneTests1.stream().filter(oneTest ->
                !oneTests2.stream().map(OneTest::getNum).collect(Collectors.toList()).contains(oneTest.getNum())
        ).collect(Collectors.toList());

        System.out.println("====" + collect);*/

    }

    @org.junit.Test
    public void one () {
        String user_name = "爱华丢丢(10020)";
        String user_number = "";
        //处理公共参加码user_number替换为自己的customer_id
        if(user_name != null &&user_name.contains("(")&&user_name.contains(")")) {
            String temp = user_name.substring(user_name.indexOf("(")+1,user_name.indexOf(")"));
            if(StringUtils.isNumeric(temp)) {
                user_number = temp;
            }
        }
    }
}
