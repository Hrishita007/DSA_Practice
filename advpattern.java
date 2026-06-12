public class advpattern {
    public static void main(String[] args) {
        int n=4;
        
        
        //pattern1
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     int s= 2*(n-i);
        //     for(int j=1;j<=s;j++){
        //         System.out.print("  ");
        //     }
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
        // for(int i=n;i>=1;i--){
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     int s= 2*(n-i);
        //     for(int j=1;j<=s;j++){
        //         System.out.print("  ");
        //     }
        //     for(int j=1;j<=i;j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

    //     //pattern2
    //     for(int i=1;i<=5;i++){
    //         int s=5-i;
    //         for(int j=1;j<=s;j++){
    //             System.out.print("  ");
    //         }
    //         for(int j=1;j<=5;j++){
    //             System.out.print("* ");
    //         }
    //         System.out.println();
            
    // }

    //pattern3
    // for(int i=1;i<=5;i++){
    //     for(int j=1;j<=5-i;j++){
    //         System.out.print(" ");
    //     }
    //     for(int j=1;j<=i;j++){
    //         System.out.print(i+" ");
    //     }
    //     System.out.println();
    // }

    //pattern4
    // for(int i=1;i<=5;i++){
    //     for(int j=1;j<=5-i;j++){
    //         System.out.print(" ");
    //     }
    //     for(int j=i;j>=1;j--){
    //         System.out.print(j);
    //     }
    //     for(int j=2;j<=i;j++){
    //         System.out.print(j);
    //     }
    //     System.out.println();
    // }

    //pattern5
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n-i;j++){
            System.out.print("  ");
        }
        for(int j=1;j<=2*i-1;j++){
            System.out.print("* ");
        }
        System.out.println();
    }
    for(int i=n;i>=1;i--){
        for(int j=1;j<=n-i;j++){
            System.out.print("  ");
        }
        for(int j=1;j<=2*i-1;j++){
            System.out.print("* ");
        }
        System.out.println();
    }

    
}
}
