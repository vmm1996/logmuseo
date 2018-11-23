package menu;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Insertar {
	
	static Scanner teclado=new Scanner(System.in);

	//metodo para introducir los datos de los alumnos
	static ArrayList<Alumno> meter(ArrayList<Alumno> alumnos){
		
		boolean salir=true;
		
		int opcion;
		String Id,Nombre,Apellidos,Altura,Curso,Mayor;
		int Edad=0;
		
		
		do {
			
			System.out.println("Introduce el DNI del alumno");
			Id=teclado.next();
			System.out.println("Introduce el Nombre del alumno");
			Nombre=teclado.next();
			Nombre = capitalizar(Nombre);
			System.out.println("Introduce el Apellido del alumno");
			teclado.nextLine();
			Apellidos=teclado.nextLine();
			Apellidos= capitalizar(Apellidos);
			System.out.println("Introduce el Altura del alumno");
			Altura=teclado.next();
			System.out.println("Introduce el Curso del alumno");
			Curso=teclado.next();
			System.out.println("Introduce el Edad del alumno");
			Edad=teclado.nextInt();
			
			Curso=verificarcurso(Edad,Curso);
			Curso=capitalizar(Curso);
			if(Edad>18) {
				Mayor="Es mayor de edad";
			}
			else {
				Mayor="Es menor de edad";
			}
			
			alumnos.add(new Alumno(Id,Nombre,Apellidos,Edad,Altura,Curso,Mayor));
			
			
			System.out.println("Desea introducir mas alumnos pulse 1 para cuntinuar 2 para salir");
			opcion=teclado.nextInt();
			
			switch(opcion) {
			case 1:
				salir=true;
				break;
			case 2:
				salir=false;
				break;
			}	
		}while(salir!=false);
		return alumnos;	
	}
	//metodo para capitalizar la primera letra del metodo "meter"
	public static String capitalizar (String word){
		 
		String[] words = word.split(" ");
        StringBuilder sb = new StringBuilder();
        if (words[0].length() > 0) {
            sb.append(Character.toUpperCase(words[0].charAt(0)) + words[0].subSequence(1, words[0].length()).toString().toLowerCase());
            for (int i = 1; i < words.length; i++) {
                sb.append(" ");
                if (words[i].length() > 0) sb.append(Character.toUpperCase(words[i].charAt(0)) + words[i].subSequence(1, words[i].length()).toString().toLowerCase());
            }
        }
        return  sb.toString();
	}
	
	//metodo para comprobar si por su edad puede estar en ese curso 
	static String verificarcurso(int edad,String c) {
		switch(edad) {
		case 12:
			while(!c.equalsIgnoreCase("primero")) {
				c=datos(c);
			}
			break;
		case 13:
			while(!c.equalsIgnoreCase("segundo")) {
				c=datos(c);
			}
			break;
		case 14:
			while(!c.equalsIgnoreCase("tercero")) {
				c=datos(c);
			}
			break;
		case 15:
			while(!c.equalsIgnoreCase("cuarto")) {
				c=datos(c);
			}
			break;
		case 16:
			while(!c.equalsIgnoreCase("bachillerato")) {
				c=datos(c);
			}
			break;
		case 17:
			while(!c.equalsIgnoreCase("bachillerato")) {
				c=datos(c);	
			}
			break;
		case 18:
			while(!c.equalsIgnoreCase("bachillerato")) {
				c=datos(c);	
			}
			break;
		}
		return c;
	}
	//Para a�adir el curso si no es el correcto se llama de 
	static String datos(String c) {
		System.out.println("La edad no se corresponde con el curso");
		System.out.println("Por favor, introduzca curso de nuevo:");	
		c = teclado.next();
		c=capitalizar(c);
		return c;
	}
	
	//metodo para leer los alumnos del arrays
	static void leeralumnos(ArrayList<Alumno> alumnos) {
		System.out.println("... Alumnos ingresados ...");
		Iterator<Alumno> itr = alumnos.iterator();
		while(itr.hasNext()){
			Alumno alum = itr.next();
			System.out.println(alum.getId()+ ".-> "+ alum.getNombre()
			+".-> "+ alum.getApellido()+".-> "+ alum.getEdad()+".-> "+ alum.getAltura()+
			".-> "+ alum.getCurso()+ ".->" + alum.getMayor());
			
		}
	}
	
	//metodo para introducir los alumnos del arrays en un archivo ".txt"
	static void archivotxt(ArrayList<Alumno> alumnos) {
		String separador="... Alumnos ingresados ..."+System.getProperty("line.separator");
		Iterator<Alumno> itr = alumnos.iterator();
		while(itr.hasNext()){
			Alumno alum = itr.next();
			separador +=alum.getId() + ".-> "+ alum.getNombre()
			+".-> "+ alum.getApellido()+".-> "+ alum.getEdad()+".-> "+ alum.getAltura()+
			".-> "+ alum.getCurso()+System.getProperty("line.separator");
		}
		separador +="\n---------------------------------------------";
		try {
			FileWriter fWriter = new FileWriter(new File("Alumno.txt"), true);
			fWriter.write(separador);
			fWriter.flush();
			fWriter.close();
			System.out.println("\nLos datos se han guardado correctamente en el fichero: Alumno.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	//metodo para borar los alumnos del array 
	static void borrar(ArrayList<Alumno> alumnos) {
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("... Borrando alumno segun id ...");
		Iterator<Alumno> itr = alumnos.iterator();
		System.out.println("Introduzca el id del alumno que desea borrar:");
		String i = s.nextLine();
		while(itr.hasNext()){
			Alumno alumno = itr.next();
			if (i.equalsIgnoreCase(alumno.getId())) {
				System.out.println("Partido encontrado. Procediendo a borrado...");
				itr.remove();
			}
		} 
		leeralumnos(alumnos);
	}
	
	//metodo para leer lo que hay metido en el ".txt"
	public static void leer() throws IOException {
		RandomAccessFile procesoleer = new RandomAccessFile("Alumno.txt","rw");
		for(int i=0;i<procesoleer.length();i++){
					System.out.print((char)procesoleer.read());
		}
		procesoleer.close();
	}
	
	//metodo para introducir los alumnos del ".xml" por terminal en eclipse
	public static void volcarxml(ArrayList<Alumno> alumno) throws ParseException{
		try {
	        DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
	        DocumentBuilder build = dFact.newDocumentBuilder();
	        org.w3c.dom.Document doc = build.newDocument();
	        Node raiz = (Node) ((org.w3c.dom.Document) doc).createElement("Colegio");
	        ((Node) doc).appendChild(raiz);
	        
	        for (Alumno dtl : alumno) {
	        	Element Detalles =  doc.createElement("Alumno");
		        raiz.appendChild(Detalles);
	            Element Id =  doc.createElement("Id");
	            Id.appendChild(doc.createTextNode(String.valueOf(dtl.getId())));
	            Detalles.appendChild(Id);            
	            Element nom = doc.createElement("Nombre");
	            nom.appendChild(doc.createTextNode(String.valueOf(dtl.getNombre())));
	            Detalles.appendChild(nom);	            
	            Element ape = doc.createElement("Apellidos");
	            ape.appendChild(doc.createTextNode(String.valueOf(dtl.getApellido())));
	            Detalles.appendChild(ape);	            
	            Element cur = doc.createElement("Curso");
	            cur.appendChild(doc.createTextNode(String.valueOf(dtl.getCurso())));
	            Detalles.appendChild(cur);
	            Element eda = doc.createElement("Edad");
	            eda.appendChild(doc.createTextNode(String.valueOf(dtl.getEdad())));
	            Detalles.appendChild(eda);	            
	            Element alt = doc.createElement("Altura");
	            alt.appendChild(doc.createTextNode(String.valueOf(dtl.getAltura())));
	            Detalles.appendChild(alt);
	            Element ma = doc.createElement("Mayor");
	            ma.appendChild(doc.createTextNode(String.valueOf(dtl.getMayor())));
	            Detalles.appendChild(ma);
	        }
	        
	        TransformerFactory tranFactory = TransformerFactory.newInstance();
	        Transformer aTransformer = tranFactory.newTransformer();
	        DOMSource source = new DOMSource((Node) doc);
	        
	        try {
	            FileWriter fos = new FileWriter(new File("Alumno.xml"));
	            StreamResult result = new StreamResult(fos);
	            aTransformer.transform(source, result);
	            System.out.println("Los datos han sido guardados correctamente en el archivo Alumnos.xml");

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		    } catch (Exception ex2) {
		        ex2.printStackTrace();
		    } 
		
	}
	
	//metodo para leer lo introducido en el ".xml" por terminal en eclipse
	static void leerXml(ArrayList<Alumno> alumnos) {
		DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();	
		File f = new File("Alumno.xml");
		try {
			DocumentBuilder build = fac.newDocumentBuilder();
			Document doc = build.parse(f);
			doc.getDocumentElement().normalize();	
			System.out.println("Elemento ra�z: "+doc.getDocumentElement().getNodeName());				
			NodeList lista_Alumnos = doc.getElementsByTagName("Alumno");
			
			for(int i = 0; i < lista_Alumnos.getLength(); i ++){
				Node Atributos=lista_Alumnos.item(i);
				System.out.println("Elemento: "+Atributos.getNodeName());
				if(Atributos.getNodeType() == Node.ELEMENT_NODE) {
					Element element=(Element)Atributos;
					System.out.println("Id:" + element.getElementsByTagName("Id").item(0).getTextContent());
					System.out.println("Nombre: " + element.getElementsByTagName("Nombre").item(0).getTextContent());
					System.out.println("Apellidos: " + element.getElementsByTagName("Apellidos").item(0).getTextContent());
					System.out.println("Curso: " + element.getElementsByTagName("Curso").item(0).getTextContent());
					System.out.println("Edad: " + element.getElementsByTagName("Edad").item(0).getTextContent());
					System.out.println("Altura: " + element.getElementsByTagName("Altura").item(0).getTextContent());
					System.out.println("Mayor: " + element.getElementsByTagName("Mayor").item(0).getTextContent());
				}	
			}		
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
	
}
