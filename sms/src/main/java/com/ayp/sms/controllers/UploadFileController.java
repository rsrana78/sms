package com.ayp.sms.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 
 * @author rana
 *
 */

@Controller
public class UploadFileController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@RequestMapping(value = "/saveFiles", method = RequestMethod.POST)
    @ResponseBody
    public String saveFiles(MultipartHttpServletRequest request, HttpServletResponse response) throws FileNotFoundException, IOException {
		String imagePath = "/home/rana/smsimages/";
		File pathToSaveFile = new File(imagePath);
    	if(!pathToSaveFile.exists())
    		pathToSaveFile.mkdirs();
		Iterator<String> itr =  request.getFileNames();
        MultipartFile mpf = request.getFile(itr.next());
        String fileName = mpf.getOriginalFilename();
        StringBuilder tempFileName = new StringBuilder(fileName);
        for(int i=1;;i++){
        	File file = new File(imagePath+tempFileName);
        	if(file.exists()){
        		String[] tempName = fileName.split("\\.");
        		tempFileName.delete(0, tempFileName.length());
        		tempFileName = tempFileName.append(tempName[0]+"("+i+")"+"."+tempName[1]);
        	}else
        		break;
        }
        FileOutputStream fileStream = null;
        byte[] bytes = mpf.getBytes();
        fileStream = new FileOutputStream(imagePath+tempFileName);
        fileStream.write(bytes);
        fileStream.close();
        return "[\"" + tempFileName + "\"]";
    }

}
