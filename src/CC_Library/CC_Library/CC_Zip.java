package CC_Library;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;

/**
 *
 * @author EtaYuy88 aka Meihta Dwiguna Saputra
 */
public class CC_Zip {
    //create zip
    public void create(String filePath, String zipPath)
    {
        try {
            //zipPath is absolute path of zipped file
            ZipFile zipFile = new ZipFile(zipPath);
            //filePath is absolute path of file that want to be zip
            File fileToAdd = new File(filePath);
            //create zip parameters such a password, encryption method, etc
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            parameters.setEncryptFiles(true);
            parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
            parameters.setPassword("mdsaputra");
            zipFile.addFile(fileToAdd, parameters);
        } catch (ZipException e) {
            e.printStackTrace();
        }
    }//end of create zip

    //extract zip file
    @SuppressWarnings("unused")
	private void extract(String zipPath, String extractPath) throws ZipException
    {
        ZipFile zipFile = new ZipFile(zipPath);
        // Check to see if the zip file is password protected
        if (zipFile.isEncrypted())
        {
        // if yes, then set the password for the zip file
            zipFile.setPassword("mdsaputra");
        }
        //extractPath is absolute path of file after extracted
        zipFile.extractAll(extractPath);
    }//end of extract

}