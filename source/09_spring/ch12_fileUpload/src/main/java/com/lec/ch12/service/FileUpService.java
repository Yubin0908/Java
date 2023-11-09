package com.lec.ch12.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUpService {
	private static final Logger logger = LoggerFactory.getLogger(FileUpService.class);
	
	public boolean fileUp(MultipartHttpServletRequest mrs, ModelAndView mov) {
		boolean isUpload = false;
		// mrs를 통해 들어온 파일을  서버에 저장(동일 파일명일 경우 파일명 변경) -> dbResource 폴더에 복사
		String uploadPath = mrs.getRealPath("dbResource/"); // 실제 저장될 폴더
		String backupPath = "D:/Project/source/09_spring/ch12_fileUpload/src/main/webapp/dbResource/"; // Copy 폴더(절대경로 지정)
		String[] fileNames = new String[3];
				
		int i = 0;
		Iterator<String> params = mrs.getFileNames(); // FIFO
		while(params.hasNext()) {
			String param = params.next();
			logger.info(i + "번째 파리미터 값 : " + param);
			MultipartFile mFile = mrs.getFile(param); // parameter File 객체
			fileNames[i] = mFile.getOriginalFilename(); // Upload File Name
			logger.info(fileNames[i] == null ? "null":fileNames[i].equals("") ? "빈스트링":"첨부한 파일 이름은 :" + fileNames[i]);
			// 첨부여부 확인
			if(fileNames[i] != null && !fileNames[i].equals("")) {
				// 파일 첨부한경우
				// 동일한 이름이 존재하나?
				if(new File(uploadPath + fileNames[i]).exists()) {
					fileNames[i] = System.currentTimeMillis() + fileNames[i];
				}
				try {
					mFile.transferTo(new File(uploadPath + fileNames[i])); // server 파일 저장
					logger.info("server Upload File : " + uploadPath + fileNames[i]);
					logger.info("copy File : " + backupPath + fileNames[i]);
					
					isUpload = filecopy(uploadPath + fileNames[i], backupPath + fileNames[i]);
				} catch (IOException e) {
					logger.error(e.getMessage());
				} 
			}
			i++;
		}
		mov.addObject("fileNames", fileNames);
		return isUpload;
	}

	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		
		FileInputStream is = null; 
		FileOutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] bs = new byte[((int)file.length())];
			
			while(true) {
				int nReadByte = is.read(bs);
				if(nReadByte == -1) break;
				os.write(bs, 0, nReadByte);
			}
			isCopy = true;
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
		return isCopy;
	}
}
