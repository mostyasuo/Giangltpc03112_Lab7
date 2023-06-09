package com.poly.service;


import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class ParamService {
	@Autowired
	HttpServletRequest request;

	/**
	 * Đọc chuỗi giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public String getString(String name, String defaultValue) {
		String value = request.getParameter(name);
		if (value != null) {
			return value;
		}
		return defaultValue;
	};

	/**
	 * Đọc số nguyên giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tạiLAB4: SPRING
	 *         BEANS SOF3021 – LẬP TRÌNH JAVA 5 TRANG 2
	 */
	public int getInt(String name, int defaultValue) {
		String value = request.getParameter(name);
		if (value != null) {
			try {
				return Integer.parseInt(value);
			} catch (NumberFormatException e) {
				// Xử lý nếu không phải số nguyên
			}
		}
		return defaultValue;
	};

	/**
	 * Đọc số thực giá trị của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public double getDouble(String name, double defaultValue) {
		String value = request.getParameter(name);
		if (value != null) {
			try {
				return Double.parseDouble(value);
			} catch (NumberFormatException e) {
				// Xử lý nếu không phải số thực
			}
		}
		return defaultValue;
	};

	/**
	 * Đọc giá trị boolean của tham số
	 * 
	 * @param name         tên tham số
	 * @param defaultValue giá trị mặc định
	 * @return giá trị tham số hoặc giá trị mặc định nếu không tồn tại
	 */
	public boolean getBoolean(String name, boolean defaultValue) {
		String value = request.getParameter(name);
		if (value != null) {
			return Boolean.parseBoolean(value);
		}
		return defaultValue;
	};

	/**
	 * Đọc giá trị thời gian của tham số
	 * 
	 * @param name    tên tham số
	 * @param pattern là định dạng thời gian
	 * @return giá trị tham số hoặc null nếu không tồn tại
	 * @throws RuntimeException lỗi sai định dạng
	 */
	public Date getDate(String name, String pattern) {
		String value = request.getParameter(name);
		if (value != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				return sdf.parse(value);
			} catch (ParseException e) {
				throw new RuntimeException("Lỗi sai định dạng thời gian");
			}
		}
		return null;
	};

	/**
	 * Lưu file upload vào thư mục
	 * 
	 * @param file chứa file upload từ client
	 * @param path đường dẫn tính từ webroot
	 * @return đối tượng chứa file đã lưu hoặc null nếu không có file upload
	 * @throws RuntimeException lỗi lưu file
	 */
	public File save(MultipartFile file, String path) {
		if (!file.isEmpty()) {
	        try {
	            File directory = new File(path);
	            if (!directory.exists()) {
	                directory.mkdirs();
	            }
	            String fileName = file.getOriginalFilename();
	            File destinationFile = new File(directory, fileName);
	            file.transferTo(destinationFile);
	            return destinationFile;
	        } catch (IOException e) {
	            throw new RuntimeException("Lỗi lưu file");
	        }
	    }
	    return null;
	};
}

