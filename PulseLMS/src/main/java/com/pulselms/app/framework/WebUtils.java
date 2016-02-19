package com.pulselms.app.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.monte.screenrecorder.ScreenRecorder;
import org.testng.Reporter;


/**
 * Utils class will have some common utility methods required
 * @author Cognizant
 *
 */

public abstract class WebUtils {
	
	public static String twoStringsWithNewLine(String one, String two) {
		
		String separator = System.getProperty( "line.separator" );
		StringBuilder lines = new StringBuilder( one );
		lines.append( separator );
		lines.append( two );
		return lines.toString( );
		
	}
	
	/**
	 * Windows Only method
	 * 
	 * @param serviceName
	 * @return true if process status is running, false otherwise
	 */
	public static boolean isProcessRuning(String serviceName) {
		if (EnvParameters.getOSname() == EnvParameters.OSType.windows) {
			Process p;
			try {
				p = Runtime.getRuntime().exec("tasklist");
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(p.getInputStream()));
				String line;

				while ((line = reader.readLine()) != null) {
					if (line.contains(serviceName)) {
						Reporter.log(serviceName + " is running", true);
						return true;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		} else {
			LoggerUtil.log(
					"Client OS is not Windows, cannot check running process: "
							+ serviceName);
			return false;
		}
	}

	/**
	 * Kills the specified process (Windows Only method)
	 * 
	 * @param serviceName
	 */
	public static void killProcess(String serviceName) {
		Reporter.log("Trying to kill " + serviceName, true);

		String KILL = "taskkill /F /T /IM ";
		if (EnvParameters.getOSname() == EnvParameters.OSType.windows) {
			try {
				Runtime.getRuntime().exec(KILL + serviceName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
			Reporter.log(
					"Client OS is not window, can not kill " + serviceName,
					true);
	}
	
	/**utility method for capturing video
	 * @param videofilename
	 * @param recorder
	 */
	public static void captureVideo(String videofilename,
			ScreenRecorder recorder) {
		try {
			String currentVideoFilePath = videofilename+"avi";
			Reporter.log("Video Recordings:<br> <a href='file:///"+
				 currentVideoFilePath+
				 "' target='new'>Click here to view </a>");

				if (recorder != null)
					recorder.stop();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Error in onTestFailure" + e.getMessage());
		}

	}
	
	public static void createFolder(String strDirectoy) {
		boolean success = (new File(strDirectoy)).mkdirs();
		if (success) {
		}
	}
	
	/**
	 * Method to find the relative path from 2 absolute paths
	 * @param absPath
	 * @param basePath
	 * @return relative path to the file/folder. If an exception occurs absPath will be returned
	 */
	public static String getRelativePath(String absPath, String basePath){
        try {
        	Path pathAbsolute = Paths.get(absPath);
            Path pathBase = Paths.get(basePath);
            Path pathRelative = pathBase.relativize(pathAbsolute);
            return pathRelative.toString(); 
		} catch (Exception e) {
			return absPath;
		}
	}
	
	public static File lastFileModified(String dir) {
	    File fl = new File(dir);
	    File[] files = fl.listFiles(new FileFilter() { 
	    	 public boolean accept(File file) {
	            return file.isFile();
	        }
	    });
	    long lastMod = Long.MIN_VALUE;
	    File choice = null;
	    for (File file : files) {
	        if (file.lastModified() > lastMod) {
	            choice = file;
	            lastMod = file.lastModified();
	        }
	    }
	    return choice;
	}
	
	public static boolean renameFile(File oldFile, File newFile) {
		
	     if(oldFile.renameTo(newFile)) {
	         return true;
	      } else {
	         return false;
	      }
		
	}
	
	public static String getFile(String folder, String ext) {

		GenericExtFilter filter = new GenericExtFilter(ext);

		File dir = new File(folder);
		
		if(dir.isDirectory()==false){
			throw new BrowserBotException("Directory does not exists : " + folder);
		}
		
		// list out all the file name and filter by the extension
		String[] list = dir.list(filter);

		if (list.length == 0) {
			throw new BrowserBotException("no files end with : " + ext);
		}

		return list[0];
		
	}
	
	public static void main(String x[]) {
		
		File appDir = new File("build" + File.separator + "QA");
		File app = new File(appDir, WebUtils.getFile(appDir.getAbsolutePath(), "ipa"));
		System.out.println(app.getName());
	}


}
