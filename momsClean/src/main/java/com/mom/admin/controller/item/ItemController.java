package com.mom.admin.controller.item;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mom.admin.domain.Item;
import com.mom.admin.service.item.ItemService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/admin/item")
public class ItemController {

	@Autowired
	private ItemService ItemService;

	@Value("${upload.path}")
	private String uploadPath;

	// 상품 등록 페이지
	@RequestMapping(value = "/itemRegister", method = RequestMethod.GET)
	public void registerForm(Model model) {
		model.addAttribute(new Item());

		
	}

	// 상품 등록 처리
	@RequestMapping(value = "/itemRegister", method = RequestMethod.POST)
	public String register(Item item, RedirectAttributes rttr) 
			throws Exception {

		MultipartFile pictureFile = item.getPicture();
		MultipartFile thumbFile = item.getThumb();

		String createdPictureFilename = null;
		String createdThumbFilename =null;
	    try {
	        if (pictureFile != null && !pictureFile.isEmpty()) {
	            createdPictureFilename = uploadImg
	            		(pictureFile.getOriginalFilename(), pictureFile.getBytes());
	        }else { createdPictureFilename = "";
	        }
	        if (thumbFile != null && !thumbFile.isEmpty()) {
	            createdThumbFilename = uploadThumb
	            		(thumbFile.getOriginalFilename(), thumbFile.getBytes());
	        }else {createdThumbFilename="";}
	    } catch (IOException e) {
	       
	    }
		
		item.setItemImg(createdPictureFilename);
		item.setItemImgThumb(createdThumbFilename);

		ItemService.register(item);

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/item/list";
	}

	// 옵션 등록 페이지
	@RequestMapping(value = "/optionRegister", method = RequestMethod.GET)
	public void optionRegisterForm(Model model) {
		model.addAttribute(new Item());

		
	}

	// 옵션 등록 처리
	@RequestMapping(value = "/optionRegister", method = RequestMethod.POST)
	public String optionRegister(Item item, RedirectAttributes rttr) throws Exception {

		ItemService.optionRegister(item);

		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/admin/item/list";
	}

	// 상품 목록 페이지
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		List<Item> itemList = ItemService.list();
		List<Item> itemList2 = ItemService.list2();

		model.addAttribute("itemList2", itemList2);
		model.addAttribute("itemList", itemList);
	}

	// 상품 수정 페이지
	@RequestMapping(value = "/itemModify", method = RequestMethod.GET)
	public void modifyForm(String itemNo, Model model) throws Exception {
		Item item = ItemService.read(itemNo);
		
		model.addAttribute(item);

		
	}

	// 옵션 수정 페이지
	@RequestMapping(value = "/optionModify", method = RequestMethod.GET)
	public void optionModifyForm(String itemName, Model model) throws Exception {
		
		Item item = ItemService.optionRead(itemName);
		
		model.addAttribute(item);


	}

	// 상품 수정 처리
	@RequestMapping(value = "/itemModify", method = RequestMethod.POST)
	public String modify(Item item, RedirectAttributes rttr) throws Exception {
		
		MultipartFile pictureFile = item.getPicture();
		String createdPictureFilename = null;
		try {
		    if (pictureFile != null && pictureFile.getSize() > 0) {
		        createdPictureFilename = uploadImg(pictureFile.getOriginalFilename(), pictureFile.getBytes());
		    } else {
		        createdPictureFilename = ""; // 빈 문자열로 설정
		    }
		} catch (IOException e) {
		    // 예외 처리
		}
		item.setItemImg(createdPictureFilename); // 한 번만 설정하도록 수정

		MultipartFile thumbFile = item.getThumb();
		String createdThumbFilename = null;
		try {
		    if (thumbFile != null && thumbFile.getSize() > 0) {
		        createdThumbFilename = uploadThumb(thumbFile.getOriginalFilename(), thumbFile.getBytes());
		    } else {
		        createdThumbFilename = ""; 
		    }
		} catch (IOException e) {
		    // 예외 처리
		}
		item.setItemImgThumb(createdThumbFilename);

		ItemService.modify(item);


		
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/item/list";
	}

	// 옵션 수정 처리
	@RequestMapping(value = "/optionModify", method = RequestMethod.POST)
	public String optionModify(Item item, RedirectAttributes rttr) throws Exception {

		ItemService.optionModify(item);
		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/item/list";
	}

	// 상품 삭제 처리
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(Item item, RedirectAttributes rttr) throws Exception {
		log.info(item.toString());
		ItemService.remove(item.getItemName());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/admin/item/list";
	}

	// 변경 페이지
	@RequestMapping(value = "/itemChange", method = RequestMethod.GET)
	public void read(String itemNo, Model model) throws Exception {
		model.addAttribute(ItemService.read(itemNo));
	}

	// 변경 페이지
	@RequestMapping(value = "/optionChange", method = RequestMethod.GET)
	public void optionRead(String itemName, Model model) throws Exception {
		model.addAttribute(ItemService.optionRead(itemName));
	}

	// 이미지 업로드
	private String uploadImg(String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();

		String createdFileName = "/info/" + originalName;

		File target = new File(uploadPath, createdFileName);

		FileCopyUtils.copy(fileData, target);

		return createdFileName;
	}

	// 이미지 업로드
	private String uploadThumb(String originalName, byte[] fileData) throws Exception {
		UUID uid = UUID.randomUUID();

		String createdFileName = "/thumb/" + originalName;

		File target = new File(uploadPath, createdFileName);

		FileCopyUtils.copy(fileData, target);

		return createdFileName;
	}

	// 썸네일 이미지 표시
	@ResponseBody
	@RequestMapping("/thumb")
	public ResponseEntity<byte[]> displayFile(String itemNo) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		String fileName = ItemService.getThumb(itemNo);

		try {
			if (fileName != null) {

				String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);

				MediaType mType = getMediaType(formatName);

				HttpHeaders headers = new HttpHeaders();

				in = new FileInputStream(uploadPath + File.separator + fileName);

				if (mType != null) {
					headers.setContentType(mType);
				}

				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			} else {
				entity = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return entity;
	}

	// 확장자로 이미지 형식 확인
	private MediaType getMediaType(String formatName) {
		if (formatName != null) {
			if (formatName.equals("JPG")) {
				return MediaType.IMAGE_JPEG;
			}
			if (formatName.equals("GIF")) {
				return MediaType.IMAGE_GIF;
			}
			if (formatName.equals("PNG")) {
				return MediaType.IMAGE_PNG;
			}

		}
		return null;
	}

	// 원본 이미지 표시
	@ResponseBody
	@RequestMapping("/picture")
	public ResponseEntity<byte[]> pictureFile(String itemNo) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;

		String fileName = ItemService.getPicture(itemNo);

		try {
			if (fileName != null) {

				String formatName = fileName.substring(fileName.lastIndexOf(".") + 1);
				MediaType mType = getMediaType(formatName);

				HttpHeaders headers = new HttpHeaders();
				in = new FileInputStream(uploadPath + File.separator + fileName);

				if (mType != null) {
					headers.setContentType(mType);
				}

				entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			} else {
				entity = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return entity;
	}
}