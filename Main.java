


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
      MVC_DAOdefaultDirs.add("src/com/" + projectName.toLowerCase() + "/DAO");
      
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
    System.out.println("|  The Last Attribute will be considered the primary key  |");
    System.out.println("|                                                         |");
    System.out.println("| Obs1: If you use complex types like Lists, you must     |");
    System.out.println("|       import it.                                        |");
    System.out.println("- Obs2: Use exactly the spacing according to the example. -");
    System.out.println("---------------------- Use 0 to exit ----------------------\n");
    System.out.println("Example: ");
    System.out.println("> Users: String name, int id");
    System.out.println("> Book: int pages, String isbn, String title");
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
        System.out.print("Error: invalid format. Try again:\n");
        continue;
      }

      String className = inputSplit[0].trim();

      String classNameSplit[] = className.split(" ");
      if(classNameSplit.length != 1 || classNameSplit[0].isEmpty()) {
        System.err.println("Don`t use space in Class name.");
        continue;
      }

      className = classNameSplit[0];

      if(!Character.isUpperCase(className.charAt(0))) {
        System.err.println("Error: Classes name must be started with capital letters.");
        continue;
      }


      ModelClass newClass = new ModelClass(className);
          
      String attributes[] = inputSplit[1].split(",");
      boolean invalidAttributes = false;

      for(String attr : attributes) {
        attr = attr.trim();
        String attrSplitted[] = attr.split(" ");

        if(attrSplitted.length != 2) {
          System.out.print("Error: invalid format. Try again:\n");
          invalidAttributes = true;
          break;
        }

        if(!Character.isLowerCase(attrSplitted[1].charAt(0))) {
          System.err.println("Error: Attributes name must be started with lowercase letters.");
        }

        newClass.addAttr(attrSplitted[0], attrSplitted[1]);
      }

      Classes.add(newClass);

      if(invalidAttributes) {
        System.out.print("Error: invalid format. Try again:\n");
        continue;
      }         
      count++; 
    }

    if(count == 0) {
      System.err.println("Error: no class provided as input");
      sc.close();
      return;
    }

    String url, port, dbName, user, pass, driver;
    System.out.print("Use the default options for connection with database? [Y/n] ");
    String option = sc.nextLine();
    if(option.toLowerCase().equals("n")) {
      System.out.println("Leave the following questions in blank to use default:\n");
      System.out.print("Enter url of the database, dont insert the port and last / (Defautl: jdbc:mysql://localhost) -> ");
      url = sc.nextLine();
      System.out.print("Enter the port of the database (Default: 3306) -> ");
      port = sc.nextLine();
      System.out.print("Enter the database name (Default: testDB) ->");
      dbName = sc.nextLine();
      System.out.print("Enter the username (Default: root) -> ");
      user = sc.nextLine();
      System.out.print("Enter the pass of the user (Default: root) -> ");
      pass = sc.nextLine();
      System.out.print("Enter the driver class name (Default: com.mysql.cj.jdbc.Driver) -> ");
      driver = sc.nextLine();
      
      if(url.isBlank()) url = "jdbc:mysql://localhost";
      if(port.isBlank()) port = "3306";
      if(dbName.isBlank()) dbName = "testDB";
      if(user.isBlank()) user = "root";
      if(pass.isBlank()) pass = "root";
      if(driver.isBlank()) driver = "com.mysql.cj.jdbc.Driver";
    } else {
      url = "jdbc:mysql://localhost";
      port = "3306";
      dbName = "testDB";
      user = "root";
      pass = "root";
      driver = "com.mysql.cj.jdbc.Driver";
    }


    File dirNewProject = new File(projectName);

    // cleaning directory
    if (dirNewProject.exists()) {
      System.out.println("File or directory " + dirNewProject + " already exists, want to overwrite? [y/N]");
      String confirmation = sc.nextLine();

      if(!confirmation.equalsIgnoreCase("y")) {
        System.out.println("Exiting.");
        sc.close();
        return;
      } else {
        if(recursiveDelete(dirNewProject)) {
          System.out.println("Cannot delete " + dirNewProject + " recursively. Possibly permission problem.");
        } else {
          System.out.println("File " + dirNewProject + " deleted succesfully.");
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

    System.out.println("Create MVC + DAO structure? [Y/n]");
    String confirmation = sc.nextLine();
    if(confirmation.equalsIgnoreCase("n")) {
      System.out.println("Exiting. More structures not implemented yet.");
      sc.close();
      return;
    }

    System.out.println("Creating project with" + count + " classes.");

    System.err.println("Generating directories...");
    if(createMVCDAODirs(dirNewProject)) {
      System.err.println("An error ocurred. Exiting.");
      sc.close();
      return;
    }
 
    // creating project files
    System.out.println("Generating files...");

    // model Classes
    for(ModelClass c: Classes) {

      System.out.println("Creating " + "src/com/" + projectName.toLowerCase() + "/model/" + c.getClassName() + ".java");

      try( BufferedWriter fWriter = new BufferedWriter(new FileWriter(dirNewProject.getAbsolutePath() + "/src/com/" + projectName.toLowerCase() + "/model/" + c.getClassName() + ".java"))) {
        fWriter.write("package com." + projectName.toLowerCase() + ".model;\n\n");
        fWriter.write("public class " + c.getClassName() + " {\n");
        for(Attribute attr : c.getAttributes()) {
          fWriter.write("    private " + attr.getType() + " " + attr.getName() + ";\n");
        }
        
        fWriter.newLine();

        // getters
        fWriter.write("// getters\n");
        for(Attribute attr : c.getAttributes()) {
          fWriter.write("    public " + attr.getType() + " get" + attr.getName().substring(0,1).toUpperCase() + attr.getName().substring(1) + "() {\n");
          fWriter.write("        return " + attr.getName() + ";\n");
          fWriter.write("    }\n");
        }

        fWriter.newLine();

        // setters
        fWriter.write("// setters\n");
        for(Attribute attr : c.getAttributes()) {
          fWriter.write("    public void set" + attr.getName().substring(0,1).toUpperCase() + attr.getName().substring(1) + "( " + attr.getType() + " " + attr.getName() + " ) {\n");
          fWriter.write("        this." + attr.getName() + " = " + attr.getName() + ";\n");
          fWriter.write("    }\n");
        }

        fWriter.newLine();
        
        // @Override toString() method
        fWriter.write("    @Override\n");
        fWriter.write("    public String toString() {\n");
        fWriter.write("        return ");

        for (Attribute attr : c.getAttributes()) {
          fWriter.write("\"" + attr.getName() + " -> \" + get" + attr.getName().substring(0, 1).toUpperCase() + attr.getName().substring(1) + "()" + " + \"\\n\" + ");
        }
        fWriter.write("\"\";\n"); // for last '+'

        fWriter.write("    }\n");
        fWriter.write("}\n");

        fWriter.flush();

      } catch(IOException e) {
        System.err.println("An error occurred when generating Class " + c.getClassName() + ": " + e.getMessage());
        e.printStackTrace();
        sc.close();
        return;
      }
    }

    // DAO Classes
    System.out.println("Creating " + "src/com/" + projectName.toLowerCase() + "/DAO/DBConnection.java");
    try(BufferedWriter fWriter = new BufferedWriter(new FileWriter(dirNewProject.getAbsolutePath() + "/src/com/" + projectName.toLowerCase() + "/DAO/DBConnection.java"))) {
      
      fWriter.write("package com." + projectName.toLowerCase() + ".DAO;\n");
      fWriter.newLine();

      String toImport[] = {"java.sql.Connection", "java.sql.DriverManager", "java.sql.SQLException"};
      for(String packToImport : toImport) {
        fWriter.write("import " + packToImport + ";\n");
      }
      fWriter.newLine();
      
      fWriter.write("public class DBConnection {\n");
      fWriter.newLine();

      fWriter.write("    static {\n");
      fWriter.write("        try {\n");
      fWriter.write("            Class.forName(\"" + driver + "\");\n");
      fWriter.write("        } catch(ClassNotFoundException e) {\n");
      fWriter.write("            e.printStackTrace();\n");
      fWriter.write("            System.exit(1);\n");
      fWriter.write("        }\n");
      fWriter.write("    }\n");

      fWriter.newLine();

      fWriter.write("    private static final String USER = \"" + user + "\";\n");
      fWriter.write("    private static final String PASSWORD = \"" + pass + "\";\n");
      fWriter.write("    private static final String URL = \"" + url + ":" + port + "/" + dbName + "\";\n");
      fWriter.newLine();

      fWriter.write("    public static Connection getConnection() throws SQLException {\n");
      fWriter.write("        return DriverManager.getConnection(URL, USER, PASSWORD);\n");
      fWriter.write("    }\n");
      fWriter.write("}\n");

      fWriter.flush();

    } catch(IOException e) {
        System.err.println("An error occurred when generating Class DBConnection: " + e.getMessage());
        e.printStackTrace();
        sc.close();
        return;
    }

    for(ModelClass c : Classes) {
      System.out.println("Creating " + "src/com/" + projectName.toLowerCase() + "/DAO/" + c.getClassName() + "DAO.java");

      try(BufferedWriter fWriter = new BufferedWriter(new FileWriter(dirNewProject.getAbsolutePath() + "/src/com/" + projectName.toLowerCase() + "/DAO/" + c.getClassName() + "DAO.java"))) {
        
        fWriter.write("package com." + projectName.toLowerCase() + ".DAO;\n");
        fWriter.newLine();

        String toImport[] = {"java.sql.Connection", "java.sql.PreparedStatement", "java.sql.ResultSet", "java.sql.SQLException", "com." + projectName.toLowerCase() + ".model." + c.getClassName()};

        for(String packToImport : toImport) {
          fWriter.write("import " + packToImport + ";\n");
        }

        fWriter.write("public class " + c.getClassName() + "DAO {\n");

        fWriter.newLine();

        fWriter.write("    private Connection connection;\n");

        fWriter.newLine();

        fWriter.write("    public " + c.getClassName() + "DAO(Connection connection) {\n");
        fWriter.write("        this.connection = connection;\n");
        fWriter.write("    }\n");

        fWriter.newLine();

        // insert method
        List<Attribute> classAttributes = c.getAttributes();
        String attributes = classAttributes.get(0).getName();
        String interrogations = "?";
        
        for(int i=1; i<classAttributes.size(); i++) {
          attributes += ", " + classAttributes.get(i).getName();
          interrogations += ", ?";
        }
        
        
        fWriter.write("    public void insert(" + c.getClassName() + " " + c.getClassName().substring(0,1).toLowerCase() + c.getClassName().substring(1) + ") throws SQLException {\n");
        fWriter.write("        String sql = \"INSERT INTO " + c.getClassName().toLowerCase() + " (" + attributes + ") VALUES (" + interrogations + ")\";\n");
        
        fWriter.write("        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {\n");

        for(int i = 0; i < classAttributes.size(); i++) {
          fWriter.write("            pstmt.setObject(" + Integer.toString(i+1) + ", " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ".get" + classAttributes.get(i).getName().substring(0,1).toUpperCase() + classAttributes.get(i).getName().substring(1) + "());\n");
        }

        fWriter.write("            pstmt.executeUpdate();\n");
        fWriter.write("        }\n");
        fWriter.write("    }\n");
        
        fWriter.newLine();

        // update method
        fWriter.write("    public void update(" + c.getClassName() + " " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ") throws SQLException {\n");
        

        attributes = classAttributes.get(0).getName() + " = ?";
        int tmp;
        for(int tmp = 1; tmp < classAttributes.size() - 1; tmp++) {
          attributes += ", " + classAttributes.get(tmp).getName() + " = ?";
        }

        fWriter.write("        String sql = \"UPDATE " + c.getClassName().toLowerCase() + " SET " + attributes + " WHERE " + classAttributes.get(tmp).getName() + " = ?\";\n");
        fWriter.write("        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {\n");
        
        for(tmp = 0; tmp < classAttributes.size() - 1; tmp++) {
          fWriter.write("            pstmt.setObject(" + Integer.toString(tmp+1) + ", " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ".get" + classAttributes.get(tmp).getName().substring(0,1).toUpperCase() + classAttributes.get(tmp).getName().substring(1) + "());\n");
        }        
        
        fWriter.write("            pstmt.executeUpdate();\n");
        fWriter.write("        }\n");
        fWriter.write("    }\n");

        fWriter.newLine();

        // delete method
        fWriter.write("    public void delete(" + c.getClassName() + " " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ") throws SQLException {\n");
        fWriter.write("        String sql = \"DELETE FROM " + c.getClassName().toLowerCase() + " WHERE " + classAttributes.get(classAttributes.size() - 1).getName() + " = ?\";\n");
        fWriter.write("        try(PreparedStatement pstmt = connection.prepareStatement(sql)) {\n");
        fWriter.write("            pstmt.setObject(1, " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ".get" + classAttributes.get(classAttributes.size() - 1).getName().substring(0,1).toUpperCase() + classAttributes.get(classAttributes.size() - 1).getName().substring(1) + "());\n");
        fWriter.write("            pstmt.executeUpdate();\n");
        fWriter.write("        }\n");
        fWriter.write("    }\n");


          
      } catch(IOException e) {
        System.err.println("An error occurred when generating Class " + c.getClassName() + ": " + e.getMessage());
        e.printStackTrace();
        sc.close();
        return;
      }



      
    }

    
/*

// controllers
    for(ModelClass c : Classes) {
  

      System.out.println("Creating " + "src/com/" + projectName.toLowerCase() + "/controller/" + c.getClassName() + "Controller.java");

      try(BufferedWriter fWriter = new BufferedWriter(new FileWriter(dirNewProject.getAbsolutePath() + "/src/com/" + projectName.toLowerCase() + "/controller/" + c.getClassName() + "Controller" + ".java"))) {
        fWriter.write("package com." + projectName.toLowerCase() + ".controller;\n\n");
        fWriter.write("import com." + projectName.toLowerCase() + ".model." + c.getClassName() + ";\n");
        fWriter.write("import com." + projectName.toLowerCase() + ".DAO." + c.getClassName() + "DAO;\n\n");
        fWriter.write("public class " + c.getClassName() + "Controller {\n");
        fWriter.write("    private final " + c.getClassName() + "DAO " + c.getClassName().substring(0,1).toLowerCase() + c.getClassName().substring(1) + "DAO;\n\n");

        // create
        fWriter.write("    public void create" + c.getClassName() + "(" + c.getClassName() + " " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ") {\n\n");
        
        fWriter.write("    }\n");
        fWriter.write("    public void get" + c.getClassName() + "(" + c.getClassName() + " " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ") {\n\n");
        fWriter.write("    }\n");
        fWriter.write("    public void delete" + c.getClassName() + "(" + c.getClassName() + " " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ") {\n\n");
        fWriter.write("    }\n");
        fWriter.write("    public void update" + c.getClassName() + "(" + c.getClassName() + " " + c.getClassName().substring(0, 1).toLowerCase() + c.getClassName().substring(1) + ") {\n\n");
        fWriter.write("    }\n");
        fWriter.write("}\n");
        
      } catch(IOException e) {
        System.err.println("An error occurred when generating Class " + c.getClassName() + ": " + e.getMessage());
        e.printStackTrace();
        sc.close();
      }
    }
*/
    sc.close();


    System.out.println("Project generated successfully!");
    System.out.println("1. Add the JDBC driver JAR file to the /lib folder.");
    System.out.println("2. Check the update method in the DAO classes — replace id with your table's actual primary key.");
    System.out.println("3. Create the database and start your MySQL server before running the application.");
    System.out.println("4. Edit yout main method in /src/com/view/Main.java");
  }
}