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
public class AplikasiJawaban {

    private DatabaseJawaban dbJ;

    public AplikasiJawaban() {
        dbJ = new DatabaseJawaban();
    }

    public ArrayList<Jawaban> getAllJawaban() { //MINDAHIN DATA DARI MYSQL KE LIST
        dbJ.connect();
        ArrayList<Jawaban> arrayJwb = new ArrayList<>();
        ResultSet rs = dbJ.getData("select * from kunjaw");
        try {
            while (rs.next()) {
                Jawaban j = new Jawaban(rs.getString("jawab"));
                arrayJwb.add(j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dbJ.disconnect();
        return arrayJwb;
    }
}
