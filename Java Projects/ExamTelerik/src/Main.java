import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String title , sample;
        title = scan.nextLine();
        String temp=title;
        int N;
        boolean test = false;

        N=Integer.parseInt(scan.nextLine());
        for(int i=0; i<N;i++){
            sample = scan.nextLine();
            for(int j=0;j<temp.length();j++){
                for(int k=0;k<sample.length();k++){
                    if(title.charAt(j)==sample.charAt(k)){
                        test=true;
                        break;
                    }
                    test=false;
                }
            }
            if(test){
                for(int j=0;j<sample.length();j++){
                    title = temp;
                    temp="";
                    for(int k=0;k<title.length();k++){
                        if(title.charAt(k)!=sample.charAt(j)){
                            temp += title.charAt(k);
                        }
                        else{
                            for(int t=k+1;t<title.length();t++) {
                                temp += title.charAt(t);
                            }
                            break;
                        }
                    }
                }

                System.out.println(temp);

            }
            else{
                System.out.println("No such title found!");
            }
        }

    }
}
