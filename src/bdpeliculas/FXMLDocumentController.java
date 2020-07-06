/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdpeliculas;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author grave
 */
public class FXMLDocumentController implements Initializable {
    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private TextField fieldNombre;

    @FXML
    private TextField fieldDirector;

    @FXML
    private TextField fieldMusica;

    @FXML
    private TextField fieldPais;

    @FXML
    private TextField fieldYear;

    @FXML
    private TextField fieldDuracion;

    @FXML
    private TextField fieldGenero;
    
    //instancia de clase 
    BdConnect bd = new BdConnect();
    Connection tipocon = bd.conexion();
    
    PreparedStatement preparar;
    String pNombre;
    String pDirector;
    String pMusica;
    String pPais;
    String pAnnio;
    String pDuracion;
    String pGenero;
    
    String sql;
    
    @FXML
    private void handleAlta(ActionEvent event) throws SQLException {
        pNombre = fieldNombre.getText();
        pDirector = fieldDirector.getText();
        pMusica = fieldMusica.getText();
        pPais = fieldPais.getText();
        pAnnio = fieldYear.getText();
        pDuracion = fieldDuracion.getText();
        pGenero = fieldGenero.getText();
        
        
        String campos = "(pNombre, pDirector, pMusica, pPais, pAno, pDuracion, pGenero)";
        sql = "INSERT INTO movies" + campos + "VALUES(?,?,?,?,?,?,?)";
        
        try{
            //prepare the statement for conexion method in BdConnect class
            preparar = tipocon.prepareStatement(sql);
            preparar.setString(1, pNombre);     //adding all the fields to the statement
            preparar.setString(2, pDirector);
            preparar.setString(3, pMusica);
            preparar.setString(4, pPais);
            preparar.setString(5, pAnnio);
            preparar.setString(6, pDuracion);
            preparar.setString(7, pGenero);
                
            //execute statement
            preparar.executeUpdate();
            System.out.println("Succes");
            //eliminate info from fields
            fieldNombre.setText("");
            fieldDirector.setText("");
            fieldMusica.setText("");
            fieldPais.setText("");
            fieldYear.setText("");
            fieldDuracion.setText("");
            fieldGenero.setText("");
        }catch (SQLException ex){
            //error in sending the fields.
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al enviar los datos");
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
