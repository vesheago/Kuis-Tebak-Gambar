/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author VESHEA GO
 */
public class AplikasiHighscore {

    private DatabaseHighscore dbH;

    public AplikasiHighscore() {
        dbH = new DatabaseHighscore();
    }

    public ArrayList<Highscore> getAllHighscore() { //MINDAHIN DATA DARI MYSQL KE LIST
        dbH.connect();
        ArrayList<Highscore> arrayHgs = new ArrayList<>();
        ResultSet rs = dbH.getData("SELECT * from highscore ORDER BY score DESC LIMIT 10");
        try {
            while (rs.next()) {
                Highscore s = new Highscore(rs.getString("nama"), rs.getInt("score"));
                arrayHgs.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbH.disconnect();
        return arrayHgs;
    }

    public boolean saveScore(Highscore h) { //MENYIMPAN DATA NAMA DAN SCORE
        dbH.connect();
        boolean berhasil = false;
        berhasil = dbH.eksekusiQuery("insert into highscore (nama, score) values ('"
                            + h.getNama() + "','"
                            + h.getScore() + "');");
        dbH.disconnect();
        return berhasil;
    }
}




















//    public boolean delScore(Highscore h){ //MENGHAPUS DATA NAMA DAN SCORE
//        dbH.connect();
//        boolean berhasil = false;
////        berhasil = dbH.eksekusiQuery("DELETE FROM highscore WHERE ((nama = '" 
////                + h.getNama() + "') and (score < "
////                +String.valueOf(h.getScore())+"));");
//        berhasil = dbH.eksekusiQuery("DELETE FROM highscore WHERE nama = '" + h.getNama() + "'");
//        if (berhasil){
//            for (Highscore hgs : highscore) {
//                if (hgs.getNama().equals(h.getNama())){
//                    highscore.remove(hgs);
//                    break;
//                }
//            }
//        }
//        dbH.disconnect();
//        return berhasil;
//    }
//    public void updateScore(Highscore h) {
//        dbH.connect();
//        String query = ("UPDATE highscore SET nama='" 
//                + h.getNama() + "', score=" 
//                + h.getScore() +" WHERE ((nama = '" 
//                + h.getNama() + "') and (score < "
//                + String.valueOf(h.getScore())+"));");
//        if (dbH.eksekusiQuery(query)){
//            for (Highscore hgs : highscore) {
//                if (hgs.getNama().equals(h.getNama())){
//                    hgs.setNama(h.getNama());
//                    hgs.setScore(h.getScore());
//                    break;
//                }
//            }
//        }
//        dbH.disconnect();
//    }