package Visual;


import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

import Back.Sistema;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Duniel
 */
public class Util {
    public static void exportar(Sistema sistema, String dir) throws FileNotFoundException, IOException{
        dir += "Feria.dat";

        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(dir));

        salida.writeObject(sistema);

        salida.close();
    }

    public static Sistema exportar(String dir) throws ClassNotFoundException, IOException{
        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(dir));

        Sistema sistema = (Sistema)entrada.readObject();

        entrada.close();

        return sistema;
    }

    public static void launchFrame(javax.swing.JFrame frame, Frame caller) {
        //caller.setEnabled(false);
        frame.setLocation(innerPosition(caller, frame));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public static Point innerPosition(Component parent, Component child){
        Dimension pLoc = parent.getSize();
        Dimension chLoc = child.getSize();
        
        int x = (pLoc.width - chLoc.width)/2; 
        int y = (pLoc.height - chLoc.height)/2;
        
        return innerPosition(parent, x, y);
    }
    public static Point innerPosition(Component comp, int xplus, int yplus){
        Point pt = comp.getLocation();
        return new Point(pt.x + xplus, pt.y + yplus);
    }

//    public static void exportarCentro(Centro centro) throws FileNotFoundException, IOException{
//        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("C:/Data Proyecto/Centro.dat"));
//
//        salida.writeObject(centro);
//
//        salida.close();
//    }
//    public static void exportarCentro(Centro centro, String  dir) throws FileNotFoundException, IOException{
//        dir += ".dat";
//
//        ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(dir));
//
//        salida.writeObject(centro);
//
//        salida.close();
//    }

//    public static Centro importarCentro(String dir) throws FileNotFoundException, IOException, ClassNotFoundException{
//        ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(dir));
//
//        Centro centro = (Centro)entrada.readObject();
//
//        entrada.close();
//
//        return centro;
//    }
    
    public static boolean isNull(String a) {
        return a.isEmpty();
    }
    public static boolean areAllDigits(String str){
        if(str == null || str.equals(""))
            return false;
        for(int i=0; i < str.length(); i++)
            if( '9' < str.charAt(i) || str.charAt(i) < '0' )
                return false;
        return true;
    } 
    
    public static boolean isNonNegativeInteger(String str){
        try {
            int i = Integer.parseInt(str);
            return i >= 0;
        }
        catch(NumberFormatException nfe) {
            return false; 
        }        
    }
    
    public static boolean isNotValid(String a){
        try{
            LocalDate.parse(a);
            return false;
        }catch(Exception ex){
            return true;
        }
    }
    
//    public static String launchLoadOptions(Frame caller) {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setFileFilter(new CCFFileFilter());
//        fileChooser.approveSelection();
//        fileChooser.setDialogTitle("Seleccione el nombre del archivo");
//        
//        if( fileChooser.showDialog(caller, "Abrir") == JFileChooser.APPROVE_OPTION ){
//            return fileChooser.getSelectedFile().toString();
//        }
//        
//        return "";
//    }
}
