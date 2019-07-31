package lc.cds.database.model.hsql;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User implements Serializable  {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 4673093535433888511L;

	/** The policy number. */
	@Id
	@Column(name="id")
	private long id;
		
	@Column(name="name")
	private String name;
    
    @Column(name="email")
    private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
    
    
    
    
}
