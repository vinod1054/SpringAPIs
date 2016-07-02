package instavans.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Job_Porter {
	
	@Id
	@GeneratedValue
	private int id;
	private  int jobId;
	private int porterId;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public int getPorterId() {
		return porterId;
	}
	public void setPorterId(int porterId) {
		this.porterId = porterId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
	
	

}
