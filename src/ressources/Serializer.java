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
	public static Object deserializableObject(String path) throws IOException, ClassNotFoundException {
		//creation du lecteur binaire FileInputStream à partir du fichier de serialisation
		FileInputStream ffichier = new FileInputStream(path) ;
		//creation du Buffer à partir du lecteur
		BufferedInputStream bffichier = new BufferedInputStream(ffichier) ;
		//creation du lecteur d'objet à partir du buffer
		ObjectInputStream obffichier = new ObjectInputStream(bffichier) ;
		//creation de l'objet Personne "deserializedPerson"
		Object deserializedObject = obffichier.readObject();
		//retourne l'objet "deserializedPerson"
		return deserializedObject ;
	}
	//methode de serialisation
	public static void serializableObject(Object object, String path) throws IOException {
		//creation du writer binaire FileOutputStream
		FileOutputStream fichier = new FileOutputStream(path) ;
		//creation du buffer à partir du writer
		BufferedOutputStream bfichier = new BufferedOutputStream(fichier) ;
		//creation du writer d'objet à partir du buffer
		ObjectOutputStream obfichier = new ObjectOutputStream(bfichier) ;
		//ecriture de l'objet "person" dans le fichier de serialisation
		obfichier.writeObject(object);
		//fermeture de l'accès au fichier
		obfichier.close();
	}
}
