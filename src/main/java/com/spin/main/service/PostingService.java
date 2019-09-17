
package com.spin.main.service;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spin.main.model.Postings;
import com.spin.main.model.statemaster;
import com.spin.main.model.usermaster;
import com.spin.main.repository.PostingRepository;

@Service
public class PostingService {

	@Autowired
	private PostingRepository postingRepository;

	@Transactional
	public Postings savePostings(Postings postings) throws ParseException, Exception {
		LocalDate plusMonths = LocalDate.now().plusDays(30);
		System.out.println(plusMonths);
		Date date = Date.valueOf(plusMonths);

		postings.setExpirydate(date);

		return postingRepository.save(postings);
	}

	public long allImageCount() {

		return postingRepository.allImagesCount();

	}

	public long allVideosCount() {

		return postingRepository.allVideosCount();

	}

	public long allTalksCount() {

		return postingRepository.allTalksCount();

	}

	public long allArticlesCount() {

		return postingRepository.allArticlesCount();

	}

	// ---------------------------------------Ande_Ranjith------------User_Data_fecting--------------------------------------------

	public List<Postings> allPostings() {

		return postingRepository.findAll();
	}

	public List<Postings> findByPostings(Integer userid) {

		List<Postings> userData = postingRepository.findByPostings(userid);

		return userData;
	}

	// getByPosting
	public Postings getByPosting(Integer userid) {
		Postings posting = postingRepository.getByPosting(userid);

		return posting;
	}

	// findByUserArticles
	public List<Postings> findByUserArticles(Integer userid) {
		List<Postings> uservideos = postingRepository.findByUserArticles(userid);

		return uservideos;
	}

	// findByUserVideos
	public List<Postings> findByUserVideos(Integer userid) {
		List<Postings> uservideos = postingRepository.findByUserVideos(userid);

		return uservideos;
	}

	// findByUserImages
	public List<Postings> findByUserImages(Integer userid) {
		List<Postings> userImages = postingRepository.findByUserImages(userid);

		return userImages;
	}

	// findByUserTalks
	public List<Postings> findByUserTalks(Integer userid) {
		System.out.println("this is service talk" + userid);
		List<Postings> findByUserTalks = postingRepository.findByUserTalks(userid);

		for (Postings talk : findByUserTalks) {
			System.out.println(talk.getPreview() + "service----------------->" + talk.getThumnail());
		}

		return findByUserTalks;
	}

	public List<Postings> findByPostingImages(Integer userid, Integer postingtypeid) {

		List<Postings> userData = postingRepository.findByUserPostings(userid, postingtypeid);

		return userData;
	}

	public List<Postings> findByPostingVideos(Integer userid, Integer postingtypeid) {

		List<Postings> userData = postingRepository.findByUserPostings(userid, postingtypeid);

		return userData;
	}

	public List<Postings> findByPostingBlogs(Integer userid, Integer postingtypeid) {

		List<Postings> userData = postingRepository.findByUserPostings(userid, postingtypeid);

		return userData;
	}

	public List<Postings> findByPostingTalks(Integer userid, Integer postingtypeid) {

		List<Postings> userData = postingRepository.findByUserPostings(userid, postingtypeid);

		return userData;
	}

	// -----------------------------------Sandeep kathoju-----------------------//

	public List<Postings> getCountryById(Integer postingtypeid) {
		List<Postings> s = postingRepository.ListByPostId(postingtypeid);
		return s;
	}

	public Postings getPostingByid(Integer postingtypeid) {

		Postings s = postingRepository.detailPage(postingtypeid);
		System.out.println("id--" + postingtypeid);

		return s;

	}

}
