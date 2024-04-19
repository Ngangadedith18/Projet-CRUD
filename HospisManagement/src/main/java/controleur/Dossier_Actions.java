/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controleur;

import Dao.ConnexionBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modele.dossier;

/**
 *
 * @author ideal
 */
public class Dossier_Actions {
    //methode Dossier_Add
    public void Dossier_Add(dossier d){
        //connexion à la base
        ConnexionBase cb=new ConnexionBase();
        cb.connection();
        //requete sql
        String rep="insert into dossier (Id, dateCreation, nature_Examen ,date_Examen ,Observations, codeP)values('"+d.getId()+"','"+d.getDateCreation()+"','"+d.getNature_Examen()+"','"+d.getDate_Examen()+"','"+d.getObservations()+"','"+d.getCodeP()+"')";
    
        try {
            //execution
            cb.st.executeUpdate(rep);
            JOptionPane.showMessageDialog(null, "Dossier ajouté avec succès");
        } catch (SQLException ex) {
            Logger.getLogger(Dossier_Actions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //methode Dossier_Update 
    
    public void Dossier_Update(dossier d){
       //connexion
        ConnexionBase cb=new ConnexionBase();
        cb.connection();
        
        //requete
        String rep="update dossier set Id='"+d.getId()+"',dateCreation='"+d.getDateCreation()+"',nature_Examen='"+d.getNature_Examen()+"',date_Examen='"+d.getDate_Examen()+"',Observations='"+d.getObservations()+"',codeP='"+d.getCodeP()+"'";
        
        try {
            cb.st.executeUpdate(rep);
        } catch (SQLException ex) {
            Logger.getLogger(Dossier_Actions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    //methode Dossier_Del
     public void Dossier_Del(int Id){
        ConnexionBase cb=new ConnexionBase();
        cb.connection();
        
        String rep="Delete from dossier where IdP='"+Id+"'";
    
        try {
            cb.st.executeUpdate(rep);
            JOptionPane.showMessageDialog(null,"Dossier supprimé avec succès");
            //methode Dossier_Find
            
            //methode Dossier_Liste
        } catch (SQLException ex) {
            Logger.getLogger(Dossier_Actions.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
    //methode Patient_Find
    public dossier Dossier_Find(int Id){
        dossier d=null;
        ConnexionBase cb=new ConnexionBase();
        cb.connection();
        
        String rep="Select * from dossier where Id='"+Id+"'";
        
        ResultSet rs;
        try { 
            rs=cb.st.executeQuery(rep);
           if (rs.next()){
            d.setId(rs.getInt("Id"));
            d.setDateCreation(rs.getString("dateCreation"));
            d.setNature_Examen(rs.getString("nature_Examen"));
            d.setDate_Examen(rs.getString("date_Examen"));
            d.setObservations(rs.getString("Observations"));
            d.setCodeP(rs.getInt("codeP"));
            } 
        } catch (SQLException ex) {
            Logger.getLogger(Dossier_Actions.class.getName()).log(Level.SEVERE, null, ex);
        }
      return d;  
    }  

    //methode Patient_Liste
    public ResultSet Dossier_Liste(){
        ResultSet rs=null;
       ConnexionBase cb=new ConnexionBase();
        cb.connection();
        
        String rep="Select * from dossier ";
        
        try {
            rs=cb.st.executeQuery(rep);
        } catch (SQLException ex) {
            Logger.getLogger(Dossier_Actions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
     
