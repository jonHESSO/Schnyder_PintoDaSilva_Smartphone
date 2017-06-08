/*
 * Project : Schnyder_PintoDaSilva_Smartphone
 * Author : Jonathan Schnyder
 * Created : May 29, 2017
 */

package ressources;

import java.io.*;

public abstract class Serializer
{
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
		}
		catch (Exception e)
		{

		}
		//retourne l'objet "deserializedPerson"
		return deserializedObject ;
	}
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
		{} ;
	}
}
