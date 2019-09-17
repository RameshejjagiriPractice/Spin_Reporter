package com.spin.main.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spin.main.model.Postings;

@Repository
@EnableAutoConfiguration
@EnableJpaRepositories
public interface PostingRepository extends JpaRepository<Postings, Integer> {

	// ---------------------------------------Ande_Ranjith------------User_Data_fecting--------------------------------------------

	

	@Query(value ="select COUNT(*) from spin.postings where postingtypeid=1 and isactive=1", nativeQuery = true)
	long allArticlesCount();


	@Query(value ="select COUNT(*) from spin.postings where postingtypeid=4 and isactive=1", nativeQuery = true)
	long allTalksCount();


	@Query(value ="select COUNT(*) from spin.postings where postingtypeid=2 and isactive=1", nativeQuery = true)
	long allVideosCount();
	
	@Query(value ="select COUNT(*) from spin.postings where postingtypeid=3 and isactive=1", nativeQuery = true)
	long allImagesCount();
	
	// allUserData
	@Query(value = "  select * from postings where  isactive=1 and userid=:userid", nativeQuery = true)
	List<Postings> findByPostings(@Param("userid") Integer userid);
	

	// getByPosting play the flash player
	@Query(value = "  select * from postings where  isactive=1 and postid=:postid", nativeQuery = true)
	Postings getByPosting(@Param("postid") Integer postid);

	// findByUserArticles------------>postingtypeid=1
	@Query(value = "  select * from postings where isactive=1 and postingtypeid=1 and userid=:userid", nativeQuery = true)
	List<Postings> findByUserArticles(@Param("userid") Integer userid);

	// findByUserVideos------------>postingtypeid=2
	@Query(value = "  select * from postings where isactive=1 and postingtypeid=2 and userid=:userid", nativeQuery = true)
	List<Postings> findByUserVideos(@Param("userid") Integer userid);

	// findByUserImages------------>postingtypeid=3
	@Query(value = "  select * from postings where isactive=1 and postingtypeid=3 and userid=:userid", nativeQuery = true)
	List<Postings> findByUserImages(@Param("userid") Integer userid);

	// findByUserTalks------------>postingtypeid=4
	@Query(value = "  select * from postings where isactive=1 and postingtypeid=4 and userid=:userid", nativeQuery = true)
	List<Postings> findByUserTalks(@Param("userid") Integer userid);

	@Query(value = "  select * from postings where userid=:userid and postingtypeid=:postingtypeid", nativeQuery = true)
	List<Postings> findByUserPostings(@Param("userid") Integer userid, @Param("postingtypeid") Integer postingtypeid);

	// ---------------------------------------Ande_Ranjith------------User_Data_fecting--------------------------------------------

	@Transactional
	@Modifying
	@Query(value = "SELECT * FROM postings t WHERE " + "LOWER(t.posttitle) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR "
			+ "LOWER(t.postdescription) LIKE LOWER(CONCAT('%',:searchTerm, '%'))", nativeQuery = true)
	List<Postings> findBySearchTermNative(String searchTerm);

	@Transactional
	@Modifying
	@Query(value = "select * from postings where(isactive=1) and dateofposting between :dateofposting and :expirydate", nativeQuery = true)
	// List<Postings> getAllBetweenDates(Date date, Date date2);

	List<Postings> getAllBetweenDates(Date dateofposting, Date expirydate);

//-------------------------SANDEEP KATHOJU//'----------------------------
	/*
	 * @Query(
	 * value=" select * from postings inner join usermaster on postings.userid=usermaster.userid where postings.userid=:userid;"
	 * ,nativeQuery=true) List<Postings> detailPage(Integer userid );
	 */
	@Query(value=" select * from postings where postid=:postingtypeid",nativeQuery=true)
	Postings detailPage(Integer postingtypeid );
	
	@Query(value = "  select * from postings where isactive=1", nativeQuery = true)
	List<Postings> homepage(Postings postings);
	
	@Query(value=" select * from postings where postid=:postingtypeid",nativeQuery=true)
	List<Postings> ListByPostId(Integer postingtypeid );
	
	@Query(value="select postprice from Postings where userid=:userid;",nativeQuery=true)
	List<Postings> byUserId(Integer userid );
	
	//--------------------------------------sandeep kathoju/homepage----------------------------
	
	@Query(value = "  select * from postings where isactive=1 and postingtypeid=1", nativeQuery = true)
	List<Postings> findByArticles(Postings postings);
	
	@Query(value = "  select * from postings where isactive=1 and postingtypeid=2", nativeQuery = true)
	List<Postings> findByVideos(Postings postings);
	
	@Query(value = "  select * from postings where isactive=1 and postingtypeid=3", nativeQuery = true)
	List<Postings> findByImages(Postings postings);
	
	@Query(value = "  select * from postings where isactive=1 and postingtypeid=4", nativeQuery = true)
	List<Postings> findByAudios(Postings postings);
	 

}
