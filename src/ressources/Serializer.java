/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 29, 2017
 */

package ressources;

import java.io.*;

import javax.swing.JOptionPane;

// TODO: Auto-generated Javadoc
/**
 * The abstract Class Serializer.
 * It contains a method for saving and 
 * reading files used by the apps. The apps
 * can just call them to read/save their files
 */
public abstract class Serializer
{
	
	/**
	 * Deserializable object.
	 *
	 * @param path the path to the saved object
	 * @return the saved object
	 */
	//methode de deserialisation
	public static Object deserializableObject(String path) {
		File file = new File(path) ;
		Object deserializedObject = null ;
		if (file.exists()==false){
			serializableObject(null, path);
		}
		try
		{
			//creation du lecteur binaire FileInputStream � partir du fichier de serialisation
			FileInputStream ffichier = new FileInputStream(path) ;
			//creation du Buffer � partir du lecteur
			BufferedInputStream bffichier = new BufferedInputStream(ffichier) ;
			//creation du lecteur d'objet � partir du buffer
			ObjectInputStream obffichier = new ObjectInputStream(bffichier) ;
			//creation de l'objet Personne "deserializedPerson"
			deserializedObject = obffichier.readObject();
			bffichier.close();
		}
		catch (Exception e)
		{
			//les erreurs de lecture des fichier de serialisation sont gérés au cas par cas dans les applications
		}
		
		//retourne l'objet "deserializedPerson"
		return deserializedObject ;
	}
	
	/**
	 * Serializable object.
	 *
	 * @param object the object to save
	 * @param path the path where the object must be saved
	 */
	//methode de serialisation
	public static void serializableObject(Object object, String path) {
		try{
			
		//creation du writer binaire FileOutputStream
		FileOutputStream fichier = new FileOutputStream(path) ;
		//creation du buffer � partir du writer
		BufferedOutputStream bfichier = new BufferedOutputStream(fichier) ;
		//creation du writer d'objet � partir du buffer
		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier) ;
		//ecriture de l'objet "person" dans le fichier de serialisation
		obfichier.writeObject(object);
		//fermeture de l'acc�s au fichier
		obfichier.close();
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(Ressources.MAINFRAME, "Impossible d'ecrire le fichier :"+path+"\nVérifiez que le dossier n'est pas en lecture seule");
		} ;
	}
}
