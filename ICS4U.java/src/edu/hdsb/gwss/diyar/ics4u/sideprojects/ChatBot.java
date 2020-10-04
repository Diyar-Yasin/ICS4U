/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.diyar.ics4u.sideprojects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Diyar
 */
public class ChatBot extends JFrame {

    private JTextArea Chatarea = new JTextArea();
    private JTextField chatbox = new JTextField();
    private int heartLevel = 1; //5 levels, different dialogue options unlock each level up 1 -> 5
    private int diaProg = 0; //0 -> n parts of the dialogue within each heartLevel. 
    private String userName;
    private String favSeason;

    public ChatBot() {
        Frame FRM = new Frame();

        //Setup for the whole frame
        FRM.setDefaultCloseOperation(EXIT_ON_CLOSE);
        FRM.setVisible(true);
        FRM.setResizable(false);
        FRM.setLayout(null);
        FRM.setSize(700, 700);
        FRM.setTitle("ChatBot");
        FRM.add(Chatarea);
        FRM.add(chatbox);

        //For TEXTAREA
        Chatarea.setSize(400, 400);
        Chatarea.setLocation(2, 2);
        Chatarea.setEditable(false);

        //For TEXTFIELD
        chatbox.setSize(540, 30);
        chatbox.setLocation(2, 500);

        //BOT starts conversation
        chatbot("Heyyy :)\n\tHi\n\tHey\n\tHello");

        chatbox.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                String gtext = chatbox.getText();

                switch (heartLevel) {
                    case 1:
                        heartLevel1(gtext);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void heartLevel1(String gtext) { //A method that will contain all dialogue trees for heartLevel 1

        Chatarea.append("YOU ->" + gtext + "\n");
        chatbox.setText("");
        
        gtext = gtext.toLowerCase();
        //Setting it to lowercase after posting it ensures the user sees that they sent out Hi but the program still reads
        //the input as hi, in order to give the same response to Hi and hi

        switch (diaProg) {
            case 0:
                heartLevel1DiaProg0(gtext);
                break;
            case 1:
                Chatarea.setText(null);
                heartLevel1DiaProg1(gtext);
                break;
            case 2:
                Chatarea.setText(null);
                heartLevel1DiaProg2(gtext);
                break;
            case 3:
                Chatarea.setText(null);
                //heartLevel1DiaProg3(gtext);
                break;
            case 4:
                break;
            case 5:
                break;

        }
    }

    public void heartLevel1DiaProg0(String gtext) {

        //A large tree of possibilities needs to be implemented here
        if (gtext.contains("hi") || gtext.contains("hello") || gtext.contains("hey")) {

            chatbot("my name is Candyberry, whats your name?");
            diaProg++; //The correct reply was made and it is time to continue the conversation
            
        } else {
            int rand = (int) (Math.random() * 3 + 1);
            if (rand == 1) {
                chatbot("hey! say hi back :<");
            } else if (rand == 2) {
                chatbot("what?");
            } else {
                chatbot("0w0 ?");
            }
        }
    }
    
    public void heartLevel1DiaProg1(String gtext){
        
        userName = gtext;
        
        chatbot( userName + " huh? thats such a cool name!");
        chatbot("so.. " + userName + " hehe, whats your favorite season?\n\tSpring\n\tSummer\n\tFall\n\tWinter");
        diaProg++;
    }
    
    public void heartLevel1DiaProg2(String gtext){
        
        if (gtext.contains("spring")){
            chatbot("uh.. no. I get stuffy during the Spring, \nnot for me.");
            chatbot("..anyways... what do you even like to do during the Spring?\n\tPick flowers\n\tEaster egg hunt\n\tGardening");
        }
        else if (gtext.contains("summer")){
            chatbot("I can get behind that, but the heat can \njust be too much sometimes, you know?");
            chatbot("Got any fave activities to crush the Summer\n heat?\n\tGo to the beach\n\tEat popsicles\n\tTurn on the AC");
        }
        else if (gtext.contains("fall") || gtext.contains("autumn")){
            chatbot("omg! me too! I love Fall. \nThe colours and\n the pumpkins, we are so alike!");
            chatbot("So! What do you like to do during the Fall?\n\tForest strolls\n\tDrink cinammon lattes\n\tGo to pumpkin patch");
        }
        else if (gtext.contains("winter")){
            chatbot("Nice pick. Thats my second favourite season. \nThe first? Its a secret :P");
            chatbot("What are your Winter hobbies?\n\tSkiing\n\tBuilding snowmen\n\tSpending time with family");
        }
        else{
            chatbot("Be more specific? Im not a mind reader dummy!");
            //invalid response reloop
            diaProg--; //Cancels out the diaProg++ after this if else so that this dialogue set can be repeated
        }
        diaProg++; //Continues the convo after any of the 4 responses
        favSeason = gtext;
    }

    public void heartLevel1DiaProg3(String gtext, String favSeason){
        
        switch(favSeason){
            case "spring":
                break;
            case "summer":
                break;
            case "autumn":
            case "fall":
                break;
            case "winter":
                break;
        }

    }
    private void chatbot(String str) {
        Chatarea.append("Candyberry ->" + str + "\n");
    }

    public static void main(String[] args) {
        // TODO code application logic here
        new ChatBot();
    }

}
