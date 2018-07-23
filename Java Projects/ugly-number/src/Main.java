import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1352));
    }

    static int[] save = new int[3000];
    static int flag = 0;
    public static int nthUglyNumber(int n) {
        if(flag == 0){
            flag ++;
            init();
        }
        return save[n-1];
    }
    public static void init(){
        int _2 = 0, _3 = 0, _5 = 0;
        save[0] = 1;
        for(int i = 1; i < 3000; i++){
            int min = Math.min(save[_2]*2, Math.min(save[_3]*3,save[_5]*5));
            if(save[_2]*2 == min) {
                save[i] = save[_2]*2;
                _2 ++;
            }
            if(save[_3]*3 == min) {
                save[i] = save[_3]*3;
                _3 ++;
            }
            if(save[_5]*5 == min) {
                save[i] = save[_5]*5;
                _5 ++;
            }
        }
    }
}
