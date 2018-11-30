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
        dialog.setLayout(new GridLayout(questionWithAnswer.getAnswerOptions().size() + 1, 1));
        ButtonGroup bgroup = new ButtonGroup();
        JLabel questionContent = new JLabel();
        questionContent.setText(questionWithAnswer.getQuestion());
        dialog.add(questionContent);

        for (String chosenAnswer : questionWithAnswer.getAnswerOptions()) {
            JRadioButton btn = new JRadioButton(chosenAnswer);
            bgroup.add(btn);
            dialog.add(btn);
        }

        int n = JOptionPane.showOptionDialog(
                null,
                dialog,
                "Selection",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                null
        );

        if (n == 0) {
            for (Enumeration<AbstractButton> buttons = bgroup.getElements(); buttons.hasMoreElements(); ) {
                AbstractButton button = buttons.nextElement();

                if (button.isSelected()) {
                    questionWithAnswer.setAnswer(button.getText());
                }
            }
        }
    }
}
