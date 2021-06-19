package ex43;

import java.io.File;
import java.io.FileWriter;

public class Website {
    File generateSite(String name)
    {
        //write html file
        File websiteDir = new File("output/website/" + name);
        websiteDir.mkdirs();
        System.out.println("Created ." + websiteDir.getPath());
        return websiteDir;
    }
    File generateIndex(File website, String name, String author)
    {
        File index = new File(website + "/index.html");
        String html = generateHtml(name, author);
        try {
            FileWriter writer = new FileWriter(index);
            writer.write(html);
            writer.close();
        }
        catch (Exception e)
        {
            System.out.print("Website creation failed.");
            System.exit(-1);
        }
        System.out.println("Created ." + index.getPath());
        return index;
    }
    String generateHtml(String name, String author)
    {
        String html = String.format("""
        <!DOCTYPE html>
        <html>
            <title>
                %s
            </title>
            <meta name = "author" content = "%s"/>
        </html>
        """, name, author);
        return html;
    }
    File generateFolder(File website, String name)
    {
        File folder = new File(website + "/" + name);
        folder.mkdir();
        System.out.println("Created ." + folder.getPath());
        return folder;
    }
}
