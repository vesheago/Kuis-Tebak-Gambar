/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;

/**
 *
 * @author VESHEA GO
 */
public class ControllerHome implements ActionListener {

    private Home home; //VIEW

    public ControllerHome() {
        home = new Home();
        home.getBtnPlay().addActionListener(this);
        home.getBtnHighScore().addActionListener(this);
        home.getBtnExit().addActionListener(this);
        home.setLocationRelativeTo(null); //biar guinya ditengah
        home.setVisible(true); //munculin GUI
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(home.getBtnPlay())) {
            btnPlayActionPerformed();
        } else if (source.equals(home.getBtnHighScore())) {
            btnHighscoreActionPerformed();
        } else if (source.equals(home.getBtnExit())) {
               btnExitActionPerformed();
        }
    }

    private void btnPlayActionPerformed() {
        new ControllerPlay();
        home.setVisible(false); //hilangin GUI
    }

    private void btnHighscoreActionPerformed() {
        new ControllerHighscore();
        home.setVisible(false); //hilangin GUI
    }

    private void btnExitActionPerformed() {
        home.setVisible(false); //hilangin GUI
    }
}
