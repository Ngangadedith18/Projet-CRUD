/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Dao.ConnexionBase;
import modele.dossier;
import modele.patient;

/**
 *
 * @author ideal
 */
public class test {
    public static void main (String []args){
       ConnexionBase cb=new ConnexionBase(); 
       cb.connection();
       
       dossier d=new dossier(002,"23/03/2024","Test sanguins","26/04/2024","negatif",208);
        Dossier_Actions da=new Dossier_Actions();
       da.Dossier_Add(d);
       
       patient p=new patient(1,"Darcie","Goma","10 ans","féminin","Pointe-Noire");
       Patient_Actions pa=new Patient_Actions();
       pa.Patient_Add(p);
    }
}
