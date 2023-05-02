package com.example.javafxtest2;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ResourceBundle;

public class StoneGame implements Initializable {


    StringBuilder builder = new StringBuilder();
    int stoneCounter =25;
    int whileCounter=0;
    String[] players = {"A","B"};

    @FXML
    private Label welcomeText;

    @FXML
    private Label remainingStone;

    @FXML
    private Label stoneIllustrate;

    @FXML
    private Label whoTurn;
    @FXML
    private Label guidText;

    @FXML
    private ComboBox<Integer> degreeStoneComboBox;

    @FXML
    private Button okButton;



    @Override
    public void initialize(java.net.URL url, ResourceBundle resourceBundle) {
        remainingStone.setText("残り：" + stoneCounter + "個です。");
        stoneIllustPrint();
        int whoNum = judgeWhoTurn();
        whoTurnPrint(whoNum);
        degreeStoneComboBox.getSelectionModel().select(0);

    }

    public void update() {
        remainingStone.setText("残り：" + stoneCounter + "個です。");
        stoneIllustPrint();
        int whoNum = judgeWhoTurn();
        whoTurnPrint(whoNum);

    }

    public void degreeStoneCounter(){
        stoneCounter -= degreeStoneComboBox.getValue();
    }



    public void stoneIllustPrint(){
        StringBuilder nowStone =new StringBuilder() ;
        for (int i = 0; i < stoneCounter; i++) {
            nowStone.append("●");
        }
        String nowStoneToString = nowStone.toString();
        Platform.runLater(() -> stoneIllustrate.setText(nowStoneToString));
    }

    public int judgeWhoTurn(){
        if(whileCounter % 2 == 0){
            return 0;
        }else{
            return 1;
        }
    }

    public void whoTurnPrint(int whoNum){
        whoTurn.setText(players[whoNum]+"の番です！");

    }


    @FXML
    protected void onHelloButtonClick() {
        degreeStoneCounter();
        if(stoneCounter <= 0){
            stoneCounter = 0;
            whileCounter++;
            printWinner();
        }else{
            whileCounter ++;
            update();
        }

    }

    public void  printWinner(){
        remainingStone.setText("勝者は"+players[judgeWhoTurn()]+"です！　おめ！");
        guidText.setText("またね！");
        stoneIllustrate.setVisible(false);
        whoTurn.setVisible(false);
        okButton.setVisible(false);
        degreeStoneComboBox.setVisible(false);
    }



}