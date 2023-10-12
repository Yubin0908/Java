package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MModifyService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024 * 1024; // maxi 1Megs
		String mphoto = ""; // 첨부된 파일이름 변수선언
		int result = MemberDao.FAIL; // 정보수정 결과 변수선언
		try {
			MultipartRequest mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
		//	while(params.hasMoreElements()) {
				String param = params.nextElement(); // mphoto
				mphoto = mRequest.getFilesystemName(param);
		//	}
				// parameter 받아와 DB 처리
			String dbMpw = mRequest.getParameter("dbMpw");
			String dbMphoto = mRequest.getParameter("dbMphoto");
			
			// hidden으로 넘어온 parameter가 없을 경우, session에서 가져와도 됨.
//			HttpSession session = request.getSession();
//			String dbMpw = null; String dbMphoto = null;
//			MemberDto sessionMember = (MemberDto)session.getAttribute("member");
//			if(sessionMember!=null) {
//			dbMpw = sessionMember.getMpw();
//			dbMphoto = sessionMember.getMphoto();
//			}
			String mid = mRequest.getParameter("mid");
			String oldMpw = mRequest.getParameter("oldMpw");
			if(!oldMpw.equals(dbMpw)) {
				request.setAttribute("modifyErrMsg", "입력하시 비밀번호가 일치하지 않습니다. 기존 비밀번호를 확인하세요.");
				return;
			}
			String newMpw = mRequest.getParameter("newMpw");
			if(newMpw.equals("")) {
				newMpw = dbMpw;
			}
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			// mphoto 정보수정 시, 사진첨부 안하면, 기존의 사지으로 처리(dbMphoto)
			mphoto = mphoto == null ? dbMphoto : mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);
			}
			String maddress = mRequest.getParameter("maddress");
			
			MemberDao mDao = MemberDao.getInstance();
			MemberDto mDto = new MemberDto(mid, newMpw, mname, memail, mphoto, mbirth, maddress, null);
			result = mDao.modifyMember(mDto);
			if(result == MemberDao.SUCCESS) {
				HttpSession session = request.getSession();
				session.setAttribute("member", mDto);
				request.setAttribute("modifyResult", "회원 정보 수정이 완료되었습니다.");
			} else {
				request.setAttribute("modifyErrMsg", "회원 정보 수정이 실패했습니다.");
			}
		} catch (IOException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		// server에 저장된 file을 src 폴더로 복사(filename != NOING.JPG && result == SUCCESS 경우) 
		File serverFile = new File(path + "/" + mphoto);
		if(serverFile.exists() && !mphoto.equals("NOIMG.JPG") && result == MemberDao.SUCCESS) {
			InputStream is = null;
			OutputStream os = null;
			try {
					is = new FileInputStream(serverFile);
					os = new FileOutputStream("D:/Project/source/06_jsp/ch18_mvcMember/WebContent/memberPhotoUp"+mphoto); // src폴더에 복사할 파일
					byte[] bs = new byte[(int)serverFile.length()];
					while(true) {
						int readByteCnt = is.read(bs);
						if(readByteCnt==-1) break;
						os.write(bs, 0, readByteCnt);
					}
					System.out.println(mphoto + "복사 완료.");
			} catch (IOException e) {
				System.out.println("[copy-error]" + e.getMessage());
			} finally {
					try {
						if(os!=null) os.close();
						if(is!=null) is.close();
					} catch (IOException e) {
						System.out.println(e.getMessage());
					}
				
			}
		}
	}
}
