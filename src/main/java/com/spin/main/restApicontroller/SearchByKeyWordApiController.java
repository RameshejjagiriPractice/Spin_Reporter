package com.spin.main.restApicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spin.main.model.Postings;
import com.spin.main.responsemodel.Errorcodes;
import com.spin.main.responsemodel.SearchWrapper;
import com.spin.main.service.SearchBykeyWordService;

@RestController
@RequestMapping("/api")
public class SearchByKeyWordApiController {
	@Autowired
	SearchBykeyWordService searchSer;

	@RequestMapping("/postApi/searchTerm")
	private ResponseEntity<SearchWrapper> searchBykeyWord(@RequestBody Postings post) {

		try {
			List<Postings> searchList = searchSer.searchByKeyWord(post.getPosttitle());
			if (!searchList.isEmpty()) {
				System.out.println("Search List is not Empty");
				SearchWrapper searchWrapper = new SearchWrapper();
				Errorcodes info = new Errorcodes();
				info.setErrorCode(1);
				info.setErrorMessage("Items found");
				searchWrapper.setInfo(info);
				searchWrapper.setPostlist(searchList);

				return new ResponseEntity<SearchWrapper>(searchWrapper, HttpStatus.OK);
			} else {
				SearchWrapper searchWrapper = new SearchWrapper();
				Errorcodes info = new Errorcodes();
				info.setErrorCode(0);
				info.setErrorMessage("Search item not found");
				searchWrapper.setInfo(info);
				return new ResponseEntity<SearchWrapper>(searchWrapper, HttpStatus.OK);
			}

		} catch (Exception e) {

			SearchWrapper searchWrapper = new SearchWrapper();
			Errorcodes info = new Errorcodes();
			info.setErrorCode(0);
			info.setErrorMessage("Somthing went Wrong");
			searchWrapper.setInfo(info);
			return new ResponseEntity<SearchWrapper>(searchWrapper, HttpStatus.OK);
		}

	}

}
