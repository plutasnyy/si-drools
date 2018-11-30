package com.drools.si;

import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;

public class Dialog {

    public static void showResult(String result){
        JPanel dialog = new JPanel();
        dialog.setLayout(new GridLayout(1, 1));

        JLabel questionContent = new JLabel();
        questionContent.setText(result);
        dialog.add(questionContent);

        JOptionPane.showOptionDialog(
                null,
                dialog,
                "Result",
                JOptionPane.CLOSED_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );
    }

    public static void showDialogWithQuestion(QuestionWithAnswer questionWithAnswer) {
        JPanel dialog = new JPanel();
        dialog.setLayout(new GridLayout(questionWithAnswer.getAnswerOptions().size()+1, 1));
        ButtonGroup bGroup = new ButtonGroup();
        JLabel questionContent = new JLabel();
        questionContent.setText(questionWithAnswer.getQuestion());
        dialog.add(questionContent);

        for (String chosenAnswer : questionWithAnswer.getAnswerOptions()) {
            JRadioButton btn = new JRadioButton(chosenAnswer);
            bGroup.add(btn);
            dialog.add(btn);
        }

        Integer n = JOptionPane.showOptionDialog(
                null,
                dialog,
                "Selection Panel",
                JOptionPane.CLOSED_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );

        if (n.equals(0)) {
            for (Enumeration<AbstractButton> buttons = bGroup.getElements(); buttons.hasMoreElements(); ) {
                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {
                    questionWithAnswer.setAnswer(button.getText());
                }
            }
        }
    }
}
