package org.example;
import java.util.*;

public class Main {
    public static int extract(String command){
        String[] combits = command.split("=");
        int delnum = Integer.parseInt(combits[1]);
        return delnum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 1;
        HashMap<String, String> words = new LinkedHashMap<>();
        String[] wises = new String[5];

        System.out.println("==명언 앱 ==");
        while (true){
            System.out.print("명령) ");
            String order = sc.nextLine();
            if (order.equals("등록")){
                System.out.print("명언 : ");
                String goodWord = sc.nextLine();
                System.out.print("작가 : ");
                String author = sc.nextLine();
                System.out.println(i+ "번 명언이 등록되었습니다.");
                wises[i-1]= goodWord;
                words.put(goodWord, author);
                i++;
            } else if (order.equals("목록")) {
                System.out.println("번호 / 작가 / 명언");
                System.out.println("--------------------");
                for (int j = wises.length-1; j>=0; j--){
                    if (wises[j]!= null){
                        String key = wises[j];
                        System.out.println(j+1 +" / " +  words.get(key) + " / " + key);
                    }
                }
            } else if (order.startsWith("삭제")) {


            } else if (order.startsWith("수정")) {
                int ordernum = extract(order);

                if(wises[ordernum-1]!=null){
                    System.out.println("명언(기존) : " + wises[ordernum-1]);
                    System.out.print("명언 : ");
                    String goodWord = sc.nextLine();
                    System.out.println("작가(기존) : " + words.get(wises[ordernum-1]));
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    wises[ordernum-1] = goodWord;
                    words.put(goodWord,author);
                }else {
                    System.out.println(ordernum + "번 명언은 존재하지 않습니다.");
                }
            }
            if (order.equals("종료")) {
                break;
            }
        }

    }
}
