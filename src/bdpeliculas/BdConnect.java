/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdpeliculas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author grave
 */
public class BdConnect extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        conexion();
    }
    
    Connection connect = null;
    
    public Connection conexion(){
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost/peliculas", "root", "");
            System.out.println("Conexion Succesful");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("No se pudo hacer la conexion");
        }
        return connect;
    }
}
