/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actividad_01_UD3_ED;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Juan María Mateos Ponce
 */
public class Actividad_01_UD3_ED 
{
    private static byte[] bufer = new byte[1000];
    private static String nombreArchivo = "fichero.dat";
    private static FileInputStream flujoEntrada = null;
    private static BufferedInputStream buferEntrada = null;

    /**
     *
     * @throws FileNotFoundException 
     */
    public static void inicializarArchivos() throws FileNotFoundException
    {
        setFlujoEntrada(new FileInputStream(getNombreArchivo()));
        setBuferEntrada(new BufferedInputStream(getFlujoEntrada()));
    }
    
    /**
     *
     * @return devuelve el total
     * @throws IOException
     */
    public static int mostrarArchivoDeTexto() throws IOException
    {
        int total = 0;
        int nRead = 0;
        while((nRead = getFlujoEntrada().read(getBufer())) != -1) 
        {
            System.out.println(new String(getBufer()));
            total += nRead;
        }
        
        return total;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        try 
        {
            inicializarArchivos();
            
            int total = mostrarArchivoDeTexto();           

            System.out.println("\nLeídos " + total + " bytes");
        }
        catch(IOException ex) 
        {
            System.out.println("Error -> " + ex.toString());                
        }
        finally 
        {
            try 
            {
                if( getBuferEntrada() != null && getFlujoEntrada() != null )
                {
                    getFlujoEntrada().close();
                    getBuferEntrada().close();
                }                
            } 
            catch (IOException ex) 
            {
                System.out.println("Error al cerrar el fichero -> " + ex.toString());
            }
        }
    }

    /**
     * @return Devuelve el bufer
     */
    public static byte[] getBufer() {
        return bufer;
    }

    /**
     * @param aBufer es el bufer a iniciar
     */
    public static void setBufer(byte[] aBufer) {
        bufer = aBufer;
    }

    /**
     * @return Devuelve el nombre del archivo
     */
    public static String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param aNombreArchivo Es el nombre del archivo a iniciar
     */
    public static void setNombreArchivo(String aNombreArchivo) {
        nombreArchivo = aNombreArchivo;
    }

    /**
     * @return Devuelve el flujoEntrada
     */
    public static FileInputStream getFlujoEntrada() {
        return flujoEntrada;
    }

    /**
     * @param aFlujoEntrada Es el flujoEntrada a iniciar
     */
    public static void setFlujoEntrada(FileInputStream aFlujoEntrada) {
        flujoEntrada = aFlujoEntrada;
    }

    /**
     * @return Devuelve buferEntrada
     */
    public static BufferedInputStream getBuferEntrada() {
        return buferEntrada;
    }

    /**
     * @param aBuferEntrada Es el buferEntrada a iniciar
     */
    public static void setBuferEntrada(BufferedInputStream aBuferEntrada) {
        buferEntrada = aBuferEntrada;
    }
    
}
