package es.iestetuan.dam2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

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
	private static JsonObject configuracionJSON;
//	private static InfoConfiguracion configuracionXML;

	public static String getInfoAtributoConfiguracion(String atributoConfiguracion) {
		return getConfiguracion().getProperty(atributoConfiguracion);	
	}

	public static JsonElement getInfoAtributoConfiguracionJSON(String atributoConfiguracion) {
		return getConfiguracionJSON().get(atributoConfiguracion);	
	}

	private static Properties getConfiguracion() {
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
	
	private static JsonObject getConfiguracionJSON() {
		if(configuracionJSON==null) {
			configuracionJSON= cargarConfiguracionJSON();
		}
		return configuracionJSON;	
	}
	
	private static JsonObject cargarConfiguracionJSON() {
		File fichero = new File ("config/dam2-aadd.json");
		String jsonString= null;
		JsonObject jsonObject =null;
		try {
			jsonString= new String(Files.readAllBytes(fichero.toPath()));
			//jsonString is of type java.lang.String
			 jsonObject = JsonParser.parseString(jsonString).getAsJsonObject();
/*
			//reader is of type java.io.Reader
			JsonObject jsonObject = JsonParser.parseReader​(reader).getAsJsonObject();

			//jsonReader is of type com.google.gson.stream.JsonReader
			JsonObject jsonObject = JsonParser.parseReader​(jsonReader).getAsJsonObject();
			*/
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	/*	
	public static InfoConfiguracion getConfiguracionXML() {
		if(configuracionXML==null) {
			configuracionXML= cargarConfiguracionXML();
		}
		return configuracionXML;
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
		// Acceso a informacion del sistema
		// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
		System.out.println("La carpeta de mi usuario es " + System.getProperty("user.home"));
		
		// Acceso a información de un fichero de configuración: Devuelve Properties
		System.out.println(getInfoAtributoConfiguracion("usuariodaoimp"));

		// Acceso a información de un fichero de configuración de tipo JSON
		JsonElement sValorAtributo=getInfoAtributoConfiguracionJSON("servidor");
		System.out.println(sValorAtributo);
		
		sValorAtributo=getInfoAtributoConfiguracionJSON("infodaousuario");
		JsonArray arrayAtributo = (JsonArray)getInfoAtributoConfiguracionJSON("infodaousuario");
		JsonElement jsonObject = arrayAtributo.get(0);
		String  atributo= jsonObject.getAsJsonObject().get("usuariodaoimp").getAsString();
		System.out.println(atributo);
		
		sValorAtributo=getInfoAtributoConfiguracionJSON("infodaousuario.usuariodaoimp");
		System.out.println(sValorAtributo);

	}
}


