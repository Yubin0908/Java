package com.lec.ch16e.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch16e.repository.BoardRepository;
import com.lec.ch16e.util.Paging;
import com.lec.ch16e.vo.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Override
	public List<Board> boardList(Paging paging) {
		Board board = new Board();
		board.setStartRow(paging.getStartRow());
		board.setEndRow(paging.getEndRow());
		return boardRepository.boardList(board);
	}

	@Override
	public int getBoardTotCnt() {
		return boardRepository.getBoardTotCnt();
	}

	@Override
	public int boardWrite(Board board, MultipartHttpServletRequest mrs, ModelAndView mov) {
		boolean isUpload = false;
		String uploadPath = mrs.getRealPath("serverFile");
		String backupPath = "D:/Project/source/09_spring/ch16_mybatisFileBoard/src/main/webapp/serverFile/";
		String fileNames = new String();
		
		Iterator<String> params = mrs.getFileNames();
		if(params.hasNext()) {
			String param = params.next();
			MultipartFile mFile = mrs.getFile(param);
			fileNames = mFile.getOriginalFilename();
			System.out.println(fileNames == null ? "파일첨부안됨":fileNames);
			
			if(fileNames != null && !fileNames.equals("")) {
				if(new File(uploadPath + fileNames).exists()) {
					fileNames = System.currentTimeMillis() + fileNames;
				}
				try {
					mFile.transferTo(new File(uploadPath + fileNames));
					isUpload = filecopy(uploadPath + fileNames, backupPath + fileNames);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		
		return boardRepository.boardWrite(board);
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
	
	@Override
	public Board boardInfo(int bid, String after) {
		if(after == null) {
			boardRepository.boardHitUp(bid);
		}
		return boardRepository.boardInfo(bid);
	}

	@Override
	public Board boardModifyReplyView(int bid) {
		return boardRepository.boardInfo(bid);
	}

	@Override
	public int boardModify(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		return boardRepository.boardModify(board);
	}

	@Override
	public int boardDelete(int bid) {
		return boardRepository.boardDelete(bid);
	}

	@Override
	public int boardReply(Board board, HttpServletRequest request) {
		board.setBip(request.getRemoteAddr());
		boardRepository.boardPreReplyStep(board);
		return boardRepository.boardReply(board);
	}



}
