package edu.utep.trustlab.toolkitOperators.ncl.util;

import java.io.*;
import java.util.*;

public class FileUtils
{
	private static final String SERVER = "http://iw.cs.utep.edu:8080/";
	private static final String APPLICATION = "NCL-services/";
	private static final String DATAOUTPUT = "ncl-output/";
		
	public static String getLoggingDir()
	{
		return "/usr/local/tomcat/webapps/NCL-services/log/";
	}
	
	public static String getWorkspaceDir()
	{
		return "/usr/local/tomcat/webapps/NCL-services/" + DATAOUTPUT;
	}
	
	public static String getScriptsDir()
	{
		return "/usr/local/tomcat/webapps/NCL-services/scripts/";
	}
	
	public static String getURLPrefix()
	{
		return SERVER + APPLICATION + DATAOUTPUT;
	}
	
	public static String writeTextFile(String fileContents, String dirName, String fileName)
	{
		File dirFile = new File(dirName);
		dirFile.mkdirs();
		String filePath = dirFile + File.separator + fileName;

		try
		{
			BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
			out.write(fileContents);
			out.close();
			return filePath;
		} catch (Exception e)
		{
			e.printStackTrace();
			return e.toString();
		}
	}

	public static boolean exists(String filePath)
	{
		File file = new File(filePath);
		if (file.exists())
			return true;
		return false;
	}

	public static FileOutputStream getLoggingStream()
	{
		try
		{
			return new FileOutputStream(getLoggingDir() + "/log.txt");
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String writeBinaryFile(byte[] fileContents, String dirName,
			String fileName)
	{
		File dirFile = new File(dirName);
		dirFile.mkdirs();
		String filePath = dirFile + File.separator + fileName;

		try
		{
			FileOutputStream out = new FileOutputStream(filePath);
			out.write(fileContents);
			out.close();
			return filePath;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return e.toString();
		}
	}

	public static byte[] readBinaryFile(String fileName)
	{
		try
		{
			FileInputStream in = new FileInputStream(fileName);
			byte[] fileContents = new byte[fileSize(fileName)];
			in.read(fileContents);
			in.close();
			return fileContents;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String readTextFile(String fileName)
	{
		try
		{
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String line, fileContents;

			fileContents = null;

			while ((line = in.readLine()) != null)
			{
				if (fileContents == null)
					fileContents = line + "\n";
				else
					fileContents = fileContents + line + "\n";
			}
			in.close();
			return fileContents;
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String getRandomString()
	{
		// get the current time in milliseconds to use as data source temp file
		// name
		long miliseconds = (new Date()).getTime();
		String localFileName = new String("" + miliseconds);
		return localFileName;
	}

	public static void deleteFile(String fileName)
	{
		File file = new File(fileName);
		file.delete();
	}

	public static void cleanWorkspace(String workspace)
	{
		File file = new File(workspace);
		String[] wsFiles = file.list();
		if (wsFiles != null)
		{
			for (String aFile : wsFiles)
			{
				deleteFile(FileUtils.makeFullPath(workspace, aFile));
			}
		}
	}

	public static String makePathWellFormedURI(String path)
	{
		try
		{
			String uri = path.replaceAll("\"", "");
			return uri.replaceAll(" ", "%20");
			/*
			 * uri = URLEncoder.encode(uri, "UTF-8"); uri =
			 * uri.replaceAll("%3A", ":"); uri = uri.replaceAll("%2F", "/");
			 */
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static String makeFullPath(String dir, String fileName)
	{
		return dir + File.separator + fileName;
	}

	public static int fileSize(String fileName)
	{
		File file = new File(fileName);
		return (int) file.length();
	}
	
	    
	  public static String getNameFromFilename(String fileName) {
	    StringTokenizer tokens = new StringTokenizer(fileName, ".");
	    String output = tokens.nextToken();
	    return output;
	  }

	  public static String getNameFromPath(String fileName) {
	    String name = new File(fileName).getName();
	    return name;
	  }

	  public static String getDirFromPath(String fileName) {
	    String path = new File(fileName).getParent();
	    return path;
	  }
}
