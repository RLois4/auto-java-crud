


import java.util.Scanner;

import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Attribute {
  private String type;
  private String name;
 
  public Attribute(String type, String name) {
    this.type = type;
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public String getName() {
    return name;
  }
}




class ModelClass {
  private List<Attribute> attributes = new ArrayList<>();
  private String className;

  public ModelClass(String className) {
    this.className = className;
  }

  public void addAttr(String type, String attrName) {
    Attribute att = new Attribute(type, attrName);
    attributes.add(att);
  }

  public String getClassName() {
    return className;
  }

  public List<Attribute> getAttributes() {
    return attributes;
  }
}





public class Main {
/** 
 *     Delete recursively a directory
 *     @param File : file or directory to be deleted
 *     @return boolean : false if the operation was succefull, true if an error was occurred
 */
  public static boolean recursiveDelete(File file) {
    File files[] = file.listFiles();
    if(files != null) {
      for(File f : files) {
        boolean r = recursiveDelete(f);
        if(r) {
          System.err.println("Cannot delete " + f + "file. Possibly permission problem.");
        }
      }
    }
    if(file.delete()) return false;
    else return true;
  }




/** 
 *     Delete recursively a directory
 *     @param File : root of the project
 *     @return boolean : false if the operation was succefull, true if an error was occurred
 */
  public static boolean createMVCDAODirs(File rootDir) {
    {
      String projectName = rootDir.getName();

      List<String> MVC_DAOdefaultDirs = new ArrayList<>();
      MVC_DAOdefaultDirs.add("src");
      MVC_DAOdefaultDirs.add("bin");
      MVC_DAOdefaultDirs.add("lib");
      MVC_DAOdefaultDirs.add("src/com");
      MVC_DAOdefaultDirs.add("src/com/" + projectName.toLowerCase() + "/model");
      MVC_DAOdefaultDirs.add("src/com/" + projectName.toLowerCase() +"/controller");
      MVC_DAOdefaultDirs.add("src/com/" + projectName.toLowerCase() + "/view");
      MVC_DAOdefaultDirs.add("src/com/" + projectName.toLowerCase() + "/dao");
      
      File dir;
      for(String dirName : MVC_DAOdefaultDirs) {
        dir = new File(rootDir, dirName);
        if (dir.mkdirs()) {
            System.out.println("Created: " + dir.getPath());
        } else {
            System.out.println("Failed to create: " + dir.getPath());
            return true;
        }
      }
      return false;
    } 
  }




/**
* Main function
*/
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter project name (Default \"newProject\")");

    String projectName = sc.nextLine();
    if(projectName.equals("")) projectName = "newProject";

    List<ModelClass> Classes = new ArrayList<>();

    System.out.println("-------------  Enter the classes you need:  ---------------");
    System.out.println("---   The script will generate the class, attributes,   ---");
    System.out.println("---   getters & setters, and override toString method.  ---");
    System.out.println("|                                                         |");
    System.out.println("- Obs: Use exactly the spacing according to the example.  -");
    System.out.println("---------------------- Use 0 to exit ----------------------\n");
    System.out.println("Example: ");
    System.out.println("> Users: String name, int id");
    System.out.println("> Book: int pages, String isbn, String tittle");
    System.out.println("> 0");
    System.out.println("-----------------------------------------------------------\n");
    

    int count = 0;
    while(true) {
      System.out.print("> ");
      String input = sc.nextLine();
        
      if(input.equals("0")) {
        break;
      }
        
      String inputSplit[] = input.split(":");
      if(inputSplit.length != 2) {
        System.out.print("Error: invalid format. Try again:\n> ");
        continue;
      }

      String className = inputSplit[0];
      ModelClass newClass = new ModelClass(className);
          
      String attributes[] = inputSplit[1].split(",");
      boolean invalidAttributes = false;

      for(String attr : attributes) {
        attr = attr.trim();
        String attrSplitted[] = attr.split(" ");

        if(attrSplitted.length != 2) {
          invalidAttributes = true;
          break;
        }

        newClass.addAttr(attrSplitted[0], attrSplitted[1]);
        Classes.add(newClass);
      }

      if(invalidAttributes) {
        System.out.print("Error: invalid format. Try again:\n> ");
        continue;
      }         
      count++; 
    }

    if(count == 0) {
      System.err.println("Error: no class provided as input");
      sc.close();
      return;
    }







    File dirNewProject = new File(projectName);

    // cleaning directory
    if (dirNewProject.exists()) {
      System.out.println("File or directory " + dirNewProject + " already exists, want to overwrite? [N/y]");
      String confirmation = sc.nextLine();

      if(!confirmation.equalsIgnoreCase("y")) {
        System.out.println("Exiting.");
      } else {
        if(recursiveDelete(dirNewProject)) {
          System.out.println("Cannot delete " + dirNewProject + " recursively. Possibly permission problem.");
        } else {
          System.out.println("File " + dirNewProject + " deleted succesfully.");
          sc.close();
          return;
        }
      }
    }

    // creating project structure
    File currentDir = new File(".");
    if(currentDir.canWrite()) {
      dirNewProject.mkdir();
      System.out.println("created root directory for project.");
    } else {
      System.out.println("Permission denied to create directory here.");
      sc.close();
      return;
    }

    System.out.println("Create MVC + DAO structure? [n/Y]");
    String confirmation = sc.nextLine();
    if(confirmation.equalsIgnoreCase("n")) {
      System.out.println("Exiting. More structures not implemented yet.");
    }

    System.err.println("Generating directories...");
    if(createMVCDAODirs(dirNewProject)) {
      System.err.println("An error ocurred. Exiting.");
    }
    
    System.out.println("Generating files...");
    


    
    sc.close();
  }
}