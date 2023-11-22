package com.uetoop.main;
import java.util.Scanner;

class Tracnghiem extends DictionaryDatabase {
    public void game() {
        String user_ans;
        int score = 0;
        String[] q = new String[13];
        q[0] = "I am sorry that I can't ___ your invitation\n [A]. take  [B].except  [C].agree  [D].accept";
        q[1] = "It took us almost 4 hours to ___ to London\n [A].reach  [B].arrive  [C].get  [D].approach ";
        q[2] = "It’s difficult to ___ the difference between margarine and butter\n [A].speak  [B].tell  [C].say  [D].look";
        q[3] = "I have never seen such a beautiful dress ___ you before\n [A].of  [B].on  [C].for  [D].in ";
        q[4] = "After graduating from university, I want to ____ my father's footsteps\n [A].follow in  [B].succeed in  [C].go after  [D].keep up";
        q[5] = "The boy waved his hands to his mother, who was standing at the school gate, to ___ her attention\n [A].attract  [B].pull  [C].follow  [D].tempt";
        q[6] = "The making of good habits ___ a determination to keep on training your child \n [A].require  [B].requires  [C].requirement  [D].require";
        q[7] = "Each of us must take ___ for our own actions\n [A].probability  [B].ability  [C].possibility  [D].responsibility";
        q[8] = "John is ___ only child in his family so his parents love him a lot\n [A].a  [B].an  [C].the  [D].no article";
        q[9] = "Peter tried his best and passed his driving test at the first ___\n [A].try  [B].attempt  [C].doing  [D].aim";
        q[10] = "With greatly increased workloads, everyone is ___ pressure now\n [A].under  [B].above  [C].upon  [D].out of ";

        String ans[] = new String[13];
        ans[0] = "A";
        ans[1] = "C";
        ans[2] = "B";
        ans[3] = "B";
        ans[4] = "A";
        ans[5] = "A";
        ans[6] = "B";
        ans[7] = "D";
        ans[8] = "C";
        ans[9] = "B";
        ans[10] = "A";

        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to quiz \n");
        for(int i = 0; i <= 10; i++) {
            System.out.println(q[i]);
            user_ans = sc.nextLine();
            if(user_ans.equals(ans[i])){
                System.out.println("Correct!");
                score++;
                System.out.println("Your score is:" + score);
            } else {
                System.out.println("InCorrect!" + "  " + "Correct answer is:" + " " + ans[i]);
                System.out.println("Your score is: " + score);
            }
        }
    }
}