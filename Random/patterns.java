
import java.util.*;
public class patterns {
    public static void main(String[] args) {
        int n=4;
        
        //pattern1
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //pattern2
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=m;j++){
        //         if(i==1 || i==n || j==1 || j==m){
        //             System.out.print("* ");
        //         }else{
        //             System.out.print("  ");
        //         }
        //     }
        //     System.out.println();
        // }

        //pattern3
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //pattern4
        // for(int i=n;i>=1;i--){
        //     for(int j=i;j>=1;j--){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //pattern5
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=n-i;j++){
        //         System.out.print("  ");
        //     }
        //     for(int k=1;k<=i;k++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        //pattern6
        // for(int i=1;i<=5;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }

        //pattern7
        // for(int i=5;i>=1;i--){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(j+" ");
        //     }
        //     System.out.println();
        // }

        //pattern8
        // for(int i=1;i<=5;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }

        //pattern9
        // int num=1;
        // for(int i=1;i<=5;i++){
        //     for(int j=0;j<i;j++){
        //         System.out.print(num+" ");
        //         num++;
        //     }
        //     System.out.println();
        // }

        //pattern10
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                if((i+j)%2==0)
                System.out.print("1 ");
                else
                System.out.print("0 ");
            }
            System.out.println();
        }

}
}
