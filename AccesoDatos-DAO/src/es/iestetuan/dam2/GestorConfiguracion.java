package es.iestetuan.dam2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import es.iestetuan.dam2.vo.InfoConfiguracion;

/**
 *  @descrition
 *	@author ineva
 *  @date 25 sept 2021
 *  @version 1.0
 *  @license GPLv3
 */

public class GestorConfiguracion {
	private static Properties configuracion;
//	private static InfoConfiguracion configuracionJSON;
//	private static InfoConfiguracion configuracionXML;

	public static Properties getConfiguracion() {
		if(configuracion==null) {
			configuracion= cargarConfiguracion();
		}
		return configuracion;	
	}

	private static Properties cargarConfiguracion() {
		Properties infoConfig = new Properties();
		
		try {
			infoConfig.load(new FileInputStream("config/dam2-aadd.properties"));
		} catch (FileNotFoundException fnfe ) { 
		  fnfe.printStackTrace();
		} catch (IOException ioe) { 
		  ioe.printStackTrace();
		}
		
		return infoConfig;
	}
	
	/*
	public static InfoConfiguracion getConfiguracionJSON() {
		if(configuracionJSON==null) {
			configuracionJSON= cargarConfiguracionJSON();
		}
		return configuracionJSON;	
	}
	
	public static InfoConfiguracion getConfiguracionXML() {
		if(configuracionXML==null) {
			configuracionXML= cargarConfiguracionXML();
		}
		return configuracionXML;
	}
	
	
	private static InfoConfiguracion cargarConfiguracionJSON() {
		InfoConfiguracion configuracion =null;
		Gson gson = new Gson();	
		File fichero = new File ("dam2-aadd.json");
		try {
			configuracion = gson.fromJson(new String(Files.readAllBytes(fichero.toPath())), InfoConfiguracion.class);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return configuracion;
	}
	
	private static InfoConfiguracion cargarConfiguracionXML() {
		InfoConfiguracion configuracion =null;
		Path ruta = null;
		XStream xstream = new XStream();
		try {
			//File ficheroXML = new File ("dam2-aadd.xml");
			ruta = Paths.get("dam2-aadd.xml");
	        String xmlConfiguracion= new String ( Files.readAllBytes(ruta) );
	        System.out.println(xmlConfiguracion);
			xstream.addPermission(AnyTypePermission.ANY);
			xstream.alias("configuracion", GestorConfiguracion.class);
	        configuracion = (InfoConfiguracion)xstream.fromXML(xmlConfiguracion);
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return configuracion;
	}	
	*/
	public static void main(String[] args) {
		// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
		//System.out.println("La carpeta de mi usuario es " + System.getProperty("user.home"));
		
		System.out.println(getConfiguracion());
		
		
	}
}


