package db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "food", catalog = "eatalone")

public class Food implements java.io.Serializable {

	// Fields

	private Integer id;
	private String url;
	private String title;
	private String content;
	private String step;
	private String image;

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** full constructor */
	public Food(String url, String title, String content, String step, String image) {
		this.url = url;
		this.title = title;
		this.content = content;
		this.step = step;
		this.image = image;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "url")

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "title")

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "step")

	public String getStep() {
		return this.step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	@Column(name = "image")

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}