/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author VESHEA GO
 */
public class Jawaban extends Inheritance{

    public Jawaban(String jawaban) {
        this.jawaban = jawaban;
    }
    
    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }
}