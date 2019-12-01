/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AplikasiHighscore;
import Model.AplikasiJawaban;
import Model.DatabaseJawaban;
import Model.Highscore;
import Model.Jawaban;
import View.Play;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author VESHEA GO
 */
public class ControllerPlay implements ActionListener {

    private byte kesempatan = 3;
    private byte posisi = 0;
    private int score = 0;
    private String nama = null;
    
    private Play play; //VIEW
    private AplikasiJawaban aplikasi; //MODEL
    private AplikasiHighscore aplikasihgs; //MODEL
    private DatabaseJawaban dbJ;

    public ControllerPlay() {
        aplikasi = new AplikasiJawaban();
        aplikasihgs = new AplikasiHighscore();
        dbJ = new DatabaseJawaban();
        play = new Play();
        play.getBtnCek().addActionListener(this);
        play.setLocationRelativeTo(null); //biar guinya ditengah
        play.setVisible(true); //munculin GUI
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source.equals(play.getBtnCek())) {
            btnCekActionPerformed();
        }
    }

    public void btnCekActionPerformed() {
        String jwb = play.getTxtJawaban();
        jwb.replace(" ", "_");
        ArrayList<Jawaban> listjwbn = aplikasi.getAllJawaban();
        if (jwb.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(play, "JAWABAN BELUM DIISI");
        } else {
            if (jwb.equalsIgnoreCase(listjwbn.get(0).getJawaban())) {
                JOptionPane.showMessageDialog(play, "HORE! JAWABAN ANDA BENAR");
                posisi++;
                score += 20;
                play.nextGambar(posisi);
                play.setLblScore(score);
                play.setTxtJawaban("");
            } else if (jwb.equalsIgnoreCase(listjwbn.get(1).getJawaban())) {
                JOptionPane.showMessageDialog(play, "HORE! JAWABAN ANDA BENAR");
                posisi++;
                score += 20;
                play.nextGambar(posisi);
                play.setLblScore(score);
                play.setTxtJawaban("");
            } else if (jwb.equalsIgnoreCase(listjwbn.get(2).getJawaban())) {
                JOptionPane.showMessageDialog(play, "HORE! JAWABAN ANDA BENAR");
                posisi++;
                score += 20;
                play.nextGambar(posisi);
                play.setLblScore(score);
                play.setTxtJawaban("");
            } else if (jwb.equalsIgnoreCase(listjwbn.get(3).getJawaban())) {
                JOptionPane.showMessageDialog(play, "HORE! JAWABAN ANDA BENAR");
                posisi++;
                score += 20;
                play.nextGambar(posisi);
                play.setLblScore(score);
                play.setTxtJawaban("");
            } else if (jwb.equalsIgnoreCase(listjwbn.get(4).getJawaban())) {
                JOptionPane.showMessageDialog(play, "HORE! JAWABAN ANDA BENAR");
                posisi++;
                score += 20;
                play.setLblScore(score);
                play.setTxtJawaban("");
            } else {
                JOptionPane.showMessageDialog(play, "MAAF, JAWABAN ANDA SALAH");
                kesempatan--;
                play.setLblKesempatan(kesempatan);
            }
        }
        if (kesempatan == 0) {
            JOptionPane.showMessageDialog(play, "KALAH");
            JOptionPane.showMessageDialog(play, "SKOR ANDA = " + score);
            nama = JOptionPane.showInputDialog("Nama Anda");
            new ControllerHighscore(nama,score);
            play.setVisible(false); //munculin GUI
        }
        if (score == 100) {
            JOptionPane.showMessageDialog(play, "SELAMAT ANDA MENANG");
            JOptionPane.showMessageDialog(play, "SCORE ANDA = " + score);
            nama = JOptionPane.showInputDialog("Nama Anda");
            new ControllerHighscore(nama,score);
            play.setVisible(false); //munculin GUI
        }
    }
}
