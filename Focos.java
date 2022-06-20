/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package malla;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JFrame;
/**
 *
 * @author josee
 */
public class Focos extends JFrame{
     private BufferedImage buffer;
    private Graphics graPixel;
    public Focos(){
        setTitle("Focos");
        setSize(750,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        graPixel = buffer.createGraphics();
        setVisible(true);
    }
    public static void main(String[] args){
        new Focos();
    }
    public void paint(Graphics g){
       palitopezuno();
       palitopezdos();
       palitopeztres();
    }
    public void putPixel(int x, int y, Color c){
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x,y,this);
    }
public void LineaBresehnham(int  x0, int y0, int x1, int y1, Color c){
        float steps;
        float dx= x1-x0;
        float dy=y1-y0;
        if(Math.abs(dx)>Math.abs(dy)){
            steps = Math.abs(dx);
        }else{
            steps = Math.abs(dy);
        }
        float xinc = dx/steps;
        float yinc = dy/steps;
        float x = x0;
        float y = y0;
        putPixel(Math.round(x),Math.round(y),c);
        for(int i=1; i<=steps; i++){
            x +=xinc;
            y +=yinc;
            putPixel(Math.round(x),Math.round(y),c);
        }
      }
    public void palitopezuno(){
        double xp=0, yp =0, zp = 100000;
          int puntos [][] = {{600,200,20},
            {700,200,20},
            {700,300,20},
            {600,300,20},
            {600,200,120},
            {700,200,120},
            {700,300,120},
            {600,300,120}};
        int p [][] = new int [8][4];
        for(int i=0; i<8; i++){
            p[i][0] = (int) (((zp * (double)puntos[i][0])- (xp * (double)puntos[i][2])) / (zp - (double)puntos[i][2]));
            p[i][1] = (int) (((zp * (double)puntos[i][1])- (yp * (double)puntos[i][2])) / (zp - (double)puntos[i][2]));
        }
        LineaBresehnham(p[0][0],p[0][1],p[1][0], p[1][1],  Color.black);
        LineaBresehnham(p[1][0],p[1][1],p[2][0], p[2][1],  Color.black);
        LineaBresehnham(p[2][0],p[2][1],p[3][0], p[3][1],  Color.black);
        LineaBresehnham(p[3][0],p[3][1],p[0][0], p[0][1],  Color.black);

        LineaBresehnham(p[0][0],p[0][1],p[4][0], p[4][1],  Color.black);
        LineaBresehnham(p[1][0],p[1][1],p[5][0], p[5][1],  Color.black);
        LineaBresehnham(p[3][0],p[3][1],p[7][0], p[7][1],  Color.black);
        LineaBresehnham(p[2][0],p[2][1],p[6][0], p[6][1],  Color.black);

        LineaBresehnham(p[4][0],p[4][1],p[5][0], p[5][1],  Color.black);
        LineaBresehnham(p[5][0],p[5][1],p[6][0], p[6][1],  Color.black);
        LineaBresehnham(p[6][0],p[6][1],p[7][0], p[7][1],  Color.black);
        LineaBresehnham(p[7][0],p[7][1],p[4][0], p[4][1],  Color.black);
    }
    public void palitopezdos(){
         double xp=0, yp =3000, zp = 1000000; 
        int puntos [][] ={{300,200,20},{400,200,20}, {400,300,20},{300,300,20},{300,300,120},{400,300,120},{400,400,120},{300,400,120}};
        int p [][] = new int [8][4];
        for(int i=0; i<8; i++){
            p[i][0] = (int) (((zp * (double)puntos[i][0])- (xp * (double)puntos[i][2])) / (zp - (double)puntos[i][2]));
            p[i][1] = (int) (((zp * (double)puntos[i][1])- (yp * (double)puntos[i][2])) / (zp - (double)puntos[i][2]));

            System.out.println("("+p[i][0]+ "," + p[i][1] + ")");
        }
        LineaBresehnham(p[0][0],p[0][1],p[1][0], p[1][1],  Color.black);
        LineaBresehnham(p[1][0],p[1][1],p[2][0], p[2][1],  Color.black);
        LineaBresehnham(p[2][0],p[2][1],p[3][0], p[3][1],  Color.black);
        LineaBresehnham(p[3][0],p[3][1],p[0][0], p[0][1],  Color.black);

        LineaBresehnham(p[0][0],p[0][1],p[4][0], p[4][1],  Color.black);
        LineaBresehnham(p[1][0],p[1][1],p[5][0], p[5][1],  Color.black);
        LineaBresehnham(p[3][0],p[3][1],p[7][0], p[7][1],  Color.black);
        LineaBresehnham(p[2][0],p[2][1],p[6][0], p[6][1],  Color.black);

        LineaBresehnham(p[4][0],p[4][1],p[5][0], p[5][1],  Color.black);
        LineaBresehnham(p[5][0],p[5][1],p[6][0], p[6][1],  Color.black);
        LineaBresehnham(p[6][0],p[6][1],p[7][0], p[7][1],  Color.black);
        LineaBresehnham(p[7][0],p[7][1],p[4][0], p[4][1],  Color.black);
    }
    public void palitopeztres(){
      double xp=1000000, yp =1000000, zp = 1000000; 
        int puntos [][] ={{200,400,20},
            {300,400,20},
            {300,300,20},
            {200,300,20},
            {200,400,120},
            {300,400,120},
            {300,300,120},
            {200,300,120}};
          
        int p [][] = new int [8][4];
        for(int i=0; i<8; i++){
            p[i][0] = (int) (((zp * (double)puntos[i][0])- (xp * (double)puntos[i][2])) / (zp - (double)puntos[i][2]));
            p[i][1] = (int) (((zp * (double)puntos[i][1])- (yp * (double)puntos[i][2])) / (zp - (double)puntos[i][2]));
        }
        LineaBresehnham(p[0][0],p[0][1],p[1][0], p[1][1],  Color.black);
        LineaBresehnham(p[1][0],p[1][1],p[2][0], p[2][1],  Color.black);
        LineaBresehnham(p[2][0],p[2][1],p[3][0], p[3][1],  Color.black);
        LineaBresehnham(p[3][0],p[3][1],p[0][0], p[0][1],  Color.black);

        LineaBresehnham(p[0][0],p[0][1],p[4][0], p[4][1],  Color.black);
        LineaBresehnham(p[1][0],p[1][1],p[5][0], p[5][1],  Color.black);
        LineaBresehnham(p[3][0],p[3][1],p[7][0], p[7][1],  Color.black);
        LineaBresehnham(p[2][0],p[2][1],p[6][0], p[6][1],  Color.black);

        LineaBresehnham(p[4][0],p[4][1],p[5][0], p[5][1],  Color.black);
        LineaBresehnham(p[5][0],p[5][1],p[6][0], p[6][1],  Color.black);
        LineaBresehnham(p[6][0],p[6][1],p[7][0], p[7][1],  Color.black);
        LineaBresehnham(p[7][0],p[7][1],p[4][0], p[4][1],  Color.black);;
    }
}
