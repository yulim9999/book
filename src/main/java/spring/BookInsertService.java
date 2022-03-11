package spring;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import utils.FileUtils;

public class BookInsertService {
	private BookInfoDao bookinfoDao;

	public void setBookinfoDao(BookInfoDao bookinfoDao) {
		this.bookinfoDao = bookinfoDao;
	}
//new대신에 bean에서 등록하면 찾을 수 있게 하려고 

	public void register(BookInfo bookinfo) {// 여기서 throws 하면 controller로 가서 처리해줘야한다

//		bookinfo=(BookInfo)bookinfoDao.selectAll();//얘는 DB에서 가져오는거
		// submit하면 bookinfo이게 넘어옴. 그래서 위에거 할필요 없음!
		// 파일 업로드 처리
		MultipartFile file = bookinfo.getFile();
		String isbn = bookinfo.getIsbn();

		if (file != null) {
			try {
				InputStream inputStream = file.getInputStream();
				boolean isValid = FileUtils.validImgFile(inputStream);

				if (!isValid) {
					throw new NotImageFileException();
				}

				int result = bookinfoDao.isbnChk(isbn);

				if (result == 1) {
					throw new AlreadyExistingIsbnException();
				}

				if (isbn.length() != 10) {
					throw new IsbnNot10Exception();
				}

				String fileName = null;
				String originalFileName = file.getOriginalFilename();
				String ext = FilenameUtils.getExtension(originalFileName);
				UUID uuid = UUID.randomUUID();
				fileName = uuid + "." + ext;
				file.transferTo(new File("/upload/" + fileName));

				bookinfo.setImage(fileName);
				BookInfo newBookInfo = new BookInfo(bookinfo.getRegnum(), bookinfo.getIsbn(), bookinfo.getBookname(),
						bookinfo.getWriter(), bookinfo.getPublisher(), bookinfo.getPrice(), bookinfo.getImage(),
						bookinfo.getIntroduction());
				bookinfoDao.insert(newBookInfo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
