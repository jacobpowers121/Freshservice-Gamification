package XmlDataInput;

import java.io.File;

public class XmlReader {

    File workingFile;

    public XmlReader(String[] filenames){
        for(String name : filenames){
            fileLoader(name);

        }
    }

    public void fileLoader(String filename){
        workingFile = new File(filename);
    }



}
