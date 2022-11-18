import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());

        // 重複を数える用の変数
        int dup = 0;

        // 重複無し数列
        TreeSet<Integer> set = new TreeSet<>();

        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(sc.next());
            if(set.contains(a)) dup++;
            else set.add(a);
        }

        
    }

    public static int bisectRight(List<Integer> sortedList, int a){
        int left = 0;
        int right = sortedList.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (sortedList.get(mid) > a) right = mid;
            else left = mid + 1;
        }
        return right;
    }

    // もしかしたらエラーが出るかもしれない
    public static int bisectLeft(List<Integer> sortedList, int a){
        int left = 0;
        int right = sortedList.size();
        while (left < right){
            int mid = (left + right) / 2;
            if (sortedList.get(mid) >= a) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}