/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiHighscore;
import Model.Highscore;
import View.HighScore;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VESHEA GO
 */
public class ControllerHighscore implements ActionListener {

    private HighScore hgs; //VIEW
    private AplikasiHighscore aplikasi; //MODEL

    public ControllerHighscore(String nama, int score) {
        aplikasi = new AplikasiHighscore();
        hgs = new HighScore();
        Highscore h = new Highscore(nama, score);
        hgs.getBtnBack().addActionListener(this);
        hgs.setLocationRelativeTo(null);
        hgs.setVisible(true);
        ArrayList<Highscore> listhgs = aplikasi.getAllHighscore();
        boolean a =false;
        a = aplikasi.saveScore(h);
        loadTable();
    }

    public ControllerHighscore() {
        aplikasi = new AplikasiHighscore();
        hgs = new HighScore();
        hgs.getBtnBack().addActionListener(this);
        hgs.setLocationRelativeTo(null);
        hgs.setVisible(true);
        loadTable();
    }

    public void loadTable() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Nama", "Score"}, 0);
        ArrayList<Highscore> highscore = aplikasi.getAllHighscore();
        for (Highscore h : highscore) {
            model.addRow(new Object[]{h.getNama(), h.getScore()});
        }
        hgs.setTblScore(model);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(hgs.getBtnBack())) {
            btnBackActionPerformed();
        }      
    }

    private void btnBackActionPerformed() {
        hgs.setVisible(false);
        new ControllerHome();
    }
}