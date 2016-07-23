package net.mindview.io;
//: io/MakeDirectories.java
// Demonstrates the use of the File class to
// create directories and manipulate files.
// {Args: MakeDirectoriesTest}
import java.io.*;

import org.junit.Test;

public class MakeDirectories {
	
	@Test
	public void test() throws IOException {
	     File file1 = new File("..\\src\\file");
	     System.out.println(file1.getPath());
	     System.out.println(file1.getAbsolutePath());
	     System.out.println(file1.getCanonicalPath());
	     File file2 = new File(".\\src\\file");
	     System.out.println(file2.getPath());
	     System.out.println(file2.getAbsolutePath());
	     System.out.println(file2.getCanonicalPath());
	     File file3 = new File("C:\\src\\file");
	     System.out.println(file3.getPath());
	     System.out.println(file3.getAbsolutePath());
	     System.out.println(file3.getCanonicalPath()); 
	}
	
  private static void usage() {
    System.err.println(
      "Usage:MakeDirectories path1 ...\n" +
      "Creates each path\n" +
      "Usage:MakeDirectories -d path1 ...\n" +
      "Deletes each path\n" +
      "Usage:MakeDirectories -r path1 path2\n" +
      "Renames from path1 to path2");
    System.exit(1);
  }
  private static void fileData(File f) {
    System.out.println(
      "Absolute path: " + f.getAbsolutePath() +
      "\n Can read: " + f.canRead() +
      "\n Can write: " + f.canWrite() +
      "\n getName: " + f.getName() +
      "\n getParent: " + f.getParent() +
      "\n getPath: " + f.getPath() +
      "\n length: " + f.length() +
      "\n lastModified: " + f.lastModified());
    if(f.isFile())
      System.out.println("It's a file");
    else if(f.isDirectory())
      System.out.println("It's a directory");
  }

	public static void main(String[] args) {
		if (args.length < 1)
			usage();
		if (args[0].equals("-r")) {
			if (args.length != 3)
				usage();
			File old = new File(args[1]), rname = new File(args[2]);
			old.renameTo(rname);
			fileData(old);
			fileData(rname);
			return; // Exit main
		}
		int count = 0;
		boolean del = false;
		if (args[0].equals("-d")) {
			count++;
			del = true;
		}
		count--;
		while (++count < args.length) {
			File f = new File(args[count]);
			if (f.exists()) {
				System.out.println(f + " exists");
				if (del) {
					System.out.println("deleting..." + f);
					f.delete();
				}
			} else { // Doesn't exist
				if (!del) {
					f.mkdirs();
					System.out.println("created " + f);
				}
			}
			fileData(f);
		}
	}
} /* Output: (80% match)
created MakeDirectoriesTest
Absolute path: d:\aaa-TIJ4\code\io\MakeDirectoriesTest
 Can read: true
 Can write: true
 getName: MakeDirectoriesTest
 getParent: null
 getPath: MakeDirectoriesTest
 length: 0
 lastModified: 1101690308831
It's a directory
*///:~
