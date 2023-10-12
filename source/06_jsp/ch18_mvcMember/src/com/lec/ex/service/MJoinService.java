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

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// image file save => parameter DB init => image file "src" folder copy
		String path = request.getRealPath("memberPhotoUp");
		int maxSize = 1024 * 1024; // maxi 1Megs
		String mphoto = ""; // 첨부된 파일이름 변수선언
		int result = MemberDao.FAIL; // 회원가입 결과 변수선언
		MultipartRequest mRequest = null;
		try {
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());
			Enumeration<String> params = mRequest.getFileNames();
			String param = params.nextElement();
			mphoto = mRequest.getFilesystemName(param);
			
			// mRequest를 이용하여 파라미터 받아와 DB에 저장
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			mphoto = mphoto == null ? "NOIMG.JPG":mphoto;
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = mbirthStr.equals("") ? null:Date.valueOf(mbirthStr); 
			String maddress = mRequest.getParameter("maddress");
			MemberDao mDao = MemberDao.getInstance();
			// mid confirm
			result = mDao.midConfirm(mid);
			if(result == MemberDao.NONEXISTENT) {
				MemberDto newMember = new MemberDto(mid, mpw, mname, memail, mphoto, mbirth, maddress, null);
				result = mDao.joinMember(newMember);
				if(result == MemberDao.SUCCESS) {
					HttpSession session = request.getSession();
					session.setAttribute("mid", mid);
					request.setAttribute("joinMsg", "회원가입이 완료되었습니다.");
				} else {
					request.setAttribute("joinErrMsg", "정보의 길이를 초과하였습니다.");
				}
			} else {
				request.setAttribute("joinErrMsg", "중복된 ID로 회원가입이 불가합니다.");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			request.setAttribute("joinErrMsg", "첨부파일은 최대 1MB까지 저장가능합니다.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// server에 업로드된 파일을 src폴더로 복사
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
