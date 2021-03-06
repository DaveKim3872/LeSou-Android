package Spider;

import java.io.*;
import java.util.ArrayList;

public class SearchResult{
    public ArrayList<Resource> resources = new ArrayList<Resource>();

    public void serialize(String file_name){
        try {
            File file = new File("/storage/emulated/0/Lesou/saved/"+file_name);
            file.getParentFile().mkdirs();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(resources);
            objectOutputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deserialize(String file_name){
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("/storage/emulated/0/Lesou/saved/" + file_name)));
            resources = (ArrayList<Resource>)objectInputStream.readObject();
            objectInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
