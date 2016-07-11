package CC_Library.CC_Active_Directory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Properties;
import java.util.HashSet;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;

public class DeleteFromADGroup {
    private String adGroup,dn;
    private DirContext ctx;
    private String adminName = "intranet\\patilume";

    public DeleteFromADGroup(){
        try{
            this.adGroup  = "CN=CTW_DEV";
            this.dn= "OU=DistributionLists,OU=Messaging,DC=INTRANET,DC=INFOSYSINT,DC=com";
            Properties pr = new Properties();
            pr.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
            pr.setProperty(Context.PROVIDER_URL, "ldap://intranet.infosysint.com");
            pr.setProperty(Context.SECURITY_AUTHENTICATION,"simple");
            pr.setProperty(Context.SECURITY_CREDENTIALS, "myPassword"); //its password
            pr.setProperty(Context.SECURITY_PRINCIPAL, this.adminName);
            pr.setProperty(Context.REFERRAL, "ignore");
            this.ctx = new InitialDirContext(pr);
        }
        catch(Exception e){
            System.out.println("in constructor..");
        }
    }
    public static void main(String[] args) {
        DeleteFromADGroup dadg=new DeleteFromADGroup();
        dadg.deleteUser("CTW_DEV","rakeshdw");
    }
    private void deleteUser(String ADGroup, String username){
        String groupName = "CN="+ADGroup+",OU=DistributionLists,OU=Messaging,DC=INTRANET,DC=INFOSYSINT,DC=com";
        try{

            ModificationItem mods[] = new ModificationItem[1];
            mods[0]= new ModificationItem(DirContext.REMOVE_ATTRIBUTE, new BasicAttribute("member", username));

            //update the group
            ctx.modifyAttributes(groupName,mods);
            ctx.close();
        }
        catch(Exception e){
            System.out.println("Exception while removing user from DL");
        }
    }
}