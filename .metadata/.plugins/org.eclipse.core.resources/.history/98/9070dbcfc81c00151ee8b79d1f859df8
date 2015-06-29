package con.task.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TaskApp")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	 private Integer id =0;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Content")
	private String content;
	
	@Column(name = "Priority")
	private String priority;
	
	public Task(){}
	
	public Task(Integer id){
		this.id = id;
	}
	 @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Task)) {
            return false;
        }
        Task other = (Task) object;

        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {

            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Task.Task[id=" + id + "]";
    }
}
